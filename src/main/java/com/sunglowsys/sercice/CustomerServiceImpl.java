package com.sunglowsys.sercice;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer, Long id) {
        Customer customer1 = findById(id);
        if(customer.getFirstName() != null){
            customer1.setFirstName(customer.getFirstName());
        }
        if(customer.getLastName() != null){
            customer1.setLastName(customer.getLastName());
        }
        if(customer.getEmail() !=null){
            customer.setEmail(customer.getEmail());
        }
        if(customer.getMobile() !=null){
            customer1.setMobile(customer.getMobile());
        }
        if(customer.getGender() !=null){
            customer1.setGender(customer.getGender());
        }
        if(customer.getZipcode() !=null){
            customer1.setZipcode(customer.getZipcode());
        }
        return customerRepository.save(customer1);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer customer = null;
        if(optional.isPresent()){
            customer = optional.get();
        }
        else{
            throw new RuntimeException("Customer not found for ID : " + id);
        }
        return customer;
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
