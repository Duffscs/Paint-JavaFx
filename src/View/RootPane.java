package View;

import Controller.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootPane extends BorderPane {

    private Menu menu;
    private PaintPane canvas;

    public RootPane(Stage primaryStage) {
        menu = new Menu();
        canvas = new PaintPane(1918,920);
        ScrollPane s1 = new ScrollPane();
        s1.setContent(canvas);
        this.setTop(menu);
        this.setCenter(s1);
        canvas.setOnMousePressed(new EventCliquePresse(canvas,menu));
        canvas.setOnMouseDragged(new EventSourisDragged(canvas,menu));
        canvas.setOnMouseReleased(new EventCliqueRelache(canvas,menu));
        menu.redo().setOnAction(new RedoEvent(canvas));
        menu.undo().setOnAction(new UndoEvent(canvas));
        menu.btnImport().setOnAction(new ImgChooser(primaryStage,canvas));
        menu.btnExport().setOnAction(new ImgExporter(primaryStage,canvas));
        s1.setStyle("-fx-focus-color: transparent;");
        this.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(!(event.getCode() == KeyCode.CONTROL))
                return;
        });

    }

    public PaintPane canvas() {
        return this.canvas;
    }
}
