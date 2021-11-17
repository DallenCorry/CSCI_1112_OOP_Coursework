import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
* @author Dallen Corry
* @version 1.0
* @since 2021, 11, 17
*/
public class Ex15_Animation extends Application {
	//variable for pauseing on click
	static boolean paused = false;
	
	@Override
	public void start(Stage s){
		//create elements
		Pane pane = new Pane();
		Polygon p = new Polygon();
		Rectangle r = new Rectangle(0,0,60,30);
		FadeTransition ft = new FadeTransition(Duration.millis(3000),r);
		PathTransition pt = new PathTransition(Duration.millis(5000),p,r);//Duration.millis(4000),p,r);
		
		//Set values of transitions
		ft.setFromValue(1.0);
		ft.setToValue(.01);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		
		//pause on Click
		r.setOnMouseClicked(
			new EventHandler<MouseEvent>(){
				//using an event handler rather than a lambda simplifies
				//the use of the paused variable, as it does not need a mutator method
				@Override
				public void handle(MouseEvent e){
					if(!paused){
						ft.pause();
						pt.pause();
						paused=true;
					}
					else {
						ft.play();
						pt.play();
						paused=false;
					}
				}
			}
		);
		//style the objects
		p.setStroke(Color.BLACK);
		p.setFill(Color.WHITE);
		p.setRotate(54);
		
		//add objects to the scene
		pane.getChildren().addAll(p,r);
		Scene scene = new Scene(pane,300,300);
		
		//Create the Pentagon
		//Code from ShowPollygon from exercise 14-15
		double radius = 100;
		for (int i = 0; i < 5; i++) {
			p.getPoints().add(pane.getWidth() / 2 + radius * Math.cos(2 * i * Math.PI/5)); 
			p.getPoints().add(pane.getHeight() / 2 - radius * Math.sin(2 * i * Math.PI/5));
		}
		//End Quoted code
		
		//add the scene to the Stage
		s.setTitle("Animation");
		s.setScene(scene);
		s.setX(300);
		s.setY(300);
		s.show();
		//finally, play animations
		ft.play();
		pt.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
