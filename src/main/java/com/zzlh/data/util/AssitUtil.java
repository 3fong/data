package com.zzlh.data.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 帮助工具类
 * @author liulei
 * @date 2018年11月16日 下午3:15:45
 */
public class AssitUtil {
	
	public static Date strToDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.parse(str);
	}
}
