package telefonos.clases;

import telefonos.interfaz.Ringable;
import telefonos.phone.Phone;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "Galaxy "+ this.getVersionNumber() +" dice "+ this.getRingTone();
    }
    @Override
    public String unlock() {
    	return "Desbloqueo mediante huella dactilar";
    }
    @Override
    public void displayInfo() {
        System.out.println("Galaxy "+ this.getVersionNumber() +" operador "+ this.getCarrier());
    }
	
}
