package com.qinglan.designPattern._08_filterPattern.filiter;

import com.qinglan.designPattern._08_filterPattern.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria{
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase("male")){
                people.add(person);
            }
        }
        return people;
    }
}
