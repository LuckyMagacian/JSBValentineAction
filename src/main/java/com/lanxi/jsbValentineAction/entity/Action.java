package com.lanxi.jsbValentineAction.entity;

import com.lanxi.jsbValentineAction.util.BeanUtil;

public class Action {
	/**活动编号*/
	private String id;
	/**活动名称*/
	private String name;
	/**特等奖中奖概率*/
	private String specialPrize;
	/**一等奖中奖概率*/
	private String firstPrize;
	/**二等奖中奖概率*/
	private String secondPrize;
	/**未中奖中奖概率*/
	private String noPrize;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialPrize() {
		return specialPrize;
	}
	public void setSpecialPrize(String specialPrize) {
		this.specialPrize = specialPrize;
	}
	public String getFirstPrize() {
		return firstPrize;
	}
	public void setFirstPrize(String firstPrize) {
		this.firstPrize = firstPrize;
	}
	public String getSecondPrize() {
		return secondPrize;
	}
	public void setSecondPrize(String secondPrize) {
		this.secondPrize = secondPrize;
	}
	public String getNoPrize() {
		return noPrize;
	}
	public void setNoPrize(String noPrize) {
		this.noPrize = noPrize;
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
