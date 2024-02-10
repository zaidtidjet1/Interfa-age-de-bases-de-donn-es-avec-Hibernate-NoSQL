package hibernate_validator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import hibernate_validator.NumSerieValidator;

@Documented
@Constraint(validatedBy = NumSerieValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface NumSerieValide {
	
	 String message() default "Le numéro de série est invalide";

	   

}
