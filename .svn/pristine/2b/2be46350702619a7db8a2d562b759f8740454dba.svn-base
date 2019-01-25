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
package com.she.health.baseInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.she.health.baseInfo.mapper.InterviewItemMapper;
import com.she.health.model.InterviewItem;

/**
 * 문진항목 기능정의
 *
 */
@Service
public class InterviewItemService
{
	@Autowired
	private InterviewItemMapper interviewItemMapper;
	
	/**
	 * 문진항목 조회
	 * @param useYn 사용여부
	 * @return 문진항목 목록
	 * @throws Exception
	 */
	public List<InterviewItem> getInterviewItems(String useYn) throws Exception
	{
		return this.interviewItemMapper.getInterviewItems(useYn);
	}
	
	/**
	 * 문진항목 상제 조회
	 * @param heaInteItemCd 문진항목코드
	 * @return 문진항목
	 * @throws Exception
	 */
	public InterviewItem getInterviewItem(String heaInteItemCd) throws Exception
	{
		return this.interviewItemMapper.getInterviewItem(heaInteItemCd);
	}
	
	/**
	 * 문진항목 생성
	 * @param interviewItem 문진항목
	 * @return 문진항목코드
	 * @throws Exception
	 */
	public String createInterviewItem(InterviewItem interviewItem) throws Exception
	{
		this.interviewItemMapper.createInterviewItem(interviewItem);
		return interviewItem.getHeaInteItemCd();
	}
	
	/**
	 * 문진항목 수정
	 * @param interviewItem 문진항목
	 * @return 수정행수
	 * @throws Exception
	 */
	public int updateInterviewItem(InterviewItem interviewItem) throws Exception
	{
		return this.interviewItemMapper.updateInterviewItem(interviewItem);
	}
}
