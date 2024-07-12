package com.opencejav.LibMaster.controllers;

import com.opencejav.LibMaster.repository.BookRepository;

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
	public ResponseEntity<?> baseRoute() {
		return ResponseEntity
				.ok()
				.body(new ResponseContent("Welcome!", "RESPONSE_TYPE: INFO"));
	}
	
	@GetMapping("/book/find")
	public ResponseEntity<?> findBook(@RequestParam BigInteger bookId) {
		return ResponseEntity
				.ok()
				.body(bookRepository.findById(bookId.intValue()));
	}
	
	@PutMapping("/book")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		bookRepository.save(book); // TODO: Consider using Credentials Class

		return ResponseEntity
				.ok()
				.body(new ResponseContent("Updated successfully!", "RESPONSE_TYPE: CONFIRMATION"));
	}
	
	@PostMapping("/book")
	public ResponseEntity<?> uploadBook(@RequestBody Book book) {
		bookRepository.save(book);

		return ResponseEntity
				.ok(new ResponseContent("Success!", "RESPONSE_TYPE: CONFIRMATION"));
	}

	@DeleteMapping("/book")
	public ResponseEntity<?> delete(@RequestBody @NonNull BigInteger bookId) {
		if (bookRepository.findById(bookId.intValue()).isPresent()) {
			return ResponseEntity
					.badRequest()
					.body(new ResponseContent("Deletion Unsuccessful, Try Again.", "Confirmation"));
		}

		bookRepository.deleteById(bookId.intValue());
		return ResponseEntity
				.ok()
				.body(new ResponseContent("Deletion Successful", "Confirmation"));
	}
}