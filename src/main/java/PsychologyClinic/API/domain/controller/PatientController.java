package PsychologyClinic.API.domain.controller;

import PsychologyClinic.API.domain.patient.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerPatient(@RequestBody @Valid PostPatientDto data, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(data);
        repository.save(patient);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientDetailsDto(patient));
    }

    @GetMapping
    public ResponseEntity<Page<GetPatientsDto>> getPatients(@PageableDefault(size = 10, sort = {"firstName"}) Pageable pagination) {

        var page = repository.findAll(pagination).map(GetPatientsDto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity GetPatientById(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);

        return ResponseEntity.ok(new PatientDetailsDto(patient));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid PutPatientDto data) {
        var patient = repository.getReferenceById(data.id());
        patient.updatePatientInfo(data);

        return ResponseEntity.ok(new PatientDetailsDto(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
