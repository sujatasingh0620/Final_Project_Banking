package api.sujata.banking.advices;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import api.sujata.banking.Exceptions.TransactionNotFoundException;

@ControllerAdvice
public class TransactionExceptionAdvices {
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<Object> handleNoTransactionFoundException(TransactionNotFoundException ex)
	{
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("Code Author", "Sujata Singh");
		body.put("Root cause", ex.getStackTrace()[0].getClassName());
		body.put("timestamp", LocalDateTime.now());
		body.put("Custom Error Code", "604");
		body.put("message", ex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
