package com.lanxi.jsbValentineAction.dao;

import java.util.List;

import com.lanxi.jsbValentineAction.entity.ActionController;

public interface ActionControllerDao {
	public void addActionController(ActionController controller);
	public void addActionControllerDefault(ActionController controller);
	public void deleteActionController(ActionController controller);
	public void updateActionController(ActionController controller);
	public List<ActionController> selectActionController(ActionController controller);
}
