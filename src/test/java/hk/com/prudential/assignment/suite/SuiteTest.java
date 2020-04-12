package hk.com.prudential.assignment.suite;

import hk.com.prudential.assignment.test.CarServiceTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author zhnlk
 * @date 2020/4/12
 * @mail tomleader0828@gmail.com
 */
@Slf4j
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CarServiceTest.class,
        }
)
public class SuiteTest {


}
