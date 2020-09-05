package functionalinterface.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class FunctionImpl {
	public static void toUpperCaseFunction(String input) {
		Function<String, String> toUpperCaseFunction = (name) -> name.toUpperCase();
		String output = toUpperCaseFunction.apply(input);
		System.out.println(output);
	}
	
	public static void andThenFunction(String input) {
		Function<String, String> f1 = (name) -> name.toUpperCase();
		Function<String, char[]> f2 = (name) -> name.toCharArray();
		
		char[] output = f1.andThen(f2).apply(input);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}
	
	public static void composeFunction(String input) {
		Function<String, String> f1 = (name) -> name.toUpperCase();
		Function<String, String> f2 = (name) -> name.concat(" katiyar");
		
		String output = f1.compose(f2).apply(input);
		System.out.println(output);
	}
	
	static Function<List<Student>, Map<String, Double>> studentNameAndGpaFunction = (students) -> {
		Map<String, Double> result = new HashMap<>();
		students.forEach(student -> {
			result.put(student.getName(), student.getGpa());
		});
		return result;
	};
	
	public static void main(String[] args) {
//		toUpperCaseFunction("ankur");
//		andThenFunction("ankur");
//		composeFunction("ankur");
		System.out.println(studentNameAndGpaFunction.apply(StudentDataBase.getAllStudents()));
	}
}
