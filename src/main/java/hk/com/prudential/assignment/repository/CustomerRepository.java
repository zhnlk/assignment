package hk.com.prudential.assignment.repository;

import hk.com.prudential.assignment.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Repository
public interface CustomerRepository extends JpaRepository<Car, String> {
}
