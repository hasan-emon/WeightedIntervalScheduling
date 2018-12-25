package com.nsu.cse.ms.aa.asn5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WISRunner {
	private static final String FILENAME= "WIS.txt";
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	
	public static String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(WISRunner.class.getResourceAsStream(fileName)));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		while (line != null) {
			sb.append(line+"\n");
			line = br.readLine();
		}
		br.close();
		return sb.toString();
	}

	public static List<Job> getJobsDetailsFormFile(String fileName) throws IOException{
		List<Job> jobs = new ArrayList<Job>();
		Job job;
		String[] studentDataArray = readFile(fileName).split(NEW_LINE);
		int id = 0;
		jobs.add(new Job(id,0,0,0));//before start
		id++;
		for (String studentData : studentDataArray) {
			job = new Job();
			String[] data = studentData.split(SPACE);
			job.setId(id);
			job.setStartTime(Integer.parseInt(data[0]));
			job.setFinishTime(Integer.parseInt(data[1]));
			job.setValue(Integer.parseInt(data[2]));
			jobs.add(job);
			id++;
		}

		return jobs;
	}

	public static void main(String[] args) throws IOException {
		WISMemoization wis = new WISMemoization();
		List<Job> inputJobs = getJobsDetailsFormFile(FILENAME);
			
//							{{0,0,0,0},		//dummy 0th item to make array indexes line up
//							{1, 0, 6, 3},
//							{2, 1, 4, 5},
//							{3, 3, 5, 5},
//							{4, 3, 8, 8},
//							{5, 4, 7, 3},
//							{6, 5, 9, 7},
//							{7, 6, 10, 3},
//							{8, 8, 11, 4}};
		wis.calcSchedule(inputJobs);
	}
	

}
