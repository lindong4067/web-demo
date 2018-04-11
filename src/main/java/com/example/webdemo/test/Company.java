

package com.example.webdemo.test;

import java.util.List;

public class Company {
    private List<Person> personList;

    @Override
    public String toString() {
        return "Company{" +
                "personList=" + personList +
                '}';
    }

    public Company(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
