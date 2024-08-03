package com.example.demoreaderapp.rest;

import com.example.demowritersdk.RedisWriterFeign;
import dto.RedisRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DemoReaderRest {

    private final RedisWriterFeign redisWriterFeign;

    @GetMapping("/{id}")
    public ResponseEntity<RedisRecord> findRedisRecord(@PathVariable String id) {
        log.info("executing find request with record id [{}] ", id);
        return redisWriterFeign.findRecord(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> writeRecord(@RequestBody RedisRecord record) {
        log.info("executing write request with record body [{}] ", record);
        return redisWriterFeign.createRecord(record);
    }
}