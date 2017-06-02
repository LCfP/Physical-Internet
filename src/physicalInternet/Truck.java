package physicalInternet;

public class Truck {
	private double weight = 1000;
	private int height = 30;
	private int width = 30;
	private int depth = 40;
	private double speed = 20.0;
	private Boolean trailerOnTruck = false;

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void SetTrailerAttached(Boolean trailerOnTruck) {
		this.trailerOnTruck = trailerOnTruck;
	}

	public void speedOfTruck(Boolean trailerOnTruck, Trailer trailer) {
		if (this.trailerOnTruck = true) {
			setSpeed(speed - (trailer.getTotalWeight() / 10));
		} else {
			setSpeed(speed);

		}
	}

}