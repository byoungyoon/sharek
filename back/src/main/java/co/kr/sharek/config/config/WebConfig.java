package co.kr.sharek.config.config;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOriginPatterns("*")
            
        .allowCredentials(true)
        .allowedMethods("*");
  }

  /**
   * XSS Filter
   * @return
   */
  @Bean
  public FilterRegistrationBean<XssEscapeServletFilter> getFilterRegistrationBean(){
    FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(new XssEscapeServletFilter());
    registrationBean.setOrder(1);
    registrationBean.addUrlPatterns("/*");
    return registrationBean;
  }
}
