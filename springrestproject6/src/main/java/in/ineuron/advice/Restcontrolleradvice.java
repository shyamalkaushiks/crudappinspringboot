package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.Error.errors;
import in.ineuron.Exception.TouristNotFoundException;

@RestControllerAdvice
public class Restcontrolleradvice {
@ExceptionHandler(TouristNotFoundException.class)
public ResponseEntity<errors> handleTouristNotFound(TouristNotFoundException tf )
{
	System.out.println("TouristErrorControllerAdvice.handleTouristNotFound()");
	errors Errorinfo=new errors(LocalDateTime.now(),tf.getMessage(),"404 not found");
	return new ResponseEntity<errors>(Errorinfo,HttpStatus.NOT_FOUND);
}

@ExceptionHandler(Exception.class)
public ResponseEntity<errors> handleAllProblems(Exception e) {
	System.out.println("TouristErrorControllerAdvice.handleAllProblems()");
	errors details = new errors(LocalDateTime.now(), e.getMessage(), "Problem in exeuction");
	return new ResponseEntity<errors>(details, HttpStatus.INTERNAL_SERVER_ERROR);
}
}
