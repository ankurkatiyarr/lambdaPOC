package functionalinterface.consumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class BiConsumerImpl {
	public static void printNameAndActivities() {
		List<Student> list = StudentDataBase.getAllStudents();
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " " + activities);
		list.forEach(
				student -> biConsumer.accept(student.getName(), student.getActivities())
		);
	}
	
	public static void printNameAndActivities2() {
		List<Student> list = StudentDataBase.getAllStudents();
		Consumer<Student> consumer = (student) -> System.out.println(student.getName() + " " + student.getActivities());
		list.forEach(consumer);
	}
	
	public static void main(String[] args) {
//		printNameAndActivities();
		printNameAndActivities2();
	}
}
