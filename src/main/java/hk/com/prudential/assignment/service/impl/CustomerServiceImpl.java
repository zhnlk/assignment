package hk.com.prudential.assignment.service.impl;

import hk.com.prudential.assignment.entity.Customer;
import hk.com.prudential.assignment.repository.CustomerRepository;
import hk.com.prudential.assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer build) {
        return customerRepository.save(build);
    }

    @Override
    public Optional<Customer> getById(String customerId) {
        return customerRepository.findById(customerId);
    }
}
