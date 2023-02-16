package co.kr.sharek.project.repository;

import co.kr.sharek.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>, UserRepositoryCustom {
    Optional<User> findById(String id);
    boolean existsById(String id);
}
