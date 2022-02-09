package com.sunglowsys.resource;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.sercice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<?> create(@RequestBody Customer customer){
        Customer result = customerService.createCustomer(customer);
        return ResponseEntity.ok().body("Customer is Created Successfully : " + result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer,@PathVariable("id") Long id ){
        Customer result = customerService.update(customer,id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/customers/{id}")
    public Customer getById(@PathVariable("id") Long id){
        return customerService.findById(id);
    }

    @GetMapping
    public List<Customer> getAll(){
        List<Customer> result1 = customerService.findAll();
        return result1;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        customerService.delete(id);
        return ResponseEntity.ok().body("Customer is deleted Successfully on this Id : " + id);
    }
}
