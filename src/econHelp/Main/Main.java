package econHelp.Main;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import econHelp.econController.MacroController;
import econHelp.econModel.econMicro.SlopeGraph;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * 
 */

/**
 * @author Raksha
 *
 */
public class Main extends Application {


	protected static Pane root;
	protected Pane root2;
    protected Scene scene;
    protected Stage primaryStage;
    public static Main instance;
    WebView browser = new WebView();
	WebEngine webEngine = browser.getEngine();
    public Main(){
        instance = this;
    }
    public static Main getInstance(){
        return instance;
    }
    
	@Override
	public void start(Stage primaryStge) {
		primaryStage = primaryStge;
		primaryStage.setResizable(false);
        try {
			changeStage("/econHelp/econView/Login.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// To change the screen.
	public void changeStage(String fxmlAddress) throws IOException{
		browser.getEngine().load(null);
		root = FXMLLoader.load(getClass().getResource(fxmlAddress));
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("EconHelp");
		primaryStage.show();
	}
	
	public static Pane getRoot() {
		return root;
	}
	// To change the screen to slope page. Includes the function to call slope graph. 'gr' is a Pane that will be added 
	// to slope FXML file. 
	public void changeStageToSlope(String fxmlAddress, double x1, double y1, double x2, double y2) throws IOException{
		browser.getEngine().load(null);
		root =FXMLLoader.load(getClass().getResource(fxmlAddress));
		SlopeGraph xy = new SlopeGraph(x1, y1, x2, y2);  //x1,y1,x2,y2 Creating new SlopeGraph with respective coordinates
	    Pane gr = xy.get_plot();	//returns the plot of type Pane which will be added to our main FXML.
		gr.relocate(450, 120);		    // Adjusting the location of Graph on the Main FXML Screen
		root.getChildren().add(gr);    // Adds the graph to the main FXML
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("EconHelp");
		primaryStage.show();
	}
	
	public void changeStateToMacro(String fxmlAddress) throws IOException {
		browser.setMaxSize(6000, 6000);
		browser.setPrefSize(939, 657);
		browser.relocate(0, 47);
		String url = "http://sffed-education.org/chairthefed/WebGamePlay.html";
		webEngine.load(url);
		root =FXMLLoader.load(getClass().getResource(fxmlAddress));
		root.getChildren().add(browser);
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("EconHelp");
		primaryStage.show();
	
		
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

}
