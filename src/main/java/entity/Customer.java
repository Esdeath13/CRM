package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private Integer id;
    private String name;
    private Integer phone;
    private String adress;
    private String credit;
}
