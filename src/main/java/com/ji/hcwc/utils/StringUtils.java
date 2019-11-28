package com.ji.hcwc.utils;

public class StringUtils {

	public static String StringReplace(String str) {
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		str = str.replaceAll(match, " ");
		return str;
	}
	
	public static String StringEngReplace(String str) {
		String match = "^[a-zA-Z]*$";
		str = str.replaceAll(match, " ");
		return str;
	}
	
	public static boolean checkStringSubWord(String filStr) {
		filStr = filStr.trim();
		return (filStr.length()<3||filStr.equals("�ִ�")||filStr.equals("�ִٴ�")||filStr.equals("�ִٴ�")||
				filStr.equals("������")||filStr.equals("�׷���")||filStr.equals("�׷���")||
				filStr.equals("qwe123"))? true:false;
		
	}
	

}
