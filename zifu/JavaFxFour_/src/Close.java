
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Close extends Application {
	Stage window;
	Button button1;

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Title");
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});

		button1 = new Button("Close new window");
		button1.setOnAction(e -> closeProgram());

		StackPane layout1 = new StackPane();
		layout1.getChildren().add(button1);
		Scene scene1 = new Scene(layout1, 300, 250);

		window.setScene(scene1);
		window.show();
	}

	private void closeProgram() {
		boolean answer = ComfirmBox.display("Alert!", "Are you sure you want to close this window?");
		if (answer)
			window.close();

	}

	public static void display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		Label label1 = new Label();
		label1.setText(message);
		Button closeButton = new Button("Close this window");
		closeButton.setOnAction(e -> window.close());
		VBox layout1 = new VBox(10);
		layout1.getChildren().addAll(label1, closeButton);
		layout1.setAlignment(Pos.CENTER);

		// GIT comparison testing
		Scene scene = new Scene(layout1);
		window.setScene(scene);
		window.showAndWait();
	}
}
