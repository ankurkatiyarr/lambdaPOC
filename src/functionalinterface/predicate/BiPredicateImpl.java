package functionalinterface.predicate;

import java.util.List;
import java.util.function.BiPredicate;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class BiPredicateImpl {
	public static void getStudentsByCondition() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		BiPredicate<String, Integer> biPredicate = (gender, gradeLevel) -> gender.equalsIgnoreCase("male") && gradeLevel > 2;
		list.forEach(
				student -> {
					if (biPredicate.test(student.getGender(), student.getGradeLevel())) {
						System.out.println(student);
					}
				}
		);
	}
	
	public static void main(String[] args) {
		getStudentsByCondition();
	}
}
