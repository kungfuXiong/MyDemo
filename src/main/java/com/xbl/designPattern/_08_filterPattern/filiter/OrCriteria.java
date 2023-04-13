package com.xbl.designPattern._08_filterPattern.filiter;

import com.xbl.designPattern._08_filterPattern.Person;

import java.util.List;

public class OrCriteria implements Criteria{
    private Criteria criteria;
    private Criteria orCriteria;

    public OrCriteria(Criteria criteria, Criteria andCriteria) {

        this.criteria = criteria;
        this.orCriteria = andCriteria;
    }

    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> people = criteria.meetCriteria(personList);

        List<Person> people1 = orCriteria.meetCriteria(personList);

        for (Person person : people1) {
            if (!people.contains(person)){
                people.add(person);
            }
        }
        return people;
    }
}
