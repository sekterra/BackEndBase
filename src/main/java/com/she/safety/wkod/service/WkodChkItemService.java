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
package com.she.safety.wkod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.she.safety.model.WkodChkItem;
import com.she.safety.wkod.mapper.WkodChkItemMapper;

/**
 * 건강검진기관 기능정의
 *
 */
@Service
public class WkodChkItemService 
{
	
	@Autowired
	private WkodChkItemMapper wkodChkItemMapper;
	
	/**
	 * 작업허가서 항목 조회
	 * @param wkodDutyCd 점검부서구분 코드
	 * @param chkItemNm 항목명
	 * @return 작업허가서 항목 목록
	 * @throws Exception
	 */
	public List<WkodChkItem> getWkodChkItems(String wkodKindCd, String wkodDutyCd, String chkItemNm) throws Exception 
	{
		return wkodChkItemMapper.getWkodChkItems(wkodKindCd, wkodDutyCd, chkItemNm);
	}
	
	/**
	 * 작업허가서 항목 상세 조회
	 * @param chkItemNo 작업허가서 항목 코드
	 * @return 작업허가서 항목
	 * @throws Exception
	 */
	public WkodChkItem getWkodChkItem(String chkItemNo) throws Exception 
	{
		return wkodChkItemMapper.getWkodChkItem(chkItemNo);
	}
	
	/**
	 * 작업허가서 항목 생성
	 * @param wkodChkItem 작업허가서 항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public String createWkodChkItem(WkodChkItem wkodChkItem) throws Exception 
	{
		wkodChkItemMapper.createWkodChkItem(wkodChkItem);
		return wkodChkItem.getChkItemNo();
	}
	
	/**
	 * 작업허가서 항목 수정
	 * @param wkodChkItem 작업허가서 항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateWkodChkItem(WkodChkItem wkodChkItem) throws Exception 
	{
		return wkodChkItemMapper.updateWkodChkItem(wkodChkItem);
	}
}
