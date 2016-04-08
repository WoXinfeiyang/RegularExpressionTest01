import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 文件名称：正则表达式StartEndTest01
 * 时间：2016-4-7 11:18
 * 说明：1、正则表达式的使用：正则表达式字符串必须先被编译成Pattern对象，然后再利用该Patter对象创建Matcher对象。
 * 执行匹配所涉及的状态保留在Matcher对象中，多个Matcher对象可以共享同一个Pattern对象。
 * 2、Macher类常见方法：
 * Matcher.find()---返回类型boolean，返回目标字符串中是否包含与Pattern匹配的子串
 * Matcher.group()---返回类型String,返回上一次与Pattern匹配的子串
 * Matcher.start()---返回类型int，返回上一次与Pattern匹配的子串在目标字符串中开始的位置
 * Matcher.end()---返回类型int，返回上一次与Pattern匹配的子串在目标字符串中结束的位置
 * Matcher.reset(CharSequence input)---返回类型Matcher，将现有的Matcher对象应用于一个新的目标字符串
 * Matcher.matches()---返回类型boolean,返回整个目标字符串与Pattern是否匹配的boolean值。
 * */

public class StartEnd {

	public static void main(String[] args) {
		
		String regStr="Java is very easy!";
		System.out.println("目标字符串:"+regStr);
		/*将正则表达式字符串编译成Pattern对象*/
		Pattern patter=Pattern.compile("\\w+");
		/*向Pattern对象传入目标字符串来创建Matcher对象*/
		Matcher m=patter.matcher(regStr);
		
		while(m.find()){
			System.out.println(m.group()+"子串起始位置："+m.start()+",其结束位置:"+m.end());
		}
		
		System.out.println();
		
		String[] mails =
		{
			"kongyeeku@163.com" ,
			"kongyeeku@gmail.com",
			"ligang@crazyit.org",
			"wawa@abc.xx"
		};
		String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		Pattern mailPattern = Pattern.compile(mailRegEx);/*将正则表达式字符串编译成Pattern对象*/
		Matcher matcher = null;
		for (String mail : mails)
		{
			if (matcher == null)
			{
				matcher = mailPattern.matcher(mail); 
			}
			else
			{
				matcher.reset(mail);
			}
			String result = mail + (matcher.matches() ? "是" : "不是")
				+ "一个有效的邮件地址！";
			System.out.println(result);
		}
	}

}
