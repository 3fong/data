package com.zzlh.data.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zzlh.data.domain.JiGouBianHao;

/**
 * @Description TODO
 * @author liulei
 * @date 2018年11月16日 下午1:24:14
 */
public interface OrganizationDao {

	int countDataId();
	
	List<JiGouBianHao> selectByDataId(@Param("num") Integer num);
	
	int updateDataId(List<Map<String,Object>> dataIds);
}
