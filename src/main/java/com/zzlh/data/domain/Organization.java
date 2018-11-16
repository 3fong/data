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
public class Organization {
	private BigInteger id;
	private String name;//主体名称
	private String subjectCode;//主体代码
	private String address;//联系地址
	private String contact;//联系人
	private String phone;//联系电话
	private String email;//联系邮箱
	
	private Date registerTime;//注册时间
	private String approveBy;//审核人
	private Date approveTime;//审核通过时间
	private int status;//状态 -1-注销  1-正式 2-停用   0-待验证 -2-验证未通过 3-黑名单
	private String platformCode;//数据来源平台
	private String countryRegion;//国别/地区
	
	private String unitNature;//单位性质
	private String regionCode;//行政区域
	private String industryCode;//行业代码
	private String caCode;//CA证书编号
	private String creditRate;//资信等级
	private String openingBank;//开户银行
	
	private String basicAccount;//基本账户账号
	private BigDecimal zipCode;//邮政编码
	private BigDecimal regCapital;//注册资本
	private String regCapCurrency;//注册资本币种
	private String regUnit;//注册资本单位
	private String fax;//传真
	
	private Date createTime;//记录创建时间
	private String artificialPerson;//负责人&法人名称
	private String sourceId;//数据来源id
	private int version;//版本号，用于乐观锁
	private String codeType;//证件类别
	private int isGroup;//是否企业
	
	private String attachmentCode;//注册材料附件
	private Date updateTime;//信息变更时间
	private String artificialPersonCode;//负责人&法人证件号
	private Date gmtCreate;//数据库创建数据时间
	private Date gmtUpdate;//数据库更新数据时间
}
