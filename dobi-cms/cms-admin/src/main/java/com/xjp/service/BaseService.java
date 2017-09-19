package com.xjp.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BaseService接口
 */
public interface BaseService<Record, Example> {

  int selectCount(Record record);

  int deleteByExample(Example example);

  int deleteByPrimaryKey(Integer id);

  int insert(Record record);

  int insertSelective(Record record);

  List<Record> selectByExample(Example example);

  List<Record> selectAll();

  List<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer pageSize);

  List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit);

  Record selectFirstByExample(Example example);

  Record selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

  int updateByExample(@Param("record") Record record, @Param("example") Example example);

  int updateByPrimaryKeySelective(Record record);

  int updateByPrimaryKey(Record record);

  int deleteByPrimaryKeys(String ids);

  void initMapper();

}