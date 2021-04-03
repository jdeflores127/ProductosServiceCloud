package com.springBoot.cloud.app.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class Utilidades {
	
	public static String getFormatoErrorBindingResult(BindingResult bindingResult) {
		StringBuilder errorResultado=new StringBuilder("Error al relizar la validacion de los campos del web service: ");
		for(FieldError error_item : bindingResult.getFieldErrors())
			errorResultado.append("\nCampo:"+error_item.getField()+"|"+"DescripcionError:"+error_item.getDefaultMessage());
		return errorResultado.toString();
	}
}
