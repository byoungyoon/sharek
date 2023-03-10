package co.kr.sharek.config.config;

import co.kr.sharek.common.constants.enums.UserAuthEnum;
import co.kr.sharek.config.security.jwt.JwtAccessDeniedHandler;
import co.kr.sharek.config.security.jwt.JwtAuthenticationEntryPoint;
import co.kr.sharek.config.security.jwt.JwtSecurityConfig;
import co.kr.sharek.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@Component
public class WebSecurityConfig {

  private final JwtTokenProvider jwtTokenProvider;
  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

  private static final String[] PERMIT_URL_ARRAY = {
      "/api/**",
      "/h2-console/**",
      /* Swagger v3 */
      "/v2/api-docs",
      "/swagger-resources",
      "/swagger-resources/**",
      "/v3/api-docs/**",
      "/swagger-ui/**"
    };

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
          .httpBasic().and()// .disable()
          .headers().frameOptions().sameOrigin()
        .and()
          .csrf().ignoringAntMatchers("/h2-console/**").disable()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
          .exceptionHandling()
          .authenticationEntryPoint(jwtAuthenticationEntryPoint)
          .accessDeniedHandler(jwtAccessDeniedHandler)
        .and()
          .authorizeRequests()
          .antMatchers(PERMIT_URL_ARRAY).permitAll()
          .antMatchers("/user/**").hasAnyAuthority(
                    UserAuthEnum.ROLE_ADMIN.getValue(),
                    UserAuthEnum.ROLE_USER.getValue()
            )
          .antMatchers("/admin/**").hasAnyAuthority(
                  UserAuthEnum.ROLE_ADMIN.getValue()
            )
          .anyRequest().authenticated()
        .and()
          .apply(new JwtSecurityConfig(jwtTokenProvider))
        .and()
          .build();
  }
}
