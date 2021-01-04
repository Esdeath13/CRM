package service;

import entity.Information;

import java.util.List;

/**
 * @ClassName InformationService
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/31 14:26
 **/
public interface InformationService {
    /**
     * 根据
     *
     * @param p_id 产品id
     * @return 列表
     */
    List<Information> selectByCustomerId(int p_id);

    /**
     * 查询所有班级
     *
     * @return List<Information>
     */
    List<Information> selectAll();
}
