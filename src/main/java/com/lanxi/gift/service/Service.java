package com.lanxi.gift.service;

import com.lanxi.gift.report.BaoWen;
import com.lanxi.jsbValentineAction.entity.ActionOrder;
import com.lanxi.jsbValentineAction.entity.Award;

public interface Service {
	public BaoWen toBaowen(String phone,Award award);
}
