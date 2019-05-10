package ar.edu.unlam.tallerweb1.modelo;
import java.util.Locale;

public class Cadena {
		//Atributos
		private String texto;
		private String accion;
		private String resultado;
		
			//Metodos
		public String getAccion() {
			return accion;
		}
		public void setAccion(String accion) {
			this.accion = accion;
		}

		public void pasarAMayuscula(){
			this.resultado = this.texto.toUpperCase();

		}
		public void pasarAMinuscula(){
			this.resultado = this.texto.toLowerCase();

		}
		public void cantidadDeCaracteres(){
			this.resultado = this.texto.replace(" ", "");
			Integer r = this.resultado.length();
			this.resultado = r.toString();
		}
		public void invertirOrden(){
			String ordenInvertido = "";
			for(int i=this.texto.length()-1;i>=0;i--){
				ordenInvertido = ordenInvertido + this.texto.charAt(i);
			}
			this.resultado = ordenInvertido;
		}
		public String getTexto() {
			return texto;
		}
		public void setTexto(String texto) {
			this.texto = texto;
		}
		public String getResultado() {
			return resultado;
		}
		public void setResultado(String resultado) {
			this.resultado = resultado;
		}
		
		public void realizarMetodo(){
			switch(this.accion){
			case "Pasar cadena a mayúsculas": this.pasarAMayuscula();
									break;
			case "Pasar cadena a minúsculas": this.pasarAMinuscula();
									break;
			case "Invertir Orden":   this.invertirOrden();
									break;
			case "Mostrar cantidad de caracteres": this.cantidadDeCaracteres();
										 break;
			default: this.resultado="Acción no válida";
			
			}
		}
		
	}
