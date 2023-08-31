package PsychologyClinic.API.domain.patient;

import PsychologyClinic.API.domain.psychologist.Psychologist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findAll(Pageable pagination);
}
