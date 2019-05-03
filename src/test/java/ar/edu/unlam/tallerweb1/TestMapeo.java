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
	public void testquebusquetodoslospa�sesdehablainglesa () {
		
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
	public void testquebusquetodoslospa�sesdelcontinenteeuropeo () {
		
		
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
	
	@Test
	@Transactional
	@Rollback (true)
	public void TestTodosLosPaisesCuyaCapitalEstanAlNorteDelTropicoDeCancer(){

		Pais p1 = new Pais();
		Pais p2 = new Pais();
		Pais p3 = new Pais();

		Ciudad c1 = new Ciudad();
		Ciudad c2 = new Ciudad();
		Ciudad c3 = new Ciudad();
		Ciudad c4 = new Ciudad();
		Ciudad c5 = new Ciudad();
		Ciudad c6 = new Ciudad();
		
		Ubicacion u1 = new Ubicacion();
		Ubicacion u2 = new Ubicacion();
		Ubicacion u3 = new Ubicacion();
		Ubicacion u4 = new Ubicacion();
		Ubicacion u5 = new Ubicacion();
		Ubicacion u6 = new Ubicacion();
		
		p1.setNombre("Canada");
		p2.setNombre("Indonesia");
		p3.setNombre("Holanda");
		
		p1.setCapital("Ottawa");
		p2.setCapital("Yakarta");
		p3.setCapital("�msterdam");
		
		c1.setNombre("Montreal");
		c2.setNombre("Ottawa");
		c3.setNombre("Yakarta");
		c4.setNombre("Surabaya");
		c5.setNombre("Eindhoven");
		c6.setNombre("�msterdam");
		
		c1.setPais(p1);
		c2.setPais(p1);
		c3.setPais(p2);
		c4.setPais(p2);
		c5.setPais(p3);
		c6.setPais(p3);
		
		u1.setLatitud(45.508889);
		u1.setLongitud(-73.561667);
		u2.setLatitud(45.424722);
		u2.setLongitud(-75.695);
		u3.setLatitud(-6.21462);
		u3.setLongitud(106.84513);
		u4.setLatitud(-7.245833);
		u4.setLongitud(112.737778);
		u5.setLatitud(51.434444);
		u5.setLongitud(5.484167);
		u6.setLatitud(52.383333);
		u6.setLongitud(4.9);
		
		c1.setUbicacion(u1);
		c2.setUbicacion(u2);
		c3.setUbicacion(u3);
		c4.setUbicacion(u4);
		c5.setUbicacion(u5);
		c6.setUbicacion(u6);

		//Latitud de Tropico de Cancer en decimales 23.43722222222222
				Double tropC = 23.43722222222222;
				
				getSession().save(c1);
				getSession().save(c2);
				getSession().save(c3);
				getSession().save(c4);
				getSession().save(c5);
				getSession().save(c6);

		List <Pais> ppListaw = getSession().createCriteria(Pais.class)
										.createAlias("ciudades", "ciuBuscada")
										.createAlias("ciuBuscada.ubicacion", "ubiBuscada")
										.add(Restrictions.like("ciuBuscada.nombre", "capital"))
										.add(Restrictions.gt("ubiBuscada.latitud", tropC)).list();
		//ESTA MAL PERO NO SE COMO AGREGAR AL CRITERIA EL OneToMany
		/*
		for(Pais pp3:ppListaw){
			for(Ciudad cc3:pp3.getCiudades()){
				assertThat(cc3.getUbicacion().getLatitud()).isEqualTo(tropC);
			}
		}*/
								

	
	
	}	
	
}