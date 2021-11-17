import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
* This class creates a circle in a box that can be moved with buttons
* @author Dallen Corry
* @version 1.2
* @since 2021, 11, 17
*/
public class Ex15_Listeners extends Application{
	
	@Override
	public void start(Stage primaryStage){
		//create the panes
		Pane center = new Pane();
		HBox bottom = new HBox(5);
		BorderPane pane = new BorderPane();
		center.setStyle("-fx-background-color: aqua;");
		bottom.setStyle("-fx-background-color: black;");
		
		//create the buttons
		Button b1 = new Button("  Up  ");
		Button b2 = new Button(" Down ");
		Button b3 = new Button(" Left ");
		Button b4 = new Button(" Right ");
		
		//create the circle
		Circle c = new Circle(200,200,20);
		c.setStroke(Color.BLACK);
		c.setFill(Color.RED);
		//create and bind the face :)
		Circle c2 = new Circle(195,200,4);
		c2.setFill(Color.BLACK);
		c2.centerXProperty().bind(c.centerXProperty().subtract(8));
		c2.centerYProperty().bind(c.centerYProperty().subtract(5));

		Circle c3 = new Circle(195,200,4);
		c3.setFill(Color.BLACK);
		c3.centerXProperty().bind(c.centerXProperty().add(8));
		c3.centerYProperty().bind(c.centerYProperty().subtract(5));

		Arc arc = new Arc(200,200,10,10,225,90);
		arc.centerXProperty().bind(c.centerXProperty());
		arc.centerYProperty().bind(c.centerYProperty());
		
		//create handlers for the buttons
		b1.setOnAction(e ->{
			if(c.getCenterY()>(0+c.getRadius()))
				c.setCenterY(c.getCenterY()-10);
			else {
				c.setCenterY(0+c.getRadius());
			}
		} );
		b2.setOnAction(e ->{
			if(c.getCenterY()<(center.getHeight()-c.getRadius()))
				c.setCenterY(c.getCenterY()+10);
			else{
				c.setCenterY(center.getHeight()-c.getRadius());
			}
		});
		b3.setOnAction(e ->{
			if(c.getCenterX()>(0+c.getRadius()))
				c.setCenterX(c.getCenterX()-10);
			else {
				c.setCenterX(0+c.getRadius());
			}
		});
		b4.setOnAction(e ->{
			if(c.getCenterX()<(center.getWidth()-c.getRadius()))
				c.setCenterX(c.getCenterX()+10);
			else{
				c.setCenterX(center.getWidth()-c.getRadius());
			}
		} );
		
		//add all elements to the BorderPane
		center.getChildren().addAll(c,c2,c3,arc);
		bottom.getChildren().addAll(b1,b2,b3,b4);
		bottom.setAlignment(Pos.CENTER);
		pane.setCenter(center);
		pane.setBottom(bottom);
		
		//add BorderPane to Scene
		Scene scene = new Scene(pane,400,400);
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//focus the circle to receive updates
		c.requestFocus();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

