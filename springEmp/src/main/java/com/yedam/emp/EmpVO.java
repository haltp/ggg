package com.yedam.emp;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data; //앞으로 이것만 추가하면 source에 set get tostring 추가 안해도 됨
import lombok.NoArgsConstructor;



@Data  //다 합친게 Data 각각 뜻 알아오기
/*@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor*/
//@Builder                    //생성자 대체 가능
@NoArgsConstructor          //인수가 없는 빈 생성자
@AllArgsConstructor         //모든 생성자

public class EmpVO {
	@NotEmpty(message = "employee_id 필수입니다")
	private String employee_id;
	@NotEmpty
	private String first_name;
	@NotEmpty(message = "last_name 필수입니다")
	private String last_name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String phone_number;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hire_date;
	@NotEmpty
	private String job_id;
	private String salary;
	private String commission_pct;
	@NotEmpty
	private String manager_id;
	@NotEmpty
	private String department_id;
	@NotEmpty
	private String department_name;
	@NotEmpty
	private String job_title;
	
	
}
