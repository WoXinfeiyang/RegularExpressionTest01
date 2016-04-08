import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * �ļ����ƣ�������ʽStartEndTest01
 * ʱ�䣺2016-4-7 11:18
 * ˵����1��������ʽ��ʹ�ã�������ʽ�ַ��������ȱ������Pattern����Ȼ�������ø�Patter���󴴽�Matcher����
 * ִ��ƥ�����漰��״̬������Matcher�����У����Matcher������Թ���ͬһ��Pattern����
 * 2��Macher�ೣ��������
 * Matcher.find()---��������boolean������Ŀ���ַ������Ƿ������Patternƥ����Ӵ�
 * Matcher.group()---��������String,������һ����Patternƥ����Ӵ�
 * Matcher.start()---��������int��������һ����Patternƥ����Ӵ���Ŀ���ַ����п�ʼ��λ��
 * Matcher.end()---��������int��������һ����Patternƥ����Ӵ���Ŀ���ַ����н�����λ��
 * Matcher.reset(CharSequence input)---��������Matcher�������е�Matcher����Ӧ����һ���µ�Ŀ���ַ���
 * Matcher.matches()---��������boolean,��������Ŀ���ַ�����Pattern�Ƿ�ƥ���booleanֵ��
 * */

public class StartEnd {

	public static void main(String[] args) {
		
		String regStr="Java is very easy!";
		System.out.println("Ŀ���ַ���:"+regStr);
		/*��������ʽ�ַ��������Pattern����*/
		Pattern patter=Pattern.compile("\\w+");
		/*��Pattern������Ŀ���ַ���������Matcher����*/
		Matcher m=patter.matcher(regStr);
		
		while(m.find()){
			System.out.println(m.group()+"�Ӵ���ʼλ�ã�"+m.start()+",�����λ��:"+m.end());
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
		Pattern mailPattern = Pattern.compile(mailRegEx);/*��������ʽ�ַ��������Pattern����*/
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
			String result = mail + (matcher.matches() ? "��" : "����")
				+ "һ����Ч���ʼ���ַ��";
			System.out.println(result);
		}
	}

}
