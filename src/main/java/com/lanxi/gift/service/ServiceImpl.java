package com.lanxi.gift.service;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;


import com.lanxi.gift.report.BaoWen;
import com.lanxi.gift.report.Head;
import com.lanxi.gift.report.Msg;
import com.lanxi.gift.report.ReqHead;
import com.lanxi.gift.report.ReqMsg;
import com.lanxi.gift.report.ResHead;
import com.lanxi.gift.report.ResMsg;
import com.lanxi.jsbValentineAction.entity.ActionOrder;
import com.lanxi.jsbValentineAction.entity.Award;
import com.lanxi.jsbValentineAction.util.*;

public class ServiceImpl implements Service {

	@Override
	public BaoWen toBaowen(String phone,Award award) {
		ReqHead head=new ReqHead();
		head.setMsgId(TimeUtil.getDate().substring(4)+RandomUtil.getRandomNumber(4));
		head.setReserve("");
		ReqMsg  body=new ReqMsg();
		body.setPhone(phone);
		body.setSkuCode(award.getMerchantId());
		body.setCount(award.getCount()+"");
		body.setType(body.getSkuCode().substring(0,2));
		BaoWen baoWen=new BaoWen();
		baoWen.setHead(head);
		baoWen.setMsg(body);
		baoWen.sign();
		return baoWen;
	}
}
