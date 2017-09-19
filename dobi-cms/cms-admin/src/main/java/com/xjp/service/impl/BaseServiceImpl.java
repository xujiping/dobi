package com.xjp.service.impl;

import com.github.pagehelper.PageHelper;
import com.xjp.db.DataSourceEnum;
import com.xjp.db.DynamicDataSource;
import com.xjp.service.BaseService;
import com.xjp.util.SpringContextUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;

/**
 * 实现BaseService抽象类.
 * Created by xujiping on 2017/01/07.
 */
public abstract class BaseServiceImpl<Mapper, Record, Example>
    implements BaseService<Record, Example> {

  public Mapper mapper;

  @Override
  public List<Record> select(Record record) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method countByRecord = mapper.getClass().getDeclaredMethod("select", record.getClass());
      List<Record> result = (List<Record>) countByRecord.invoke(mapper, record);
      return result;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return null;
  }

  @Override
  public Record selectOne(Record record) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method countByRecord = mapper.getClass().getDeclaredMethod("selectOne", record.getClass());
      Record result = (Record) countByRecord.invoke(mapper, record);
      return result;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return null;
  }

  @Override
  public int delete(Record record) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method countByRecord = mapper.getClass().getDeclaredMethod("delete", record.getClass());
      Object result = countByRecord.invoke(mapper, record);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public int selectCount(Record record) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method countByRecord = mapper.getClass().getDeclaredMethod("selectCount", record.getClass());
      Object result = countByRecord.invoke(mapper, record);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public List<Record> selectAll() {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method selectByExample = mapper.getClass().getDeclaredMethod("selectAll");
      Object result = selectByExample.invoke(mapper);
      return (List<Record>) result;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return null;
  }

  @Override
  public int deleteByExample(Example example) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      Method deleteByExample = mapper.getClass().getDeclaredMethod("deleteByExample",
          example.getClass());
      Object result = deleteByExample.invoke(mapper, example);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public int deleteByPrimaryKey(Integer id) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      Method deleteByPrimaryKey = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey",
          id.getClass());
      Object result = deleteByPrimaryKey.invoke(mapper, id);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public int insert(Record record) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      Method insert = mapper.getClass().getDeclaredMethod("insert", record.getClass());
      Object result = insert.invoke(mapper, record);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public int insertSelective(Record record) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      Method insertSelective = mapper.getClass().getDeclaredMethod("insertSelective",
          record.getClass());
      Object result = insertSelective.invoke(mapper, record);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public List<Record> selectByExample(Example example) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample",
          example.getClass());
      Object result = selectByExample.invoke(mapper, example);
      return (List<Record>) result;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return null;
  }

  @Override
  public List<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer
      pageSize) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example
          .getClass());
      PageHelper.startPage(pageNum, pageSize, false);
      Object result = selectByExample.invoke(mapper, example);
      return (List<Record>) result;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return null;
  }

  @Override
  public List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example
          .getClass());
      PageHelper.offsetPage(offset, limit, false);
      Object result = selectByExample.invoke(mapper, example);
      return (List<Record>) result;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return null;
  }

  @Override
  public Record selectFirstByExample(Example example) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", example
          .getClass());
      List<Record> result = (List<Record>) selectByExample.invoke(mapper, example);
      if (null != result && result.size() > 0) {
        return result.get(0);
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return null;
  }


  @Override
  public Record selectByPrimaryKey(Long id) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
      //因通用mapper形参类型是Object，所以此处获取Long的父类Number再获取父类Object
      Method selectByPrimaryKey = mapper.getClass().getDeclaredMethod("selectByPrimaryKey", id
          .getClass().getSuperclass().getSuperclass());
      Object result = selectByPrimaryKey.invoke(mapper, id);
      return (Record) result;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return null;
  }

  @Override
  public int updateByExampleSelective(@Param("record") Record record, @Param("example") Example
      example) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      Method updateByExampleSelective = mapper.getClass().getDeclaredMethod
          ("updateByExampleSelective", record.getClass(), example.getClass());
      Object result = updateByExampleSelective.invoke(mapper, record, example);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public int updateByExample(@Param("record") Record record, @Param("example") Example example) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      Method updateByExample = mapper.getClass().getDeclaredMethod("updateByExample", record
          .getClass(), example.getClass());
      Object result = updateByExample.invoke(mapper, record, example);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public int updateByPrimaryKeySelective(Record record) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      Method updateByPrimaryKeySelective = mapper.getClass().getDeclaredMethod
          ("updateByPrimaryKeySelective", record.getClass());
      Object result = updateByPrimaryKeySelective.invoke(mapper, record);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public int updateByPrimaryKey(Record record) {
    try {
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      Method updateByPrimaryKey = mapper.getClass().getDeclaredMethod("updateByPrimaryKey",
          record.getClass());
      Object result = updateByPrimaryKey.invoke(mapper, record);
      return Integer.parseInt(String.valueOf(result));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public int deleteByPrimaryKeys(String ids) {
    try {
      if (StringUtils.isBlank(ids)) {
        return 0;
      }
      DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
      String[] idArray = ids.split("-");
      int count = 0;
      for (String idStr : idArray) {
        if (StringUtils.isBlank(idStr)) {
          continue;
        }
        Integer id = Integer.parseInt(idStr);
        Method deleteByPrimaryKey = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey", id
            .getClass());
        Object result = deleteByPrimaryKey.invoke(mapper, id);
        count += Integer.parseInt(String.valueOf(result));
      }
      return count;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    DynamicDataSource.clearDataSource();
    return 0;
  }

  @Override
  public void initMapper() {
    this.mapper = SpringContextUtil.getBean(getMapperClass());
  }

  /**
   * 获取类泛型class.
   */
  public Class<Mapper> getMapperClass() {
    return (Class<Mapper>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

}