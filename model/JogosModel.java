package catalago.de.jogos.demo.model;



import java.util.UUID;

import catalago.de.jogos.demo.dto.JogosDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Catálogo")
public class JogosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column (name = "Nome")
	private String nome;
	
	@Column (name = "Categoria")
	private String categoria;
	
	@Column (name = "Classificação")
	private String classificação;
	
	@Column (name = "Avaliação")
	private String avaliacao;
	
	@Column (name = "Lançamento")
	private String lancamento;
	
	@Column (name = "Descrição")
	private String descricao;



	public JogosModel() {
		
	}

	public JogosModel(UUID id, String nome, String categoria, String classificação, String avaliacao, String lancamento,
			String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.classificação = classificação;
		this.avaliacao = avaliacao;
		this.lancamento = lancamento;
		this.descricao = descricao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getClassificação() {
		return classificação;
	}

	public void setClassificação(String classificação) {
		this.classificação = classificação;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
