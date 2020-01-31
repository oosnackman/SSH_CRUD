package com.mark.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mark.entities.Employee;

/*
 * Description:BaseDao+HibernateDaoSupport處理
 * @author MarkLin
 * @Date:2019年10月28日下午6:20:44
 * @Remarks: 
 *     	由於繼承HibernateDaoSupport,會使Spring無法管理且會丟出異常,在此
 *     	使用HQL演示一下BaseDao的流程
 * 
 */
public class BaseDaoImp<T> implements BaseDao<T>  {

	private Class clazzP;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}


	/*
	 * Description:得到實際運行的類型參數
	 * @author MarkLin
	 * @Date:2019年10月28日下午6:24:08
	 * @Remarks:
	 */
	public BaseDaoImp() {
	
		//第一步驟 ,得到當前運行類的Class找到
	    Class clazz = this.getClass();
		
		//第二步驟 ,得到當運行類的父類型參數化類型,BaseDaoImp<Employee> 
		Type type = clazz.getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) type;	//轉成子接口ParameterizedType
		
		//第三步驟 ,得到實際類型參數<Employee> 
		Type[] types = ptype.getActualTypeArguments();
		Class clazzParameter = (Class) types[0]; //把Type轉成Class
		this.clazzP = clazzParameter;
	}
	
	
	/*
	 *  HibernateDaoSupport - 樣板
	 * 
		//添加
		public void add(T t) {
	
			this.getHibernateTemplate().save(t);
		}
	
		//删除
		public void delete(T t) {
			this.getHibernateTemplate().delete(t);
		}
	
		//更新
		pulic void update(T t) {
			this.getHibernateTemplate().update(t);
		}
	
		//根据id查询
		public T getId(Serializable id) {
			return (T) getHibernateTemplate().get(clazzP, id);
		}
	
		//查询所有
		public List<T> getAll() {
			return (List<T>) this.getHibernateTemplate().find("FROM " + clazzP.getSimpleName());
		}
	
	*/
	

		/*
		 * Description:查詢所有資料
		 * @author MarkLin
		 * @Date:2019年10月28日下午6:20:17
		 * @Remarks:
		 */
		public List<T> getAll() {
			String hql = "FROM "+clazzP.getSimpleName();
			System.out.println("getAll():"+hql);
			return getSession().createQuery(hql).list();
		}
	
	
		/*
		 * Description:刪除
		 * @author MarkLin
		 * @Date:2019年10月28日下午6:20:04
		 * @Remarks:
		 */
		public void delete(int id) {
			String hql = "DELETE FROM " + clazzP.getSimpleName() + " EM WHERE EM.id=?";
			getSession().createQuery(hql).setInteger(0, id).executeUpdate();
		}
				

		/*
		 * Description:新增/更新統一處理
		 * @author MarkLin
		 * @Date:2019年10月28日下午6:19:25
		 * @Remarks:
		 */
		public void save(T t) {
			getSession().saveOrUpdate(t);
		}

		/*
		 * Description:根據id查詢
		 * @author MarkLin
		 * @Date:2019年10月28日下午6:18:46
		 * @Remarks:
		 */
		public T getId(Serializable id) {
			return (T) getSession().get(clazzP, id);
		}
		
	
	
	

}
