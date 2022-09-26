package se.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import se.test.dto.MontyResponse;
import se.test.dto.SimulationRequest;
import se.test.service.MontyService;

@RestController
@RequestMapping(value = "/")
public class MontyController {
    @Autowired
    private MontyService montyService;

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("start")
    @ResponseStatus(HttpStatus.CREATED)
    public MontyResponse runSimulation(@RequestBody SimulationRequest request) {
        return montyService.startSimulation(request);
    }
}