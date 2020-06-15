package com.d2vfactory.resttodolist.controller;

import com.d2vfactory.resttodolist.exceptions.RuntimeTodoException;
import com.d2vfactory.resttodolist.model.dto.ExceptionDTO;
import com.d2vfactory.resttodolist.model.resource.ExceptionResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeTodoException.class)
    public ExceptionResource handleTodoException(RuntimeTodoException e) {
        return new ExceptionResource(createExceptionDTO(e));
    }

    @ExceptionHandler(value = Exception.class)
    public ExceptionResource handleException(Exception e) {
        return new ExceptionResource(createExceptionDTO(e));
    }

    private ExceptionDTO createExceptionDTO(Exception e) {
        return ExceptionDTO.builder()
                .message(e.getMessage())
                .cause(e.toString())
                .build();
    }

}
