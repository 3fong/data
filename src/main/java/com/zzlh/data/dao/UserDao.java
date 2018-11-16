package com.zzlh.data.dao;

import org.apache.ibatis.annotations.Param;

import com.zzlh.data.domain.User;

/**
 * @Description TODO
 * @author liulei
 * @date 2018年11月16日 下午1:24:14
 */
public interface UserDao {
	
	User selectByDataId(@Param("num") Integer num);
	
	int update(@Param("id") String id,@Param("dataId") String dataId);
}
