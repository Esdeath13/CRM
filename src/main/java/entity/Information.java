package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Information
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 12:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Information {
    private Integer id;
    private String c_id;
    private Date time;
    private String content;
    private String p_id;
    private Integer result;

    @Override
    public String toString() {
        return this.p_id;
    }
}
