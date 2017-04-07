package cn.zsza.demo.service;

import cn.zsza.demo.BaseTest;
import cn.zsza.demo.entity.Person;
import cn.zsza.demo.repository.PersonRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zs on 2017/3/6.
 * 15:20
 */
public class PersonServiceTest extends BaseTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findAll() throws Exception {
        List<Person> all = personRepository.findAll();
        System.out.println(all.size());
    }
    @Test
    public void testSave(){

        Person person = new Person();
        person.setName("小刘");

        personRepository.save(person);
    }

    @Test
    public void testSavelist(){
        List<Person> list = new ArrayList<Person>();

        for (int i = 0; i < 10; i++) {
            Person person = new Person();

            person.setName("小" + (i + 1));
            person.setCreateDate(new Date());
            list.add(person);
        }
        personRepository.save(list);
    }

    /**
     * 分页
     */
    @Test
    public void testPage(){
        Pageable pageable = new PageRequest(1,2);
        Page<Person> all = personRepository.findAll(pageable);

        for (Person person: all
             ) {
            System.out.println(person.getName());

        }
    }

    /**
     * 分页 + 按照id排序
     */
    @Test
    public void testPage2(){
        Pageable pageable = new PageRequest(0,2,new Sort(Sort.Direction.ASC,"id"));
        Page<Person> all = personRepository.findAll(pageable);

        for (Person person: all
                ) {
            System.out.println(person.getName());

        }
    }

}