package demos.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
	public ExceptionDetails handleNullPointerException(NullPointerException e, WebRequest request) {
		System.out.println("Inside handleNullPointerException");
		ExceptionDetails ed = new ExceptionDetails();
		ed.setMessage(e.getMessage());
		ed.setUrl(request.getDescription(false));
		return ed;
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ExceptionDetails handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
		System.out.println("Inside handleResourceNotFoundException");
		ExceptionDetails ed = new ExceptionDetails();
		ed.setMessage(e.getMessage());
		ed.setUrl(request.getDescription(false));
		return ed;
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ExceptionDetails handleGenericException(Exception e, WebRequest request) {
		System.out.println("Inside handleGenericException");
		ExceptionDetails ed = new ExceptionDetails();
		ed.setMessage(e.getMessage());
		ed.setUrl(request.getDescription(false));
		return ed;
	}

}
