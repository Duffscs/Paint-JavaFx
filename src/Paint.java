import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import View.RootPane;

public class Paint extends Application {

    @Override
    public void start(Stage primaryStage) {

        RootPane root = new RootPane(primaryStage);
        primaryStage.setTitle("Paint");
        primaryStage.getIcons().add(new Image("file:./icon/icon.png"));
        primaryStage.setScene(new Scene(root, 1920, 1080));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}