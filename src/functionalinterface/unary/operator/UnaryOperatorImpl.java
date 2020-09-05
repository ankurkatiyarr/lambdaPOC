package functionalinterface.unary.operator;

import java.util.function.UnaryOperator;

public class UnaryOperatorImpl {
	static UnaryOperator<String> unaryOperator = (name) -> name.concat("Katiyar");
	
	public static void main(String[] args) {
		System.out.println(unaryOperator.apply("Ankur"));
	}

}
