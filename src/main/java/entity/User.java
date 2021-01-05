package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName user
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String account;
    private String password;
    private Integer type;
}
