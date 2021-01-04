package vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @ClassName customerVo
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/30 9:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class customerVo {
    private Integer id;
    private String name;
    private String  phone;
    private String adress;
    private String credit;
    private Integer p_id;
    private Date time;
    private Integer e_id;


    @Override
    public String toString() {
        return this.name;
    }
}
