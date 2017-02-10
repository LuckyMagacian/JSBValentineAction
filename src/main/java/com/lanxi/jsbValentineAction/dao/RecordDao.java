package com.lanxi.jsbValentineAction.dao;

import java.util.List;
import com.lanxi.jsbValentineAction.entity.Record;

public interface RecordDao {
	public void addRecord(Record record);
	public void addRecordDefault(Record record);
	public void deleteRecord(Record record);
	public void updateRecord(Record record);
	public List<Record> selectRecord(Record record);
}
