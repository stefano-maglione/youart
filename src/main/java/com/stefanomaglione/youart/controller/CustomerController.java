package com.stefanomaglione.youart.controller;

import com.stefanomaglione.youart.model.Customer;
import com.stefanomaglione.youart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*@RequestMapping(value = "/customer" , method = RequestMethod.GET)
    public @ResponseBody List<Customer>  getCustomers() {

        return (List<Customer>) customerService.findAll();
    }*/

    @RequestMapping(value = "/customer/{id}" , method = RequestMethod.GET)
    public @ResponseBody Customer getCustomer( @PathVariable String id){

        Customer u = customerService.getCustomerByCustomerId(id);

        return u;
    }

    @RequestMapping(value = "/customer" , method = RequestMethod.POST)
    public @ResponseBody Customer addCustomer( @RequestBody Customer customer){

        Customer u = customerService.createCustomer(customer);

        return u;
    }




}
