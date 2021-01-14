//import java.util.Arrays;

public class ProjectTest {

	public static void main(String[] args) {
		
		Project proyectoA = new Project();
		proyectoA.setNombre("VideoJuegos");
		proyectoA.setDescripcion("Crear una coleccion de juegos");
		System.out.println(proyectoA.getNombre());
        System.out.println(proyectoA.getDescripcion());
        
        Project proyectoB = new Project("Autos", "Comprar flota de vehiculos");
        proyectoB.setCostoInicial(10000.0);
        
        Project proyectoC = new Project("Computadores");
        proyectoC.setDescripcion("Reemplazo de computadores");
        proyectoC.setCostoInicial(1500000.0);
        
        System.out.println(proyectoA.elevatorPicth());
        System.out.println(proyectoB.elevatorPicth());
        System.out.println(proyectoC.elevatorPicth());
        
        Portafolio portafolioA = new Portafolio(proyectoA);
        portafolioA.setProject(proyectoB);
        
        System.out.println(portafolioA.getAllProjects());
        System.out.println(portafolioA.getPortafolioCost());
        System.out.println(portafolioA.showPortafolio());
        
	}

}
