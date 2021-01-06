package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import app.entities.Book;
import app.services.BookService;

@org.springframework.web.bind.annotation.RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("books")
	public List<Book> book() {
		var book = new Book("J.K.Rowling", "Harry Potter 1");
		return bookService.getAll();
	}

	@PostMapping("/books")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createBook(@RequestBody Book book) {
		bookService.save(book);

	}

	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		return bookService.getBook(id);

	}

	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.delete(id);
	}

	@PutMapping("books/{id}")
	public void update(@RequestBody Book book, @PathVariable Long id) {
		try {
			Book formerBook = bookService.getBook(id);
			bookService.save(book);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
