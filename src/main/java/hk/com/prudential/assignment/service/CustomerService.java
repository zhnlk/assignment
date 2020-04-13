package hk.com.prudential.assignment.service;

import hk.com.prudential.assignment.base.BaseService;
import hk.com.prudential.assignment.entity.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
public interface CustomerService extends BaseService<Customer> {

    List<Customer> list();

    Customer save(Customer build);

    Optional<Customer> getById(String customerId);
}
