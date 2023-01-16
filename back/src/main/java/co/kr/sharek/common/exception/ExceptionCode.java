package co.kr.sharek.common.exception;

import co.kr.sharek.common.exception.httpexception.CustomException;
import co.kr.sharek.common.exception.httpexception.InternalServerException;
import co.kr.sharek.common.exception.httpexception.NotFoundException;
import co.kr.sharek.common.exception.httpexception.UnauthorizedException;
import lombok.Getter;

@Getter
public enum ExceptionCode {

  /* 5xx : 서버 관련 */
  INTERNAL_SERVER(new InternalServerException("서버 에러입니다. 서버 관리자에게 문의해주세요.", 500)),

  /* 6xx :사용자 관련 */
  NOT_FOUND_USER(new NotFoundException("해당하는 사용자가 없습니다.", 600)),

  /* 7xx : 블로그 관련 */
  NOT_FOUND_POST(new NotFoundException("존재하지 않는 게시글입니다.", 700)),
  UNAUTHORIZED_POST(new UnauthorizedException("접근 권한이 없습니다.", 704)),

  /* 8xx : 토큰 관련 */
  SHOULD_LOGIN(new UnauthorizedException("로그인이 필요합니다.", 800)),
  INVALID_JWT_TOKEN(new UnauthorizedException("토큰이 유효하지 않습니다", 801)),
  MISMATCH_REFRESH_TOKEN(new UnauthorizedException("토큰의 유저 정보가 일치하지 않습니다", 802)),
  NOT_EXISTS_ACCESS_TOKEN(new UnauthorizedException("엑세스 토큰이 존재하지 않습니다.", 803));


  private final CustomException exception;

  ExceptionCode(CustomException e) {
    this.exception = e;
  }

  public String getMessage() {
    return exception.getMessage();
  }

  public int getCode() {
    return exception.getCode();
  }
}
