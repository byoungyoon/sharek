package co.kr.sharek.project.dto.common;

import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * common request page dto
 */
@Getter
@Setter
@AllArgsConstructor
public class ReqPageDto {
    public ReqPageDto(){
        this.name = "";
        this.option1 = "";
        this.option2 = "";
        this.option3 = "";
    }

    @NotNull
    @Positive
    @ApiParam(value = "현재 페이지", example = "1")
    private int currentPage;

    @NotNull
    @Positive
    @ApiParam(value = "한계 페이지", example = "20")
    private int perPage;

    @ApiParam(value = "필터 조건1", example = "")
    private String name;

    @ApiParam(value = "필터 조건2")
    private String option1;

    @ApiParam(value = "필터 조건3")
    private String option2;

    @ApiParam(value = "필터 조건4")
    private String option3;
}
