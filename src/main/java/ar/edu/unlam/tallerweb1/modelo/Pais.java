package ar.edu.unlam.tallerweb1.modelo;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer habitantes;
	private String idioma;
	@OneToOne
	@Cascade(value= CascadeType.ALL)
	private Ciudad capital;
	@ManyToOne
	@Cascade(value= CascadeType.SAVE_UPDATE)
	private Continente continente;
	
	

	//Getters and Setters.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(Integer habitantes) {
		this.habitantes = habitantes;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	public Ciudad getCapital() {
		return capital;
	}

	public void setCapital(Ciudad capital) {
		this.capital = capital;
	}
	
	
}