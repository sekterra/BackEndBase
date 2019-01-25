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
package com.she.health.baseInfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.health.model.InterviewItem;

/**
 * 문진항목 맵퍼
 *
 */
@Mapper
@Repository("com.she.health.baseInfo.mapper.InterviewItemMapper")
public interface InterviewItemMapper
{
	/**
	 * 문진항목 조회
	 * @param useYn 사용여부
	 * @return 문진항목 목록
	 * @throws Exception
	 */
	public List<InterviewItem> getInterviewItems(@Param("useYn") String useYn) throws Exception;
	
	/**
	 * 문진항목 상제 조회
	 * @param heaInteItemCd 문진항목코드
	 * @return 문진항목
	 * @throws Exception
	 */
	public InterviewItem getInterviewItem(@Param("heaInteItemCd") String heaInteItemCd) throws Exception;
	
	/**
	 * 문진항목 생성
	 * @param interviewItem 문진항목
	 * @return 생성행수
	 * @throws Exception
	 */
	public int createInterviewItem(InterviewItem interviewItem) throws Exception;
	
	/**
	 * 문진항목 수정
	 * @param interviewItem 문진항목
	 * @return 수정행수
	 * @throws Exception
	 */
	public int updateInterviewItem(InterviewItem interviewItem) throws Exception;
}
