package sample;

import java.util.List;
import java.util.stream.Collectors;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class StreamsSample {
	public static void main(String[] args) {
		List<Student> list = StudentDataBase.getAllStudents().stream()
		.filter(student -> student.getGpa() > 3.8)
		.collect(Collectors.toList());
		System.out.println(list);
	}
}
