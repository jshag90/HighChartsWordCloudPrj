package com.ji.hcwc.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingUtils {

	static String addr;
	public CrawlingUtils(String addr) {
		this.addr = addr;
	}
	
	public static String crawlingSingTexts() {
		Document doc = null;
		String textResult = "";

		try {
			doc = Jsoup.connect(addr).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Elements elements = doc.select("div.mw-body-content div.mw-content-ltr div.mw-parser-output dl");

		for (Element e : elements) {
			String signTexts = StringUtils.StringReplace(e.text());
			textResult += signTexts;
		}

		return textResult;
	}



}
