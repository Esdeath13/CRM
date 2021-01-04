package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName employee
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private String id;
    private String name;
    private String department;
    private String type;
    private String t_id;
    private Float salary;
}
