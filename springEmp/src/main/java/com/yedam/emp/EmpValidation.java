package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmpValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmpVO emp = (EmpVO)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", null, "first_name is not allowed. ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", null, "last_name is not allowed. ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hire_date", null, "hire_date is not allowed. ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job_id", null, "job_id is not allowed. ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manager_id", null, "manager_id is not allowed. ");
		if(emp.getEmail() == null|| emp.getEmail().isEmpty())
		errors.rejectValue("email", null, "email NOT null");
		if(emp.getDepartment_id() == null|| emp.getDepartment_id().isEmpty())
		errors.rejectValue("department_id", null, "Department_id not null");
		if(emp.getEmployee_id() == null|| emp.getEmployee_id().isEmpty())
			errors.rejectValue("employee_id", null, "employee_id not null");
		if(emp.getPhone_number() == null|| emp.getPhone_number().isEmpty())
			errors.rejectValue("phone_number", null, "phone_number not null");
	}
	
}
