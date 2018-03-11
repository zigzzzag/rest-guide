package org.zigzzzag.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zigzzzag.model.AllGreetingsModel;
import org.zigzzzag.model.Greeting;
import org.zigzzzag.service.GreetingService;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService greetingService;

    @ApiOperation(value = "Greeting simple rest", response = Greeting.class)
    @GetMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name
    ) {
        return greetingService.create(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @ApiOperation(value = "Greeting simple rest 2", response = Greeting.class, notes = "${GreetingController.greetingPost.notes}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Greeting"),
            @ApiResponse(code = 409, message = "If greeting id less than the existing")
    })
    @PostMapping("/greeting-post")
    public ResponseEntity<Greeting> greetingPost(
            @ApiParam(value = "Some greeting example", required = true)
            @RequestBody Greeting gr
    ) {
        if (gr.getId() < counter.get()) {
            return new ResponseEntity<>(new Greeting(gr.getId(), gr.getContent()), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(greetingService.create(gr.getId(), gr.getContent()), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all actual greeting", response = AllGreetingsModel.class)
    @GetMapping("/all-greetings")
    public AllGreetingsModel allGreetings() {
        return new AllGreetingsModel(greetingService.allGreetings());
    }
}
