package br.com.cadastros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastros.model.Filme;
import br.com.cadastros.repository.FilmeRepository;

@RestController
@RequestMapping("/filme")
@CrossOrigin(origins = "*", allowedHeaders = "")
public class FilmeController {
	@Autowired

	private FilmeRepository repository;

	@GetMapping
	public ResponseEntity<List<Filme>> GetAll() {
		return ResponseEntity.ok(repository.findAll());

	}
	@GetMapping("/{id}")
	public ResponseEntity<Filme> GetbyId(@PathVariable Long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	
	}
	@GetMapping("titulo/{title}")
	public ResponseEntity<List<Filme>> FindbyTitle(@PathVariable String title){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(title));
	}

	@PostMapping
	public ResponseEntity<Filme> post(@RequestBody Filme post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}

	@PutMapping
	public ResponseEntity<Filme> put(@RequestBody Filme put) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(put));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	

}
