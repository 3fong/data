package com.zzlh.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzlh.data.domain.JiGouBianHao;
import com.zzlh.data.domain.Organization;
import com.zzlh.data.service.OrganizationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataApplicationTests {
	@Autowired
	private OrganizationService dataImport;
	
	@Test
	public void contextLoads() {
		List<JiGouBianHao> dataIds = new ArrayList<>();
		/*Map<String,Object> map = new HashMap<>();
		map.put("id","0001");
		map.put("dataId",new BigInteger("1"));
		Map<String,Object> map2 = new HashMap<>();
		map2.put("id","0001e96ea5b0457c9092acb1ae25065a");
		map2.put("dataId", new BigInteger("2"));*/
		JiGouBianHao org = new JiGouBianHao();
		org.setJGBH("0001");
		org.setDATAID(new BigInteger("1"));
		dataIds.add(org);
		JiGouBianHao org2 = new JiGouBianHao();
		org2.setJGBH("0001e96ea5b0457c9092acb1ae25065a");
		org2.setDATAID(new BigInteger("2"));
		dataIds.add(org2);
		dataImport.updateJiGou(dataIds);
	}

}
