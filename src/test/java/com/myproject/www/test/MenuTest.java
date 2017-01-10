package com.myproject.www.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
//import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.www.entity.MenuEntity;
import com.myproject.www.pageQuery.MenuQuery;
import com.myproject.www.pageQuery.Pagination;
import com.myproject.www.service.IMenuService;
import com.myproject.www.utils.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/xml/spring-core.xml")
public class MenuTest {
//	@Resource(name = "validator")
//    private Validator validator;
	
	@Resource(name="menuServiceImpl")
	private IMenuService menuService;
	
	@Test
	public void addTest() throws Exception {
//		for (int i = 11; i < 12; i++) {
//			MenuBean m = new MenuBean();
//			m.setName("测试菜单"+i);
//			m.setPath("/"+i+i+i+i+i);
//			m.setIcon("icon-envelope");
//			menuService.add(m);
//		}
		List<MenuEntity> menus = menuService.findRoot();
		for (MenuEntity menu : menus) {
			System.out.println(menu);
		}
	}
	
	@Test
	public void testRootMenu() {
		List<MenuEntity> roots = new ArrayList<MenuEntity>();
		try {
			roots = menuService.findRoot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (MenuEntity menu : roots) {
			System.out.println(menu);
		}
	}
	
	@Test
	public void testFindById() {
		MenuEntity root = null;
		try {
			root = menuService.findById(1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(root);
	}
	
	@Test
	public void beanValidateTest() throws Exception {
		MenuEntity m = new MenuEntity();
		m.setId(1L);
//		System.out.println(verify(m));
	}
	
	@Test
	public void findPage() throws Exception {
		MenuQuery query = new MenuQuery();
		Pagination<MenuEntity> pagination = menuService.findPage(query);
		System.out.println(JsonUtils.toJson(pagination));
	}
	
//	protected boolean verify(Object target, Class<?>... groups) {
//        return validator.validate(target, groups).isEmpty();
//    }
}
