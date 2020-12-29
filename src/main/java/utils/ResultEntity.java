package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResultEntity
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 13:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultEntity {
    private int code;
    private String message;
    private Object data;
    private int type;
}
