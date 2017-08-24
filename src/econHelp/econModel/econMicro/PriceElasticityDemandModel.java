package econHelp.econModel.econMicro;

import java.text.DecimalFormat;

import econHelp.Main.Main;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
/**
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class PriceElasticityDemandModel {
	static DecimalFormat df = new DecimalFormat("###.##");
	static Text description = new Text(600, 250,"");
	static Text interpretation = new Text(600, 350,"");

	public static void getPriceElasticityDemand(TextField Q1, TextField Q2, TextField P1, TextField P2, Text messageEp,
			Text messageEpModulus) {
	
		try {
			Pane root = Main.getRoot();

			if (isValid(Q1) && isValid(Q2) && isValid(P1) && isValid(P2)) {
				double q1 = Double.parseDouble(Q1.getText());
				double q2 = Double.parseDouble(Q2.getText());
				double p1 = Double.parseDouble(P1.getText());
				double p2 = Double.parseDouble(P2.getText());
				double Ep;
				double EpAbs;
				Ep = ((q2 - q1) /((q2 + q1)/2))/((p2 - p1)/((p1 + p2)/2));
				EpAbs = Math.abs(Ep);
				String DecOrInc = " decreases ";
				if (Ep >= 0) {
					DecOrInc =" increases ";
				}
				messageEp = format(messageEp, "Ep = " + df.format(Ep),Color.LIGHTCORAL );
				messageEpModulus = format(messageEpModulus, "|Ep| = " + df.format(EpAbs) ,Color.LIGHTCORAL );
				
				
				if (EpAbs < 1){
					description =  format(description, "|Ep| < 1	 Inelastic Demand",Color.TEAL );
					interpretation = format(interpretation,"INTERPRETATION : \n\n"
														+ "The price elasticity of "+df.format(EpAbs)+" means that a \n"
														+ "1% increase in price generated a " + df.format(EpAbs) +"% \n"
													    + DecOrInc + "in the quantity demanded.",Color. DARKSEAGREEN  );
				}
				if (EpAbs == 1){
					description =  format(description, "|Ep| = 1 	(Unit Elasticity of Demand)",Color.NAVAJOWHITE   );
					interpretation = format(interpretation,"INTERPRETATION : \n\n"
							+ "The price elasticity of "+df.format(EpAbs)+" means that a \n"
							+ "1% increase in price generated a " + df.format(EpAbs) +"% \n"
							 + DecOrInc + "in the quantity demanded.",Color. DARKSEAGREEN  );
				}
				if (EpAbs > 1){
					description =  format(description, "|Ep| > 1	 (Elastic Demand)",Color.NAVAJOWHITE   );
					interpretation = format(interpretation,"INTERPRETATION : \n\n"
							+ "The price elasticity of "+df.format(EpAbs)+" means that a \n"
							+ "1% increase in price generated a " + df.format(EpAbs) +"% \n"
							 + DecOrInc + "in the quantity demanded.",Color. DARKSEAGREEN  );
				}
				if (EpAbs == 0){
					description =  format(description, "|Ep| = 0	 (Perfectly Inelastic)", Color.NAVAJOWHITE   );
					interpretation = format(interpretation,"INTERPRETATION : \n\n"
							+ "The price elasticity of "+df.format(EpAbs)+" means that  \n"
						    + "quantity demanded does not change with change in price. ",Color. DARKSEAGREEN  );
				}
				if (EpAbs == Double.POSITIVE_INFINITY || EpAbs == Double.NEGATIVE_INFINITY){
					description =  format(description, "|Ep| = Infinity 	 (Perfectly Elastic)", Color.NAVAJOWHITE   );
					interpretation = format(interpretation,"INTERPRETATION : \n\n"
							+ "The price elasticity of "+df.format(EpAbs)+" means that  \n"
						    + "price does not change with change \n"
						    + "in quantity demanded.",Color. DARKSEAGREEN  );
				}
				if (Double.isNaN(EpAbs)){
					root.getChildren().remove(interpretation);
					description =  format(description, "Please try again with different \n		numbers", Color.RED);
					interpretation = format(interpretation, "Price and Quantity cannot have \n"
														  + "both Initial And final values = 0",Color. DARKSEAGREEN);
				}
			}
			else {
	
				System.out.println("Please enter valid Number");
				root.getChildren().remove(messageEpModulus);
				root.getChildren().remove(messageEp);
				root.getChildren().remove(interpretation);
				description = format(description , "Please enter valid Numbers", Color.RED);
				
			}
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks if the input value is a Number and +v3 or not.
	 * @return True if it is a number.
	 */
	public static boolean isValid (TextField input) {
		try {
			Double value = Double.parseDouble(input.getText());
			System.out.println("Actual value =" + input.getText());
			System.out.println("double value = "+value);
			if( value < 0){
				throw new NumberFormatException() ;
			}
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
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
