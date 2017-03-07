package br.com.masm.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.masm.loja.models.Product;

public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		return Product.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
		
		Product product = (Product) target;
		
		if (product.getPages() == 0) {
			errors.rejectValue("pages", "field.required");
		}
	}

}
