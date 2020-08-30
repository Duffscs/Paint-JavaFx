package Controller;

import View.PaintPane;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ImgExporter implements EventHandler<ActionEvent> {

    private final PaintPane canvas;
    private final Stage primaryStage;

    public ImgExporter(Stage primaryStage,PaintPane canvas) {
        this.primaryStage = primaryStage;
        this.canvas = canvas;
    }

    @Override
    public void handle(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String str = System.getProperty("user.home");
        fc.setInitialDirectory(new File(str+"/Images"));
        fc.setTitle("Save");
        File file = fc.showSaveDialog(primaryStage);
        if(file != null){
            WritableImage wi = new WritableImage((int)canvas.getWidth(),(int)canvas.getHeight());
            try {
                canvas.snapshot(null, wi);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(wi, null);
                ImageIO.write(renderedImage, "jpg", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
