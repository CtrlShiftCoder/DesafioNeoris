package cl.camiletti.desafio.repository;

import cl.camiletti.desafio.model.PhoneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneModel, Long> {
}