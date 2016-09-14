/*
package auto.newsky.coding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auto.newsky.coding.mapper.DepartmentMapper;
import auto.newsky.coding.service.IDepartment;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


@Service
public class DepartmentImpl implements IDepartment {
	
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public void add(Department department) throws Exception {
		departmentMapper.insertSelective(department);
	}

	@Override
	public List<Department> findList(PageBounds pageBounds) throws Exception {
		return departmentMapper.selectByExample(null, pageBounds);
	}

	@Override
	public void modify(Department department) throws Exception {
		departmentMapper.updateByPrimaryKeySelective(department);
	}

	@Override
	public void remove(Integer id) throws Exception {
		departmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Department> findList() throws Exception {
		return departmentMapper.selectByExample(null);
	}

	@Override
	public Department findById(Integer id) throws Exception {
		return departmentMapper.selectByPrimaryKey(id);
	}

}
*/
