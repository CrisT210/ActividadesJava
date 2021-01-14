
class Project {

	private String nombre;
	private String descripcion;
	private double costoInicial;
	
	public Project() {
		//System.out.println("Proyecto Creado!");
		this.nombre = "";
		this.descripcion = "";
	}
	
	public Project(String nombre) {
		this.nombre = nombre;
		this.descripcion = "";
	}
	
	public Project(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCostoInicial() {
		return costoInicial;
	}

	public void setCostoInicial(double costoInicial) {
		this.costoInicial = costoInicial;
	}
	
	public String elevatorPicth() {
		return this.nombre +" ("+ this.costoInicial +"): "+ this.descripcion;
	}

}
