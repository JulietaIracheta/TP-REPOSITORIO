package ar.edu.unlam.tallerweb1;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.assertThat;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class TestMapeo extends SpringTest{
	
	@Test
	@Transactional
	@Rollback (true)
	public void testquebusquetodoslospaísesdehablainglesa () {
		
		Pais p1 = new Pais ();
		Pais p2 = new Pais ();
		Pais p3 = new Pais ();
	
		p1.setIdioma("Ingles");
		p2.setIdioma("Chino");
		p3.setIdioma("Castellano");
		
		getSession().save(p1);
		getSession().save(p2);
		getSession().save(p3);
		
		List <Pais> paisList = getSession().createCriteria(Pais.class)
				.add(Restrictions.like("idioma", "Inglesa"))
				.list();
		
		for (Pais pl: paisList) {
			assertThat(pl.getIdioma()).isEqualTo("Inglesa");
		}	
	}
	
	
	@Test
	@Transactional
	@Rollback (true)
	public void testquebusquetodoslospaísesdelcontinenteeuropeo () {
		
		
		Continente c1 = new Continente ();
		Continente c2 = new Continente ();
		Continente c3 = new Continente ();
		
		
		Pais p1 = new Pais ();
		Pais p2 = new Pais ();
		Pais p3 = new Pais ();
		Pais p4 = new Pais ();
		
		p1.setContinente(c1);
		p2.setContinente(c2);
		p3.setContinente(c3);
		p4.setContinente(c1);
		
		c1.setNombre("Europa");
		c2.setNombre("America");
		c3.setNombre("Africa");
		
		getSession().save(p1);
		getSession().save(p2);
		getSession().save(p3);
		getSession().save(p4);
		
		List <Pais> pceuropeoList = getSession().createCriteria(Pais.class)
				.createAlias("continente", "continenteBuscado")
				.add(Restrictions.like("continenteBuscado.nombre", "europeo"))
				.list();
		
		for (Pais ce: pceuropeoList) {
			assertThat(ce.getContinente().getNombre()).isEqualTo("europeo");
		}
	}
	
	
	
	
	
	
	
}