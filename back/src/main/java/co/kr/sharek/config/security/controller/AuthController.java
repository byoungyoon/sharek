package co.kr.sharek.config.security.controller;

import co.kr.sharek.common.constants.enums.ResCodeEnum;
import co.kr.sharek.common.dto.ResCodeDto;
import co.kr.sharek.common.util.JsonUtil;
import co.kr.sharek.config.security.service.AuthService;
import co.kr.sharek.project.dto.user.ReqLoginDto;
import co.kr.sharek.project.dto.user.ReqSignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthService authService;
    private final JsonUtil jsonUtil;

    @PostMapping("/signup")
    public ResponseEntity<ResCodeDto> signUp(@Valid @RequestBody ReqSignupDto reqDto) {
        jsonUtil.writeStringAndLog(reqDto);

        ResCodeDto resDto = ResCodeDto.builder()
                .code(ResCodeEnum.SUCCESS.getValue())
                .data(authService.signUp(reqDto))
                .build();

        return ResponseEntity.ok(resDto);
    }

    @PostMapping("/login")
    public ResponseEntity<ResCodeDto> login(@Valid @RequestBody ReqLoginDto reqDto) {
        jsonUtil.writeStringAndLog(reqDto);

        ResCodeDto resDto = ResCodeDto.builder()
                .code(ResCodeEnum.SUCCESS.getValue())
                .data(authService.login(reqDto))
                .build();
        return ResponseEntity.ok(resDto);
    }
}
