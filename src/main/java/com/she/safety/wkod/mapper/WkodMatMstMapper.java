package com.she.safety.wkod.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.safety.model.WkodMatMst;

@Mapper
@Repository("com.she.safety.wkod.mapper.WkodMatMstMapper")
public interface WkodMatMstMapper 
{
	/**
	 * 취급물질 조회
	 * @param wkodMatClass 취급물질분류 코드
	 * @param wkodMatNm 취급물질명
	 * @return 취급물질 목록
	 * @throws Exception
	 */
	public List<WkodMatMst> getWkodMatMsts(
			@Param("wkodMatClass") String wkodMatClass,
			@Param("wkodMatNm") String wkodMatNm) throws Exception;

	/**
	 * 취급물질 상세 조회
	 * @param matMstNo 취급물질 코드
	 * @return 취급물질
	 * @throws Exception
	 */
	public WkodMatMst getWkodMatMst(@Param("matMstNo") String matMstNo) throws Exception;
	
	/**
	 * 취급물질 생성
	 * @param wkodMatMst 취급물질
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int createWkodMatMst(WkodMatMst wkodMatMst) throws Exception;
	
	/**
	 * 취급물질 수정
	 * @param wkodMatMst 취급물질
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateWkodMatMst(WkodMatMst wkodMatMst) throws Exception;
}
