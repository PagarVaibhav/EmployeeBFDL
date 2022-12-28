package com.mpl.Exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.mpl.Dtos.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandeller {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandeller(ResourceNotFoundException ex){
		
		String message=ex.getMessage();
		
		ApiResponse apiResponce=new ApiResponse(message, false);
		
		return new ResponseEntity<ApiResponse>(apiResponce,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		Map<String, String> resp=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			
			String fieldName= ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			
			resp.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp , HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(EmployeeNotFoundException.class)
     public ResponseEntity<Object> handleResourceNotFoundException(
             EmployeeNotFoundException ex) {
         
         List<String> details = new ArrayList<String>();
         details.add(ex.getMessage());
         ApiError err = new ApiError(
             LocalDateTime.now(), 
             "Employee Not Found" ,
             details);
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
     }
	
}
