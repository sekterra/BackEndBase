/** 
 * Copyright (C) 2019, 2019 All Right Reserved, http://www.yullin.com/
 * 
 * SHE Business can not be copied and/or distributed without the express
 * permission of Yullin Technologies
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 
 */

package com.she.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.she.manage.model.User;
import org.apache.commons.lang3.StringUtils;

/**
 * 공용으로 사용될만한 함수모음
 *
 */
public class Methods
{
	/**
	 * 로그인 사용자 정보 - 임시
	 * @return
	 */
	public static User getLoginUser()
	{
		User user = new User();
		user.setUserId("dev");
		user.setUserNm("개발자");
		user.setDeptCd("yullin");
		user.setDeptNm("열린기술");
		user.setComSexTypeCd("M");
		user.setComSexTypeNm("남자");
		user.setOfficeTel("02-555-7033");
		user.setPhoneNo("010-555-7033");
		user.setEmail("dev@yullin.com");
		user.setBirthYmd("1980-01-01");
		user.setEntryYmd("2002-01-01");
		
		return user;
	}
	
	/**
	 * 문자열 날짜형 변환
	 * @param s 문자
	 * @return 변환된 날짜(error->null)
	 */
	public static Date convertStringToDate(String s)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.parse(s);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/**
	 * 날짜형 문자 변환(yyyy-MM-dd)
	 * @param d 날짜
	 * @return 변환된 문자(error->null)
	 */
	public static String convertDateToString(Date d)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(d);
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	
	/**
	 * 지정된 포멧으로 날짜형 문자 변환
	 * @param d 날짜
	 * @param format 지정포멧
	 * @return 변환된 문자(error->null)
	 */
	public static String convertDateToString(Date d, String format)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(d);
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	/**
	 * padChar로 size길이 만큼 좌측 문자열 채우는 함수
	 * @param str : 원본 문자열
	 * @param size : 채울 크기
	 * @param padChar : 채울 문자
	 * @return left padding 된 문자열
	 * ex) leftPad('code', 3', '0') → 000code
	 */
	public static String leftPad(String str, int size, char padChar) {
		return StringUtils.leftPad(str, size, padChar);
	}

	/**
	 * padChar로 size길이 만큼 우측 문자열 채우는 함수
	 * @param str : 원본 문자열
	 * @param size : 채울 크기
	 * @param padChar : 채울 문자
	 * @return
	 * ex) rightPad('code', 3', '0') → code000
	 */

	public static String rightPad(String str, int size, char padChar) {
		return StringUtils.rightPad(str, size, padChar);

	}
}
