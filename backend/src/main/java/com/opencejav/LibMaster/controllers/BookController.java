package com.opencejav.LibMaster.controllers;

import com.opencejav.LibMaster.repositories.*;
import com.opencejav.LibMaster.tools.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.opencejav.LibMaster.models.*;
import java.util.*;

@RestController
public class BookController {
	@Autowired
	private BookRepository repo;
	
	private Optional<Book> dummyOptional;
	
	@GetMapping("/book")
	public Object welcome() {
		return new Response("Welcome!", "Welcome!");
	}
	
	@GetMapping("/book/find")
	public Object find(@RequestParam String bookId) {
		return repo.findById((UUID.fromString(bookId)));
	}
	
	@PutMapping("/book/update")
	public Object update(@RequestBody Book book) {
		//Might use a Credentials class.
		return repo.save(book);
	}
	
	@PostMapping("/book/upload")
	public Object upload(@RequestBody Book book) {
		return repo.save(book);
	}

	@DeleteMapping("/book/delete")
	public Object delete(@RequestBody String bookId) {
		repo.deleteById(UUID.fromString(bookId));
		if (repo.findById(UUID.fromString(bookId)).isEmpty() == false) {
			return new Response("Deletion Unsuccessful. Please try again.", "Confirmation");
		}
		return new Response("Deletion Successful", "Confirmation");
	}
}