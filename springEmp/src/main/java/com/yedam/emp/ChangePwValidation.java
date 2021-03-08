package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ChangePwValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserVO user = (UserVO)target;
		if(user.getPassword() != user.getNewpassword())
		errors.rejectValue("newpassword", null, "패스워드 일치시키세요!!");
		
	}
	
}
