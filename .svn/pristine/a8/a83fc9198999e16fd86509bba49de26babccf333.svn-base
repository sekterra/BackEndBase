package com.she.safety.wkod.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.safety.model.WkodChkItem;
import com.she.safety.model.WkodMaster;
import com.she.safety.model.WkodMatMst;

@Mapper
@Repository("com.she.safety.wkod.mapper.WkodMasterMapper")
public interface WkodMasterMapper 
{
	/**
	 * 작업허가서 조회
	 * @param workYmd 작업기간 코드
	 * @param reqDeptCd 신청부서
	 * @param wkodKindCd 작업종류
	 * @param pubDeptCd 발행부서
	 * @param wkodStepCd 진행단계
	 * @param wkodNum 작업NO
	 * @param workTitle 작업명
	 * @param searchFlag 조회구분자
	 * @return 작업허가서 목록
	 * @throws Exception
	 */
	public List<WkodMaster> getWkodMasters(
			@Param("workYmd") String workYmd,
			@Param("reqDeptCd") String reqDeptCd,
			@Param("wkodKindCd") String wkodKindCd,
			@Param("pubDeptCd") String pubDeptCd,
			@Param("wkodStepCd") String wkodStepCd,
			@Param("wkodNum") String wkodNum,
			@Param("workTitle") String workTitle,
			@Param("searchFlag") String searchFlag) throws Exception;
	
	/**
	 * 작업허가서 상세 조회
	 * @param wkodNo 작업허가서 ID
	 * @return 작업허가서 상세
	 * @throws Exception
	 */
	public WkodMaster getWkodMaster(@Param("wkodNo") String wkodNo) throws Exception;
	
	/**
	 * 안전보호구 조회
	 * @param wkodNo 작업허가서 ID
	 * @return 안전보호구 목록
	 * @throws Exception
	 */
	public List<String> getSafWkodUseSpe(@Param("wkodNo") String wkodNo) throws Exception;
	
	/**
	 * 취급물질 조회
	 * @param wkodNo 작업허가서 ID
	 * @return 취급물질 목록
	 * @throws Exception
	 */
	public List<WkodMatMst> getWkodMatMstsSelectList(@Param("wkodNo") String wkodNo) throws Exception;
	
	/**
	 * 안전점검확인 결과 조회
	 * @param wkodNo 작업허가서 ID
	 * @param searchFlag 조회구분
	 * @return 취급물질 목록
	 * @throws Exception
	 */
	public List<WkodChkItem> getWkodDepts(@Param("wkodNo") String wkodNo,@Param("searchFlag") String searchFlag) throws Exception;
	
	/**
	 * 안전점검확인 결과(저장된 데이터) 조회
	 * @param wkodNo 작업허가서 ID
	 * @param searchFlag 조회구분
	 * @return 취급물질 목록
	 * @throws Exception
	 */
	public List<WkodChkItem> getSelectedWkodDepts(@Param("wkodNo") String wkodNo,@Param("searchFlag") String searchFlag) throws Exception;
}
