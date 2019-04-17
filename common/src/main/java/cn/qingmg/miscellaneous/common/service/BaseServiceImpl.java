package cn.qingmg.miscellaneous.common.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 抽象服务层
 * @Author vhs
 * @Date 2019-04-16
 * @Version 1.0
 */
public abstract class BaseServiceImpl<D extends Mapper<T>, T extends Serializable> implements BaseService<T>  {

    @Autowired(required = false)
    protected D dao;

    /**
     * 列表 查
     */
    @Override
    public List<T> queryAll() {
        return this.dao.selectAll();
    }

    /**
     * 分页 查
     */
    @Override
    public Page<T> queryForPage(int curr_page, int page_count, String orderBy) {
        return PageHelper.startPage(curr_page, page_count).setOrderBy(orderBy)
                .doSelectPage(() -> this.dao.selectAll());
    }

    /**
     * 通过 ID 查
     */
    @Override
    public T queryByPrimaryKey(Object id) {
        return this.dao.selectByPrimaryKey(id);
    }

    /**
     * 增
     */
    @Override
    public int insertBySelective(T t) {
        return this.dao.insertSelective(t);
    }

    /**
     * 改
     */
    @Override
    public int updateBySelective(T t) {
        return this.dao.updateByPrimaryKeySelective(t);
    }

    /**
     * 通过 ID 删
     */
    @Override
    public int deleteByPrimaryKey(Object id) {
        return this.dao.deleteByPrimaryKey(id);
    }
}
