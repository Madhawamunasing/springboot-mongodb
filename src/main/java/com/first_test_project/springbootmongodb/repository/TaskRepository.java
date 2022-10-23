package com.first_test_project.springbootmongodb.repository;

import com.first_test_project.springbootmongodb.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task,String> {

    List<Task> findBySeverity(int severity);
}
