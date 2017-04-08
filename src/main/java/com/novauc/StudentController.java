package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ANVIL_OCTOPUS on 3/30/17.
 */
@RestController
public class StudentController {


    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Student>getAllPeeps() {
        System.out.println("see this is a get");
        return (List) studentRepository.findAll();
    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    public List<Student>getAllstudents() {
        System.out.println("see this is a get");
        return (List) studentRepository.findAll();
    }


    @RequestMapping (path = "/students", method = RequestMethod.POST)
    public void postStudent(@RequestBody Student student) {
        System.out.println("this is a POST");
        studentRepository.save(student);

    }

    @RequestMapping(path = "/students", method = RequestMethod.PUT)
    public void putstudent(@RequestBody Student student) {
        studentRepository.save(student);
    }


    @RequestMapping(path = "/students/{id}", method = RequestMethod.DELETE)
    public void deletestudent(@PathVariable ("id") int id ) {
        studentRepository.delete(id);
    }

    @RequestMapping(path = "/students/{id}", method = RequestMethod.GET)
    public Student getstudent(@PathVariable ("id") int id ) {
        return studentRepository.findOne(id);

    }
    @RequestMapping(path = "/gender/{gender}", method = RequestMethod.GET)
    public List<Student> getAllFemales(@PathVariable ("gender") String gender ) {
        return studentRepository.findByGender(gender);
    }


    @PostConstruct
    public void databaseInitializer() throws Exception {
        File studentRecord = new File("student.csv");
        Scanner scanner = new Scanner(studentRecord);
        if(studentRepository.count()==0) {
            do {
                String line = scanner.nextLine();
                String[] value = line.split(",");

                Student student = new Student(value[4], value[2], Integer.parseInt(value[1]), value[3], value[0]);

            } while (scanner.hasNext());
        }


    }

}
