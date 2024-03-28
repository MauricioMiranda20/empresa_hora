package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkLevel;

public class Work {
	private String name;
	private WorkLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contract = new ArrayList<HourContract>();
	
	public Work() {
	
	}
	
	public Work(String name, WorkLevel level, Double baseSalary,Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void seBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContract() {
		return contract;
	}

	public void addContract(HourContract contracts) {
		contract.add(contracts);
	}
	public void removeContract(HourContract contracts) {
		contract.remove(contracts);
	}
	public double income(int year,int month) {
		double sum = 0;
		Calendar cal = Calendar.getInstance();
		for(HourContract c :contract) {
			cal.setTime(c.getDate());
			int c_year = cal.get(cal.YEAR);
			int c_month = 1 + cal.get(cal.MONTH);
			if(c_year == year && c_month == month) {
				sum = sum + c.totalValue();
			}
		}
		return sum;
	}
	
	

}
