package com.lanxi.jsbValentineAction.service;

import java.util.List;

import com.lanxi.jsbValentineAction.entity.Action;
import com.lanxi.jsbValentineAction.entity.ActionController;
import com.lanxi.jsbValentineAction.entity.ActionOrder;
import com.lanxi.jsbValentineAction.entity.Award;
import com.lanxi.jsbValentineAction.entity.Record;

public interface DaoService {
// TODO -----------------------------------actionController---------------------------------------------------------------
	public void addActionController(ActionController controller);
	public void addActionControllerDefault(ActionController controller);
	public void deleteActionController(ActionController controller);
	public void updateActionController(ActionController controller);
	public List<ActionController> selectActionController(ActionController controller);
	public ActionController selecActionController(String id);
// TODO -----------------------------------action--------------------------------------------------------------------------
	public void addAction(Action action);
	public void addActionDefault(Action action);
	public void deleteAction(Action action);
	public void updateAction(Action action);
	public List<Action> selectAction(Action action);
	public Action selectAction(String id);
// TODO -----------------------------------actionOrder----------------------------------------------------------------------
	public void addActionOrder(ActionOrder order);
	public void addActionOrderDefault(ActionOrder order);
	public void deleteActionOrder(ActionOrder order);
	public void updateActionOrder(ActionOrder order);
	public List<ActionOrder> selectActionOrder(ActionOrder order);
	public ActionOrder selectActionOrder(String id);
// TODO ------------------------------------Award----------------------------------------------------------------------------
	public void addAward(Award award);
	public void addAwardDefault(Award award);
	public void deleteAward(Award award);
	public void updateAward(Award award);
	public List<Award> selectAward(Award award);
	public Award selectAward(String id);
	public List<Award> selectAwardByActionId(String actionId);
// TODO ------------------------------------Record----------------------------------------------------------------------------
	public void addRecord(Record record);
	public void addRecordDefault(Record record);
	public void deleteRecord(Record record);
	public void updateRecord(Record record);
	public List<Record> selectRecord(Record record);
	public Record selectRecord(String phone);
	
}
