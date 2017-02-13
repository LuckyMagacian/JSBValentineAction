package com.lanxi.jsbValentineAction.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.lanxi.gift.report.BaoWen;
import com.lanxi.gift.report.ReqHead;
import com.lanxi.gift.report.ReqMsg;
import com.lanxi.jsbValentineAction.entity.Action;
import com.lanxi.jsbValentineAction.entity.ActionController;
import com.lanxi.jsbValentineAction.entity.ActionOrder;
import com.lanxi.jsbValentineAction.entity.Award;
import com.lanxi.jsbValentineAction.entity.Record;
import com.lanxi.jsbValentineAction.util.AppException;
import com.lanxi.jsbValentineAction.util.ConfigUtil;
import com.lanxi.jsbValentineAction.util.HttpUtil;
import com.lanxi.jsbValentineAction.util.RandomUtil;
import com.lanxi.jsbValentineAction.util.SmsUtil;
import com.lanxi.jsbValentineAction.util.TempSms;
import com.lanxi.jsbValentineAction.util.TimeUtil;
@Service("actionService")
@Order(1)
public class ActionServiceImpl implements ActionService {
	private static Logger logger=Logger.getLogger(ActionServiceImpl.class);
	public static volatile ActionController controller;
	private Counter counter;
	@Autowired
	DaoService dao;
	public ActionServiceImpl() {
		counter=new Counter();
	}
	
	public void init(){
		logger.info("加载控制器!");
		controller=dao.selecActionController("1001");
		logger.info("控制器加载完成!");
	}
	
	@Override
	public boolean hasGet(String phone) {
		Record record=dao.selectRecord(phone);
		boolean result= record!=null;
		if(result)
			logger.info("用户:"+phone+"已经参与过活动!");
		else
			logger.info("用户:"+phone+"尚未参与活动!");
		return result;
	}

	@Override
	public String phoneBelongTo(String phone) {
		if(phone.length()!=11){
			logger.info("用户:"+phone+"手机号码长度不正确!");
			return null;
		}
		String three=phone.substring(0, 3);
		if(three.matches("(15[0-2])|(13[4-9])|(15[7-9])|(18[2-4])|(18[7-8])|(178)|(147)")){
			logger.info("用户:"+phone+"是移动号码!");
			return "1001";
		}
		if(three.matches("(13[0-2])|(15[5-6])|(18[5-6])|(145)|(176)")){
			logger.info("用户:"+phone+"是联通号码!");
			return "1002";
		}
		if(three.matches("(133)|(153)|(189)|(18[0-1)|(173)|(177)")){
			logger.info("用户:"+phone+"是电信号码!");
			return "1003";
		}
//		String four=phone.substring(0,4);
//		if(four.matches("(1700)|(1705)|(170[7-9])");
//			return "10086";
		logger.info("用户:"+phone+"可能是虚拟运营商号码!");
		return null;
	}

