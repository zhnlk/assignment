package hk.com.prudential.assignment.repository;

import hk.com.prudential.assignment.entity.Car;
import hk.com.prudential.assignment.enums.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, String> {

    @Query("select c from Car c where c.model = :model")
    List<Car> listByModel(@Param("model") String model);

    @Query("select c from Car c where c.status = :status")
    List<Car> listByCarStatus(@Param("status") CarStatus status);

    @Modifying
    @Query("update Car c set c.status = :status where c.id = :id")
    void switchCarStatus(@Param("id") String id, @Param("status") CarStatus status);
}
