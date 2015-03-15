package com.concretepage;

import com.ocs.entity.Customer;
import com.ocs.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ocs1 on 3/11/2015.
 */
@Service
public class CustomerServiceRunner {
    @Autowired
    CustomerService customerService;

    public void saveOrUpdateCustomer(Customer customer) {
        customerService.saveOrUpdateCustomer(customer);
    }

    public Customer getCustomerByParameter(String parameterType, String parameterValue) {
        switch (Integer.parseInt(parameterType)) {
            case 1:
                return this.getCustomerByNationalId(parameterValue);
            case 2:
                return this.getCustomerByNationalId(parameterValue);
            case 3:
                return this.getCustomerByNationalId(parameterType);
            default:
                System.out.println("invalid parameter");
        }

        return null;
    }

    private Customer getCustomerByNationalId(String nationalId) {
        Customer customer = customerService.getCustomerByNationalId(nationalId);
        return customer;
    }
}

