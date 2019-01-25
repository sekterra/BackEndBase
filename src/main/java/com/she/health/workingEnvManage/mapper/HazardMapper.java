package com.she.health.workingEnvManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.health.model.Hazard;

/**
 * 유해인자 맵퍼
 *
 */
@Mapper
@Repository("com.she.health.workingEnvManage.mapper.HazardMapper")
public interface HazardMapper
{
	/**
	 * 유해인자 조회
	 * @param hazardClassCd 유해인자 분류
	 * @param hazardNmKo 유해인자명(한글)
	 * @param specialYn 특수검진 관련 여부
	 * @param workEnvYn 작업환경 관련 여부
	 * @return 유해인자 목록
	 * @throws Exception
	 */
	public List<Hazard> getHazards(@Param("heaHazardClassCd") String heaHazardClassCd, @Param("heaHazardNmKo") String heaHazardNmKo
								, @Param("specialYn") String specialYn, @Param("workEnvYn") String workEnvYn) throws Exception;
	
	/**
	 * 유해인자 상세 조회
	 * @param heaHazardCd 유해인자 코드
	 * @return 유해인자
	 * @throws Exception
	 */
	public Hazard getHazard(@Param("heaHazardCd") String heaHazardCd) throws Exception;
	
	/**
	 * 유해인자 신규등록
	 * @param hazard 유해인자
	 * @return 생성 행 수
	 * @throws Exception
	 */
	public int createHazard(Hazard hazard) throws Exception;
	
	/**
	 * 유해인자 수정
	 * @param hazard 유해인자
	 * @return 변경 행 수
	 * @throws Exception
	 */
	public int updateHazard(Hazard hazard) throws Exception;
	
	/**
	 * 공정별 유해인자 신규등록
	 * @param hazard 유해인자
	 * @return 생성 행 수
	 * @throws Exception
	 */
	public int createProcessHazard(Hazard hazard) throws Exception;
	
	/**
	 * 공정별 유해인자 삭제
	 * @param heaHazardCd 유해인자 코드
	 * @return 삭제 행 수
	 * @throws Exception
	 */
	public int deleteProcessHazard(String heaHazardCd) throws Exception;
}
