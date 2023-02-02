package com.qinglan.designPattern._08_filterPattern.filiter;

import com.qinglan.designPattern._08_filterPattern.Person;

import java.util.List;

public class AndCriteria implements Criteria{
    private Criteria criteria;
    private Criteria andCriteria;

    public AndCriteria(Criteria criteria, Criteria andCriteria) {

        this.criteria = criteria;
        this.andCriteria = andCriteria;
    }

    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> people = criteria.meetCriteria(personList);

        List<Person> people1 = andCriteria.meetCriteria(people);

        return people1;
    }
}
