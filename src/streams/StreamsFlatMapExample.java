package streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

/*
 * Methods in Streams:
 * flatMap()
 * distinct()
 * count()
 * sorted()
 */
public class StreamsFlatMapExample {
	public static void getListOfActivities() {
		System.out.println("getListOfActivities started..");
		List<String> list = StudentDataBase.getAllStudents().stream()
		.map(Student::getActivities)
		.flatMap(List::stream)
		.collect(Collectors.toList());
		
		System.out.println(list);
	}
	
	public static void getSetOfActivities() {
		System.out.println("getSetOfActivities started..");
		Set<String> set = StudentDataBase.getAllStudents().stream()
		.map(Student::getActivities)
		.flatMap(List::stream)
		.collect(Collectors.toSet());
		
		System.out.println(set);
	}
	
	public static void getDistinctActivities() {
		System.out.println("getDistinctActivities started..");
		List<String> list = StudentDataBase.getAllStudents().stream()
		.map(Student::getActivities)
		.flatMap(List::stream)
		.distinct()
		.collect(Collectors.toList());
		System.out.println("list: " + list);
	}
	
	public static void countDistinctActivities() {
		long noOfDistinctActivities = StudentDataBase.getAllStudents().stream()
		.map(Student::getActivities)
		.flatMap(List::stream)
		.distinct()
		.count();
		System.out.println("noOfDistinctActivities: " + noOfDistinctActivities);
	}
	
	public static void sortDistinctActivities() {
		List<String> list = StudentDataBase.getAllStudents().stream()
		.map(Student::getActivities)
		.flatMap(List::stream)
		.distinct()
		.sorted()
		.collect(Collectors.toList());
		System.out.println("list: " + list);
	}
	
	public static void main(String[] args) {
//		getListOfActivities();
//		getSetOfActivities();
//		getDistinctActivities();
//		countDistinctActivities();
		sortDistinctActivities();
	}
}
