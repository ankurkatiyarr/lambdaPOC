package streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class StreamMapExample {
	public static List<String> getNamesList() {
		// this function can also be passed as map parameter
		// Function<Student, String> function = (student) -> student.getName();
		
		return StudentDataBase.getAllStudents().stream() // returns Stream<Student>
		.map(Student::getName) // takes Function as input and returns Stream<String>
		.collect(Collectors.toList()); // finally collect the name returned by map and finally return List<String>
	}
	
	public static List<String> getNamesListUpperCase() {
		return StudentDataBase.getAllStudents().stream()
		.map(Student::getName)
		.map(String::toUpperCase)
		.collect(Collectors.toList());
	}
	
	public static void foo() {
		List<String> listOfNames = StudentDataBase.getAllStudents().stream()
		.map(Student::getName)
		.collect(Collectors.toList());
		System.out.println("listOfNames: " + listOfNames);
		
		Set<String> setOfNames = StudentDataBase.getAllStudents().stream()
		.map(Student::getName)
		.map(String::toUpperCase)
		.collect(Collectors.toSet());
		System.out.println("setOfNames: " + setOfNames);
	}
	
	public static void main(String[] args) {
//		System.out.println(getNameOfStudents());
//		System.out.println(getNamesListUpperCase());
		foo();
	}
}
