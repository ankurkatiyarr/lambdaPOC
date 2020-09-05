package functionalinterface.consumer;

import java.util.List;
import java.util.function.Consumer;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class ConsumerImpl {
	public static void printAllStudents() {
		List<Student> list = StudentDataBase.getAllStudents();
		Consumer<Student> consumer = (student) -> System.out.println(student);
		list.forEach(consumer);
	}
	
	public static void printAllStudentNameAndActivities() {
		List<Student> list = StudentDataBase.getAllStudents();
		Consumer<Student> consumer1 = (student) -> System.out.print(student.getName() + " ");
		Consumer<Student> consumer2 = (student) -> System.out.println(student.getActivities());
		list.forEach(consumer1.andThen(consumer2));
	}
	
	public static void printAllStudentsWithCondition() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		Consumer<Student> consumer = (student) -> {
			if (student.getGender().equalsIgnoreCase("male") && student.getGradeLevel() > 2) {
				System.out.println(student.getName());
			}
		};
		
		list.forEach(consumer);
	}
	
	public static void printAllStudentsWithConditionWithoutLambda() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		Consumer<Student> consumer = new Consumer<Student>() {
			@Override
			public void accept(Student student) {
				if (student.getGender().equalsIgnoreCase("male") && student.getGradeLevel() > 2) {
					System.out.println(student.getName());
				}
			}
		};
		
		list.forEach(consumer);
	}
	
	public static void printAllStudentsWithCondition2() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		Consumer<Student> c1 = (student) -> System.out.println(student.getName());
		Consumer<Student> c2 = (student) -> System.out.println(student.getActivities());
		
		list.forEach(
				student -> {
					if (student.getGender().equalsIgnoreCase("male") && student.getGradeLevel() > 2) {
						c1.andThen(c2).accept(student);
					}
				}
		);
	}
	
	public static void printAllStudentsWithMethodReference() {
		Consumer<Student> c = System.out::println;
		List<Student> list = StudentDataBase.getAllStudents();
		list.forEach(c);
	}
	
	public static void main(String[] args) {
//		printAllStudents();
//		printAllStudentNameAndActivities();
//		printAllStudentsWithCondition();
//		printAllStudentsWithConditionWithoutLambda();
//		printAllStudentsWithCondition2();
		printAllStudentsWithMethodReference();
	}
}
