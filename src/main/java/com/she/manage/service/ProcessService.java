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

package com.she.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.she.manage.mapper.ProcessMapper;
import com.she.manage.model.Process;

/**
 * 작업공정 기능정의
 *
 */
@Service
public class ProcessService
{
	@Autowired
	private ProcessMapper processMapper;
	
	/**
	 * 작업공정 조회
	 * @param useYn 사용여부
	 * @param heaHazardCd 유해인자 코드
	 * @return 작업공정목록
	 * @throws Exception
	 */
	public List<Process> getProcesses(String useYn, String heaHazardCd) throws Exception
	{
		return this.processMapper.getProcesses(useYn, heaHazardCd);
	}
	
	/**
	 * 작업공정 상세 조회
	 * @param processNo 공정번호
	 * @return 작업공정
	 * @throws Exception
	 */
	public Process getProcess(int processNo) throws Exception
	{
		return this.processMapper.getProcess(processNo);
	}
	
	/**
	 * 작업공정 생성
	 * @param process 작업공정
	 * @return 공정번호
	 * @throws Exception
	 */
	public int createProcess(Process process) throws Exception
	{
		return this.processMapper.createProcess(process) > 0? process.getProcessNo():0;
	}
	
	/**
	 * 작업공정 수정
	 * @param process 작업공정
	 * @return 변경적용 행 수
	 * @throws Exception
	 */
	public int updateProcess(Process process) throws Exception
	{
		return this.processMapper.updateProcess(process);
	}
}
