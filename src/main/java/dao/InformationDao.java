package dao;

import entity.Information;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName InformationDao
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/31 13:50
 **/
public interface InformationDao {
    /**
     * 按照
     *
     * @param customerId 院系id
     * @return List<Information> 院系班级集合
     * @throws SQLException 异常
     */
    List<Information> selectByCustomerId(int customerId) throws SQLException;

    /**
     * 查询
     *
     * @return List<Information>
     * @throws SQLException 异常
     */
    List<Information> selectAll() throws SQLException;
}
