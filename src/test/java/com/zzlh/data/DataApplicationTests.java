package com.zzlh.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzlh.data.service.OrganizationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataApplicationTests {
	@Autowired
	private OrganizationService dataImport;
	
	@Test
	@Ignore
	public void contextLoads() {
		List<Map<String,Object>> dataIds = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		map.put("id","0001");
		map.put("dataId",new BigInteger("1"));
		dataIds.add(map);
		Map<String,Object> map2 = new HashMap<>();
		map2.put("id","0001e96ea5b0457c9092acb1ae25065a");
		map2.put("dataId", new BigInteger("2"));
		dataIds.add(map2);
		dataImport.updateJiGou(dataIds);
	}

}
