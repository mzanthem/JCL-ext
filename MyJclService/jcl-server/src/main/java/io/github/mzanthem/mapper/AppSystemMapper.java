package io.github.mzanthem.mapper;

import io.github.mzanthem.model.AppSystem;
import io.github.mzanthem.model.AppSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppSystemMapper {
    int countByExample(AppSystemExample example);

    int deleteByExample(AppSystemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppSystem record);

    int insertSelective(AppSystem record);

    List<AppSystem> selectByExample(AppSystemExample example);

    AppSystem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppSystem record, @Param("example") AppSystemExample example);

    int updateByExample(@Param("record") AppSystem record, @Param("example") AppSystemExample example);

    int updateByPrimaryKeySelective(AppSystem record);

    int updateByPrimaryKey(AppSystem record);
}