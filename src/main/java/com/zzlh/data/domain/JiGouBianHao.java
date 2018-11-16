package com.zzlh.data.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

/**
 * @Description TODO
 * @author liulei
 * @date 2018年11月15日 下午5:54:16
 */
@Data
public class JiGouBianHao {
	private String JGBH;//机构编号id
	private String JGMC;//主体名称
	private String ZTDM;//主体代码
	private String LXDZ;//联系地址
	private String SBR;//联系人
	private String LXDH;//联系电话
	private String EMAIL;//联系邮箱
	
	private BigDecimal ZCSJ;//注册时间
	private String YZRY;//审核人
	private BigDecimal YZSJ;//审核通过时间
	private BigDecimal SYBZ;//状态 -1-注销  1-正式 2-停用   0-待验证 -2-验证未通过 3-黑名单
	private String GBDQ;//国别/地区
	
	private String DWXZ;//单位性质
	private String XZQY;//行政区域
	private String HYDM;//行业代码
	private String CABH;//CA证书编号
	private String ZXDJ;//资信等级
	private String KHYH;//开户银行
	
	private String JBZH;//基本账户账号
	private String YZBM;//邮政编码
	private BigDecimal ZCZB;//注册资本
	private String ZCBZ;//注册资本币种
	private String ZCDW;//注册资本单位
	private String FZR;//负责人&法人名称
	private BigInteger DATAID;//负责人&法人名称
}
