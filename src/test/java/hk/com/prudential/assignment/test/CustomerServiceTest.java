package hk.com.prudential.assignment.test;

import hk.com.prudential.assignment.AssignmentApplication;
import hk.com.prudential.assignment.entity.Customer;
import hk.com.prudential.assignment.enums.CustomerStatus;
import hk.com.prudential.assignment.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author zhnlk
 * @date 2020/4/12
 * @mail tomleader0828@gmail.com
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssignmentApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testCustomerList() {
        customerService.list();
    }

    @Test
    public void testSaveCustomer() {

        Customer customer = Customer.builder().name("tom")
                .status(CustomerStatus.NORMAL)
                .build();
        Customer save = customerService.save(customer);

        Assert.assertEquals(customer, save);
    }

    @Test
    public void testGetById() {
        String customerId = "11111111";
        Customer customer = customerService.getById(customerId).orElse(null);

        assert customer != null;

        Assert.assertEquals(customerId, customer.getId());
    }
}
