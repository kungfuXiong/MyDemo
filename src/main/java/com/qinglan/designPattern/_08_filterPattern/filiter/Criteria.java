package com.qinglan.designPattern._08_filterPattern.filiter;

import com.qinglan.designPattern._08_filterPattern.Person;

import java.util.List;

public interface Criteria {
    List<Person> meetCriteria(List<Person> personList);
}
