package co.kr.sharek.common.exception.httpexception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

  private final int code;

  public CustomException(String message, int code) {
    super(message);
    this.code = code;
  }
}
