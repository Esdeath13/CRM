package service.impl;

import entity.Information;
import factory.DaoFactory;
import service.InformationService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName InformationServiceImpl
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/31 14:30
 **/
public class InformationServiceImpl implements InformationService {
    @Override
    public List<Information> selectByCustomerId(int p_id) {
        List<Information> list = null;
        try {
            list = DaoFactory.getInformationDaoInstance().selectByCustomerId(p_id);
        }catch (SQLException e){
            System.err.println("根据产品id查询列表出现异常");
        }
        return list;
    }

    @Override
    public List<Information> selectAll() {
        List<Information> list = null;
        try {
            list = DaoFactory.getInformationDaoInstance().selectAll();
        } catch (SQLException e) {
            System.err.println("查询所有列表出现异常");
        }
        return list;
    }
}
