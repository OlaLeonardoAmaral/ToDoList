package br.com.leonardoamaral.todolist.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Sempre que acontecer um erro o spring vai passar por aqui por causa dessa anotation
public class ExceptionHandlerController {
    
    @ExceptionHandler(HttpMessageNotReadableException.class)  // Quando o erro for do tipo HttpMessageNotReadableException ela sera tratada aqui
    public ResponseEntity<String> handleHttpMessageNotReadableExcpetion(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body(e.getMostSpecificCause().getMessage());
    }
}
