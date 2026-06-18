package edu.cjc.main.service;

import java.util.List;

import edu.cjc.main.model.Student;

public interface StudentService {

public	void saveStudentDetails(Student st);

public List<Student> getAllStudentDetails();

public List<Student> searchStudentsByBatch(String batchNumber);

public void removeStudent(int studentId);

public Student getSingleStudent(int studentId);

public void updateStudentFees(int studentId,float ammount);

public void updatebatch(int studentId, String batchNumber);
}
