package demo;

public class Example1 implements ExampleInterface1 {
	@Override
	public String foo(String s1, String s2) {
		String s3 = s1.concat(s2);
		return s3;
	}
	
	public static void main(String[] args) {
//		Example1 example1 = new Example1();
//		System.out.println(example1.foo("An", "kur"));
		
		ExampleInterface1 ei = (s1, s2) -> s1.concat(s2);
		System.out.println(ei.foo("Ra", "jat"));
	}
}
