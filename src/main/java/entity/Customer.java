package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String id;
    private String name;
    private String phone;
    private String adress;
    private String credit;
    private String p_id;
    private Date c_time;
    private String e_id;
    private String p_name;

}
