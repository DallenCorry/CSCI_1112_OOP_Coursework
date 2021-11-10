/**
* @author Y. Daniel Liang
	Edited by Dallen Corry
* @version 1.2
* @since 10/Nov/2021
*/
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.util.*;

public class DisplayClock extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		Random r = new Random();
		int x=0;
		if(r.nextInt(2)>0)
			x = 30;
		else
			x=0;
			
		// Create a clock and a label
		ClockPane clock = new ClockPane(r.nextInt(12),x,0);
		//random time
//		ClockPane clock = new ClockPane(r.nextInt(12),r.nextInt(60),r.nextInt(60));
		
		clock.setHourHandVisible(true);
		clock.setMinuteHandVisible(true);
		clock.setSecondHandVisible(false);

		String timeString = clock.getHour() + ":" + clock.getMinute()+ ":" + clock.getSecond();
		Label lblCurrentTime = new Label(timeString);

		// Place clock and label in border pane
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("DisplayClock"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
