package functionalinterface.predicate;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class PredicateConsumerImpl {
	public static void getStudentsByConditions() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		Predicate<Student> predicate = (student) -> student.getGender().equalsIgnoreCase("male");
		Consumer<Student> consumer = (student) -> {
			if (predicate.test(student)) {
				System.out.println(student);
			}
		};
		
		list.forEach(consumer);
	}
	
	public static void main(String[] args) {
		getStudentsByConditions();
	}
}
