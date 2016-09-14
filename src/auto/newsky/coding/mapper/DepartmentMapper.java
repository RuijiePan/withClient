/*
package auto.newsky.coding.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface DepartmentMapper {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer id);//删除指定部门

    int insert(Department record);//添加一个新部门

    int insertSelective(Department record);//添加一个新部门，有选择性添加字段

    List<Department> selectByExample(DepartmentExample example);//example=null,取得所有部门
    
    List<Department> selectByExample(DepartmentExample example,PageBounds pageBounds);//example=null,取得所有部门

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);//修改一个部门，用部门ID
}*/
