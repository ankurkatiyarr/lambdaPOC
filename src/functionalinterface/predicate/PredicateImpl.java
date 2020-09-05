package functionalinterface.predicate;

import java.util.List;
import java.util.function.Predicate;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class PredicateImpl {
	public static void evenOrOdd(int inputNumber) {
		Predicate<Integer> predicate = (number) -> number%2 == 0;
		System.out.println(predicate.test(inputNumber));
	}
	
	public static void getStudentWithConditions() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		Predicate<Student> p1 = (student) -> student.getGender().equalsIgnoreCase("male");
		Predicate<Student> p2 = (student) -> student.getGradeLevel() > 2;
		
		list.forEach(student -> {
			if (p1.and(p2).test(student)) {
				System.out.println(student);
			}
		});
	}
	
	public static void main(String[] args) {
//		evenOrOdd(11);
		getStudentWithConditions();
	}
}
