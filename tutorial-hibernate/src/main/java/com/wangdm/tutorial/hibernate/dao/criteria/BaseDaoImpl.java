package com.wangdm.tutorial.hibernate.dao.criteria;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.metadata.ClassMetadata;

import com.wangdm.tutorial.hibernate.dao.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> clazz;
	
	public BaseDaoImpl(){
		String fullClassName = this.getClass().getName();
		String className = fullClassName.substring(fullClassName.lastIndexOf('.')+1);
		if(!"BaseDaoImpl".equals(className))
		{
			//System.out.println("this class name is "+ className);
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
	        clazz = (Class<T>) type.getActualTypeArguments()[0];
		}
	}
	
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		if(this.sessionFactory==null)
		{
			System.out.println("sessionFactory is null");
			return null;
		}
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity){
		Session s = this.getSession();
		if(s==null){
			System.out.println("Session is null");
		}else{
			s.save(entity);
		}
	}

	@Override
	public void update(T entity){
		this.getSession().update(entity);
	}
	
	@Override
	public void delete(Serializable id){
		this.getSession().delete(this.findById(id));
	}

	@Override
	public T findById(Serializable id){
		return (T)this.getSession().get(this.clazz, id);
	}

	@Override
	public List<T> listAll() {
		Session s = this.getSession();
		if(s!=null){
			Criteria c = s.createCriteria(this.clazz);
			ClassMetadata metadata = s.getSessionFactory().getClassMetadata(this.clazz);
			c.addOrder(Order.asc(metadata.getIdentifierPropertyName()));
			return c.list();
		}
		return null;
	}

}