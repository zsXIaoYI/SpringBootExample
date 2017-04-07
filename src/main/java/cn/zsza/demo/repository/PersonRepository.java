package cn.zsza.demo.repository;

import cn.zsza.demo.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zs on 2017/2/28.
 * 16:57
 */
@Transactional
public interface PersonRepository extends JpaRepository<Person,Long> {

    public List<Person> findAll();

    public Person findByName(String name);

    Page<Person> findAll(Pageable pageable);

}
