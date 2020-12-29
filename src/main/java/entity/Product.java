package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Product
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer id;
    private String name;
    private Date time;
    private String type;
    private Integer price;
}
