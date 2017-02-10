package com.lanxi.jsbValentineAction.dao;

import java.util.List;

import com.lanxi.jsbValentineAction.entity.ActionOrder;

public interface ActionOrderDao {
	public void addActionOrder(ActionOrder order);
	public void addActionOrderDefault(ActionOrder order);
	public void deleteActionOrder(ActionOrder order);
	public void updateActionOrder(ActionOrder order);
	public List<ActionOrder> selectActionOrder(ActionOrder order);
}
