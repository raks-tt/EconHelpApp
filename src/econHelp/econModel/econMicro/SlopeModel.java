package econHelp.econModel.econMicro;

import java.text.DecimalFormat;

import econHelp.Main.Main;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
/**
 * @author EconTeam(UMASS BOSTON)
 * This Model class is called by the SlopeController when calculate button is pressed.
 * This class has a static method get_plot()which is the major method of this class.
 * It takes in the 4 input text fields, a Text and a SlopeGraph with(0,0,0,0) as its parameters.
 */
public class SlopeModel {
	/*DecimalFormat df define the format to print double values. For example calling df.format(10.78666) on this Decimal format
	*Will return a string 10.79.*/
	static DecimalFormat df = new DecimalFormat("###.##");
	/**Text description is the text that displays the description of the slope, according to the input values.*/
	static Text description = new Text(120, 500,"");
	/**Text interpretation is the text that displays intepretation of the slope. */
	static Text interpretation = new Text(120, 540,"");
 /**
  * 
  * @param txtFieldXOne
  * @param txtFieldYOne
  * @param txtFieldXTwo
  * @param txtFieldYTwo
  * @param message
  * @param xy
  * @author EconTeam(UMASS BOSTON)
  * @return void
  * This method is responsible for checking if the input values are Numbers. If not, user is notified that the input format is wrong.
  * Else it calculates the slope, adds description and interperation along with the slope graph to the scene, and displays it.
  */
	public static void getSlope(TextField txtFieldXOne, TextField txtFieldYOne, TextField txtFieldXTwo, TextField txtFieldYTwo, Text message, SlopeGraph xy){
		Pane gr = xy.get_plot();
		try {
			
			Pane root = Main.getRoot();
			/**
			 * Checking if all the input values are Numbers or Not
			 */
			if (isNumber(txtFieldXOne) && isNumber(txtFieldXTwo) && isNumber(txtFieldYOne) && isNumber(txtFieldYTwo)) {
				double x1 = Double.parseDouble(txtFieldXOne.getText());
				double x2 = Double.parseDouble(txtFieldXTwo.getText());
				double y1 = Double.parseDouble(txtFieldYOne.getText());
				double y2 = Double.parseDouble(txtFieldYTwo.getText());												
				
				double slope = (y2 - y1)/(x2 - x1);
				/**
				 * A String that changes between " an increase " OR " a decrease " depending on the the value of slope.
				 * This string is later added to the interpretation Text.
				 */
				String DecOrInc = " an increase ";
				if (slope < 0) {
					DecOrInc = " a decrease ";
				}
				/**
				 * The SloopeGraph passed b the SlopController has values (0, 0, 0, 0).
				 * The following call, changes it to the respective x1, x2 ,y1, y2 values. The values are already verified as valid numbers
				 * at this point.
				 */
				xy.ChangeValues(x1, y1, x2, y2);
				/**
				 * Returns the plot of type StackPane to variable gr which will be added to our main FXML.
				 */
				gr = xy.get_plot();	
				/**
				 * Adjusting the location of Graph on the Main FXML Screen				
				 */
				gr.relocate(450, 120);		    					
				root.getChildren().add(gr);
				message = format(message, "	  Slope = " + df.format(slope), Color.LIGHTCORAL);
				/**
				 * Rules to displaying text according to the value of slope.
				 */
				if (slope > 0){
					description = format(description, "Slope > 0 (Direct relationship between X and Y)", Color.NAVAJOWHITE  );
					interpretation = format(interpretation," The Slope of "+ df.format(slope) +" means that an increase in \n"
														 + "  X by 1 generated " + DecOrInc + "in Y by "+df.format(slope)+"."
														 ,Color.DARKSEAGREEN);
				}
				if (slope < 0){
					description = format(description, "Slope < 0 (Inverse relationship between X and Y)", Color.NAVAJOWHITE  );
					interpretation = format(interpretation," The Slope of "+ df.format(slope) +" means that an increase in \n"
							 + "  X by 1 generated " + DecOrInc + "in Y by " + df.format(Math.abs(slope))+"."
							 ,Color.DARKSEAGREEN);
				}
				if (slope == 0){
					root.getChildren().remove(description);
					interpretation = format(interpretation," The slope of 0 means that change in X \n"
														 + "	 doesnt change the value of Y."
														 ,Color.DARKSEAGREEN);
				}
				if (slope == Double.POSITIVE_INFINITY || slope == Double.NEGATIVE_INFINITY ){
					root.getChildren().remove(description);
					interpretation = format(interpretation," The slope of infinity means that change in Y \n"
							 							  + "	     doesnt change the value of X."
							 							  	,Color.DARKSEAGREEN);
				}
				if (Double.isNaN(slope)){
					root.getChildren().remove(description);
					interpretation = format(interpretation,"		 Slope doesnt exist.",Color.DARKSEAGREEN);
				}
				
			}
			/*
			 * If the values are not numbers. Remove the old gr, change value of SlopeGrpah to (0, 0, 0, 0) and re add it to the screen 
			 * along with a message :  "Please Enter a valid Number", displayed in red color.
			 */
			else {
	
				root.getChildren().remove(gr);
				root.getChildren().remove(description);
				root.getChildren().remove(interpretation);
				xy.ChangeValues(0, 0, 0, 0);
				gr = xy.get_plot();
				gr.relocate(450, 120);
				message = format(message, "Please Enter a valid Number", Color.RED);
				root.getChildren().addAll(gr);
			
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @param TextFiled
	 * Checks if the input value in Text Field is a Number or not.
	 * @return True if it is a number.
	 */
	public static boolean isNumber (TextField input) {
		try {
			Double value = Double.parseDouble(input.getText());
			System.out.println("Actual value =" + input.getText());
			System.out.println("double value = "+value);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	/**
	 * 
	 * @param line
	 * @param s
	 * @param color
	 * @return Text
	 * This method is used to format a Text with the String to be displayed(s), color of the Text(color) and default size that is 
	 * 1.5 time the original size of the Font.
	 * It also removes the old version of itself and adds the new formatted text to avoid duplicate child added error.
	 * For Example: 
	 * Text apple = new apple("10","10","");
	 * apple = format(apple, "I am a fruit", Color.PINK);
	 * This code creates a Text apple at (10, 10) with no String to display.
	 * Then format method adds the String "I am a fruit", changes the color of the text to be displayed to pink and scales the 
	 * size form 1 to 1.5 
	 */
	public static Text format(Text line , String s, Color color){
		Main.getRoot().getChildren().remove(line);
		line.setText(s);
		line.setFill(color);
		line.setScaleX(1.5);
		line.setScaleY(1.5);
		Main.getRoot().getChildren().add(line);
		return line;
	}
	
}
