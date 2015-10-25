package com.tripcomposer.dao;

import java.io.Serializable;
import java.util.List;


public interface DefaultDAO<ResultObject, Id extends Serializable> {
	
	ResultObject getById(Id id);
	
	List<ResultObject> getList();
	
	void update(ResultObject obj);
	
	void saveOrUpdate(ResultObject obj);
	
	void delete(Id id);
	
	Class<ResultObject> getClassOfCurrentObj();
}
