package application;



import java.awt.List;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * A single particle with a per-frame reduced lifespan and now view. The particle is drawn on a canvas, it isn't actually a node
 */
public class Particle extends Sprite {
	public boolean source=true;
	public long value;
	public ArrayList<Particle> mom;
	public long index;
	public boolean compared;
        public Color c = null;
	
	
	public Particle(java.util.List<Particle> mom2, Vector2D location, Vector2D velocity, Vector2D acceleration, double width, double height) {
		super( location, velocity, acceleration, width, height);
		this.mom = (ArrayList<Particle>) mom2;
		value =(int) Math.random()*10000000;
                c =  Color.rgb((int)(Math.random()*255), (int)(Math.random()*255),(int)(Math.random()*255));
               
	} 
	public Particle( Vector2D location, Vector2D velocity, Vector2D acceleration, double width, double height) {
		super( location, velocity, acceleration, width, height);
		value =(int) Math.random()*10000000;
                c =  Color.rgb((int)(Math.random()*255), (int)(Math.random()*255),(int)(Math.random()*255));
	} 	
	public void remove(){
		mom.remove(this);
	}
	@Override
	public Node createView() {
		return null;
	}
	
	public void decreaseLifeSpan() {
	//	if(compared){
			lifeSpan--;
	//	}
	}

	
}
