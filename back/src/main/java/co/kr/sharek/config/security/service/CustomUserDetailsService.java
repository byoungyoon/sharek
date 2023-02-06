package co.kr.sharek.config.security.service;

import co.kr.sharek.project.dto.user.UserDto;
import co.kr.sharek.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    UserDto userDto = userRepository.findById(id)
            .map((user) -> new UserDto().domainByDto(user))
            .orElseThrow(() -> new UsernameNotFoundException(id + " 을 찾을 수 없습니다."));

    return createUserDetails(userDto);
  }

  private UserDetails createUserDetails(UserDto userDto) {
    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userDto.getAuth());

    return new User(
        String.valueOf(userDto.getId())
                     , userDto.getPw()
                     , Collections.singleton(grantedAuthority));
  }
}
