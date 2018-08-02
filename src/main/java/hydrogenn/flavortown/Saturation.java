package main.java.hydrogenn.flavortown;

public enum Saturation {
	
	SUPERNATURAL(2.4),
	GOOD(1.6),
	NORMAL(1.0),
	LOW(0.6),
	POOR(0.2);
	
	double saturationRatio;
	
	private Saturation(double saturationRatio) {
		this.saturationRatio = saturationRatio;
	}
	
}
