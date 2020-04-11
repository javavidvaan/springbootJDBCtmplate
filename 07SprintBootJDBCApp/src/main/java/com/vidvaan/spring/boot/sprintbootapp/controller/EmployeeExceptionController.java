package com.vidvaan.spring.boot.sprintbootapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.vidvaan.spring.boot.sprintbootapp.domain.EmployeeNotFoundException;


@ControllerAdvice
public class EmployeeExceptionController {
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<Object>exception(EmployeeNotFoundException exception){
		
		   return new ResponseEntity<>("Employee Not Found Check Given Id",HttpStatus.NOT_FOUND);

}
	@ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        return new ResponseEntity<>("Your Enter Wrong Data Enter Valid Details", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}