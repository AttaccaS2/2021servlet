package model;

import java.util.*;

public class TradingDetailVO {

	private int trad_num;
	private int trad_refnum;
	private Date trad_traingDate;
	private String trad_subject;
	private String trad_standard;
	private int trad_quantity;
	private int trad_unitPrice;
	private int trad_supplyPrice;
	private int trad_taxAmount;
	private String trad_note;
	
	public int getTrad_num() {
		return trad_num;
	}
	public void setTrad_num(int trad_num) {
		this.trad_num = trad_num;
	}
	public int getTrad_refnum() {
		return trad_refnum;
	}
	public void setTrad_refnum(int trad_refnum) {
		this.trad_refnum = trad_refnum;
	}
	public Date getTrad_traingDate() {
		return trad_traingDate;
	}
	public void setTrad_traingDate(Date trad_traingDate) {
		this.trad_traingDate = trad_traingDate;
	}
	public String getTrad_subject() {
		return trad_subject;
	}
	public void setTrad_subject(String trad_subject) {
		this.trad_subject = trad_subject;
	}
	public String getTrad_standard() {
		return trad_standard;
	}
	public void setTrad_standard(String trad_standard) {
		this.trad_standard = trad_standard;
	}
	public int getTrad_quantity() {
		return trad_quantity;
	}
	public void setTrad_quantity(int trad_quantity) {
		this.trad_quantity = trad_quantity;
	}
	public int getTrad_supplyPrice() {
		return trad_supplyPrice;
	}
	public void setTrad_supplyPrice(int trad_supplyPrice) {
		this.trad_supplyPrice = trad_supplyPrice;
	}
	public int getTrad_taxAmount() {
		return trad_taxAmount;
	}
	public void setTrad_taxAmount(int trad_taxAmount) {
		this.trad_taxAmount = trad_taxAmount;
	}
	public String getTrad_note() {
		return trad_note;
	}
	public void setTrad_note(String trad_note) {
		this.trad_note = trad_note;
	}
	public int getTrad_unitPrice() {
		return trad_unitPrice;
	}
	public void setTrad_unitPrice(int trad_unitPrice) {
		this.trad_unitPrice = trad_unitPrice;
	}
	@Override
	public String toString() {
		return "TradingDetailVO [trad_num=" + trad_num + ", trad_refnum=" + trad_refnum + ", trad_traingDate="
				+ trad_traingDate + ", trad_subject=" + trad_subject + ", trad_standard=" + trad_standard
				+ ", trad_quantity=" + trad_quantity + ", trad_unitPrice=" + trad_unitPrice + ", trad_supplyPrice="
				+ trad_supplyPrice + ", trad_taxAmount=" + trad_taxAmount + ", trad_note=" + trad_note + "]";
	}
	
	
	
}
