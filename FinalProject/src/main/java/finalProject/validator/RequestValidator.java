package finalProject.validator;

import finalProject.model.Request;
import finalProject.model.Type;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Request.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Request request = (Request) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "Required");

        if (request.getJob().length() < 1 || request.getJob().length() > 32) {
            errors.rejectValue("job", "Size.requestForm.job");
        }

        if (request.getType() == Type.NONE) {
            errors.rejectValue("type", "Type.requestForm");
        }
    }
}
