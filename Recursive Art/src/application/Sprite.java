package application;



import javafx.scene.Node;
import javafx.scene.layout.Region;

/**
 * Sprite base class
 */
public abstract class Sprite extends Region {

	Vector2D location;
	Vector2D velocity;
	Vector2D acceleration;

	double maxSpeed = Settings.get().getParticleMaxSpeed();
	double radius;
	  
	Node view;
	
	double width;
	double height;
	double centerX;
	double centerY;
	
	double angle;
	
	double lifeSpanMax = Settings.get().getParticleLifeSpanMax() - 1; // -1 because we want [0..255] for an amount of 256; otherwise we'd get DivByZero in the logic; will fix it later
	double lifeSpan = lifeSpanMax;
    
	public Sprite( Vector2D location, Vector2D velocity, Vector2D acceleration, double width, double height) {
		
		
		this.location = location;
		this.velocity = velocity;
		this.acceleration = acceleration;
		
		this.width = width;
		this.height = height;
		this.centerX = width / 2;
		this.centerY = height / 2;
		
		this.radius = width / 2;
		
		this.view = createView();
		
		setPrefSize(width, height);
		
		if( this.view != null) {
			getChildren().add( view);
		}
	        
	}
	
	public abstract Node createView();

	public void applyForce(Vector2D force) {

		acceleration.add(force);
		    
	}

	/**
	 * Standard movement method: calculate valocity depending on accumulated acceleration force, then calculate the location.
	 * Reset acceleration so that it can be recalculated in the next animation step.
	 */
	public void move() {
		
		// set velocity depending on acceleration
		velocity.add(acceleration);
	    
		// limit velocity to max speed
		velocity.limit(maxSpeed);
	    
		// change location depending on velocity
		location.add(velocity);

		// angle: towards velocity (ie target)
	    angle = velocity.angle();
	    
		// clear acceleration
		acceleration.multiply(0);
	}
	
	/**
	 * Update node position
	 */
	public void display() {
		
		// location
		relocate(location.x - centerX, location.y - centerY);
		
		// rotation
		setRotate(Math.toDegrees( angle));

	}
	
	
	public Vector2D getVelocity() {
		return velocity;
	}
	
	public Vector2D getLocation() {
		return location;
	}
	
	public void setLocation( double x, double y) {
		location.x = x;
		location.y = y;
	}

	public void setLocationOffset( double x, double y) {
		location.x += x;
		location.y += y;
	}

	public void decreaseLifeSpan() {
	}

	public boolean isDead() {

	    if (lifeSpan <= 0.0 || velocity.y>=0) {
	      return true;
	    } else {
	      return false;
	    }

	  }

	public int getLifeSpan() {
		return (int) lifeSpan;
	}

}
