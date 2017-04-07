package cn.zsza.company.repository;


import cn.zsza.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zs on 2017/2/28.
 * 15:40
 */
public interface UserRepositry extends JpaRepository<User,Long> {
}
