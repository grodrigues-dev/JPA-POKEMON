package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TREINADOR")
@SequenceGenerator(name = "treinador", sequenceName = "SQ_TB_TREINADOR", allocationSize = 1)
public class Treinador {
	
	@Id
	@Column(name = "CD_TREINADOR")
	@GeneratedValue(generator = "treinador", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name = "NM_TREINADOR", nullable = false)
	private String nome;
	
	@Column(name = "VL_XP")
	private int xp;
	
	@OneToMany(mappedBy = "treinador", cascade = CascadeType.PERSIST)
	private List<Pokemon> pokemons;
	
	@OneToOne(mappedBy = "lider")
	private Cidade cidade;
	
	@ManyToMany(mappedBy = "desafiantes")
	private List<Ginasio> desafios; 
	
	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public Treinador(String nome, int xp) {
		super();
		this.nome = nome;
		this.xp = xp;
	}


	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	
	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	
	public Treinador() {
		super();
	}


	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getXp() {
		return xp;
	}


	public void setXp(int xp) {
		this.xp = xp;
	}
	
	
	
	
}
