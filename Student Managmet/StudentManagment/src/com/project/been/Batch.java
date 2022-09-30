package com.project.been;

public class Batch {
	private int bid;
	private String bname;
	private int seat;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int bid, String bname, int seat) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.seat = seat;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", bname=" + bname + ", seat=" + seat + "]";
	}
	


}
