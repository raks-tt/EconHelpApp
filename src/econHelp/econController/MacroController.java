package econHelp.econController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import econHelp.Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
/**
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class MacroController  {
	@FXML
	protected Button btnMicroEconomics;
	@FXML
	protected Button btnMacroEconomics;
	@FXML
	protected Button btnHome;
	@FXML
	protected Button btnMicro;
	@FXML
	protected Button btnMacro;
	@FXML
	protected Button btnLogOut;

	@FXML
	private Button btnGo;
	

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
		
/*
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			engine = webView.getEngine();
		}*/
		
}
