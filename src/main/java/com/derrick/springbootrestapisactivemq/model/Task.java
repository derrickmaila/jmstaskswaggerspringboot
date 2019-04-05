package com.derrick.springbootrestapisactivemq.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about Tasks")
public class Task {
    @ApiModelProperty(notes = "Task id")
    private Long id;
    @ApiModelProperty(notes = "Task name")
    private String name;

    public Task(){
    }

    public Task(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
