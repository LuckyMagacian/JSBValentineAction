package com.lanxi.jsbValentineAction.entity;

import com.lanxi.jsbValentineAction.util.BeanUtil;

public class Award {
	/**奖品状态-正常供应*/
	public static final String AWARD_STATUS_NORMAL	="1";
	/**奖品状态-不再供应*/
	public static final String AWARD_STATUS_ABNORMAL="2";
	/**奖品状态-兑罄*/
	public static final String AWARD_STATUS_NONE	="3";
	
	/**奖品编号*/
	private String id;
	/**商品编号*/
	private String merchantId;
	/**奖品名称*/
	private String name;
	/**活动编号*/
	private String actionId;
	/**奖励等级*/
	private String prizeLevel;
	/**价格*/
	private String price;
	/**数量*/
	private String count;
	/**奖品状态*/
	private String status;
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
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrizeLevel() {
		return prizeLevel;
	}
	public void setPrizeLevel(String prizeLevel) {
		this.prizeLevel = prizeLevel;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
