/**
 * *********************************************
 * Date         Name                         
 * *********************************************
 * 11-Dec-2019   Sachin Patil aka JavaPatil  
 */

package org.student.demo.util.security.configuration;

import org.student.demo.util.security.admin.ErrorMessage;
import org.student.demo.util.security.exception.BadValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(BadValueException.class)
    public ResponseEntity<ErrorMessage> onBadValue(BadValueException e) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setFieldName(e.getFieldName());
        errorMessage.setReason(e.getReason());
        ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }


}
