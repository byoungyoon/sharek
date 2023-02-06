package co.kr.sharek.common.dto;

import lombok.*;

/**
 * controller response data and code
 * @param <T> Object
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResCodeDto<T extends Object> {
    private String code;
    private T data;
}
