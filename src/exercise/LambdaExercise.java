package exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class LambdaExercise {
	// sort a list without using lambda
	public static void sortWithoutLambda() {
		List<Student> list = StudentDataBase.getAllStudents();
		
		Comparator<Student> c = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getName().compareTo(o2.getName()) > 0) {
					return 1;
				} else if (o1.getName().compareTo(o2.getName()) < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		
		Collections.sort(list, c);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	// sort a list without using lambda
	public static void sortWithoutLambda2() {
		List<Student> list = StudentDataBase.getAllStudents();
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getName().compareTo(o2.getName()) > 0) {
					return 1;
				} else if (o1.getName().compareTo(o2.getName()) < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (Student student : list) {
			System.out.println(student);
		}
	}

	
	// sort a list by using lambda
	public static void sortWithLambda() {
		List<Student> list = StudentDataBase.getAllStudents();
		Collections.sort(list, (o1, o2) -> {
			if (o1.getName().compareTo(o2.getName()) > 0) {
				return 1;
			} else if (o1.getName().compareTo(o2.getName()) < 0) {
				return -1;
			} else {
				return 0;
			}
		});
		
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	public static void main(String[] args) {
//		sortWithoutLambda();
//		sortWithoutLambda2();
		sortWithLambda();
	}
}
