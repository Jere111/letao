package com.letao.common.mapper;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 通用mapper
 * @param <T>
 * @param <PK>
 */

@RegisterMapper
public interface BaseMapper<T, PK> extends Mapper<T>, IdListMapper<T, PK>, InsertListMapper<T> {
}
