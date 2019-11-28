package com.ji.hcwc.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ji.hcwc.utils.CrawlingUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private String article_bigvalue = "http://news.bizwatch.co.kr/article/real_estate/2019/08/30/0016";
	private String article_valuemap = "http://news.bizwatch.co.kr/article/real_estate/2019/03/06/0017";
	private String article_disco="http://news.bizwatch.co.kr/article/real_estate/2019/08/16/0013";
	
	private String img_bigvalue="http://www.bigvalue.co.kr/img/blog_big.png";
	private String img_valuemap="https://www.valueupmap.com/static/_images/common/logo.png";
	private String img_disco="https://aurora.disco.re/static/common/img/disco-logo.png";

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		model.addAttribute("TEXT", new CrawlingUtils().crawlingSingTexts(article_bigvalue));
		model.addAttribute("URL", article_bigvalue);
		model.addAttribute("LOGO",img_bigvalue);

		return "home_bigvalue";
	}

	@RequestMapping(value = "{brand}", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @PathVariable String brand) {
		String url = "";
		String view = "";
		String logo = "";
		
		if (brand == "bigvalue") {
			url = article_bigvalue;
			view = "home_bigvalue";
			logo = img_bigvalue;
		} else if (brand.equals("valuemap")) {
			url = article_valuemap;
			view = "home_valuemap";
			logo =img_valuemap ;
		} else if (brand.equals("disco")) {
			url = article_disco;
			view = "home_disco";
			logo =img_disco ;
		} else {
			url = article_bigvalue;
			view = "home_valuemap";
			logo = img_bigvalue;
		}

		model.addAttribute("TEXT", new CrawlingUtils().crawlingSingTexts(url));
		model.addAttribute("URL", url);
		model.addAttribute("LOGO", logo);

		return view;
	}

}
