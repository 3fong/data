package com.zzlh.data.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zzlh.data.dao.OrganizationDao;
import com.zzlh.data.domain.JiGouBianHao;
import com.zzlh.data.domain.Organization;
import com.zzlh.data.domain.ResponseEntity;
import com.zzlh.data.util.AssitUtil;
import com.zzlh.data.util.HttpUtil;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 数据导入服务
 * @author liulei
 * @date 2018年11月15日 下午5:49:00
 */
@Service
@Slf4j
public class OrganizationService {
	private static final int NUM = 100; // 每次获取条数
	@Autowired
	private OrganizationDao organizationDao;
	
	public void insertOrg() {
		try {
			int count = organizationDao.countDataId()/NUM;
			while(count>0) {
				List<JiGouBianHao> jiGouList = organizationDao.selectByDataId(NUM);
				List<Map<String,Object>> dataIds = new ArrayList<>();
				for (JiGouBianHao jiGou : jiGouList) {
					ResponseEntity<BigInteger> httpPost = HttpUtil.httpPost("http://192.168.153.23:9191/organization",getOrganization(jiGou));
					BigInteger dataId = httpPost.getData();
					if(httpPost == null || dataId == null) {
						log.error("org: "+ jiGou.toString());
						continue;
					}
					Map<String,Object> map = new HashMap<>();
					map.put("id",jiGou.getJGBH());
					map.put("dataId", dataId);
					dataIds.add(map);
				}
				updateJiGou(dataIds);
				count = count-1;
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
	}
	public void updateJiGou(List<Map<String,Object>> dataIds) {
		organizationDao.updateDataId(dataIds);
	}
	
	/**
	 * @Description 获取机构参数
	 * @param jiGou
	 * @return
	 * @throws ParseException
	 */
	private Organization getOrganization(JiGouBianHao jiGou) throws ParseException {
		Organization org = new Organization();
		org.setName(jiGou.getJGMC());
		org.setSubjectCode(jiGou.getZTDM());
		org.setAddress(jiGou.getLXDZ());
		org.setContact(jiGou.getSBR());
		org.setPhone(jiGou.getLXDH());
		org.setEmail(jiGou.getEMAIL());
		if(!StringUtils.isEmpty(jiGou.getZCSJ())) {
			Date registerTime = AssitUtil.strToDate(String.valueOf(jiGou.getZCSJ()));
			org.setRegisterTime(registerTime);
			org.setCreateTime(registerTime);
		}
		
		org.setApproveBy(jiGou.getYZRY());
		if(!StringUtils.isEmpty(jiGou.getYZSJ())) {
			org.setApproveTime(AssitUtil.strToDate(String.valueOf(jiGou.getYZSJ())));
		}
		if(!StringUtils.isEmpty(jiGou.getSYBZ())) {
			org.setStatus(jiGou.getSYBZ().intValue());
		}
		org.setPlatformCode("");
		org.setCountryRegion(jiGou.getGBDQ());
		org.setUnitNature(jiGou.getDWXZ());
		org.setRegionCode(jiGou.getXZQY());
		
		org.setIndustryCode(jiGou.getHYDM());
		org.setCaCode(jiGou.getCABH());
		org.setCreditRate(jiGou.getZXDJ());
		org.setOpeningBank(jiGou.getKHYH());
		org.setBasicAccount(jiGou.getJBZH());
		org.setZipCode(new BigDecimal(jiGou.getYZBM()));
		
		org.setRegCapital(jiGou.getZCZB());
		org.setRegCapCurrency(jiGou.getZCBZ());
		org.setRegUnit(jiGou.getZCDW());
		org.setFax(jiGou.getLXDH());
		org.setArtificialPerson(jiGou.getFZR());
		org.setSourceId("");
		org.setVersion(1);
		org.setCodeType("1");
		
		org.setIsGroup(1);
		org.setUpdateTime(new Date());
		org.setArtificialPersonCode("");
		org.setGmtCreate(new Date());
		org.setGmtUpdate(new Date());
		return org;
	}
	
}
