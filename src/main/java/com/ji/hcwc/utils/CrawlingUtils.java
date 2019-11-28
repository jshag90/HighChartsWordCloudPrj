package com.ji.hcwc.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingUtils {

	
	public static String crawlingSingTexts(String addr) {
		Document doc = null;
		String textResult = "";

		try {
			doc = Jsoup.connect(addr).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Elements elements = doc.select("article.container");

		for (Element e : elements) {
			String signTexts = e.text();
			textResult += signTexts;
		}
		
		String[] filterArr = textResult.split(" ");
		String filterResultText = "";
		for(String filStr:filterArr) {
//			System.out.println(filStr +":"+filStr.length());
			filStr = StringUtils.StringReplace(filStr);
			filStr = StringUtils.StringEngReplace(filStr);
			
			if(StringUtils.checkStringSubWord(filStr)) 
				continue;
			else
				filterResultText += filStr+" ";
		}

		return filterResultText;
	}



}
