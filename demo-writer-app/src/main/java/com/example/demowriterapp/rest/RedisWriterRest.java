package com.example.demowriterapp.rest;

import com.example.demowriterapp.model.RedisRecordModel;
import com.example.demowriterapp.repository.RedisRecordRepository;
import com.example.demowritersdk.RedisWriterFeign;
import dto.RedisRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisWriterRest implements RedisWriterFeign {

    private final RedisRecordRepository repository;
    @PostMapping
    public ResponseEntity<HttpStatus> createRecord(RedisRecord record) {
        repository.save(new RedisRecordModel(record.key(), record.value()));
        return ResponseEntity.ok()
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RedisRecord> findRecord(@PathVariable String id) {
        RedisRecordModel redisRecordModel = repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("record with id [%s] not found", id)));
        return ResponseEntity.ok(new RedisRecord(redisRecordModel.getId(), redisRecordModel.getValue()));
    }
}
