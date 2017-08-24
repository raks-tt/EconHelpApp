package econHelp.econController;

import java.io.IOException;
import econHelp.Main.Main;
import econHelp.econModel.econMicro.MicroContentsModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class MicroContentsController {
	@FXML
	protected Button btnSlope;
	@FXML
	protected Button btnPriceElasticityDemand;
	@FXML
	protected Button btnCrossPriceElasticityDemand;
	@FXML
	protected Button btnIncomeElasticityDemand;
	@FXML
	protected Button btnPriceElasticityOfSupply;

	@FXML
	protected Button btnHome;
	@FXML
	protected Button btnMicro;
	@FXML
	protected Button btnMacro;
	@FXML
	protected Button btnLogOut;

	// Menu bar
	// codes:__________________________________________________________________________________
	@FXML
	public void clickButtonHome() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/Index.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonMicro() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/MicroContentsView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonMacro() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/MacroContentsView.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonLogOut() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/Login.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// End of Menu bar
	// codes__________________________________________________________________________

	@FXML
	// This function is called when the user clicks the option slope from the
	// list of options.
	public void clickButtonSlope() throws IOException {
		try {
			// Here the changeStageToSlope method is called that calls the
			// SlopeView.fxml file and also initializes the slope graph
			// with coordinates (0, 0) and (0,0). These are the default
			// coordinate values.
			Main.getInstance().changeStageToSlope("/econHelp/econView/SlopeView.fxml", 0, 0, 0, 0);

		} // Exception if the FXML file is not found on the path.
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonPriceElasticityDemand() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/PriceElasticityDemandView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonPriceElasticitySupply() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/PriceElasticitySupplyView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonCrossPriceElasticityDemand() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/CrossPriceElasticityDemandView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void clickButtonIncomePriceElasticityDemand() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/IncomeElasticityDemandView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void displayMessage() throws IOException {
		try{
//			btnSlope.getOnMouseEntered().wait(1000);
			MicroContentsModel.clicktoDiplayMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
