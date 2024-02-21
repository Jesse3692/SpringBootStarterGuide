package com.shiyanlou.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.shiyanlou.springboot.dao.BaseMapper;
import com.shiyanlou.springboot.service.IBaseService;

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    protected BaseMapper<T> baseMapper;

    @Override
    public void delete(Integer id) {
        baseMapper.delete(id);
    }

    @Override
    public Integer save(T t) {
        return baseMapper.save(t);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public T findById(Integer id) {
        return baseMapper.findById(id);
    }

    @Override
    public List<T> list() {
        return baseMapper.list();
    }
}
