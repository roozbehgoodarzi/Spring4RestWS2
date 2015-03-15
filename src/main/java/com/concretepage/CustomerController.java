package com.concretepage;

import com.ocs.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ocs1 on 3/11/2015.
 */
@RestController
@RequestMapping//("/service")
public class CustomerController {
    @Autowired
    CustomerServiceRunner customerServiceRunner;

    @RequestMapping(value = "/customers", method = RequestMethod.POST, headers="Accept=application/json")
    public void saveOrUpdateCustomer(@RequestBody Customer customer){
        customerServiceRunner.saveOrUpdateCustomer(customer);
    }

    @RequestMapping(value = "/customers/{param1}/{param2}", method = RequestMethod.GET)
    public Customer getCustomerByParameter(
            @PathVariable("param1") String param1,
            @PathVariable("param2") String param2){
        return customerServiceRunner.getCustomerByParameter(param1, param2);
    }
}
