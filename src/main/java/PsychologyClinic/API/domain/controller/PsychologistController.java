package PsychologyClinic.API.domain.controller;

import PsychologyClinic.API.domain.psychologist.*;
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
@RequestMapping("/psychologists")
public class PsychologistController {

    @Autowired
    private PsychologistRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerPsychologist(@RequestBody @Valid PostPsychologistDto data, UriComponentsBuilder uriBuilder) {
        var psychologist = new Psychologist(data);
        repository.save(psychologist);

        var uri =  uriBuilder.path("/psychologists/{id}").buildAndExpand(psychologist.getId()).toUri();

        return ResponseEntity.created(uri).body(new PsychologistDetailsDto(psychologist));
    }

    @GetMapping
    public ResponseEntity<Page<GetPsychologistsDto>> getPsychologists(@PageableDefault(size = 10, sort = {"firstName"}) Pageable pagination) {

            var page = repository.findAllByActiveTrue(pagination).map(GetPsychologistsDto::new);
            return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePsychologist(@RequestBody @Valid PutPsychologistDto data) {
        var psychologist = repository.getReferenceById(data.id());
        psychologist.updatePsychologistInfo(data);

        return ResponseEntity.ok(new PsychologistDetailsDto(psychologist));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePsychologist(@PathVariable Long id) {
        //repository.deleteById(id);
        var psychologist = repository.getReferenceById(id);
        psychologist.remove();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity GetPsychologistById(@PathVariable Long id) {

        var psychologist = repository.getReferenceById(id);

        return ResponseEntity.ok(new PsychologistDetailsDto(psychologist));
    }


}
