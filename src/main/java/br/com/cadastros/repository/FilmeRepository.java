package br.com.cadastros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastros.model.Filme;
@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	public List<Filme> findAllByNomeContainingIgnoreCase(String titulo);
}
