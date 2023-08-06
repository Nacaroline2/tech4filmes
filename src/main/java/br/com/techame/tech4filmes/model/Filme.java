package br.com.techame.tech4filmes.model;

import org.springframework.data.annotation.Id;

public class Filme {
@Id
    private String id;
    private String nome;
    private String anoLancamento;
    private String diretor;
    private TipoItem tipo;

   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    } 
    public TipoItem getTipo() {
        return tipo;
    }
    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
   
}
