package com.nelioalves.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.workshopmongo.service.ObjectNotFoundExceptionexception;

@ControllerAdvice
public class ResourceExceptionHandler  {
	@ExceptionHandler(ObjectNotFoundExceptionexception.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExceptionexception e,HttpServletRequest request){
		HttpStatus status=HttpStatus.NOT_FOUND;
		StandardError err= new StandardError(System.currentTimeMillis(),status.value(),"não encontrado",e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
