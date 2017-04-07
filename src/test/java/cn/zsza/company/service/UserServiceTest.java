package cn.zsza.company.service;

import cn.zsza.company.entity.Department;
import cn.zsza.company.entity.Role;
import cn.zsza.company.entity.User;
import cn.zsza.company.repository.DepartmentRepositry;
import cn.zsza.company.repository.RoleRepositry;
import cn.zsza.company.repository.UserRepositry;
import cn.zsza.demo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

/**
 * Created by zs on 2017/3/6.
 * 17:34
 */
public class UserServiceTest extends BaseTest{
    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private DepartmentRepositry departmentRepositry;

    @Autowired
    private RoleRepositry roleRepositry;

//    @Before
    public void initData(){
        roleRepositry.deleteAll();
        departmentRepositry.deleteAll();
        userRepositry.deleteAll();

        Department department = new Department();
        department.setName("开发部");
        departmentRepositry.save(department);

        Role role = new Role();
        role.setName("admin");
        roleRepositry.save(role);

        User user = new User();
        user.setName("user");
        user.setCreateDate(new Date());
        user.setDepartment(department);

        List<Role> roles = roleRepositry.findAll();
        user.setRoles(roles);

        userRepositry.save(user);

    }

    @Test
    public void testFindOne(){
        User user = userRepositry.findOne(1L);
        System.out.println(user.toString());

    }

    @Test
    public void testLog(){
        System.out.println("test");
    }

}