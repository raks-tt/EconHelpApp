package econHelp.econController;

import java.io.IOException;

import econHelp.Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class MacroContententsController {
	@FXML
	protected Button btnHome;
	@FXML
	protected Button btnMicro;
	@FXML
	protected Button btnMacro;
	@FXML
	protected Button btnLogOut;
	@FXML
	protected Button btnFederalReserve;
	

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
			public void clickButtonFederalReserve() throws IOException {
				try {
					Main.getInstance().changeStateToMacro("/econHelp/econView/MacroView.fxml");
				} catch (Exception e){
					e.printStackTrace();
				}
			}
}
