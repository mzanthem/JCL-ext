package io.github.mzanthem.mapper;

import io.github.mzanthem.model.Jar;
import io.github.mzanthem.model.JarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JarMapper {
    int countByExample(JarExample example);

    int deleteByExample(JarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Jar record);

    int insertSelective(Jar record);

    List<Jar> selectByExample(JarExample example);

    Jar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Jar record, @Param("example") JarExample example);

    int updateByExample(@Param("record") Jar record, @Param("example") JarExample example);

    int updateByPrimaryKeySelective(Jar record);

    int updateByPrimaryKey(Jar record);
}