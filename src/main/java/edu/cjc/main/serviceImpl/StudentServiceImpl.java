package edu.cjc.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.main.model.Student;
import edu.cjc.main.repositary.StudentRepositary;
import edu.cjc.main.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepositary sr;

	@Override
	public void saveStudentDetails(Student st) {
		sr.save(st);
	}

	@Override
	public List<Student> getAllStudentDetails() {
		return (List<Student>) sr.findAll();
	}

	@Override
	public void removeStudent(int studentId) {
		sr.deleteById(studentId);

	}

	@Override
	public List<Student> searchStudentsByBatch(String batchNumber) {
		List<Student> batchStudents = sr.findAllByBatchNumber(batchNumber);
		return batchStudents;
	}

	@Override
	public Student getSingleStudent(int studentId) {
		Optional<Student> opStudent = sr.findById(studentId);
		return opStudent.get();
	}

	@Override
	public void updateStudentFees(int studentId, float ammount) {
		Optional<Student> opstudent = sr.findById(studentId);
		Student st = opstudent.get();
		float currentFees = Float.parseFloat(st.getFeesPaid());
		float newFees = currentFees + ammount;
		st.setFeesPaid(String.valueOf(newFees));
		sr.save(st);
	}

	@Override
	public void updatebatch(int studentId, String batchNumber) {

		Student s = sr.findById(studentId).get();
		s.setBatchNumber(batchNumber);
		sr.save(s);
	}
}
