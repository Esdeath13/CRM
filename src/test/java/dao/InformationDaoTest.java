package dao;

import entity.Information;
import factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class InformationDaoTest {
    private final InformationDao informationDao = DaoFactory.getInformationDaoInstance();

    @Test
    public void selectAll() {
        List<Information> informationList = null;
        try {
            informationList = informationDao.selectAll();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        System.out.println(informationList);
    }
}