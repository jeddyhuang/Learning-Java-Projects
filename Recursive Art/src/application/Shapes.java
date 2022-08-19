package application;



import java.util.ArrayList;
import java.util.Random;

public class Shapes {
	ArrayList<Particle> points;
	private static Random random = new Random();

	
	/**
	 * Initialize any instance variables here in the constructor
	 * @param height
	 */
	public Shapes(int height) {
		
		
		points = new ArrayList<Particle>();
		//Call your recursive method here
                
                
                
                

	}
	
	
	
	
	
	/*
	 * Draw a line based on starting point and ending points 
	 */
	public void drawLine(int x1, int y1, int x2, int y2){
		
		/*Setup random velocity vectors*/
		double vx = random.nextGaussian() * 0.2-.1;
		double vy = random.nextGaussian() * 0.2 - .1;

		Vector2D velocitySample = new Vector2D(vx,vy);
		Vector2D accelerationSample = new Vector2D(0, 0);		
		
		
		
		/*
		 * Each particle created requires location in vector format
		 */
		//example location vector xy
		Vector2D sample = new Vector2D(500, 500);

		//Example adding a particle
		points.add(new Particle(sample, velocitySample, accelerationSample, 3, 3));		
			
	}
		
	

	public void circle(double x, double y, double r){
		/*Setup random velocity vectors*/
		double vx = random.nextGaussian() * 0.2-.1;
		double vy = random.nextGaussian() * 0.2 - .1;

		Vector2D velocitySample = new Vector2D(vx,vy);
		Vector2D accelerationSample = new Vector2D(0, 0);		
		
		/*
		 * Each particle created requires location in vector format
		 */
		//example location vector xy
		Vector2D sample = new Vector2D(500, 500);

		//Example adding a particle
		//points.add(new Particle(sample, velocitySample, accelerationSample, 3, 3));				


		
	}
	

		
	public void triangle(int height, double x1, double y1) {
		
	}
	
	//for the binary tree, you can decide what your signature needs to be.
	public void tree(){
		
	}
	
	public void snowFlake(int len){
		
	}
	
	
}
