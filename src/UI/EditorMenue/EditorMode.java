package UI.EditorMenue;

import Simulation.Simulation;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditorMode {
	
	public EditorMode(Scene mainScene,Stage primaryStage) {
		EditorMenue menue = new EditorMenue(mainScene,primaryStage);
		mainScene.setRoot(menue);
		
		Simulation simulation = new Simulation();
		simulation.initialize();
		
		UI.Util.editorMode = true;
	}
	
}