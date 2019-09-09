package com.fanxingyue;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author zhuzg
 *
 */
public class StringUtils {
	
	/**
	 * 
	 * @param src
	 * @return
	 */
	public static String toHtml(String src) {
		
		String[] strings = src.split("\\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			sb.append("<p>").append(string).append("</p>");
		}
		return sb.toString();
		
		
		
	}
	
	/**
	 *  
	 * @param str
	 * @return  
	 */
	public static  boolean isEmpty(String str) {
		
		return (null==str||"".equals(str.trim()));
	}
	
	
	/**
	 * �Ƿ���ֵ
	�ж�Դ�ַ����Ƿ���ֵ�������źͿո�Ҳ��ûֵ
	 * @param str
	 * @return
	 */
	public static boolean isHasValue(String str) {
		
		// ��������д������
		//return !(null ==str || "".equals(str.trim()));
		return (null !=str && !"".equals(str.trim()));
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isTelephone(String str) {
		String pattern = "^(136|135|137)\\d{8}$";
		return str.matches(pattern);
	}
	
	/**
	 *  
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		
		String pattern = "^\\w+@\\w+\\.[a-zA-Z]{2,3}$";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * ��֤ȫΪ��ĸ
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
		String pattern = "^[a-zA-Z]+$";
		return str.matches(pattern);
	}
	
	/**
	 * 
	 * ��ȡnλ���Ӣ���ַ���
	 * @param n
	 * @return
	 */
	public String randomLetterStr(int n) {
		
		if(n<=0)
			return "";
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			char letter = (char)('A' + random.nextInt(26));
			sb.append(letter);
		}		
		return sb.toString();
	}
	
	/**
	 * ��ȡnλ���Ӣ�ĺ������ַ���
	 * @param n
	 * @return
	 */
	public String randomStr(int n) {
		
		char chars[]= {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
		
		// ������������
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			// ����õ�һ���±꣬�����±�����鵱�л�ȡֵ��ƴ�ӵ��ַ�����
			
			// �����ȡһ���±�
			int index = random.nextInt(chars.length);
			char c = chars[index];
			sb.append(c);//���ƴ��
			
			/*sb.append( chars[random.nextInt(chars.length)]
					);*/
			
		}
		return sb.toString();
		
	}
	
	//��ȡn����������ַ���
	public static String getRandonCnStr(int n) {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(getOneCn());
		}
		return sb.toString();
		
	} 
	
	/**
	 * �����ȡһ�������ַ�
	 * @return
	 */
	private static String getOneCn(){
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("����");
        }

        return str;
	}
	
	/*
	* �������ܣ������������ַ�����ȡһ��ֵ�����ں�����url��ַ����ȡIDֵ��
	* �����ڡ�http://news.cnstock.com/news,yw-201908-4413224.htm���ѡ�4413224����ȡ������
	*/
	public static String getPlaceholderValue(String src, String regex){
		//TODO ʵ�ִ���
        Pattern pattern = Pattern.compile(regex);// ƥ���ģʽ  
        Matcher m = pattern.matcher(src);  
        boolean find = m.find();
        if(find) {
        	String group = m.group(0);
        	 return group.substring(1,group.lastIndexOf('.'));
        }
        return "";
	}
	
	//���Թ��߰���isNumber()��
	/**
	 * 
	 * @param src
	 * @return
	 */
	public static boolean isNumber(String src) {
		//String regix="[0-9]{1,}(\\.?|[0-9]*)";
		String regix="[0-9]{1,}\\.?[0-9]*";
		return src.matches(regix);
		
		
	}
	
	/**
	 * ���Թ��߰���hasText()���÷����ǹ���String�����ո���ж��Ƿ���ֵ��
	 * ������иù��ܷ�����������������������۷֡����û�и÷������������ڱ�д�÷���
	 * @param src
	 * @return
	 */
	public static boolean hasText(String src) {
		String string = src.replaceAll("\\s", "");
		return (!"".equals(string));
	}
	
	
	
	
	
}