package com.lanxi.jsbValentineAction.entity;

import java.lang.reflect.Method;
import java.util.List;

import com.lanxi.jsbValentineAction.util.AppException;
import com.lanxi.jsbValentineAction.util.BeanUtil;

public class ActionController {
	/**编号*/
	private String  id;
	/**金额累计*/
	private Double  moneyAmount;
	/**金额上限*/
	private Double  moneyLimit;
	
	
	/**移动特等奖累计*/
	private Integer mobileSpecialAmount;
	/**移动特等奖上限*/
	private Integer mobileSpecialLimit;
	/**移动一等奖累计*/
	private Integer mobileFirstAmount;
	/**移动一等奖上限*/
	private Integer mobileFirstLimit;
	/**移动二等奖累计*/
	private Integer mobileSecondAmount;
	/**移动二等奖上限*/
	private Integer mobileSecondLimit;
	
	/**联通特等奖累计*/
	private Integer unicomSpecialAmount;
	/**联通特等奖上限*/
	private Integer unicomSpecialLimit;
	/**联通一等奖累计*/
	private Integer unicomFirstAmount;
	/**联通一等奖上限*/
	private Integer unicomFirstLimit;
	/**联通二等奖累计*/
	private Integer unicomSecondAmount;
	/**联通二等奖上限*/
	private Integer unicomSecondLimit;
	
	/**电信特等奖累计*/
	private Integer telecomSpecialAmount;
	/**电信特等奖上限*/
	private Integer telecomSpecialLimit;
	/**电信一等奖累计*/
	private Integer telecomFirstAmount;
	/**电信一等奖上限*/
	private Integer telecomFirstLimit;
	/**电信二等奖累计*/
	private Integer telecomSecondAmount;
	/**电信二等奖上限*/
	private Integer telecomSecondLimit;
	
	
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
	public Double getMoneyAmount() {
		return moneyAmount;
	}
	public void setMoneyAmount(Double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	public Double getMoneyLimit() {
		return moneyLimit;
	}
	public void setMoneyLimit(Double moneyLimit) {
		this.moneyLimit = moneyLimit;
	}
	
	public Integer getMobileSpecialAmount() {
		return mobileSpecialAmount;
	}
	public void setMobileSpecialAmount(Integer mobileSpecialAmount) {
		this.mobileSpecialAmount = mobileSpecialAmount;
	}
	public Integer getMobileSpecialLimit() {
		return mobileSpecialLimit;
	}
	public void setMobileSpecialLimit(Integer mobileSpecialLimit) {
		this.mobileSpecialLimit = mobileSpecialLimit;
	}
	public Integer getMobileFirstAmount() {
		return mobileFirstAmount;
	}
	public void setMobileFirstAmount(Integer mobileFirstAmount) {
		this.mobileFirstAmount = mobileFirstAmount;
	}
	public Integer getMobileFirstLimit() {
		return mobileFirstLimit;
	}
	public void setMobileFirstLimit(Integer mobileFirstLimit) {
		this.mobileFirstLimit = mobileFirstLimit;
	}
	public Integer getMobileSecondAmount() {
		return mobileSecondAmount;
	}
	public void setMobileSecondAmount(Integer mobileSecondAmount) {
		this.mobileSecondAmount = mobileSecondAmount;
	}
	public Integer getMobileSecondLimit() {
		return mobileSecondLimit;
	}
	public void setMobileSecondLimit(Integer mobileSecondLimit) {
		this.mobileSecondLimit = mobileSecondLimit;
	}
	public Integer getUnicomSpecialAmount() {
		return unicomSpecialAmount;
	}
	public void setUnicomSpecialAmount(Integer unicomSpecialAmount) {
		this.unicomSpecialAmount = unicomSpecialAmount;
	}
	public Integer getUnicomSpecialLimit() {
		return unicomSpecialLimit;
	}
	public void setUnicomSpecialLimit(Integer unicomSpecialLimit) {
		this.unicomSpecialLimit = unicomSpecialLimit;
	}
	public Integer getUnicomFirstAmount() {
		return unicomFirstAmount;
	}
	public void setUnicomFirstAmount(Integer unicomFirstAmount) {
		this.unicomFirstAmount = unicomFirstAmount;
	}
	public Integer getUnicomFirstLimit() {
		return unicomFirstLimit;
	}
	public void setUnicomFirstLimit(Integer unicomFirstLimit) {
		this.unicomFirstLimit = unicomFirstLimit;
	}
	public Integer getUnicomSecondAmount() {
		return unicomSecondAmount;
	}
	public void setUnicomSecondAmount(Integer unicomSecondAmount) {
		this.unicomSecondAmount = unicomSecondAmount;
	}
	public Integer getUnicomSecondLimit() {
		return unicomSecondLimit;
	}
	public void setUnicomSecondLimit(Integer unicomSecondLimit) {
		this.unicomSecondLimit = unicomSecondLimit;
	}
	public Integer getTelecomSpecialAmount() {
		return telecomSpecialAmount;
	}
	public void setTelecomSpecialAmount(Integer telecomSpecialAmount) {
		this.telecomSpecialAmount = telecomSpecialAmount;
	}
	public Integer getTelecomSpecialLimit() {
		return telecomSpecialLimit;
	}
	public void setTelecomSpecialLimit(Integer telecomSpecialLimit) {
		this.telecomSpecialLimit = telecomSpecialLimit;
	}
	public Integer getTelecomFirstAmount() {
		return telecomFirstAmount;
	}
	public void setTelecomFirstAmount(Integer telecomFirstAmount) {
		this.telecomFirstAmount = telecomFirstAmount;
	}
	public Integer getTelecomFirstLimit() {
		return telecomFirstLimit;
	}
	public void setTelecomFirstLimit(Integer telecomFirstLimit) {
		this.telecomFirstLimit = telecomFirstLimit;
	}
	public Integer getTelecomSecondAmount() {
		return telecomSecondAmount;
	}
	public void setTelecomSecondAmount(Integer telecomSecondAmount) {
		this.telecomSecondAmount = telecomSecondAmount;
	}
	public Integer getTelecomSecondLimit() {
		return telecomSecondLimit;
	}
	public void setTelecomSecondLimit(Integer telecomSecondLimit) {
		this.telecomSecondLimit = telecomSecondLimit;
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
	@Override
	public boolean equals(Object obj) {
		return BeanUtil.staticEquals(this, obj);
	}
}
