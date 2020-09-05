package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class StreamsComparatorExample {
	public static void sortStudentByName() {
		List<Student> list = StudentDataBase.getAllStudents().stream()
		.sorted(Comparator.comparing(Student::getName))
		.collect(Collectors.toList());
		
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	public static void sortStudentsByGpaDesc() {
		List<Student> list = StudentDataBase.getAllStudents().stream()
		.sorted(Comparator.comparing(Student::getGpa).reversed())
		.collect(Collectors.toList());
		
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	public static void main(String[] args) {
//		sortStudentByName();
		sortStudentsByGpaDesc();
	}
}
