package com.xbl.designPattern._08_filterPattern.filiter;

import com.xbl.designPattern._08_filterPattern.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria{
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : personList) {
            if (person.getMaritalStatus().equalsIgnoreCase("single")){
                people.add(person);
            }
        }
        return people;
    }
}
