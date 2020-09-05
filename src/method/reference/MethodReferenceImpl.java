package method.reference;

import java.util.function.Consumer;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class MethodReferenceImpl {
	public static void main(String[] args) {
		/*
		 * Example 1 : print all the students
		 */
		// using lambda
		System.out.println("printing all students using lambda..");
		Consumer<Student> c1 = (student) -> System.out.println(student);
		StudentDataBase.getAllStudents().forEach(c1);

		// using method reference
		System.out.println("printing all students using method reference..");
		Consumer<Student> c2 = System.out::println;
		StudentDataBase.getAllStudents().forEach(c2);
		
		/*
		 * Example 2 : print activities all the students
		 */
		// using lambda
		System.out.println("printing activities of all students using lambda..");
		Consumer<Student> c3 = student -> System.out.println(student.getActivities());
		StudentDataBase.getAllStudents().forEach(c3);
		
		// using method reference
		System.out.println("printing activities of all students using method reference..");
		Consumer<Student> c4 = Student :: printListOfActivities;
		StudentDataBase.getAllStudents().forEach(c4);
	}
}
