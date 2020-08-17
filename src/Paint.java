import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import View.RootPane;

public class Paint extends Application {

    @Override
    public void start(Stage primaryStage) {

        RootPane root = new RootPane(primaryStage);
        primaryStage.setTitle("Paint");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}