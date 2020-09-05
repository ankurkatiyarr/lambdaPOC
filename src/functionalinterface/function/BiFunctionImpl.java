package functionalinterface.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class BiFunctionImpl {
	public static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students, predicate) -> {
		Map<String, Double> result = new HashMap<>();
		students.forEach( student -> {
			if (predicate.test(student)) {
				result.put(student.getName(), student.getGpa());
			}
		});
		return result;
	};
	
	public static void main(String[] args) {
		Predicate<Student> predicate = (student) -> student.getGender().equalsIgnoreCase("male") && student.getGradeLevel() > 2;
		System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), predicate));
	}
}
