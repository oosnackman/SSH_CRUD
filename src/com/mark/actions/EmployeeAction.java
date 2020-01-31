package com.mark.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.mark.entities.Employee;
import com.mark.service.DepartmentService;
import com.mark.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/*
 * Description:員工基本資料的Action
 * @author MarkLin
 * @Date:2019年10月28日下午6:33:31
 * @Remarks:
 */
public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * Description:列表頁面
	 * 
	 * @author MarkLin
	 * 
	 * @Date:2019年10月28日下午6:31:59
	 * 
	 * @Remarks:
	 */
	public String list() {
		requestMap.put("employees", employeeService.getAll());
		return "list";
	}

	/*
	 * Description:連結到新增頁面, 新增資料的則交給save()處理。
	 * @author MarkLin	 * 
	 * @Date:2019年10月28日下午6:29:39	 * 
	 * @Remarks:
	 */
	public String add() {
		requestMap.put("departments", departmentService.getAll());
		return "add";
	}

	/*
	 * Description:連結到更新頁面, 更新資料的則交給save()處理。
	 * @author MarkLin	 * 
	 * @Date:2019年10月28日下午6:28:36	 * 
	 * @Remarks:
	 */
	public String update() {
		requestMap.put("departments", departmentService.getAll());
		return "add";
	}

	public void prepareUpdate() {
		if (id != null) {
			model = employeeService.getId(id);
		}
	}

	/*
	 * Description:刪除	  
	 * @author MarkLin	 
	 * @Date:2019年10月28日下午6:28:26	 
	 * @Remarks:
	 */
	public String delete() {
		employeeService.delete(id);
		return "delete";

	}

	/*
	 * Description:此方法處理"更新資料"/"新增資料"	
	 * @author MarkLin	 
	 * @Date:2019年10月28日下午6:32:15	
	 * @Remarks:
	 */
	public String save() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		if (id == null) {
			model.setCreateTime(new Date());
		}

		employeeService.save(model);
		return "success";
	}

	public void prepareSave() {
		model = new Employee();
	}

	private Map<String, Object> requestMap;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;

	}

	@Override
	public void prepare() throws Exception {

	}

	private Employee model;

	@Override
	public Employee getModel() {
		return this.model;
	}

}
