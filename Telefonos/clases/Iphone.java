package telefonos.clases;
import telefonos.interfaz.Ringable;
import telefonos.phone.Phone;

public class Iphone extends Phone implements Ringable {

	public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	
    @Override
    public String ring() {
    	return "Iphone "+ this.getVersionNumber() +" dice "+ this.getRingTone();
    }
    @Override
    public String unlock() {
    	return "Desbloqueo mediante reconocimiento facial";
    }
    @Override
    public void displayInfo() {
    	System.out.println("Iphone "+ this.getVersionNumber() +" operador "+ this.getCarrier());
    }
	
}
