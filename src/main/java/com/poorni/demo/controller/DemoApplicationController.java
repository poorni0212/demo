package com.poorni.demo.controller;

import com.poorni.demo.Service.DemoApplicationService;
import com.poorni.demo.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/users")
public class DemoApplicationController {


    private final DemoApplicationService demoApplicationService;

    public DemoApplicationController(DemoApplicationService demoApplicationService) {
        this.demoApplicationService = demoApplicationService;
    }

    @GetMapping
    public ResponseEntity<Object> findAll(@RequestParam("filterBy") String filterBy, @RequestParam("value") String value) {
        return new ResponseEntity<Object>(demoApplicationService.findAllUsers(filterBy, value), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createUser(@RequestBody Employee employee) {
        demoApplicationService.createUser(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findUser(@PathVariable int id) {
        Employee employee = demoApplicationService.findUser(id);
        if (Objects.nonNull(employee)) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        demoApplicationService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "/address/{id}")
    public ResponseEntity<?> findAddress(@PathVariable int id) throws Exception {
        String address = demoApplicationService.findAddress(id);
        if (Objects.nonNull(address)) {
            return ResponseEntity.ok(address);
        }
        return ResponseEntity.notFound().build();
    }



}
