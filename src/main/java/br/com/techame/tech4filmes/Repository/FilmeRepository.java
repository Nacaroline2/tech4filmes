package br.com.techame.tech4filmes.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.techame.tech4filmes.model.Filme;

public interface FilmeRepository extends MongoRepository <Filme, String> {
    
}





