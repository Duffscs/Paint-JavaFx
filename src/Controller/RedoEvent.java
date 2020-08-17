package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import View.PaintPane;

public class RedoEvent implements EventHandler<ActionEvent> {

    private PaintPane canvas;

    public RedoEvent(PaintPane canvas) {
        this.canvas = canvas;
    }

    @Override
    public void handle(ActionEvent event) {
        canvas.redo();
    }
}
