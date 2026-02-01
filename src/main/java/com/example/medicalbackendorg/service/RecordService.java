package com.example.medicalbackendorg.service;

import com.example.medicalbackendorg.entity.Record;
import com.example.medicalbackendorg.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    public Record getRecordById(Long id) {
        return recordRepository.findById(id).orElse(null);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

}
