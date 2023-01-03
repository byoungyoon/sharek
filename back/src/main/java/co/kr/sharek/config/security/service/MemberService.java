package co.kr.sharek.config.security.service;

import co.kr.sharek.common.util.SecurityUtil;
import co.kr.sharek.config.security.dto.MemberResponseDto;
import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.config.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberService {
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  public MemberResponseDto getMyInfoBySecurity() {
    return memberRepository.findById(SecurityUtil.getCurrentMemberId())
        .map(MemberResponseDto::of)
        .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
  }

  @Transactional
  public MemberResponseDto changeMemberNickname(String email, String nickname) {
    Member member = memberRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    member.setNickname(nickname);
    return MemberResponseDto.of(memberRepository.save(member));
  }

  @Transactional
  public MemberResponseDto changeMemberPassword(String email, String exPassword, String newPassword) {
    Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    if (!passwordEncoder.matches(exPassword, member.getPassword())) {
      throw new RuntimeException("비밀번호가 맞지 않습니다");
    }
    member.setPassword(passwordEncoder.encode((newPassword)));
    return MemberResponseDto.of(memberRepository.save(member));
  }
}
