package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName employeeVo
 * @Description TODO
 * @Author YWT
 * @Date 2021/1/5 10:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class employeeVo {
    private String e_id;
    private String e_name;
    private String e_department;
    private String e_type;
    private String t_id;
    private String e_salary;
    private String t_quantity;
    private String t_profit;
}
