package PsychologyClinic.API.domain.psychologist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsychologistRepository extends JpaRepository<Psychologist, Long> {

    Page<Psychologist> findAllByActiveTrue(Pageable pagination);
}
