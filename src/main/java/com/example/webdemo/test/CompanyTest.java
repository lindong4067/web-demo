

package com.example.webdemo.test;

import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CompanyTest {
//    @Test
    public void test(){
        Person p1 = new Person(1, "aaa");
        Person p2 = new Person(2, "bbb");
        Person p3 = new Person(3, "ccc");
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        Company company = new Company(personList);

        log.info(company.toString());

        for (Person person : personList) {
            log.info(person.toString());
        }
        for (Person person : personList) {
            person.setId(4);
            person.setName("ddd");
        }
        for (Person person : personList) {
            log.info(person.toString());
        }
        log.info(company.toString());
    }
}
