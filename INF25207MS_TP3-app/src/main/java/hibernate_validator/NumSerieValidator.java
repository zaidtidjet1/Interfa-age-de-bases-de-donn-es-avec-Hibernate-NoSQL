package hibernate_validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumSerieValidator implements ConstraintValidator<NumSerieValide, String> {

    @Override
    public void initialize(NumSerieValide constraintAnnotation) {
    }

    @Override
    public boolean isValid(String numSerie, ConstraintValidatorContext context) {
        if (numSerie == null) {
            return false;
        }
        return numSerie.matches("SN-[a-z]{3}-[0-9]{6}");
    }
}

