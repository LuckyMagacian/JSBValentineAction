package com.lanxi.jsbValentineAction.entity;

import com.lanxi.jsbValentineAction.util.BeanUtil;

public class ActionOrder {
	/**订单状态-等待*/
	public static final String ACTION_ORDER_STATUS_WAIT="1";
	/**订单状态-成功*/
	public static final String ACTION_ORDER_STATUS_SUCCESSS="2";
	/**订单状态-失败*/
	public static final String ACTION_ORDER_STATUS_FAIL="3";
	
	/**订单编号*/
	private String id;
	/**手机号*/
	private String phone;
	/**奖励编号*/
	private String awardId;
	/**奖励数量*/
	private String count;
	/**交易时间*/
	private String workTime;
	/**订单状态*/
	private String status;
	/**响应码*/
	private String retCode;
	/**响应信息*/
	private String retMsg;
	/**备注*/
	private String remark;
	/**备用*/
	private String rebase;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAwardId() {
		return awardId;
	}
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
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
