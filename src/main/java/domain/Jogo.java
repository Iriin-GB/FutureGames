package domain;

import java.util.ArrayList;

import db.JogoDao;

public class Jogo {
	private int idJogo;
    private String imagemUrl;
    private String nome;
    private String dataLancamento;
    private String empresaProducao;
    private String empresaPublicacao;
    
    
	public int getIdJogo() {
		return idJogo;
	}
	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}
	public String getImagemUrl() {
		return imagemUrl;
	}
	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getEmpresaProducao() {
		return empresaProducao;
	}
	public void setEmpresaProducao(String empresaProducao) {
		this.empresaProducao = empresaProducao;
	}
	public String getEmpresaPublicacao() {
		return empresaPublicacao;
	}
	public void setEmpresaPublicacao(String empresaPublicacao) {
		this.empresaPublicacao = empresaPublicacao;
	}
	
	public Jogo(String imagemUrl, String nome, String dataLancamento, String empresaProducao,
			String empresaPublicacao) {
		this.imagemUrl = imagemUrl;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.empresaProducao = empresaProducao;
		this.empresaPublicacao = empresaPublicacao;
	}
	
	public Jogo(int idJogo, String imagemUrl, String nome, String dataLancamento, String empresaProducao,
			String empresaPublicacao) {
		this.idJogo = idJogo;
		this.imagemUrl = imagemUrl;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.empresaProducao = empresaProducao;
		this.empresaPublicacao = empresaPublicacao;
	}
	
	public Jogo() {super();	}
	
	public void salvar() {
	   System.out.println("Salvando no Banco!");
	   new JogoDao().cadastrarJogo(this);;
	   }
   
	public ArrayList<Jogo> buscarJogoPorNome(String nome){
		return new JogoDao().BuscarJogoPorNome(nome);
		
	}
}
