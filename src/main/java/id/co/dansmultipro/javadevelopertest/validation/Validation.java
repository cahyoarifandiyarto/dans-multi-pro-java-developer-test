package id.co.dansmultipro.javadevelopertest.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Validation {

    private final Validator validator;

    public void validate(Object obj) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

}
