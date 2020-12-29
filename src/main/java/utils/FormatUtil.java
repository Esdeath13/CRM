package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FormatUtil
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 8:45
 **/
public class FormatUtil {
    public static String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     *
     * @param result
     * @return 实施情况
     */
    public static String formatResult(short result){
        if (result == 0){
            return "未解决";
        }else if (result == 1){
            return "已解决";
        }else{
            return "待跟进";
        }
    }
    public static Short formatResult(String result){
        if ("未解决".equals(result)){
            return 0;
        }else if ("已解决".equals(result)){
            return 1;
        }else{
            return 2;
        }
    }
    /**
     *
     * @param type
     * @return 用户类型
     */
    public static String formatType(short type){
        if (type == 0){
            return "管理员";
        }else if (type == 1){
            return "员工";
        }else{
            return "用户";
        }
    }
    public static Short formattype(String type){
        if ("管理员".equals(type)){
            return 0;
        }else if ("员工".equals(type)){
            return 1;
        }else{
            return 2;
        }
    }
    /**
     *
     * @param condition
     * @return 解决情况
     */
    public static String formatCondition(short condition){
        if (condition == 0){
            return "已完成";
        }else{
            return "未完成";
        }
    }
    public static Short formatCondition(String condition){
        if ("已完成".equals(condition)){
            return 0;
        }else{
            return 1;
        }
    }
}
