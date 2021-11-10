/**
* @author Y. Daniel Liang
	Edited by Dallen Corry
* @version 1.2
* @since 10/Nov/2021
*/

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
	private int hour, minute, second;
	private boolean hourHandVisible, minuteHandVisible, secondHandVisible;
	
	public ClockPane() {
		setCurrentTime();
	}
	
	public ClockPane(int hour, int minute, int second) {
		//should add some if statements preventing invalid times.
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	
	//getters and setters
	public int getHour() {return hour;}
	public void setHour(int hour) {this.hour = hour;}
	
	public int getMinute() {return minute;}
	public void setMinute(int minute) {this.minute = minute;}
	
	public int getSecond() {return second;}
	public void setSecond(int second) {this.second = second;}
	
	public boolean isHourHandVisible() {return hourHandVisible;}
	public void setHourHandVisible(boolean bool) {hourHandVisible=bool;}
	
	public boolean isMinuteHandVisible() {return minuteHandVisible;}
	public void setMinuteHandVisible(boolean bool) {minuteHandVisible=bool;}
	
	public boolean isSecondHandVisible() {return secondHandVisible;}
	public void setSecondHandVisible(boolean bool) {secondHandVisible=bool;}


	public void setCurrentTime() {
		Calendar cal = new GregorianCalendar();
		
		this.hour = cal.get(Calendar.HOUR_OF_DAY);
		this.minute = cal.get(Calendar.MINUTE);
		this.second = cal.get(Calendar.SECOND);
		
		paintClock();
	}
	
	private void paintClock() {
		double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
		double centerX = getWidth()/2;
		double centerY = getHeight()/2;
		
		//draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
		
		//draw Second Hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);
		
		//draw Minute Hand
		double mLength = clockRadius * 0.65;
		double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, minuteX, minuteY);
		mLine.setStroke(Color.BLUE);
		
		//draw Hour Hand
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour%12+minute/60) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour%12+minute/60) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		
		//clear and paint all objects
		getChildren().clear();
		getChildren().addAll(circle,t1,t2,t3,t4);
		if(secondHandVisible)
			getChildren().add(sLine);
		if(minuteHandVisible)
			getChildren().add(mLine);
		if(hourHandVisible)
			getChildren().add(hLine);
		
	}
	
	@Override
	public void setWidth(double width){
		super.setWidth(width);
		paintClock();
	}
	
	@Override
	public void setHeight(double height){
		super.setHeight(height);
		paintClock();
	}
}
