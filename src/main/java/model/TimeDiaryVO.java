package model;

import java.util.Date;

public class TimeDiaryVO {
	
	private int tbo_num;
	private String tbo_content;
	private String tbo_mb_id;
	private String tbo_mb_name;
	private Date tbo_datetime;
	
	public int getTbo_num() {
		return tbo_num;
	}
	public void setTbo_num(int tbo_num) {
		this.tbo_num = tbo_num;
	}
	public String getTbo_content() {
		return tbo_content;
	}
	public void setTbo_content(String tbo_content) {
		this.tbo_content = tbo_content;
	}
	public String getTbo_mb_id() {
		return tbo_mb_id;
	}
	public void setTbo_mb_id(String tbo_mb_id) {
		this.tbo_mb_id = tbo_mb_id;
	}
	public String getTbo_mb_name() {
		return tbo_mb_name;
	}
	public void setTbo_mb_name(String tbo_mb_name) {
		this.tbo_mb_name = tbo_mb_name;
	}
	public Date getTbo_datetime() {
		return tbo_datetime;
	}
	public void setTbo_datetime(Date tbo_datetime) {
		this.tbo_datetime = tbo_datetime;
	}
	@Override
	public String toString() {
		return "TimeBoardVO [tbo_num=" + tbo_num + ", tbo_content=" + tbo_content + ", tbo_mb_id=" + tbo_mb_id
				+ ", tbo_mb_name=" + tbo_mb_name + ", tbo_datetime=" + tbo_datetime + "]";
	}
	
	
	
}
