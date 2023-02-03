package co.kr.sharek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class SharekApplication {

  public static void main(String[] args) {
    if(System.getProperty("spring.profiles.active") == null)
      System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "h2");

    SpringApplication.run(SharekApplication.class, args);
  }

}
