package com.first_test_project.springbootmongodb.controller;


import com.first_test_project.springbootmongodb.model.Task;
import com.first_test_project.springbootmongodb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return service.findTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable Task taskId){
        return service.getTaskById(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity){
        return service.getTaskBySeverity(severity);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return service.deleteTask(taskId);
    }


}
