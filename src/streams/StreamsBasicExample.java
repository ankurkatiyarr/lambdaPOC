package streams;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class StreamsBasicExample {
	private static void printMap(Map<String, List<String>> result) {
		for (Entry<String, List<String>> entry : result.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			System.out.println("key: " + key + " value: " + value);
		}
	}
	
	public static Map<String, List<String>> getNameAndActivitiesWithLambda() {
		System.out.println("getNameAndActivitiesWithLambda started..");
		Function<Student, String> nameFunction = (student) -> student.getName();
		Function<Student, List<String>> activitiesFunction = (student) -> student.getActivities();
		
		Map<String, List<String>> map = StudentDataBase.getAllStudents().stream().collect(Collectors.toMap(nameFunction, activitiesFunction));
		return map;
	}
	
	public static Map<String, List<String>> getNameAndActivitiesWithMethodRef() {
		System.out.println("getNameAndActivitiesWithMR started..");
		Map<String, List<String>> map = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		return map;
	}
	
	public static Map<String, List<String>> getNameAndActivitiesGradeGreaterThan3() {
		System.out.println("getNameAndActivitiesGradeGreaterThan3 started..");
		return StudentDataBase.getAllStudents().stream().filter(Student -> Student.getGradeLevel() > 3).
		collect(Collectors.toMap(Student::getName, Student::getActivities));
	}
	
	public static Map<String, List<String>> getNameAndActivitiesGradeGreaterThan3AndGpaGreaterThan3p9() {
		System.out.println("getNameAndActivitiesGradeGreaterThan3AndGpaGreaterThan3p9..");
		Predicate<Student> gradePredicate = (student) -> student.getGradeLevel() >= 3;
		Predicate<Student> gpaPredicate = (student) -> student.getGpa() >= 3.9;
		
		return StudentDataBase.getAllStudents().stream()
				.filter(gradePredicate) // will return Stream<Student>
				.filter(gpaPredicate) // will return Stream<Student>
				.collect(Collectors.toMap(Student::getName, Student::getActivities)); // will return a Map
	}
	
	/*
	 * How to debug streams
	 */
	public static void checkHowToDebug() {
		StudentDataBase.getAllStudents().stream()
		.filter(student -> student.getGradeLevel() >= 3)
		.peek((student -> System.out.println("After 1st filter student: " + student)))
		.filter(student -> student.getGpa() >= 3.9)
		.peek((student -> System.out.println("After 2nd filter student: " + student)))
		.collect(Collectors.toMap(Student::getName, Student::getActivities));
	}
	
	public static Map<String, List<String>> foo() {
		List<Student> list = StudentDataBase.getAllStudents();
		
//		Function<Student, String> f1 = (student) -> student.getName();
//		Function<Student, List<String>> f2 = (student) -> student.getActivities();
//		Map<String, List<String>> map = list.stream().collect(Collectors.toMap(f1, f2));
		
//		Map<String, List<String>> map = list.stream()
//				.collect(Collectors.toMap((student) -> student.getName(), (student) -> student.getActivities()));
		
//		Map<String, List<String>> map = list.stream().collect(Collectors.toMap(Student::getName, Student::getActivities));
		
		Map<String, List<String>> map = list.stream()
				.filter((student) -> student.getGpa() >= 3.9)
				.peek((student) -> System.out.println("After gpa filter: " + student))
				.filter((student) -> student.getGradeLevel() > 3)
				.peek((student) -> System.out.println("After grade filter: " + student))
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		
		return map;
	}

	
	public static void main(String[] args) {
		Map<String, List<String>> result = foo();
		printMap(result);
		
//		Map<String, List<String>> result1 = getNameAndActivitiesWithLambda();
//		printMap(result1);
//		
//		Map<String, List<String>> result2 = getNameAndActivitiesWithMR();
//		printMap(result2);
//		
//		Map<String, List<String>> result3 = getNameAndActivitiesGradeGreaterThan3();
//		printMap(result3);
//		
//		Map<String, List<String>> result4 = getNameAndActivitiesGradeGreaterThan3AndGpaGreaterThan3p9();
//		printMap(result4);
//		
//		checkHowToDebug();
	}
}
