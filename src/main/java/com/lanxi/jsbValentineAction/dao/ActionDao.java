package com.lanxi.jsbValentineAction.dao;

import java.util.List;

import com.lanxi.jsbValentineAction.entity.Action;

public interface ActionDao {
	public void addAction(Action action);
	public void addActionDefault(Action action);
	public void deleteAction(Action action);
	public void updateAction(Action action);
	public List<Action> selectAction(Action action);
}
