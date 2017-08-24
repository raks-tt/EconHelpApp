/**
 * 
 */
package econHelp.econController;

import java.io.IOException;

import econHelp.Main.Main;
import econHelp.econModel.LoginModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * @author EconTeam(UMASS BOSTON)
 *
 */
public class LoginController {

	@FXML
	protected Button btnLogin;

	@FXML
	protected TextField txtAreaID;

	@FXML
	public void clickButtonLogin() throws IOException {
		try {
			boolean flag = LoginModel.validateID(txtAreaID);
			if (flag) {
				Main.getInstance().changeStage("/econHelp/econView/Index.fxml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
