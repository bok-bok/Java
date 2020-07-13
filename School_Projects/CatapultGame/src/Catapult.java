import java.util.Random;


public class Catapult {
	Random R = new Random();
	double angle  = 45.0;
	double velocity = 50.0;
	int score;
	int catapultQuality =  1+ R.nextInt(10);
	double uservalue = (Math.pow(velocity,2)*Math.sin(2*(Math.toRadians(angle)))/9.8);
	double realvalue = uservalue - (10-catapultQuality)*R.nextGaussian();
	boolean trigger = false;
	
	// function that changes angle of catapult
	public void setAngle(double angle) {
		if(angle < 0 || angle > 90) { // code to avoid out of range
			System.out.println("angle should be in the range of 0 to 90");
		}else {
			this.angle = angle;
			System.out.println("your angle is "+ angle+" now");
		}
		
	}
	// function that changes velocity of catapult
	public void setVelocity(double velocity) {
		if(velocity < 0|| velocity > 100) { // code to avoid out of range
			System.out.println("velocity should be in the range of 0 to 100");
		}else {
			this.velocity =  velocity;
			System.out.println("your velocity is "+ velocity+" now");
		}
		
	}
	// function that update value when catapultQuality is changed by cheat
	public void setvalue() {
		uservalue = (Math.pow(velocity,2)*Math.sin(2*angle)/9.8);
		realvalue = uservalue - (10-catapultQuality)*R.nextGaussian();
	}
	// function to trigger fire
	public void fire() {
		trigger = true;
	}
	// function to changes CatapultQuality
	public void setCatapultQuality(int Quality) {
		if(Quality < 0 || Quality > 10) {
			System.out.println("Catapult Quality should be in the range of 0 to 10");
		}else {
			catapultQuality = Quality;
			System.out.println("your catapultQuality is " + catapultQuality+ " now");
		}
	}
	
}
