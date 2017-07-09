
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxFour_ extends Application {
	Stage window;
	TreeView<String> tree;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("TreeView");

		TreeItem<String> root, Folder, Folder2;

		root = new TreeItem<>();
		root.setExpanded(true);

		Folder = makeBranch("Folder", root);
		makeBranch("File", Folder);
		makeBranch("File2", Folder);
		makeBranch("File3", Folder);

		Folder2 = makeBranch("Folder", root);
		makeBranch("File4", Folder2);
		makeBranch("File5", Folder2);
		makeBranch("File6", Folder2);

		tree = new TreeView<>(root);
		tree.setShowRoot(false);
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				System.out.println(newValue.getValue());
			}
		});

		StackPane layout = new StackPane();
		layout.getChildren().add(tree);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	public TreeItem<String> makeBranch(String Title, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<>(Title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}

}
