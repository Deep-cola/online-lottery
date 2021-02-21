package com.cola.base;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/21 16:12
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
