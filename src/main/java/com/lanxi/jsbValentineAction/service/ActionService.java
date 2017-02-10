package com.lanxi.jsbValentineAction.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanxi.jsbValentineAction.entity.Action;
import com.lanxi.jsbValentineAction.entity.ActionController;
import com.lanxi.jsbValentineAction.entity.Award;

public interface ActionService {
	/**
	 * 判断数据库中是否有该手机号码的记录 
	 * 有 	-true
	 * 没有	-false
	 * @param phone
	 * @return
	 * 有 	-true
	 * 没有	-false
	 */
	public boolean hasGet(String phone);
	/**
	 * 手机号码运营商判定
	 * 1001移动
	 * 1002联通
	 * 1003电信
	 * 1004未知|虚拟
	 * @param phone
	 * @return
	 */
	public String  phoneBelongTo(String phone);
	/**
	 * 通过江苏银行接口校验手机号码资格-避免外部直接调用api
	 * @param phone
	 * @return
	 * 	有	-true
	 * 	没有	-false
	 */
	public boolean hasRight(String phone);
	/**
	 * 余额判定
	 * @param controller
	 * @return
	 */
	public boolean hasLess(ActionController controller);
	/**
	 * 金额达到阀值时短信通知银行负责人员
	 * @param phone
	 * @return
	 */
	public String  smsNotice(String phone);
	
	/**
	 * 活动抽奖
	 * @param req
	 * @param res
	 */
	public String draw(String phone);
	
	public void    watchDog(ActionController controller,Award award,Action action);
	
	
	
	
	
}
