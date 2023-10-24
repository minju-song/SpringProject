package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	// 1) 컬럼따라 타입을 구분 or 실제 타입 대신 String
	// 2) 기본타입(int, double 등) or Wrap 클래스(Integer, Double)
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;
}
