package io.github.mzanthem.mapper;

import io.github.mzanthem.model.CfgStatus;
import io.github.mzanthem.model.CfgStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgStatusMapper {
    int countByExample(CfgStatusExample example);

    int deleteByExample(CfgStatusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfgStatus record);

    int insertSelective(CfgStatus record);

    List<CfgStatus> selectByExample(CfgStatusExample example);

    CfgStatus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfgStatus record, @Param("example") CfgStatusExample example);

    int updateByExample(@Param("record") CfgStatus record, @Param("example") CfgStatusExample example);

    int updateByPrimaryKeySelective(CfgStatus record);

    int updateByPrimaryKey(CfgStatus record);
}