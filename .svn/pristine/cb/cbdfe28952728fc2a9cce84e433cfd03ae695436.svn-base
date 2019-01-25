package com.she.common.service;

import java.util.List;

import com.she.common.model.Menu;
import com.she.common.model.MenuTreeBase;
import com.she.utils.Methods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.she.common.mapper.CommonMapper;
import com.she.common.model.Dept;

@Service
public class CommonService
{
	@Autowired
	private CommonMapper commonMapper;
	
	public List<Dept> getDepts() throws Exception 
	{
		return commonMapper.getDepts();
	}
	
	/**
	 * ///// 메뉴 영역 시작 /////
	 */
	/**
	 * 메뉴 등록 서비스
	 * @param menu : 메뉴 모델
	 * @return : 등록된 메뉴 ID
	 */
	public String createMenu(Menu menu) throws Exception
	{
		// TODO : transaction 처리 할 것
		String menuId = this.generateMenuId(menu.getTaskGrpCd(), menu.getMenuLvl());
		menu.setMenuId(menuId);
		commonMapper.createMenu(menu);
		return menuId;
	}

	/**
	 * ///// 메뉴 영역 시작 /////
	 */
	/**
	 * 메뉴 ID 생성 함수
	 * @param taskGrpCd : 업무 그룹 코드(com_code_domain에 정의)
	 * @param menuLvl : 메뉴 레벨 1~9까지
	 * @return 메뉴 ID
	 * @throws Exception
	 */
	public String generateMenuId(String taskGrpCd, int menuLvl) throws Exception
	{
		String menuId = "";
		int menuCount = commonMapper.getMenuCount(taskGrpCd, menuLvl);
		menuCount++;
		// 업무코드 + 레벨 1자리 + 0001
		menuId = String.format("%s%d%s", taskGrpCd, menuLvl, Methods.leftPad(String.valueOf(menuCount), 4, '0'));
		return menuId;
	}

	/**
	 * 메뉴 목록 조회 서비스
	 * @param menu : 메뉴 모델 형태 검색 조건
	 * @return 검색 조건에 맞는 메뉴 목록
	 * @throws Exception
	 */

	/**
	 * 메뉴 목록 조회 서비스
	 * @param taskGrpCd : 업무 그룹 코드
	 * @param menuNm : 메뉴명
	 * @param upMenuId : 상위메뉴ID
	 * @param menuLvl
	 * @param useYn : 사용여부
	 * @return 메뉴 리스트
	 * @throws Exception
	 */
	public List<Menu> getMenus(String taskGrpCd, String menuNm, String upMenuId, Integer menuLvl, String useYn) throws Exception
	{
		return commonMapper.getMenus(taskGrpCd, menuNm, upMenuId, menuLvl, useYn);
	}

	/**
	 * 트리 메뉴를 구성할 기초 메뉴 정보 조회 서비스
	 * @return
	 * @throws Exception
	 */
	public List<MenuTreeBase> getMenuTreeBases() throws Exception
	{
		return commonMapper.getMenuTreeBases();
	}

	/**
	 * ///// 메뉴 영역 종료 /////
	 */
}
