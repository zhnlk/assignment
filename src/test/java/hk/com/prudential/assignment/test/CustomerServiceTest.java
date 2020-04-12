package hk.com.prudential.assignment.test;

import hk.com.prudential.assignment.AssignmentApplication;
import hk.com.prudential.assignment.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void testCustomerList(){
        customerService.list();
    }

}
