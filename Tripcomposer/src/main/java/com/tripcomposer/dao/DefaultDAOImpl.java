package com.tripcomposer.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class DefaultDAOImpl<ResultObject, Id  extends Serializable> implements DefaultDAO<ResultObject, Id> {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	public ResultObject getById(Id id) {
		return (ResultObject) getSession().load(getClassOfCurrentObj(), id);
	}
	
	public List<ResultObject> getList() {
		Query query = getSession().createQuery("select m from "+getTableName()+" m order by m.id");
        @SuppressWarnings("unchecked")
		List<ResultObject>  queryResult = query.list();
        return queryResult;
	}
	
	public void update(ResultObject resultObject) {
		getSession().update(resultObject);
	}
	
	public void saveOrUpdate(ResultObject resultObject) {
		getSession().saveOrUpdate(resultObject);
	}
	
	
    public void delete(Id id) {
    	ResultObject resultObject = getById(id);
        if (resultObject != null) {
            getSession().delete(resultObject);
        }
    }
    
        
	protected Session getSession() {
		Session currentSession = getSessionFactory().getCurrentSession();
		if (currentSession == null) {
			currentSession = getSessionFactory().openSession();
		}
		return currentSession;
	}

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

	protected String getTableName() {
		Table table = getClassOfCurrentObj().getAnnotation(Table.class);
		if (table == null)
			throw new NullPointerException("unknown table name!");
		String result = table.name();
		if (result.length()>1)
			result = result.substring(0, 1).toUpperCase()+result.substring(1, result.length());
		else
			result = result.toUpperCase();
		return result;
	}

	
}
