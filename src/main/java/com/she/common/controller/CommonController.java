package com.she.common.controller;

import java.util.HashMap;
import java.util.List;

import com.she.common.model.Menu;
import com.she.common.model.MenuTreeBase;
import com.she.utils.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.she.common.model.Dept;
import com.she.common.service.CommonService;

@RestController
public class CommonController
{
	@Autowired
	private CommonService commonService;

	@Autowired
	private RequestMapper requestMapper;
	
	@GetMapping("/api/common/depts")
	public ResponseEntity<List<Dept>> getDepts() throws Exception 
	{
		List<Dept> deptList = commonService.getDepts();
		return ResponseEntity.ok().body(deptList);
	}
/**
 * ///// 메뉴 영역 시작 /////
 */

	/**
	 * 메뉴 등록 API
	 *
	 * @param menu : Menu 클래스 모델
	 * @return : 등록된 메뉴의 id
	 * @throws Exception
	 */
	@PostMapping("/api/common/menu")
	public ResponseEntity<String> createMenu(@RequestBody Menu menu) throws Exception {
		menu.setCreateUserId("dev");
		String menuId = commonService.createMenu(menu);
		return ResponseEntity.ok().body(menuId);
	}

	/**
	 * 메뉴 목록 조회 함수
	 *
	 * @param menu : 메뉴 모델 형태 검색 조건
	 * @return 검색 조건에 맞는 메뉴 목록
	 * @throws Exception
	 */
	@GetMapping("/api/common/menus")
	public ResponseEntity<List<Menu>> getMenus(@RequestParam HashMap<String, Object> parameter) throws Exception {
		HashMap<String, Object> map = this.requestMapper.convertAsParameter(parameter);
		System.out.println("======== end of convert param");
		String taskGrpCd = map.containsKey("taskGrpCd") ? map.get("taskGrpCd").toString() : "";
		String menuNm = map.containsKey("menuNm") ? map.get("menuNm").toString() : "";
		String upMenuId = map.containsKey("upMenuId") ? map.get("upMenuId").toString() : "";
		Integer menuLvl = map.containsKey("menuLvl") ? Integer.valueOf(map.get("menuLvl").toString()) : null;
		String useYn = map.containsKey("useYn") ? map.get("useYn").toString() : "";

		int i = 0;
		int temp = 10;
		int k = temp / i;

		System.out.println("======== mapping parameter");
		List<Menu> menus = commonService.getMenus(taskGrpCd, menuNm, upMenuId, menuLvl, useYn);
		System.out.println("======== get menus");
		return ResponseEntity.ok().body(menus);
	}

	/**
	 * 트리 메뉴를 구성할 기초 메뉴 정보 조회
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/api/common/menutreebases")
	public ResponseEntity<List<MenuTreeBase>> getMenuTreeBases() throws Exception
	{
		List<MenuTreeBase> menuTreeBases = commonService.getMenuTreeBases();
		return ResponseEntity.ok().body(menuTreeBases);
	}

	/**
	 * ///// 메뉴 영역 종료 /////
	 */
}

