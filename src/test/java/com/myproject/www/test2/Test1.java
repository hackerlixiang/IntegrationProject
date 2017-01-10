//package com.myproject.www.test2;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import javax.annotation.Resource;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.util.StringUtils;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.myproject.www.entity.MenuEntity;
//import com.myproject.www.service.IUserService;
//import com.myproject.www.utils.JsonUtils;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/config/xml/spring-core.xml")
//public class Test1 {
//	
//	@Resource(name="userServiceImpl")
//	IUserService userServiceImpl;
//	
//	@Autowired(required = false)
//    private WebApplicationContext webApplicationContext;
//	
//	@Test
//	public void test(){
//		MenuEntity m = new MenuEntity();
//		m.setIcon("icon");
//		m.setId(1L);
//		m.setName("name");
//		m.setLevel(1);
//		m.setPath("path");
//		m.setSort(2);
//		String mstr = JsonUtils.toJson(m);
//		System.out.println(mstr);
//	}
//	
//	private Document getDocument(String urlStr){
//		if(!StringUtils.hasLength(urlStr)){
//			return null;
//		}
//		URL url = null;
//		Document doc = null;
//		try {
//			url = new URL(urlStr);
//			doc = Jsoup.parse(url , 8000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return doc;
//	}
//	
//	private List<String> parseHtml(Document doc){
//	    Elements tables = doc.getElementsByClass("mod-kjnum-table");
//        Element table = tables.first();
//        Element tbody = table.getElementsByTag("tbody").first();
//        Elements trs = tbody.getElementsByTag("tr");
//        
//        List<String> numList = new ArrayList<String>();
//        for (int i = 0; i < trs.first().getElementsByTag("td").size(); i++) {
//            for (int j = 0; j < trs.size(); j++) {
//                Element tr = trs.get(j);
//                Element number = tr.getElementsByTag("td").get(i);
//                numList.add(number.text().replace(" ", ""));
//            }
//        }
//        return numList;
//	}
//	
//	private List<Integer[]> formatStrNum(List<String> numberStrs){
//		List<Integer[]> numbers = new ArrayList<Integer[]>();
//		for (String numStr : numberStrs) {
//			Integer[] nums = new Integer[6];
//			for (int i = 0; i <= 10; i+=2) {
//				if(numStr.length()==12){
//					int number = Integer.parseInt(numStr.substring(i, i+2));
//		    		nums[i/2] = number;
//	    		}
//			}
//			if(nums[0]!=null){
//				numbers.add(nums);
//			}
//		}
//		return numbers;
//	}
//	
//	private String parity(List<Integer[]> numbers,int x){
//		Integer[] number = new Integer[numbers.size()];
//		for (int i = 0;i<numbers.size();i++) {
//			number[i] = numbers.get(i)[x];
//		}
//		
//		Integer odd = 0;
//		Integer even = 0;
//		
//		for (Integer integer : number) {
//			if(integer%2==0){even++;}else{odd++;}
//		}
//		if(odd>even){return "odd";}else if(odd<even){return "even";}else{return "equal";}
//	}
//	
//	@Test
//	public void test1(){
//		 MenuEntity d = new MenuEntity();
//	        d.setName("小明");
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(Integer.valueOf("1"));
//		for (int i = 0; i < 50; i++) {
//			System.out.println(new Random().nextInt(5));
//		}
//	}
//}
