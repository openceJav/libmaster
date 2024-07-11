package com.opencejav.LibMaster.controllers;

import com.opencejav.LibMaster.repository.BookRepository;

import com.opencejav.LibMaster.utils.Response;
import com.opencejav.LibMaster.utils.ResponseContent;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.opencejav.LibMaster.models.*;

import java.math.BigInteger;
import java.util.*;

@RestController
@RequestMapping("/v1/api")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	private Optional<Book> optionalBook; // Dummy Optional
	
	@GetMapping("/book/welcome")
	public ResponseEntity<?> welcome() {
		return ResponseEntity.ok(new ResponseContent("Welcome!", "RESPONSE_TYPE: INFO"));
	}
	
	@GetMapping("/book/find")
	public Object find(
			@RequestParam BigInteger bookId) {
		return bookRepository.findById(bookId.intValue());
	}
	
	@PutMapping("/book")
	public Object update(@RequestBody Book book) {
		return bookRepository.save(book); // TODO: Consider using Credentials Class
	}
	
	@PostMapping("/book")
	public Object upload(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	// TODO: Change to ResponseEntity<?>
	@DeleteMapping("/book")
	public Object delete(@RequestBody @NonNull BigInteger bookId) {
		if (bookRepository.findById(bookId.intValue()).isPresent()) {
			return new ResponseContent("Deletion Unsuccessful, Try Again.", "Confirmation");
		}

		bookRepository.deleteById(bookId.intValue());
		return new ResponseContent("Deletion Successful", "Confirmation");
	}
}