package streams.tomap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Book {
	private String name;
	private int releaseYear;
	private String isbn;

	public Book(String name, int releaseYear, String isbn) {
		super();
		this.name = name;
		this.releaseYear = releaseYear;
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", releaseYear=" + releaseYear + ", isbn=" + isbn + "]";
	}
	
	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
		bookList.add(new Book("The Two Towers", 1954, "0345339711"));
		bookList.add(new Book("The Return of the King", 1955, "0618129111"));
		
		Map<Integer, String> map = bookList.stream()
				.collect(Collectors.toMap(Book::getReleaseYear, Book::getName, (existing, replacement) -> existing));
		System.out.println(map);
	}

}
