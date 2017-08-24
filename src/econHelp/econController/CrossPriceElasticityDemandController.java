package econHelp.econController;

import java.io.IOException;

import econHelp.Main.Main;
import econHelp.econModel.econMicro.CrossPriceElasticityDemandModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CrossPriceElasticityDemandController {

	/**
	 * Text that displays value of Es on the scene.
	 */
	Text messageExy = new Text(650, 150, "");
	/**
	 * Text that displays value of |Es| on the scene.
	 */
	Text messageExyModulus = new Text(647, 200, "");

	// new FXML elements
	@FXML
	protected Pane top_pane;
	@FXML
	protected Label numerator1;
	@FXML
	protected Label numerator2;
	@FXML
	protected Label Cross_price_elasticity_label;
	@FXML
	protected Label Exy;
	@FXML
	protected Label denomenator1;
	@FXML
	protected Label denomenator2;
	@FXML
	protected Label qx1_label;
	@FXML
	protected Label qx2_label;
	@FXML
	protected TextField txtFieldPOne;
	@FXML
	protected TextField txtFieldPTwo;
	@FXML
	protected Label py1_label;
	@FXML
	protected Label py2_label;
	@FXML
	protected TextField txtFieldQOne;
	@FXML
	protected TextField txtFieldQTwo;
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


	@FXML
	public void clickButtonCalculate() throws IOException {
		try {
			CrossPriceElasticityDemandModel.getCrossPriceElasticityDemand(txtFieldQOne, txtFieldQTwo, txtFieldPOne,
					txtFieldPTwo, messageExy, messageExyModulus);
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
			Main.getInstance().changeStage("/econHelp/econView/CrossPriceElasticityDemandView.fxml");
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
