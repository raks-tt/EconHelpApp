package econHelp.econController;

import java.io.IOException;

import econHelp.Main.Main;
import econHelp.econModel.econMicro.IncomeElasticityDemandModel;
import econHelp.econModel.econMicro.PriceElasticitySupplyModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 * @author EconTeam(UMASS BOSTON)
 *This class defines the Controller class for PriceElasticitySupply.fxml.
 *The Menu bar codes are exactly similar to all menu bar codes in all controller files.(See descriptions in IndexController.java
 */
public class PriceElasticitySupplyController {
	/**
	 * Text that displays value of Es on the scene.
	 */
	Text messageEs = new Text(650, 150, "");
	/**
	 * Text that displays value of |Es| on the scene.
	 */
	Text messageEsModulus = new Text(647, 200,"");
	//Initializing all the button and Text fields Ids from PriceElasticitySupply.fxml.
	@FXML
	protected Button btnHome;
	@FXML
	protected Button btnMicro;
	@FXML
	protected Button btnMacro;
	@FXML
	protected Button btnLogOut;
	@FXML
	protected Button btnCal;
	@FXML
	protected TextField txtFieldQOne;
	@FXML
	protected TextField txtFieldPOne;
	@FXML
	protected TextField txtFieldQTwo;
	@FXML
	protected TextField txtFieldPTwo;


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
	 * This function is called when the user clicks the Calculate button.
	 * @throws IOException
	 */
	@FXML
	public void clickButtonCalculate() throws IOException {
		try {
			/**
			 *  This function statically calls the functions in the SlopeModel.
			 */
			PriceElasticitySupplyModel.getPriceElasticitySupply(txtFieldQOne, txtFieldQTwo, txtFieldPOne, txtFieldPTwo,
					messageEs, messageEsModulus
					);
			System.out.println("Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is called when the Refresh button is pressed in the
	 * SlopeView.FXML
	 *  @throws IOException
	 */
	@FXML
	public void clickButtonRefresh() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/PriceElasticitySupplyView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
