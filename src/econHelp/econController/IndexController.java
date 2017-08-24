package econHelp.econController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import econHelp.Main.Main;
import econHelp.econModel.econMacro.MacroModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
/**
 * @author EconTeam (UMASS BOSTON) 
 * This class defines the Controller class for Index.fxml.
 * The Menu bar button functions are created which get called when the respective buttons are pressed.
 * Foe example, the function clickButtonMicroOptions() is called by button btnMicroEconomics. The 
 * functions are linked to their respective button via scene builder.
 * When clickButtonMicroOptions() function is called, the changeStage("/econHelp/econView/MicroContentsView.fxml") , of Main class is called,
 * This function changes the scene to new FXML file, which is going to be MicroContentsView.fxml in this case.
 */
public class IndexController {

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
	public void clickButtonMicroOptions() throws IOException {
		try {
			Main.getInstance().changeStage("/econHelp/econView/MicroContentsView.fxml");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void clickButtonMacroOptions() throws IOException {
		try {
	
			Main.getInstance().changeStage("/econHelp/econView/MacroContentsView.fxml");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
	
}