	@Override
	public  void watchDog(ActionController controller,Award award,Action action) {
		synchronized (controller) {
			ActionController tempController=dao.selecActionController("1001");
			if(!tempController.equals(controller)){
				logger.info("数据库与本地活动控制器参数不一致");
				logger.info("本地版本:"+controller+"数据库版本:"+tempController);
				logger.info("取高值处理!");
				//TODO 处理版本不一致情况
			}
			controller.setMoneyAmount(controller.getMoneyAmount()+Double.parseDouble(award.getPrice()));
			switch (action.getId()) {
			case "1001":
				switch (award.getPrizeLevel()) {
				case "0":
						controller.setMobileSpecialAmount(controller.getMobileSpecialAmount()+1);
						break;
				case "1":
						controller.setMobileFirstAmount(controller.getMobileFirstAmount()+1);
						break;
				case "2":
						controller.setMobileSecondAmount(controller.getMobileSecondAmount()+1);
						break;
				default:
					break;
				}
				break;
			case "1002":
				switch (award.getPrizeLevel()) {
				case "0":
						controller.setUnicomSpecialAmount(controller.getUnicomSpecialAmount()+1);
						break;
				case "1":
						controller.setUnicomFirstAmount(controller.getUnicomFirstAmount()+1);
						break;
				case "2":
						controller.setUnicomSecondAmount(controller.getUnicomSecondAmount()+1);
						break;
				default:
					break;
				}
				break;
			case "1003":
				switch (award.getPrizeLevel()) {
				case "0":
						controller.setTelecomSpecialAmount(controller.getTelecomSpecialAmount()+1);
						break;
				case "1":
						controller.setTelecomFirstAmount(controller.getTelecomFirstAmount()+1);
						break;
				case "2":
						controller.setTelecomSecondAmount(controller.getTelecomSecondAmount()+1);
						break;
				default:
					break;
				}
				break;
			default:
				break;
			}
			if(controller.getMoneyAmount()>=controller.getMoneyLimit()){
				smsNotice(ConfigUtil.get("warnPhone"));
				logger.info("活动金额达到预警值,发送短信通知银行工作人员!");
			}
			if(controller.getMobileSpecialAmount()>=controller.getMobileSpecialLimit()){
				Award temp=dao.selectAward("1001");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("移动特等奖达到上限,关闭奖励!");
			}
			if(controller.getMobileFirstAmount()>=controller.getMobileFirstLimit()){
				Award temp=dao.selectAward("1002");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("移动一等奖达到上限,关闭奖励!");
			}
			if(controller.getMobileSecondAmount()>=controller.getMobileSecondLimit()){
				Award temp=dao.selectAward("1003");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("移动二等奖达到上限,关闭奖励!");
			}
			
			if(controller.getUnicomSpecialAmount()>=controller.getUnicomSpecialLimit()){
				Award temp=dao.selectAward("2001");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("联通特等奖达到上限,关闭奖励!");
			}
			if(controller.getUnicomFirstAmount()>=controller.getUnicomFirstLimit()){
				Award temp=dao.selectAward("2002");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("联通一等奖达到上限,关闭奖励!");
			}
			if(controller.getUnicomSecondAmount()>=controller.getUnicomSecondLimit()){
				Award temp=dao.selectAward("2003");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("联通二等奖达到上限,关闭奖励!");
			}
			if(controller.getTelecomSpecialAmount()>=controller.getTelecomSpecialLimit()){
				Award temp=dao.selectAward("3001");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("电信特等奖达到上限,关闭奖励!");
			}
			if(controller.getTelecomFirstAmount()>=controller.getTelecomFirstLimit()){
				Award temp=dao.selectAward("3002");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("电信一等奖达到上限,关闭奖励!");
			}
			if(controller.getTelecomSecondAmount()>=controller.getTelecomSecondLimit()){
				Award temp=dao.selectAward("3003");
				temp.setStatus(Award.AWARD_STATUS_NONE);
				dao.updateAward(temp);
				logger.info("电信二等奖达到上限,关闭奖励!");
			}
			dao.updateActionController(controller);
		}
	}

	@Override
	public boolean hasRight(String phone) {
		logger.info("用户:"+phone+"调用银行接口判定活动资质!");
		// TODO Auto-generated method stub
		boolean result=true;
		if(result)
			logger.info("用户:"+phone+"拥有参与活动资格!");
		else
			logger.info("用户:"+phone+"没有参与活动资格!");
		return result;
	}

	@Override
	public String smsNotice(String phone) {
		logger.info("准备发送预警通知短信!");
		TempSms sms=new TempSms();
		sms.setMobile(phone);
		sms.setMchtId(TempSms.SMS_MCHTID);
		sms.setTdId(TempSms.SMS_TDID_WODONG);
		sms.setContent("【杭州蓝喜】测试短信");
		sms.setOrderId(TempSms.SMS_MCHTID+TimeUtil.getDateTime()+RandomUtil.getRandomNumber(4));
		sms.setTradeDate(TimeUtil.getDate());
		sms.setTradeTime(TimeUtil.getTime());
		SmsUtil.signSms(sms);
		logger.info("预警短信:"+sms.toString());
		return SmsUtil.postSms(sms);
	}

	@Override
	public String draw(String phone) { 
			if(controller==null)
				init();
		try {
			logger.info("用户:"+phone+"尝试参与活动");
			if(hasGet(phone))
				return null;
			if(!hasLess(controller))
				return null;
			if(!hasRight(phone))
				return null;
			String actionId=phoneBelongTo(phone);
			if(actionId==null)
				return null;
			Action action  =dao.selectAction(actionId);
			logger.info("用户:"+phone+"活动详情:"+action);
			List<Award> awards=dao.selectAwardByActionId(actionId);
			logger.info("用户:"+phone+"奖励池"+awards);
			Award award=getAward(awards,action);
			logger.info("用户:"+phone+"获得的奖励:"+award);
			ActionOrder order=dealAward(award, phone);
			logger.info("用户:"+phone+"活动订单!"+order);
			Record record=new Record();
			record.setActionId(action.getId());
			record.setAwardId(award==null?null:award.getId());
			record.setPhone(phone);
			record.setPrizeLevel(award==null?null:award.getPrizeLevel());
			record.setWorkTime(TimeUtil.getDateTime());
			record.setOrderId(order.getId());
			logger.info("用户:"+phone+"增加活动记录:"+record);
			dao.addRecord(record);
			watchDog(controller, award, action);
		} catch (Exception e) {
			throw new AppException("参与活动异常",e);
		}
		return null;
	}

