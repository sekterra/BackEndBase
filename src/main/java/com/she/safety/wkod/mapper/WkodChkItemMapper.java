package com.she.safety.wkod.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.health.model.Disease;
import com.she.safety.model.WkodChkItem;

@Mapper
@Repository("com.she.safety.wkod.mapper.WkodChkItemMapper")
public interface WkodChkItemMapper 
{
	/**
	 * 작업허가서 항목 조회
	 * @param wkodDutyCd 점검부서구분 코드
	 * @param chkItemNm 항목명
	 * @return 작업허가서 항목 목록
	 * @throws Exception
	 */
	public List<WkodChkItem> getWkodChkItems(
			@Param("wkodKindCd") String wkodKindCd,
			@Param("wkodDutyCd") String wkodDutyCd,
			@Param("chkItemNm") String chkItemNm) throws Exception;
	
	/**
	 * 작업허가서 항목 상세 조회
	 * @param chkItemNo 작업허가서 항목 코드
	 * @return 작업허가서 항목
	 * @throws Exception
	 */
	public WkodChkItem getWkodChkItem(@Param("chkItemNo") String chkItemNo) throws Exception;
	
	/**
	 * 작업허가서 항목 생성
	 * @param wkodChkItem 작업허가서 항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int createWkodChkItem(WkodChkItem wkodChkItem) throws Exception;
	
	/**
	 * 작업허가서 항목 수정
	 * @param wkodChkItem 작업허가서 항목
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateWkodChkItem(WkodChkItem wkodChkItem) throws Exception;
}
