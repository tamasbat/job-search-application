package job.search.app.validation;

import job.search.app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UuidValidator implements ConstraintValidator<ApikeyValidation, String> {
    @Autowired
    private ApplicationService service;

    @Override
    public void initialize(ApikeyValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String apikey, ConstraintValidatorContext context) {
        return service.validateApikey(apikey);
    }
}
