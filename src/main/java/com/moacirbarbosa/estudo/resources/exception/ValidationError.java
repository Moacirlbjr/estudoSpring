package com.moacirbarbosa.estudo.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardErro {
	private static final long serialVersionUID = 1L;

	private List<fieldMessage> erros = new ArrayList<>();

	public ValidationError(Integer status, String msn, long timeStamp) {
		super(status, msn, timeStamp);
		// TODO Auto-generated constructor stub
	}

	public List<fieldMessage> getErrors() {
		return erros;
	}

	public void addError(String fieldName, String message) {
		erros.add(new fieldMessage(fieldName, message));
	}

}
