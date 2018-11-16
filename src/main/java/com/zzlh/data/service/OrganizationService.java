package com.zzlh.data.service;

import java.math.BigDecimal;
import java.math.BigInteger;
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
	@Autowired
	private OrganizationDao organizationDao;
	
	public void insertOrg() {
		try {
			List<JiGouBianHao> jiGouList = organizationDao.selectByDataId(0);
			List<Map<String,BigInteger>> dataIds = new ArrayList<>();
			for (JiGouBianHao jiGou : jiGouList) {
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
				ResponseEntity<BigInteger> httpPost = HttpUtil.httpPost("http://192.168.153.23:9191/organization",org);
				BigInteger dataId = httpPost.getData();
				if(httpPost == null || dataId == null) {
					log.error("org: "+ jiGou.toString());
					continue;
				}
				Map<String,BigInteger> map = new HashMap<>();
				/*map.put("id",jiGou.getJGBH());
				map.put("dataId", dataId);*/
				map.put(jiGou.getJGBH(), dataId);
				dataIds.add(map);
			}
			
		} catch (Exception e) {
			log.error(e.toString());
		}
	}
	
	public void updateJiGou(List<JiGouBianHao> dataIds) {
		organizationDao.updateDataId(dataIds);
	}
}
