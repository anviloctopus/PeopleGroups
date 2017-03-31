package com.novauc;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ANVIL_OCTOPUS on 3/30/17.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {


    List findByGender(String gender);
    Student findFirstByGender(String gender);

}
