package co.kr.sharek.common.exception.httpexception;

public class InternalServerException extends CustomException {

  public InternalServerException(String message, int code) {
    super(message, code);
  }
}
