package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import View.PaintPane;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgChooser implements EventHandler<ActionEvent> {


    private PaintPane canvas;
    private Stage primaryStage;

    public ImgChooser(Stage primaryStage, PaintPane paintPane) {
        this.canvas = paintPane;
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(primaryStage);
        if(file != null){
            final Pattern  pattern = Pattern.compile("([^*]+(\\.(?i)(jpg|png|gif|bmp))$)");
            final Matcher match = pattern.matcher(file.getAbsolutePath());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Erreur dans le type de fichier");
            alert.setHeaderText(null);
            if(match.matches()) {
                canvas.undoSave();
                Image img = new Image("file:"+file.getAbsolutePath());
                if(img.getWidth() > canvas.getWidth())
                    canvas.setWidth(img.getWidth());
                if(img.getHeight() > canvas.getHeight())
                    canvas.setHeight(img.getHeight());
                canvas.getGraphicsContext2D().drawImage(img,0,0);
            }
            else
                alert.showAndWait();
        }
    }
}
