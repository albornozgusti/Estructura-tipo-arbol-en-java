package Main;

public class DatoRaiz {
	
	private Metabolismo metabolismo;
	private Reproduccion reproduccion;
	
	public DatoRaiz(Metabolismo meta,Reproduccion repro) {	
		this.metabolismo=meta;
		this.reproduccion=repro;
	}

	public Metabolismo getMetabolismo(){
		return metabolismo;
	}
	
	public Reproduccion getReproduccion(){
		return reproduccion;
	}
	
	public void setMetabolismo(Metabolismo metabolismo){
		this.metabolismo = metabolismo;
	}
	
	public void setReproduccion(Reproduccion reproduccion){
		this.reproduccion = reproduccion;
	}
	
	public String TipoDeMetabolismo(){
		return metabolismo.getTipo_de_Metabolismo();
	}
	
	public String TipoDeReproduccion(){
		return reproduccion.getTipo_de_reproduccion();
	}
	
}
