package co.kr.sharek.common.exception.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
public class ExceptionResponse {

  private final LocalDateTime timestamp = LocalDateTime.now();
  private final int status;
  private final int code;
  private final String message;

  public ExceptionResponse(int status, int code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
