package co.kr.sharek.common.util.enums;

/**
 *  enum의 공통적인 custom valueOf
 *  만든 이유 : valueOf 없을 시 exception 대신 null
 */
public class BaseEnum {
    public static <T extends Enum<T> & IEnum<D>, D> T getValueOf(Class<T> enumClass, D code) {
        for (T e : enumClass.getEnumConstants()) {
            if (e.getValue().equals(code))
                return e;
        }

        return null;
    }
}
