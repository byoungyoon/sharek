package co.kr.sharek.common.exception.httpexception;

/**
 * json parse error exception
 */
public class ParseByJsonException extends CustomException {
    public ParseByJsonException(String message, int code){
        super(message, code);
    }
}
