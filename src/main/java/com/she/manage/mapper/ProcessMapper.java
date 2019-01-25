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

package com.she.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.manage.model.Process;

/**
 * 작업공정 맵퍼
 *
 */
@Mapper
@Repository("com.she.manage.mapper.ProcessMapper")
public interface ProcessMapper
{
	/**
	 * 작업공정 조회
	 * @param useYn 사용여부
	 * @param heaHazardCd 유해인자 코드
	 * @return 작업공정목록
	 * @throws Exception
	 */
	public List<Process> getProcesses(@Param("useYn") String useYn, @Param("heaHazardCd") String heaHazardCd) throws Exception;
	
	/**
	 * 작업공정 상세 조회
	 * @param processNo 공정번호
	 * @return 작업공정
	 * @throws Exception
	 */
	public Process getProcess(int processNo) throws Exception;
	
	/**
	 * 작업공정 생성
	 * @param process 작업공정
	 * @return 생성 행 수
	 * @throws Exception
	 */
	public int createProcess(Process process) throws Exception;
	
	/**
	 * 작업공정 수정
	 * @param process 작업공정
	 * @return 변경적용 행 수
	 * @throws Exception
	 */
	public int updateProcess(Process process) throws Exception;
}
