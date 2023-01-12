package co.kr.sharek.common.exception;

import co.kr.sharek.common.exception.httpexception.BadRequestException;
import co.kr.sharek.common.exception.httpexception.InternalServerException;
import co.kr.sharek.common.exception.httpexception.NotFoundException;
import co.kr.sharek.common.exception.httpexception.UnauthorizedException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class ExceptionAdvice {

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse handleBadRequestException(BadRequestException ex) {
    return new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionResponse handleNotFoundException(NotFoundException ex) {
    return new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
  }

  @ExceptionHandler(UnauthorizedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ExceptionResponse handleUnauthorizedException(UnauthorizedException ex) {
    return new ExceptionResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
  }

  @ExceptionHandler(InternalServerException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ExceptionResponse handleInternalServerException(InternalServerException ex) {
    return new ExceptionResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

}
