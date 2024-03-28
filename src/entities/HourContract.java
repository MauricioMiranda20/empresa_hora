package entities;

import java.util.Date;

public class HourContract {
	private Date date;
	private Double valuerperHour;
	private Integer hour;
	
	public HourContract() {
		
	}
	public HourContract(Date date, Double valuerperHour, Integer hour) {
		this.date = date;
		this.valuerperHour = valuerperHour;
		this.hour = hour;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getValuerperHour() {
		return valuerperHour;
	}
	public void setValuerperHour(Double valuerperHour) {
		this.valuerperHour = valuerperHour;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	
	public double totalValue() {
		return valuerperHour*hour;
	}
	
}
