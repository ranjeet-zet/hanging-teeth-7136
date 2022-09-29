package com.project.been;

public class Batch {

	private int cid;
	private String cname;
	private int fee;
	private String bname;

	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int cid, String cname, int fee, String bname) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.fee = fee;
		this.bname = bname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

}
