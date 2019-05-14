package io.github.mzanthem.mapper;

import io.github.mzanthem.model.MonitorLog;
import io.github.mzanthem.model.MonitorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorLogMapper {
    int countByExample(MonitorLogExample example);

    int deleteByExample(MonitorLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MonitorLog record);

    int insertSelective(MonitorLog record);

    List<MonitorLog> selectByExample(MonitorLogExample example);

    MonitorLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MonitorLog record, @Param("example") MonitorLogExample example);

    int updateByExample(@Param("record") MonitorLog record, @Param("example") MonitorLogExample example);

    int updateByPrimaryKeySelective(MonitorLog record);

    int updateByPrimaryKey(MonitorLog record);
}