package econHelp.econController;
import java.io.IOException;
import econHelp.Main.Main;
import econHelp.econModel.econMicro.SlopeGraph;
import econHelp.econModel.econMicro.SlopeModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

/**
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class SlopeController {
	/**
	*Text message is the Text that appears after the user enters the coordinate values.
	* Its either the value of Slope or the error message that appears if the user enters the wrong format.
	**/
	Text message = new Text(170, 470,"");
	/**
	 * A SlopeGraph that will be passed on to SlopeModel later.
	 */
	SlopeGraph xy = new SlopeGraph(0, 0, 0, 0); 	
	@FXML
	protected Button btnCalculate;
	@FXML
	protected Button btnRefresh;
	@FXML
	protected Button btnInfo;
	@FXML
	protected TextField txtFieldXOne;
	@FXML
	protected TextField txtFieldYOne;
	@FXML
	protected TextField txtFieldXTwo;
	@FXML
	protected TextField txtFieldYTwo;
	@FXML
	protected Button btnHome;
	@FXML
	protected Button btnMicro;
	@FXML
	protected Button btnMacro;
	@FXML
	protected Button btnLogOut;

	

	// Menu bar codes:__________________________________________________________________________________
	@FXML
	public void clickButtonHome() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/Index.fxml");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void clickButtonMicro() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/MicroContentsView.fxml");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonMacro() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/MacroContentsView.fxml");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void clickButtonLogOut() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/Login.fxml");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//End of Menu bar codes__________________________________________________________________________
			
		/**
		*This function is called when the Calculate button is pressed in the SlopeView.FXML 
		*@return void
		*/	
		@FXML
		public void clickButtonCalculate(ActionEvent event)  {
			/**
			 * @param txtFieldXOne
			 * @param txtFieldYOne
			 * @param txtFieldXTwo
			 * @param txtFieldYTwo
			 * @param message
			 * @param xy
			  This function calls the Slope Model function that adds and calculates slope in the Model package.
			  As parameters, it takes the 4 coordinates that is entered by the user along with the Text 'message'.
			 */
			SlopeModel.getSlope(txtFieldXOne, txtFieldYOne,txtFieldXTwo, txtFieldYTwo, message, xy); 
		}
		/**
		*This function is called when the Refresh button is pressed in the SlopeView.FXML 
		*@return void
		*/
		@FXML
		public void clickButtonRefresh() throws IOException{
			try {
				Main.getInstance().changeStageToSlope("/econHelp/econView/SlopeView.fxml", 0, 0, 0, 0);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		*This function is called when the Refresh button is pressed in the SlopeView.FXML 
		*@return void
		*/
		@FXML
		public void clickButtonInfo() throws IOException{
			
		}
		


}
