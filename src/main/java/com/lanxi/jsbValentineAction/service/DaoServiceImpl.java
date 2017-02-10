package com.lanxi.jsbValentineAction.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.lanxi.jsbValentineAction.dao.ActionControllerDao;
import com.lanxi.jsbValentineAction.dao.ActionDao;
import com.lanxi.jsbValentineAction.dao.ActionOrderDao;
import com.lanxi.jsbValentineAction.dao.AwardDao;
import com.lanxi.jsbValentineAction.dao.RecordDao;
import com.lanxi.jsbValentineAction.entity.Action;
import com.lanxi.jsbValentineAction.entity.ActionController;
import com.lanxi.jsbValentineAction.entity.ActionOrder;
import com.lanxi.jsbValentineAction.entity.Award;
import com.lanxi.jsbValentineAction.entity.Record;
@Service("daoService")
@Order(0)
public class DaoServiceImpl implements DaoService {
	@Autowired
	ActionControllerDao controller;
	@Autowired
	ActionDao			action;
	@Autowired
	ActionOrderDao 		order;
	@Autowired
	AwardDao 			award;
	@Autowired
	RecordDao 			record;
	@Override
	public void addActionController(ActionController controller) {
		this.controller.addActionController(controller);
	}
	@Override
	public void addActionControllerDefault(ActionController controller) {
		this.controller.addActionControllerDefault(controller);
	}
	@Override
	public void deleteActionController(ActionController controller) {
		this.controller.deleteActionController(controller);
	}
	@Override
	public void updateActionController(ActionController controller) {
		this.controller.updateActionController(controller);
	}
	@Override
	public List<ActionController> selectActionController(ActionController controller) {
		List<ActionController> temp= this.controller.selectActionController(controller);
		return temp.isEmpty()?null:temp;
	}
	@Override
	public void addAction(Action action) {
		this.action.addAction(action);
	}
	@Override
	public void addActionDefault(Action action) {
		this.action.addActionDefault(action);
	}
	@Override
	public void deleteAction(Action action) {
		this.action.deleteAction(action);
	}
	@Override
	public void updateAction(Action action) {
		this.action.updateAction(action);
	}
	@Override
	public List<Action> selectAction(Action action) {
		List<Action> temp=this.action.selectAction(action);
		return	temp.isEmpty()?null:temp;  
	}
	@Override
	public void addActionOrder(ActionOrder order) {
		this.order.addActionOrder(order);
	}
	@Override
	public void addActionOrderDefault(ActionOrder order) {
		this.order.addActionOrderDefault(order);
	}
	@Override
	public void deleteActionOrder(ActionOrder order) {
		this.order.deleteActionOrder(order);
	}
	@Override
	public void updateActionOrder(ActionOrder order) {
		this.order.updateActionOrder(order);
	}
	@Override
	public List<ActionOrder> selectActionOrder(ActionOrder order) {
		List<ActionOrder> temp=this.order.selectActionOrder(order);
		return  temp.isEmpty()?null:temp;
	}
	@Override
	public void addAward(Award award) {
		this.award.addAward(award);
	}
	@Override
	public void addAwardDefault(Award award) {
		this.award.addAwardDefault(award);
	}
	@Override
	public void deleteAward(Award award) {
		this.award.deleteAward(award);
	}
	@Override
	public void updateAward(Award award) {
		this.award.updateAward(award);
	}
	@Override
	public List<Award> selectAward(Award award) {
		List<Award> temp=this.award.selectAward(award);
		return temp.isEmpty()?null:temp;
	}
	@Override
	public void addRecord(Record record) {
		this.record.addRecord(record);
	}
	@Override
	public void addRecordDefault(Record record) {
		this.record.addRecordDefault(record);
	}
	@Override
	public void deleteRecord(Record record) {
		this.record.deleteRecord(record);
	}
	@Override
	public void updateRecord(Record record) {
		this.record.updateRecord(record);
	}
	@Override
	public List<Record> selectRecord(Record record) {
		List<Record> temp=this.record.selectRecord(record);
		return temp==null?null:temp.isEmpty()?null:temp; 
	}
	@Override
	public Action selectAction(String id) {
		Action action=new Action();
		action.setId(id);
		List<Action> temp=selectAction(action);
		return temp==null?null:temp.size()==1?temp.get(0):null;
	}
	@Override
	public ActionController selecActionController(String id) {
		ActionController controller=new ActionController();
		controller.setId(id);
		List<ActionController> temp=selectActionController(controller);
		return temp==null?null:temp.size()==1?temp.get(0):null;
	}
	@Override
	public ActionOrder selectActionOrder(String id) {
		ActionOrder order=new ActionOrder();
		order.setId(id);
		List<ActionOrder> temp=selectActionOrder(order);
		return temp==null?null:temp.size()==1?temp.get(0):null;
	}
	@Override
	public Award selectAward(String id) {
		Award award=new Award();
		award.setId(id);
		List<Award> temp=selectAward(award);
		return temp==null?null:temp.size()==1?temp.get(0):null;
	}
	@Override
	public Record selectRecord(String phone) {
		Record record=new Record();
		record.setPhone(phone);
		List<Record> temp=selectRecord(record);
		return temp==null?null:temp.size()==1?temp.get(0):null;
	}
	@Override
	public List<Award> selectAwardByActionId(String actionId) {
		Award award=new Award();
		award.setActionId(actionId);
		award.setStatus(Award.AWARD_STATUS_NORMAL);
		List<Award> temp=selectAward(award);
		return temp==null?null:temp.isEmpty()?null:temp;
	}
	
	
}