	public Award getAward(List<Award> awards,Action action){
		if(awards==null||awards.isEmpty())
			return null;
		Award special=null;
		Award first  =null;
		Award second =null;
		for(Award each:awards)
			if(each.getId().endsWith("001"))
				special=each;
			else if(each.getId().endsWith("002"))
				first=each;
			else if(each.getId().endsWith("003"))
				second=each;
		Random random=new Random();
		Double probability = random.nextInt(10000)/10000D;
		logger.info("掷点结果:"+probability);
		if(special!=null&&probability<Double.parseDouble(action.getSpecialPrize()))
			return special;
		if(first!=null&&probability<Double.parseDouble(action.getFirstPrize())+Double.parseDouble(action.getSpecialPrize()))
			return first;
		return second;
	}
	
	public ActionOrder dealAward(Award award,String phone){
		ActionOrder order=null;
		try{
			logger.info("尝试处理奖励!用户:"+phone);
			if(award==null||phone==null)
				return null;
			ReqHead head=new ReqHead();
			synchronized (counter) {
				head.setMsgId(TimeUtil.getDate().substring(4)+counter.getCount());
			}
			head.setReserve("");
			ReqMsg  reqMsg=new ReqMsg();
			reqMsg.setPhone(phone);
			reqMsg.setSkuCode(award.getMerchantId());
			reqMsg.setCount(award.getCount()+"");
			reqMsg.setType(award.getMerchantId().substring(0,2));
			BaoWen  baoWen=new BaoWen();
			baoWen.setHead(head);
			baoWen.setMsg(reqMsg);
			baoWen.sign();
			logger.info("报文构建完成!用户:"+phone);
			order=new ActionOrder();
			order.setAwardId(award.getId());
			order.setCount(award.getCount());
			order.setPhone(phone);
			order.setId(head.getMsgId());
			order.setStatus(ActionOrder.ACTION_ORDER_STATUS_WAIT);
			order.setWorkTime(TimeUtil.getDateTime());
			dao.addActionOrder(order);
			logger.info("订单信息添加完成!用户:"+phone);
			logger.info("用户:"+phone+"礼品订单报文:"+baoWen.toDocument().asXML());
			String rs=HttpUtil.postXml(baoWen.toDocument().asXML(), ConfigUtil.get("giftUrl"), "GBK");
			logger.info("用户:"+phone+"礼品订单报文响应信息:"+rs);
			Document doc=DocumentHelper.parseText(rs);
			order.setRetCode(doc.selectSingleNode("//ResCode").getText());
			if(doc.selectSingleNode("//ResCode").getText().trim().equals("0000")){
				order.setStatus(ActionOrder.ACTION_ORDER_STATUS_SUCCESSS);
				order.setRetMsg(doc.selectSingleNode("//ResDesc").getText());
			}else{
				order.setStatus(ActionOrder.ACTION_ORDER_STATUS_FAIL);
				order.setRetMsg(doc.selectSingleNode("//ResDesc").getText());
			}
			dao.updateActionOrder(order);
		}catch (Exception e) {
			throw new AppException("处理奖品异常",e);
		}
		return order;
	}
	
	/**
	 * 重置订单计数器
	 */
	public void counterInit() {
		counter.init();
	}
	
	@Override
	public boolean hasLess(ActionController controller) {
		logger.info("活动预算判定!");
		boolean result=controller.getMoneyAmount()<controller.getMoneyLimit();
		if(result)
			logger.info("活动预算充足!"+controller);
		else
			logger.info("活动预算已满!"+controller);
		return result;
	}

	public static class Counter{
		private Integer count;
		private Timer timer;
		String  lastDate =TimeUtil.getDate();
		public Counter() {
			logger.info("生成计数器!初始值:"+1000);
			count=1000;
			timer=new Timer(60*60*1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!lastDate.equals(TimeUtil.getDate()))
						init();
					lastDate=TimeUtil.getDate();
					logger.info("更新日期!"+lastDate);
				}
			});
//			timer.start();
//			logger.info("计数器启动!");
		}
		public void init(){
			logger.info("计数器重置为初始值1000");
			count=1000;
		}
		public Integer getCount(){
			logger.info("计数器被调用,计数累加!"+count);
			return count++;
		}
	}
}
