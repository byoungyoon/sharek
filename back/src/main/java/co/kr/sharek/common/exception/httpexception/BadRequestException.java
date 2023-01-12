package co.kr.sharek.common.exception.httpexception;

import lombok.Getter;

@Getter
public class BadRequestException extends CustomException {

  public BadRequestException(String message, int code) {
    super(message, code);
  }

}
