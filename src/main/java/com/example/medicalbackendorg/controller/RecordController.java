package com.example.medicalbackendorg.controller;

import com.example.medicalbackendorg.entity.Record;
import com.example.medicalbackendorg.repository.RecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class RecordController {

    private final RecordRepository repository;

    public RecordController(RecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Record> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Record create(@RequestBody Record record) {
        return repository.save(record);
    }

    @PutMapping("/{id}")
    public Record update(@PathVariable Long id, @RequestBody Record record) {
        Record existing = repository.findById(id).orElseThrow();
        existing.setPatientName(record.getPatientName());
        existing.setAge(record.getAge());
        existing.setGender(record.getGender());
        existing.setContactNumber(record.getContactNumber());
        existing.setDoctorName(record.getDoctorName());
        existing.setDiagnosis(record.getDiagnosis());
        existing.setVisitDate(record.getVisitDate());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
