package com.zzlh.data.domain;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

/**
 * @Description TODO
 * @author liulei
 * @date 2018年11月15日 下午5:53:01
 */

@Data
public class User {
	private BigInteger id;
	private String userName;//用户ID
	private String userNickname;//用户姓名
	private String password;//密码
	private String phone;//'电话'
	private String mobile;// 手机
	private int isMobileUsed;// 手机号是否绑定
	
	private String email;//email
	private int isEmailUsed;// email是否绑定
	private String fax;// 传真
	private Date registerTime;// 注册时间
	private Date loginTime;// 登录时间
	private int status;//状态使用标志  -1-注销  1-正式 2-停用  0-待验证 -2-验证未通过 3-进入黑名单
	private int version;// 版本号，用于乐观锁
	
	private String codeType;// 类型
	private String code;// 代码
	private String caId;// ca的id
	private String caDn;// ca内容
	private String openId;// 微信端登录
	private int isLocked;// 是否锁定
	
	private Date passChangedTime;// 密码修改时间
	private Date updateTime;// 记录更新时间
	private String attachmentCode;// 附件表code
	private Date approveTime;// 批复时间
	private int loginAttemp;// 错误后登录次数
	private Date caExpiredTime;// ca过期时间
	
	private Date gmtCreate;//数据库创建数据时间
	private Date gmtUpdate;//数据库更新数据时间
	private BigInteger organizationId;// organization表id
}
