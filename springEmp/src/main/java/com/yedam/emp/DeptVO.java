package com.yedam.emp;

import lombok.Data;

@Data
public class DeptVO {
	private String department_id;
	private String department_name;
	private String manager_id;
	private String location_id;
	private String city;
	private String last_name;

	// 페이징
	Integer page = 1;
	int start = 1;
	int end = 10;
}
