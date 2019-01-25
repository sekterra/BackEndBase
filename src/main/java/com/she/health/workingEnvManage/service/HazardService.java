package com.she.health.workingEnvManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.she.health.model.CheckupUser;
import com.she.health.model.Hazard;
import com.she.health.workingEnvManage.mapper.HazardMapper;
import com.she.utils.Methods;

/**
 * 유해인자 기능정의
 *
 */
@Service
public class HazardService
{
	@Autowired
	private HazardMapper hazardMapper;

	/**
	 * 유해인자 조회
	 * 
	 * @param 검색조건
	 * @return 유해인자 목록
	 * @throws Exception
	 */
	public List<Hazard> getHazards(String heaHazardClassCd, String heaHazardNmKo, String specialYn, String workEnvYn)
			throws Exception
	{
		return this.hazardMapper.getHazards(heaHazardClassCd, heaHazardNmKo, specialYn, workEnvYn);
	}

	/**
	 * 유해인자 상세 조회
	 * 
	 * @param heaHazardCd 유해인자 코드
	 * @return 유해인자
	 * @throws Exception
	 */
	public Hazard getHazard(String heaHazardCd) throws Exception
	{
		return this.hazardMapper.getHazard(heaHazardCd);
	}

	/**
	 * 유해인자 신규등록
	 * 
	 * @param hazard 유해인자
	 * @return 생성 행 수
	 * @throws Exception
	 */
	@Transactional
	public String createHazard(Hazard hazard) throws Exception
	{
		this.hazardMapper.createHazard(hazard);
		
		int count = 0;
		
		//공정별 유해인자
		for(int i=0; i<hazard.getProcessNos().length; i++)
		{
			hazard.setProcessNo(hazard.getProcessNos()[i]);
			count += this.hazardMapper.createProcessHazard(hazard);
		}
		
		return hazard.getHeaHazardCd();
	}

	/**
	 * 유해인자 수정
	 * 
	 * @param hazard 유해인자
	 * @return 변경 행 수
	 * @throws Exception
	 */
	@Transactional
	public int updateHazard(Hazard hazard) throws Exception
	{
		//공정별 유해인자
		this.hazardMapper.deleteProcessHazard(hazard.getHeaHazardCd());
		
		for(int i=0; i<hazard.getProcessNos().length; i++)
		{
			hazard.setProcessNo(hazard.getProcessNos()[i]);
			this.hazardMapper.createProcessHazard(hazard);
		}
		return this.hazardMapper.updateHazard(hazard);
	}

}
