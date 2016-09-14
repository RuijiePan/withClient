/*
package auto.newsky.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import auto.newsky.coding.exception.CustomException;
import auto.newsky.coding.service.IDepartment;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private IDepartment departmentImpl;

	*/
/**
	 * 查询所有项目
	 *//*

	@RequestMapping("/showList")
	public String showList() throws Exception {
		return "department/showList";
	}

	@RequestMapping("/getDepartmentList")
	public @ResponseBody
	Pagination getDepartmentList(
			@RequestParam(value = "currentPage", required = true) Integer currentPage,
			@RequestParam(value = "pageSize", required = true) Integer pageSize)
			throws Exception {
		List<Department> departments = departmentImpl.findList(new PageBounds(currentPage, pageSize));
		return new Pagination(departments);
	}
	
	*/
/**
	 * 添加新部门-跳转到添加界面
	 *//*

	@RequestMapping("/add")
	public String add(Model model) throws Exception {
		model.addAttribute("departmentList", departmentImpl.findList());
		return "department/add";
	}
	
	*/
/**
	 * 添加新部门-保存数据
	 *//*

	@RequestMapping("/added")
	public @ResponseBody
	Result added(Department department)
			throws Exception {
		departmentImpl.add(department);
		return Result.SUCCESS;
	}
	
	*/
/**
	 * 修改部门-跳转到修改界面
	 *//*

	@RequestMapping("/modify")
	public String modify(@RequestParam(value="id",required=true) Integer id,Model model) throws Exception {
		Department info = departmentImpl.findById(id);
		if(info!=null){
			model.addAttribute("department", info);
			model.addAttribute("departmentList", departmentImpl.findList());
			return "department/modify";
		}else{
			throw new CustomException("要修改的部门并不存在！");
		}
	}
	
	*/
/**
	 * 修改部门-保存数据
	 *//*

	@RequestMapping("/modifyed")
	public @ResponseBody
	Result modifyed(Department department)
			throws Exception {
		departmentImpl.modify(department);
		return Result.SUCCESS;
	}
	
	*/
/**
	 * 删除项目
	 *//*

	@RequestMapping("/remove")
	public @ResponseBody
	Result remove(@RequestParam(value="id",required=true) Integer id)
			throws Exception {
		departmentImpl.remove(id);
		return Result.SUCCESS;
	}
}
*/
