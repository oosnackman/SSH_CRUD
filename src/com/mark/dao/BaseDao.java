package com.mark.dao;

import java.io.Serializable;

import java.util.List;


/*
 * Description:BaseDao+HibernateDaoSupport處理
 * @author MarkLin
 * @Date:2019年10月28日下午6:20:44
 * @Remarks: 
 *     	由於繼承HibernateDaoSupport,會使Spring無法管理且會丟出異常,在此
 *     	使用HQL演示一下BaseDao的流程
 * 
 */
interface BaseDao<T> {

	/*   HibernateDaoSupport - 樣板
	 * 
		// 新增
		public void add(T t);
	
		// 刪除
		public void delete(T t);
	
		// 更新
		public void update(T t);
	
		// 根據ID查詢
		public T getId(Serializable id);
	
		// 查詢所有
		public List<T> getAll();
		
	 */
	
	
	//更新+新增
	public void save(T t);
	
	// 根据id查询
	public T getId(Serializable id);
	
	//删除
	public void delete(int id) ;
	
	// 查询所有
	public List<T> getAll();
}
