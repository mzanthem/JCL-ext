package io.github.mzanthem.mapper;

import io.github.mzanthem.model.CfgVersions;
import io.github.mzanthem.model.CfgVersionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgVersionsMapper {
    int countByExample(CfgVersionsExample example);

    int deleteByExample(CfgVersionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfgVersions record);

    int insertSelective(CfgVersions record);

    List<CfgVersions> selectByExample(CfgVersionsExample example);

    CfgVersions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfgVersions record, @Param("example") CfgVersionsExample example);

    int updateByExample(@Param("record") CfgVersions record, @Param("example") CfgVersionsExample example);

    int updateByPrimaryKeySelective(CfgVersions record);

    int updateByPrimaryKey(CfgVersions record);
}