package dr.dta.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordValidator implements ConstraintValidator<Password , String>{

    @Override
    public void initialize( Password constraintAnnotation ) {
        
    }

    @Override
    public boolean isValid( String value, ConstraintValidatorContext context ) {
        return value.length() >= 8 && value.matches( ".*[0-9]+.*" );
    }
    
}
