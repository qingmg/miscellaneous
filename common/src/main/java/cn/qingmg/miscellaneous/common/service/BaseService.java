package cn.qingmg.miscellaneous.common.service;

import cn.qingmg.miscellaneous.common.entity.Criteria;
import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author vhs
 * @Date 2019-04-16
 * @Version 1.0
 */
public interface BaseService<T extends Serializable> {

    List<T> query2List(Criteria criteria);

    T query2OneRecord(Criteria criteria);

    List<T> queryAll();

    Page<T> queryForPage(int curr_page, int page_count, String orderBy);

    T queryByPrimaryKey(Object id);

    int insertBySelective(T t);

    int updateBySelective(T t);

    int deleteByPrimaryKey(Object id);
}
