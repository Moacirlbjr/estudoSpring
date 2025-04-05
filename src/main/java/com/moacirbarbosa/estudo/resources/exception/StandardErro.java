package com.moacirbarbosa.estudo.resources.exception;

import java.io.Serializable;

public class StandardErro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msn;
	private long timeStamp;
	
	
	
	public StandardErro(Integer status, String msn, long timeStamp) {
		super();
		this.status = status;
		this.msn = msn;
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the msn
	 */
	public String getMsn() {
		return msn;
	}
	/**
	 * @param msn the msn to set
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}
	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
