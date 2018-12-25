package com.nsu.cse.ms.aa.asn5;

public class Job {
	private int id;
	private int startTime;
	private int finishTime;
	private int value;

	public Job() {
	}
	public Job(int id, int startTime, int finishTime, int value) {
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
