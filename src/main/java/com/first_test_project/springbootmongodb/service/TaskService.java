package com.first_test_project.springbootmongodb.service;


import com.first_test_project.springbootmongodb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.first_test_project.springbootmongodb.model.Task;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    //CRUD

    //create
    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    //read
    public List<Task> findTasks(){
        return repository.findAll();
    }

    //single_read
    public Task getTaskById(Task taskId){
        return repository.findById(String.valueOf(taskId)).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return repository.findBySeverity(severity);
    }

    //update
    public Task updateTask(Task taskRequest){
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        return repository.save(existingTask);
    }

    //delete
    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return taskId + " Task Deleted";
    }
}
