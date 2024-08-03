package com.example.demowriterapp.repository;

import com.example.demowriterapp.model.RedisRecordModel;
import org.springframework.data.repository.CrudRepository;

public interface RedisRecordRepository extends CrudRepository<RedisRecordModel, String> {}