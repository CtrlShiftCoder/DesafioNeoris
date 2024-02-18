package cl.camiletti.desafio.repository;


import cl.camiletti.desafio.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByEmail(String email);
}
