import java.util.ArrayList;

public class Portafolio {

	private ArrayList<Project> projects = new ArrayList<Project>();
	
	public Portafolio(Project project) {
		this.projects.add(project);
	}
	
	public void setProject(Project project){
        this.projects.add(project);
    }

    public ArrayList<Project> getAllProjects(){
    	return projects;
    }
	
    public String getPortafolioCost() {
    	return "Costo Total: "+ calcularCostoTotal();
    }
    
    public String showPortafolio() {
    	return showProyectos() +"Costo Total: "+ calcularCostoTotal();
    }
    
    private double calcularCostoTotal() {
    	
    	double sum = 0.0;
    	for(int i = 0; i < projects.size(); i++) {
    		sum += projects.get(i).getCostoInicial();
    	}
    	return sum;
    }
    
    private String showProyectos() {
    	
    	String proyectos = "";
    	for(int i = 0; i < projects.size(); i++) {
    		proyectos += projects.get(i).getNombre()+ " : "+ projects.get(i).getDescripcion()+" \n";
    	}
    	return proyectos;
    }
    
}
