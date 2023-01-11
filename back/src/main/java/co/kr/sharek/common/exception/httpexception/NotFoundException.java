package co.kr.sharek.common.exception.httpexception;

public class NotFoundException extends CustomException {

  public NotFoundException(String message, int code) {
    super(message, code);
  }
}
