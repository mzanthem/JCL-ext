package io.github.mzanthem.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import io.github.mzanthem.model.User;
import io.github.mzanthem.model.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);
    //返回对象
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    
    //-------------- 自定义SQL -----------------//
    User findById(Long id);
    
    List<User> findAll();

    //@Params 会自动把参数封装成map
    //自定义翻页
	int count(@Param("params")Map<String, Object> params);
	//自定义翻页
	List<User> page(@Param("params")Map<String, Object> params, @Param("start")Integer start, @Param("size")Integer size, @Param("sortColumn")String sortColumn);
    
}