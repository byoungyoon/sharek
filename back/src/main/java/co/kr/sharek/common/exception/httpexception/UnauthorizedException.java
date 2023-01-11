package co.kr.sharek.common.exception.httpexception;

public class UnauthorizedException extends CustomException {

  public UnauthorizedException(String message, int code) {
    super(message, code);
  }
}
