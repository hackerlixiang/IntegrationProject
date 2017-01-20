package com.myproject.www.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.myproject.www.utils.JsonUtils;
import com.myproject.www.utils.StringUtils;

public class JsoupTest {
	public static void main(String[] args) throws Exception {
		Document document = Jsoup.connect("http://stock.finance.qq.com/sstock/view/show.php?t=qgqp&c=search_by_type&p=1&type=1").get();
		String body = document.body().toString();
		// body = body.replace("\"", "");
		body = StringUtils.substringBetween(body, "\"result\":", "}}");
		body = new String(body.getBytes(), "UTF-8");
		System.out.println(body);
		List<Stock> stocks = new ArrayList<Stock>();
		stocks = JsonUtils.toObject(body, stocks.getClass());
	}

	class Stock{
		private String DATE;
		private String ZQDM;
		private String ZQJC;
		private String TYPE;
		private String CLOSE_PRICE;
		private String ZF;
		private String VOLUMN;
		private String ZLW_PRICE;
		private String ZCW_PRICE;
		private String HSL;
		private String DP;

		public String getDATE() {
			return DATE;
		}

		public void setDATE(String dATE) {
			DATE = dATE;
		}

		public String getZQDM() {
			return ZQDM;
		}

		public void setZQDM(String zQDM) {
			ZQDM = zQDM;
		}

		public String getZQJC() {
			return ZQJC;
		}

		public void setZQJC(String zQJC) {
			ZQJC = zQJC;
		}

		public String getTYPE() {
			return TYPE;
		}

		public void setTYPE(String tYPE) {
			TYPE = tYPE;
		}

		public String getCLOSE_PRICE() {
			return CLOSE_PRICE;
		}

		public void setCLOSE_PRICE(String cLOSE_PRICE) {
			CLOSE_PRICE = cLOSE_PRICE;
		}

		public String getZF() {
			return ZF;
		}

		public void setZF(String zF) {
			ZF = zF;
		}

		public String getVOLUMN() {
			return VOLUMN;
		}

		public void setVOLUMN(String vOLUMN) {
			VOLUMN = vOLUMN;
		}

		public String getZLW_PRICE() {
			return ZLW_PRICE;
		}

		public void setZLW_PRICE(String zLW_PRICE) {
			ZLW_PRICE = zLW_PRICE;
		}

		public String getZCW_PRICE() {
			return ZCW_PRICE;
		}

		public void setZCW_PRICE(String zCW_PRICE) {
			ZCW_PRICE = zCW_PRICE;
		}

		public String getHSL() {
			return HSL;
		}

		public void setHSL(String hSL) {
			HSL = hSL;
		}

		public String getDP() {
			return DP;
		}

		public void setDP(String dP) {
			DP = dP;
		}

	}
}
