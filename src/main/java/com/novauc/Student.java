package com.novauc;

import javax.persistence.*;

/**
 * Created by ANVIL_OCTOPUS on 3/30/17.
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    int id;




    @Column(nullable = false)
    String major;

    @Column(nullable = false)
    String gender;

    @Column(nullable = false)
    String race;

    @Column(nullable = false)
    int age;

    @Column(nullable = false)
    String name;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student () {

    }

    public Student(String gender, String race, int age, String major, String name) {

        this.gender = gender;
        this.race = race;
        this.age = age;
        this.major = major;
        this.name = name;
    }
}
