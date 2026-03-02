package com.vsk.mtcs.Controller;
import com.vsk.mtcs.dto.*;
import com.vsk.mtcs.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerResponse create(@RequestBody CustomerRequest request) {
        // TODO: Implement create method in CustomerService
        return null;
    }

    @GetMapping
    public List<CustomerResponse> getAll() {
        return service.getAll();
    } 
}
