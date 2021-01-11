package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName showCustomerVo
 * @Description TODO
 * @Author YWT
 * @Date 2021/1/7 13:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowCustomerVo {
    private String id;
    private String name;
    private String phone;
    private String adress;
    private String credit;
    private String p_id;
    private Date c_time;
    private String p_name;
    private String p_price;

}
