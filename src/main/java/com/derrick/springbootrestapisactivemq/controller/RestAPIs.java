package com.derrick.springbootrestapisactivemq.controller;

import com.derrick.springbootrestapisactivemq.jms.producer.JmsProducer;
import com.derrick.springbootrestapisactivemq.model.MessageStorage;
import com.derrick.springbootrestapisactivemq.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestAPIs {

    @Autowired
    JmsProducer jmsProducer;
    @Autowired
    private MessageStorage taskStorage;

    @PostMapping(value="/api/task")
    public Task postCustomer(@RequestBody Task task){
        jmsProducer.send(task);
        return task;
    }


    @GetMapping(value="/api/tasks")
    public List<Task> getAll(){
        List<Task> tasks = new ArrayList<Task>(taskStorage.getAll());
        taskStorage.clear();
        return tasks;
    }
}
