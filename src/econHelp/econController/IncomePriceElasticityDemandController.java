package econHelp.econController;

import java.io.IOException;

import econHelp.Main.Main;
import econHelp.econModel.econMicro.IncomeElasticityDemandModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class IncomePriceElasticityDemandController {

	/**
	 * Text that displays value of Es on the scene.
	 */
	Text messageEi = new Text(650, 150, "");
	/**
	 * Text that displays value of |Es| on the scene.
	 */
	Text messageEiModulus = new Text(647, 200, "");
	// new FXML elements
	@FXML
	protected Pane top_pane;
	@FXML
	protected Label numerator1;
	@FXML
	protected Label numerator2;
	@FXML
	protected Label income_elasticity_demand_label;
	@FXML
	protected Label Ei;
	@FXML
	protected Label denomenator1;
	@FXML
	protected Label denomenator2;
	@FXML
	protected Label q1_label;
	@FXML
	protected Label q2_label;
	@FXML
	protected TextField txtFieldQOne;
	@FXML
	protected TextField txtFieldQTwo;
	@FXML
	protected Label I1_label;
	@FXML
	protected Label I2_label;
	@FXML
	protected TextField txtFieldPTwo;
	@FXML
	protected TextField txtFieldPOne;
	@FXML
	protected Button calculateElasticity;
	@FXML
	protected Button Refresh;
	@FXML
	protected Button Info;
	@FXML
	protected Button formulaDescription;
	@FXML
	protected Pane OutputInfo;
	@FXML
	protected Rectangle highlighter;
	@FXML
	protected Button home;
	@FXML
	protected Button micro;
	@FXML
	protected Button macro;
	@FXML
	protected Button logout;

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

	// End of menu bar codes
	// ---------------------------------------------------------------------------------
	@FXML
	public void clickButtonCalculate() throws IOException {
		try {
			IncomeElasticityDemandModel.getIncomePriceElasticityDemand(txtFieldQOne, txtFieldQTwo, txtFieldPOne,
					txtFieldPTwo, messageEi, messageEiModulus);
			System.out.println("Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is called when the Refresh button is pressed in the
	 * SlopeView.FXML
	 */
	@FXML
	public void clickButtonRefresh() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/IncomeElasticityDemandView.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is called when the Refresh button is pressed in the
	 * SlopeView.FXML
	 */
	@FXML
	public void clickButtonInfo() throws IOException {

	}

}
