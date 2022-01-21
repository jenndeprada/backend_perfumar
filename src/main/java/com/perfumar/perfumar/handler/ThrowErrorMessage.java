package com.perfumar.perfumar.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice         //cuando se da una exception, primero entra aca...
public class ThrowErrorMessage {

    Logger logger = LogManager.getLogger(ThrowErrorMessage.class);

    @ResponseBody
    @ExceptionHandler(HandleExceptionInRest.class) //no entiendo bien este bean
    //se pasa la exception a Spring a traves de HandleExceptionRest y se responde con el
    // mensaje de error tanto en http como en consola por logger
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessageStruct throwErrorMessage(HandleExceptionInRest ex) {
        logger.error(ex.getMessage());
        return ErrorMessageStruct.of(ex.getMessage());
    }


}
