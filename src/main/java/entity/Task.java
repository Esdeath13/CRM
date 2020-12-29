package entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Task
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    private Integer id;
    private String quantity;
    private String profit;
    private Date time;
    private Integer condition;
}
