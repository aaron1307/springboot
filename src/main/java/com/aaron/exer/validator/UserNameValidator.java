package com.aaron.exer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * UserNameValidator, annotation validation for hibernate validation
 * 
 * @author Aaron C.
 * @version v0.1
 */
public class UserNameValidator implements ConstraintValidator<UserName, String> {

	/**   
	 * @Fields regexp : regular expressions to match phone numbers
	 */   
	private String regexp;

	/**   
	 * @Title: initialize   
	 * @Description: initialize variables
	 * @param: PhoneNO
	 * @return: void
	 * @throws   
	 */  
	public void initialize(UserName constraintAnnotation) {
		// TODO Auto-generated method stub
		
		//Get regex from @interface PhoneNO
		this.regexp = constraintAnnotation.regexp();

	}

	/**   
	 * @Title: isValid   
	 * @Description: determine if phone number is valid using regex
	 * @param: String, ConstraintValidatorContext
	 * @return: boolean
	 * @throws   
	 */  
	public boolean isValid(String userName, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub

		if (userName == null) {
			return true;
		}

		if (userName.matches(regexp)) {
			return true;
		}

		return false;
	}

}
