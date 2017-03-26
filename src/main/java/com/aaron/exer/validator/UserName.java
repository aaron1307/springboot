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
//	String regexp() default "^(((\\+?64\\s*[-\\.]?[3-9]|\\(?0[3-9]\\)?)\\s*[-\\.]?\\d{3}\\s*[-\\.]?\\d{4})|((\\+?64\\s*[-\\.\\(]?2\\d{1}[-\\.\\)]?|\\(?02\\d{1}\\)?)\\s*[-\\.]?\\d{3}\\s*[-\\.]?\\d{3,5})|((\\+?64\\s*[-\\.]?[-\\.\\(]?800[-\\.\\)]?|[-\\.\\(]?0800[-\\.\\)]?)\\s*[-\\.]?\\d{3}\\s*[-\\.]?(\\d{2}|\\d{5})))$";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}