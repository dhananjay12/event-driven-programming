package com.example.mq.consumer;

import java.util.List;

public class Department {

	private String name;
	
	 private List<Employee> emps;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", emps=" + emps + "]";
	}
	
	
}
