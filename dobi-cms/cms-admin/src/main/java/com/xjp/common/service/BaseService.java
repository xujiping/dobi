package com.xjp.common.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 通用Service接口.
 */
public interface BaseService<Record, Example> {

  List<Record> select(Record record);

  Record selectByPrimaryKey(Long id);

  List<Record> selectAll();

  int insert(Record record);

  int insertSelective(Record record);

  int updateByPrimaryKeySelective(Record record);

  int updateByPrimaryKey(Record record);

  int delete(Record record);

  int deleteByPrimaryKeys(String ids);

  int deleteByExample(Example example);

  int deleteByPrimaryKey(Integer id);

  List<Record> selectByExample(Example example);

  List<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer pageSize);

  List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit);

  Record selectFirstByExample(Example example);

  int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

  int updateByExample(@Param("record") Record record, @Param("example") Example example);


  void initMapper();

}