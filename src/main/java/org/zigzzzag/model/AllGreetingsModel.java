package org.zigzzzag.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;

@ApiModel(description = "Model of all greetings")
public class AllGreetingsModel {

    @ApiModelProperty(value = "Greeting collection")
    private Collection<Greeting> greetings;


    public AllGreetingsModel() {
    }

    public AllGreetingsModel(Collection<Greeting> greetings) {
        this.greetings = greetings;
    }


    public Collection<Greeting> getGreetings() {
        return greetings;
    }

    public void setGreetings(Collection<Greeting> greetings) {
        this.greetings = greetings;
    }
}
