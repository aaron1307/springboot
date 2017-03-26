package com.aaron.exer.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * PhoneNO Annotation
 * customized annotation class for hibernate validation
 * 
 * @author Aaron C.
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
		ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { UserNameValidator.class })
public @interface UserName {

	/**   
	 * @Fields message : default error message
	 */   
	String message() default "user name should contain letter a";

	/**   
	 * @Fields regexp : regular expressions to match phone numbers
	 */   
	String regexp() default "\\.*a\\.*";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}