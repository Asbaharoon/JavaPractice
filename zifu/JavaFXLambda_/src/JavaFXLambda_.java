import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JavaFXLambda_ extends Application implements EventHandler<ActionEvent>{
	

	Button button;

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == button){
			System.out.println("button");
		}

	}

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("This is the Title");
	
		button = new Button();
		button.setText("Click Me");
		
		button.setOnAction(this);
	
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
	
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	     
}

