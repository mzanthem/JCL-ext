package io.github.mzanthem.mapper;

import io.github.mzanthem.model.BzCode;
import io.github.mzanthem.model.BzCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BzCodeMapper {
    int countByExample(BzCodeExample example);

    int deleteByExample(BzCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BzCode record);

    int insertSelective(BzCode record);

    List<BzCode> selectByExample(BzCodeExample example);

    BzCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BzCode record, @Param("example") BzCodeExample example);

    int updateByExample(@Param("record") BzCode record, @Param("example") BzCodeExample example);

    int updateByPrimaryKeySelective(BzCode record);

    int updateByPrimaryKey(BzCode record);
}