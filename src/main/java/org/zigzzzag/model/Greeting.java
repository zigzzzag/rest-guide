package org.zigzzzag.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Greeting model")
public class Greeting {

    @ApiModelProperty(value = "identifier", required = true, example = "42")
    private long id;

    @ApiModelProperty(value = "Content", required = true, example = "World")
    private String content;


    public Greeting() {
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
