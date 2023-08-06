package br.com.techame.tech4filmes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techame.tech4filmes.Repository.FilmeRepository;
import br.com.techame.tech4filmes.model.Filme;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    
    @Autowired
    private FilmeRepository repositorio;

    // CREATED

    @PostMapping
    private String cadastrarFilme(@RequestBody Filme filme){

        if (filme != null) {
            repositorio.save(filme);
            return "Nome: " + filme.getNome() +
                " Lançamento: " + filme.getAnoLancamento() +
                " Diretor: " + filme.getDiretor() +
                " Foi cadastrado com sucesso!";
        }
        return "O filme informado não existe no nosso banco de dados.";
    }

    // READ
    
    @GetMapping
    private List<Filme> obterFilme(){
        return repositorio.findAll();
    }

    @GetMapping("/{nome}")
    private Filme obterFilmePorNome(@PathVariable String nome){
        Filme filme = repositorio.findById(nome).orElse(null);
        return filme;
    }

    // UPDATE

    @PutMapping("/{id}")
    private Filme atualizarFilme(@PathVariable String id, @RequestBody Filme filmeNovo){

        Filme filme = repositorio.findById(id).orElse(null);

        if (filme != null) {
            filme.setNome(filmeNovo.getNome()); 
            filme.setAnoLancamento(filmeNovo.getAnoLancamento()); 
            filme.setDiretor(filmeNovo.getDiretor());
            return repositorio.save(filme);
        }
        return null;
    }

    //DELETE

    // DELETE
    @DeleteMapping("/{id}")
    private void removerFilme(@PathVariable String id){

        Filme filme = repositorio.findById(id).orElse(null);

        if (filme != null) {
            repositorio.delete(filme);
        }
    }
}
