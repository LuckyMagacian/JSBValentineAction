package com.lanxi.jsbValentineAction.dao;

import java.util.List;

import com.lanxi.jsbValentineAction.entity.Award;

public interface AwardDao {
	public void addAward(Award award);
	public void addAwardDefault(Award award);
	public void deleteAward(Award award);
	public void updateAward(Award award);
	public List<Award> selectAward(Award award);
}
