package com.derrick.springbootrestapisactivemq.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "All details about the Task Message Storage. ")
public class MessageStorage {
    @ApiModelProperty(notes ="List of Tasks")
    private List<Task> tasks  = new ArrayList<Task>();

    public void add(Task task){
        tasks.add(task);
    }
    public void clear(){
        tasks.clear();
    }
    public List<Task> getAll(){
        return tasks;
    }
}
