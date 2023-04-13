package com.xbl.designPattern._08_filterPattern;

public class Person {
    private String name;
    private String maritalStatus;
    private String gender;

    public String getName() {
        return name;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
