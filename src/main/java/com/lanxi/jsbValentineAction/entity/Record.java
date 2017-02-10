package com.lanxi.jsbValentineAction.entity;

import com.lanxi.jsbValentineAction.util.BeanUtil;

public class Record {
	/**参与手机号*/
	private String phone;
	/**参与时间*/
	private String workTime;
	/**奖励编号*/
	private String awardId;
	/**活动编号*/
	private String actionId;
	/**奖励等级*/
	private String prizeLevel;
	/**订单编号*/
	private String orderId;
	/**备注*/
	private String remark;
	/**备用*/
	private String rebase;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getAwardId() {
		return awardId;
	}
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	public String getPrizeLevel() {
		return prizeLevel;
	}
	public void setPrizeLevel(String prizeLevel) {
		this.prizeLevel = prizeLevel;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRebase() {
		return rebase;
	}
	public void setRebase(String rebase) {
		this.rebase = rebase;
	}
	@Override 
	public String toString() {
		return BeanUtil.staticToString(this);
	}
}
