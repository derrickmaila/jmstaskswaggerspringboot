package com.derrick.springbootrestapisactivemq.controller;

import com.derrick.springbootrestapisactivemq.jms.producer.JmsProducer;
import com.derrick.springbootrestapisactivemq.model.MessageStorage;
import com.derrick.springbootrestapisactivemq.model.Task;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Api(value="Task Integration between JMS and Springboot",description = "Operations pertaining to Task Integration System")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestAPIs {

    @Autowired
    JmsProducer jmsProducer;
    @Autowired
    private MessageStorage taskStorage;

    @ApiOperation(value ="Add a task")
    @PostMapping(value="/api/task")
    public Task postCustomer(@RequestBody Task task){
        jmsProducer.send(task);
        return task;
    }

    @ApiOperation(value="View a list of available tasks",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value="/api/tasks")
    public List<Task> getAll(){
        List<Task> tasks = new ArrayList<Task>(taskStorage.getAll());
        taskStorage.clear();
        return tasks;
    }
}
