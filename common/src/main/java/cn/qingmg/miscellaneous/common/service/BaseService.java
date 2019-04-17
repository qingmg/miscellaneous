package cn.qingmg.miscellaneous.common.service;

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

    List<T> queryAll();

    Page<T> queryForPage(int curr_page, int page_count, String orderBy);

    T queryByPrimaryKey(Object id);

    int insertBySelective(T t);

    int updateBySelective(T t);

    int deleteByPrimaryKey(Object id);
}
