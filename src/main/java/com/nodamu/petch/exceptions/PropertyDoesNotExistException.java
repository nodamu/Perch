package com.nodamu.petch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author profnick
 * 5/13/21
 **/

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PropertyDoesNotExistException extends RuntimeException{

}
