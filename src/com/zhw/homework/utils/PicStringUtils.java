package com.zhw.homework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * �ַ����������ĸ�����
 * @author Administrator
 *
 */
public class PicStringUtils {
	/**
	 * ������beatyGail.jpg
	 * 
	 * ƴ�����ֻ����ַ�.jpg
	 * @return
	 */
	public static String getReplaceName(String name){
		//�Ȼ�ȡ.�ַ������±�
		int index = name.lastIndexOf(".");
		
		
		String houZui = 	name.substring(index);
		
		//System.out.println("houZui=="+houZui);
		
		//ƴ��ǰ׺
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		String shijianChuo = sdf.format(new Date());
		
		String newStr = shijianChuo + houZui;*/
		
		String uuid = UUID.randomUUID().toString().replace("-", "");
		
		String prifix = uuid.substring(uuid.length()-10);
		
		String newStr = prifix + houZui;
		
		return newStr;
	}
	
	public static void main(String[] args) {
		String newStr = getReplaceName("beatyGail.png");
		
		System.out.println(newStr);
	}

}
