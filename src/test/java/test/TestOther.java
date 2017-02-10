package test;

import org.junit.Test;

import com.lanxi.gift.report.BaoWen;
import com.lanxi.gift.report.ReqHead;
import com.lanxi.gift.report.ReqMsg;
import com.lanxi.jsbValentineAction.entity.Action;
import com.lanxi.jsbValentineAction.entity.ActionController;
import com.lanxi.jsbValentineAction.entity.ActionOrder;
import com.lanxi.jsbValentineAction.entity.Award;
import com.lanxi.jsbValentineAction.entity.Record;
import com.lanxi.jsbValentineAction.service.ActionService;
import com.lanxi.jsbValentineAction.service.ActionServiceImpl;
import com.lanxi.jsbValentineAction.util.CheckReplaceUtil;
import com.lanxi.jsbValentineAction.util.ConfigUtil;
import com.lanxi.jsbValentineAction.util.FileUtil;
import com.lanxi.jsbValentineAction.util.RandomUtil;
import com.lanxi.jsbValentineAction.util.SqlUtil;
import com.lanxi.jsbValentineAction.util.SqlUtilForDB;
import com.lanxi.jsbValentineAction.util.TimeUtil;

public class TestOther {
	
	@Test
	public void testConn (){
		System.out.println("jsb_valentine_action_"+CheckReplaceUtil.upcaseToUnderlineLowcaser(ActionOrder.class.getSimpleName()));
	}
	
	@Test
	public void makeFile(){
		Class[] classes={ActionController.class};
		for(Class each:classes)
		SqlUtil.createMapperFile(each, "jsb_valentine_action_"+CheckReplaceUtil.upcaseToUnderlineLowcaser(each.getSimpleName()));
	}
	@Test
	public void test2(){
		ActionService actionService=new ActionServiceImpl();
		System.out.println(actionService);
	}
	@Test
	public void test3(){
		ActionController controller=new ActionController();
		ActionController controller2=new ActionController();
		controller.setId("10086");
		controller2.setId("10086");
		System.out.println(controller.equals(controller2));
	}
	@Test
	public void test4(){
		ReqHead head=new ReqHead();
		head.setMsgId("1001");
		head.setWorkDate("1001");
		head.setWorkTime("1001");
		head.setChkDate("1001");
		ReqMsg  reqMsg=new ReqMsg();
		reqMsg.setPhone("15068610940");
		reqMsg.setSkuCode("1001");
		reqMsg.setCount("1");
		reqMsg.setType("10");
		BaoWen  baoWen=new BaoWen();
		baoWen.setHead(head);
		baoWen.setMsg(reqMsg);
		baoWen.sign();
		System.out.println(baoWen.getHead().getSign());
		System.out.println(baoWen.toDocument().asXML());
	}
}
