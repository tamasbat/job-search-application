package job.search.app.validation;

import job.search.app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmailValidation, String> {
    @Autowired
    private ApplicationService service;

    @Override
    public void initialize(UniqueEmailValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return service.validateUniqueEmail(email);
    }
}
