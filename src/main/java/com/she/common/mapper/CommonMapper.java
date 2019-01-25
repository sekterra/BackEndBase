package com.she.common.mapper;

import java.util.List;

import com.she.common.model.Menu;
import com.she.common.model.MenuTreeBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.she.common.model.Dept;

@Mapper
@Repository("com.she.common.mapper.CommonMapper")
public interface CommonMapper
{
	public List<Dept> getDepts() throws Exception;

	/**
	 * ///// 메뉴 영역 시작 /////
	 */
	/**
	 * 메뉴 등록용 mapper
	 * @param menu
	 */
	public void createMenu(Menu menu) throws Exception;

	/**
	 * 업무별 메뉴 개수 조회용 mapper
	 * @param taskGrpCd : 업무 코드
	 * @param menuLvl
	 * @return 업무별 메뉴 개수
	 * @throws Exception
	 */
	public int getMenuCount(String taskGrpCd, int menuLvl) throws Exception;

	/**
	 * 업무별 메뉴 목록 조회용 mapper
	 * @param taskGrpCd : 업무 코드
	 * @param menuNm : 메뉴명
	 * @param upMenuId : 상위 메뉴 ID
	 * @param menuLvl : 메뉴 level
	 * @param useYn : 사용 여부
	 * @return
	 * @throws Exception
	 */
	public List<Menu> getMenus(
					@Param("taskGrpCd") String taskGrpCd,
					@Param("menuNm") String menuNm,
					@Param("upMenuId") String upMenuId,
					@Param("menuLvl") Integer menuLvl,
					@Param("useYn") String useYn) throws Exception;

	/**
	 * 트리 메뉴를 구성할 기초 메뉴 정보 조회 mapper
	 * @return
	 * @throws Exception
	 */
	public List<MenuTreeBase> getMenuTreeBases() throws Exception;

	/**
	 * ///// 메뉴 영역 종료 /////
	 */
}
