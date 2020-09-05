package functionalinterface.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import functionalinterface.common.Student;
import functionalinterface.common.StudentDataBase;

public class SupplierImpl {
	static Supplier<Student> supplier = () -> new Student("Ankur",2,3.6, "male",10,Arrays.asList("swimming", "basketball","volleyball"));
	
	static Supplier<List<Student>> allStudentsSupplier = () -> StudentDataBase.getAllStudents();
	
	public static void main(String[] args) {
//		System.out.println(supplier.get());
		
		System.out.println(allStudentsSupplier.get());
		
		String s;
	}
}
