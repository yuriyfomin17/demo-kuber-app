package com.example.demowritersdk;

import dto.RedisRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "redis-writer", url = "${redis.writer.url}")
public interface RedisWriterFeign {

    @PostMapping
    ResponseEntity<HttpStatus> createRecord(@RequestBody RedisRecord record);

    @GetMapping("/{id}")
    ResponseEntity<RedisRecord> findRecord(@PathVariable String id);
}