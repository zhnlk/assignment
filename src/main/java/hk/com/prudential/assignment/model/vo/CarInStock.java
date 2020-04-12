package hk.com.prudential.assignment.model.vo;

import hk.com.prudential.assignment.abstracts.AbstractObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhnlk
 * @date 2020/4/12
 * @mail tomleader0828@gmail.com
 */
@Data
@AllArgsConstructor
public class CarInStock extends AbstractObject {

    private String carModel;

    private int inStock;

    public static List<CarInStock> fromMap(Map<String, Long> map) {
        return map.keySet()
                .stream()
                .map(k -> new CarInStock(k, map.get(k).intValue()))
                .collect(Collectors.toList());
    }

}
