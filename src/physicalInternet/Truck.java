package physicalInternet;

public class Truck {
    private double weight = 1000;
    private int height = 30;
    private int width = 30;
    private int depth = 40;
    private double speed = 20.0; 
    private Boolean trailorOnTruck = false;
  

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void SetTrailorAttached(Boolean trailorOnTruck) {
		this.trailorOnTruck = trailorOnTruck;
	}

    
	public void speedOfTruck (Boolean trailorOnTruck, Trailor trailor) {
		if (this.trailorOnTruck = true) {
		setSpeed(speed - (trailor.getTotalWeight()/10)); 
		} else {setSpeed(speed);
			
		}
	}
	
	
	
	
	
	
	
		
		
	
}