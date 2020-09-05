package functionalinterface.unary.operator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorImpl {
	static BinaryOperator<Integer> binaryOperatorFunction = (a, b) -> a*b;
	
	static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
	
	static BinaryOperator<Integer> boMaxBy = BinaryOperator.maxBy(comparator);
	
	static BinaryOperator<Integer> boMinBy = BinaryOperator.minBy(comparator);
	
	public static void main(String[] args) {
		System.out.println(binaryOperatorFunction.apply(10, 5));
		
		System.out.println(boMaxBy.apply(10, 18));
		
		System.out.println(boMinBy.apply(10, 18));
	}
}
