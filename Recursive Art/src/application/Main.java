package application;


import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application implements EventListener{

	private static Random random = new Random();

	Canvas canvas;
	GraphicsContext graphicsContext;

	/**
	 * Container for canvas and other nodes like attractors and repellers
	 */
	Pane layerPane;

	List<Attractor> allAttractors = new ArrayList<>();
	List<Repeller> allRepellers = new ArrayList<>();
	List<Particle> allParticles = new ArrayList<>();
	List<Particle> Points = new ArrayList<>();

	List<Particle> sorted = new ArrayList<Particle>();

	AnimationTimer animationLoop;
	int x =0;

	Scene scene;

	MouseGestures mouseGestures = new MouseGestures();

	/**
	 * Container for pre-created images which have color and size depending on
	 * the particle's lifespan
	 */
	Image[] images;

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		canvas = new Canvas(Settings.get().getCanvasWidth(), Settings.get().getCanvasHeight());
		graphicsContext = canvas.getGraphicsContext2D();

		layerPane = new Pane();
		layerPane.getChildren().addAll(canvas);

		canvas.widthProperty().bind(layerPane.widthProperty());
		root.setCenter(layerPane);

		Node toolbar = Settings.get().createToolbar();
		root.setRight(toolbar);
		
		scene = new Scene(root, Settings.get().getSceneWidth(), Settings.get().getSceneHeight(), Settings.get().getSceneColor());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Particles");
		primaryStage.show();

		// initialize content
		preCreateImages();
		
		// add content
		prepareObjects();

		// listeners for settings
		addSettingsListeners();
		
		// add mouse location listener
		addInputListeners();

		// add context menus
		addContextMenu( canvas);
		
		// run animation loop
		startAnimation();

	}

	private void preCreateImages() {
		this.images = Utils.preCreateImages();
	}

	private void prepareObjects() {
/*
		// add attractors
		for (int i = 0; i < Settings.get().getAttractorCount(); i++) {
			addAttractor();
		}

		// add repellers
		for (int i = 0; i < Settings.get().getRepellerCount(); i++) {
			addRepeller();
		}*/

	}

	private void startAnimation() {

		// start game
		animationLoop = new AnimationTimer() {
			
			FpsCounter fpsCounter = new FpsCounter();
			
			@Override
			public void handle(long now) {

                            			/*Setup random velocity vectors*/
		double vx = 0;
		double vy = Math.random()*(-25)+5;

		Vector2D velocitySample = new Vector2D(vx,vy);
		Vector2D accelerationSample = new Vector2D(0, 0);		
		
                //example location vector xy
		Vector2D sample = new Vector2D(Math.random()*canvas.widthProperty().intValue(), Settings.get().getCanvasHeight());

		//Example adding a particle
                if(Math.random()<.04&&sample.x>100&&sample.x<600)
		allParticles.add(new Particle(sample, velocitySample, accelerationSample, 3, 3));
                            
                            
				// update fps
				fpsCounter.update( now);
				
				if( allParticles.size()<1000	){
                                    // add new particles
                                    for (int i = 0; i < Settings.get().getEmitterFrequency() ; i++) {
                                            addParticle();
                                            //if(allParticles.size()>80000 ) break;
                                            //addTriangle(800); 
                                    }
				}
				// apply force: gravity
				Vector2D forceGravity = Settings.get().getForceGravity();
				allParticles.forEach(sprite -> {
					sprite.applyForce(forceGravity);
				});

				// apply force: attractor
			/*	for (Attractor attractor: allAttractors) {
					allParticles.stream().parallel().forEach(sprite -> {
						Vector2D force = attractor.getForce(sprite);
						sprite.applyForce(force);
					});
				}
				
				// apply force: repeller
				for (Repeller repeller : allRepellers) {
					allParticles.stream().parallel().forEach(sprite -> {
						Vector2D force = repeller.getForce(sprite);
						sprite.applyForce(force);
					});
				}*/

				// move sprite: apply acceleration, calculate velocity and location
				allParticles.stream().parallel().forEach(Sprite::move);

				// update in fx scene
				allAttractors.forEach(Sprite::display);
				allRepellers.forEach(Sprite::display);

				// draw all particles on canvas
				// -----------------------------------------
				// graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				graphicsContext.setFill(Color.BLACK);
				graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

				// TODO: parallel?
				double particleSizeHalf = Settings.get().getParticleWidth() / 2;
				allParticles.stream().forEach(particle -> {

					Image img = images[particle.getLifeSpan()];
					graphicsContext.drawImage(img, particle.getLocation().x - particleSizeHalf, particle.getLocation().y - particleSizeHalf);

				});

				// life span of particle
				allParticles.stream().parallel().forEach(Sprite::decreaseLifeSpan);

				// remove all particles that aren't visible anymore
				removeDeadParticles();

				// show number of particles
				graphicsContext.setFill(Color.WHITE);
				graphicsContext.fillText("Particles: " + allParticles.size() + ", fps: " + fpsCounter.getFrameRate(), 1, 10);

			}
		};

		animationLoop.start();

	}
	
	public void circle(double x, double y, double r, ArrayList<Particle> add){
            for(int angle = 0; angle < 360; angle +=20){
                double x1 = r*Math.cos(angle);
                double y1 = r*Math.cos(angle);
            }
	}
        
        public void triangle(){
            
        }
        
        public void line(double x1, double y1, double x2, double y2, ArrayList<Particle> add){
            if(x1<x2){
                //create a location vector
                Vector2D location = new Vector2D(200,200);
                
                //create a velocity vector
                Vector2D velocity = new Vector2D(0.2,0.2);
                
                //create an acceleration vector
                Vector2D acc = new Vector2D(0.2,0.2);
                
                Particle p = new Particle(location, velocity, acc, 3, 3);
                
                p.source = false;
                add.add(p);
                line(x1+5, y1, x2, y2, add);
            }
        }
        
        public void maxPoint(){
            
        }
        
        public void tree(){
            
        }
        
        public void snowflake(){
            
        }
	

	private void removeDeadParticles() {

		Iterator<Particle> iter = allParticles.iterator();
                ArrayList<Particle> add = new ArrayList<Particle>();
		while (iter.hasNext()) {

			Particle particle = iter.next();
			if (particle.isDead()) {
                                iter.remove();	
                                System.out.println(particle.centerX);
                                if(particle.source==true){
                                    circle(particle.location.x, particle.location.y, 20,add);
                                    line(particle.location.x-50, particle.location.y-50, particle.location.x, particle.location.y,add);
                                }
			}
		}
                int i =0; 
		for(Particle p: add){
                    allParticles.add(p);
                    if(i++>100) break;
                }
                add.clear();
		

	}
	
	
	private void addTriangle(int width){
	
		Shapes t = new Shapes(250);
		
		// register sprite
		for(int i =0; i < t.points.size(); i++){
		//	Points.add(t.points.get(i));
			allParticles.add(t.points.remove(0));
		}

	}

	private void addParticle() {
            
                if(Math.random()<.95)return;
            
		// random location
		double x = Settings.get().getCanvasWidth() / 2 + random.nextDouble() * Settings.get().getEmitterWidth() - Settings.get().getEmitterWidth() / 2;
	//	double y = Settings.get().getEmitterLocationY();

		//randomize a particle anywhere on the canvas
		double y = random.nextDouble()*Settings.get().getCanvasHeight()/3;
		
		// dimensions
		double width = Settings.get().getParticleWidth();
		double height = Settings.get().getParticleHeight();
		if(x==0){
			width = 50;
			height = 50;
			x++;
		}

		// create motion data
		Vector2D location = new Vector2D(x, y);

		double vx = random.nextGaussian() * 0.3;
		double vy = random.nextGaussian() *-50;
		Vector2D velocity = new Vector2D(0, 50);

		Vector2D acceleration = new Vector2D(0, 0);

		// create sprite and add to layer
		Particle sprite = new Particle(sorted, location, velocity, acceleration, width, height);

		// register sprite
		//allParticles.add(sprite);
	//	add(sprite);

	}
	
	
	public void add(Sprite s){
		for(int i =0; i < allParticles.size();i++){
			if(((Particle) s).value>= ((Particle)s).value ){
				((Particle) s).index = i;
				sorted.add(i, (Particle) s);
			}
		}
	}

	private void addAttractor() {

		// center node
		double x = Settings.get().getCanvasWidth() / 2;
		double y = Settings.get().getCanvasHeight() - Settings.get().getCanvasHeight() / 4;

		// dimensions
		double width = 100;
		double height = 100;

		// create motion data
		Vector2D location = new Vector2D(x, y);
		Vector2D velocity = new Vector2D(0, 0);
		Vector2D acceleration = new Vector2D(0, 0);

		// create sprite and add to layer
		Attractor attractor = new Attractor(location, velocity, acceleration, width, height);

		// register sprite
		allAttractors.add(attractor);

		layerPane.getChildren().add(attractor);

		// allow moving via mouse
		mouseGestures.makeDraggable(attractor);
	}

	private void addRepeller() {

		// center node
		double x = Settings.get().getCanvasWidth() / 2;
		double y = Settings.get().getCanvasHeight() - Settings.get().getCanvasHeight() / 4 + 110;

		// dimensions
		double width = 100;
		double height = 100;

		// create motion data
		Vector2D location = new Vector2D(x, y);
		Vector2D velocity = new Vector2D(0, 0);
		Vector2D acceleration = new Vector2D(0, 0);

		// create sprite and add to layer
	//	Repeller repeller = new Repeller(location, velocity, acceleration, width, height);

		// register sprite
	//	allRepellers.add(repeller);
		int hy = (int) Settings.get().getCanvasHeight();
		for(int i =0; i < Settings.get().getCanvasWidth()/50;i++){
			Repeller r = new Repeller(new Vector2D(i*50,hy-40), velocity, acceleration, width,height);
			allRepellers.add(r);
			layerPane.getChildren().add(r);
			mouseGestures.makeDraggable(r);


		}


	}

	private void addInputListeners() {
	}

	private void addSettingsListeners() {
		
		// particle size
		Settings.get().particleWidthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				preCreateImages();
			}
			
		});
	}

	public void addContextMenu( Node node) {
		MenuItem menuItem;
		
		// create context menu
		ContextMenu contextMenu = new ContextMenu();
		
		// add attractor
		menuItem = new MenuItem("Add Attractor");
		menuItem.setOnAction(e -> addAttractor());
		contextMenu.getItems().add( menuItem);
		
		// add repeller
		menuItem = new MenuItem("Add Repeller");
		menuItem.setOnAction(e -> addRepeller());
		contextMenu.getItems().add( menuItem);
		
		// context menu listener
		node.setOnMousePressed(event -> {
		    if (event.isSecondaryButtonDown()) {
		        contextMenu.show(node, event.getScreenX(), event.getScreenY());
		    }
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Helper class for frame rate calculation
	 */
	private static class FpsCounter {

		final long[] frameTimes = new long[100];
		int frameTimeIndex = 0;
		boolean arrayFilled = false;
		double frameRate;

		double decimalsFactor = 1000; // we want 3 decimals
		
		public void update(long now) {

			long oldFrameTime = frameTimes[frameTimeIndex];
			frameTimes[frameTimeIndex] = now;
			frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length;

			if (frameTimeIndex == 0) {
				arrayFilled = true;
			}

			if (arrayFilled) {

				long elapsedNanos = now - oldFrameTime;
				long elapsedNanosPerFrame = elapsedNanos / frameTimes.length;
				frameRate = 1_000_000_000.0 / elapsedNanosPerFrame;

			}
		}

		public double getFrameRate() {
			// return frameRate;
			return ((int) (frameRate * decimalsFactor)) / decimalsFactor; // reduce to n decimals
		}
	}

}
