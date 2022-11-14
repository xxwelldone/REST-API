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

import br.com.cadastros.model.Diretor;
import br.com.cadastros.repository.DiretorRepository;

@RestController
@RequestMapping("/diretor")
@CrossOrigin(origins = "*")
public class DiretorController {
	@Autowired
	DiretorRepository repo;

	@GetMapping
	public ResponseEntity<List<Diretor>> getAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Diretor> getId(@PathVariable Long id) {
		return repo.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Diretor> post(@RequestBody Diretor post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(post));
	}
	@PutMapping
	public ResponseEntity<Diretor> put (@RequestBody Diretor put){
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(put));
	}
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable Long id) {
		repo.deleteById(id);
	}
}
