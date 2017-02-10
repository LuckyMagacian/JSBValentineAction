package test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.lanxi.jsbValentineAction.util.HttpUtil;

public class TestPhone {
	
	@Test
	public void testPhoen() throws Exception{
		System.out.println(phoneBelongTo("1706861090"));
	}
	public static String phoneBelongTo(String phone) {
		if(phone.length()!=11)
			return null;
		String three=phone.substring(0, 3);
		//([134-139])|([150-152])|([157-159])|([188])
		if(three.matches("(15[0-9])|(13[4-9])|(15[7-9])|(188)"))
			return "1001";
		if(three.matches("(13[0-2])|(15[5-6])|(186)"))
			return "1002";
		if(three.matches("(133)|(153)|(189)"))
			return "1003";
		return "1004";
	}
}
