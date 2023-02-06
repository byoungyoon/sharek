package co.kr.sharek.project.repository;

import co.kr.sharek.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsById(String id);
}
