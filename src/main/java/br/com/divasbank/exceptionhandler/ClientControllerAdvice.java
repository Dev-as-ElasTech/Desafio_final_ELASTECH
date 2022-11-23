package br.com.divasbank.exceptionhandler;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice(basePackages = "br.com.divasbank.controller")
public class ClientControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> clientNotFound(ClientNotFoundException clientNotFound) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Cliente não encontrado. Informe um ID válido!"
        );
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<MessageExceptionHandler> ConstraintViolationException (ConstraintViolationException dataViolation) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), "E-mail ou CPF já cadastrados!"
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<MessageExceptionHandler> PropertyValueException (PropertyValueException dataViolation) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), "Insira todos os campos obrigatórios para cadastro"
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
