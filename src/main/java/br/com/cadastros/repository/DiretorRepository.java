package br.com.cadastros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastros.model.Diretor;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long>{
	public  List<Diretor> findAllByNomeContainingIgnoreCase(String nome);

}
