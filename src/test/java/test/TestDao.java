package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanxi.jsbValentineAction.entity.Action;
import com.lanxi.jsbValentineAction.entity.ActionController;
import com.lanxi.jsbValentineAction.entity.Award;
import com.lanxi.jsbValentineAction.service.ActionServiceImpl;
import com.lanxi.jsbValentineAction.service.DaoService;
import com.lanxi.jsbValentineAction.servlet.Log4jInitServlet;

public class TestDao {
    private ApplicationContext ac;
	DaoService dao;
	ActionServiceImpl action;
	@Before
	public void init(){
		  ac = new ClassPathXmlApplicationContext("xml/spring-mvc.xml");
	      dao = ac.getBean(DaoService.class);
	      action=ac.getBean(ActionServiceImpl.class);
	      Log4jInitServlet.Log4jInit();
	}
	@Test
	public void testInit(){
		Action action=new Action();
		action.setId("1001");
		action.setName("移动");
		action.setSpecialPrize("0.0001");
		action.setFirstPrize("0.001");
		action.setSecondPrize("0.9989");
		action.setNoPrize("0");
		action.setRemark("移动号码参与的活动");
		dao.updateAction(action);
	}
	@Test
	public void test1(){
		Action action=dao.selectAction("1001");
		action.setId("1003");
		action.setName("电信");
		action.setRemark(action.getRemark().replace("移动", "电信"));
		dao.addAction(action);
	}
	@Test
	public void test2(){
		ActionController controller=new ActionController();
		controller.setId("1001");
		controller.setMoneyAmount(0.0);
		controller.setMoneyLimit(195000.0);
		
		controller.setMobileSpecialAmount(0);
		controller.setMobileSpecialLimit(10);
		controller.setMobileFirstAmount(0);
		controller.setMobileFirstLimit(100);
		controller.setMobileSecondAmount(0);
		controller.setMobileSecondLimit(99999);
		
		controller.setUnicomSpecialAmount(0);
		controller.setUnicomSpecialLimit(10);
		controller.setUnicomFirstAmount(0);
		controller.setUnicomFirstLimit(100);
		controller.setUnicomSecondAmount(0);
		controller.setUnicomSecondLimit(99999);
		
		controller.setTelecomSpecialAmount(0);
		controller.setTelecomSpecialLimit(10);
		controller.setTelecomFirstAmount(0);
		controller.setTelecomFirstLimit(100);
		controller.setTelecomSecondAmount(0);
		controller.setTelecomSecondLimit(99999);
		
		controller.setRemark("活动控制器");
		dao.addActionController(controller);
	}
	
	@Test
	public void test3(){
		Award award=new Award();
		award.setId("3001");
		award.setMerchantId("2015");
		award.setName("电信流量1024MB");
		award.setCount("1");
		award.setActionId("1003");
		award.setPrice("46.50");
		award.setPrizeLevel("0");
		award.setStatus(Award.AWARD_STATUS_ABNORMAL);
		award.setRemark("电信活动一等奖1024兆流量");
		dao.addAward(award);
	}
	@Test
	public void test4(){
	}
	public static class TempClass{
		Long phone;
		public TempClass(Long phone) {
			this.phone=phone;
		}
		public Long getPhone() {
			return phone;
		}
		public void setPhone(Long phone) {
			this.phone = phone;
		}
		
	}
	@Test 
	public void test6() throws Exception, SecurityException{
		action.init();
	    final TempClass temp=new TempClass(15068610940L);
		Runnable task=new Runnable() {
			@Override
			public void run() {
				action.draw(temp.getPhone()+"");
			}
		};
		
		Thread[] threads=new Thread[20];
		int i=0;
		for(Thread each:threads){
			each=new Thread(task);
//			each.start();
			each.run();
			System.out.println("线程"+i+"启动");
			i++;
			temp.setPhone(temp.getPhone()+1);
		}

		System.out.println(); 
	}
}
