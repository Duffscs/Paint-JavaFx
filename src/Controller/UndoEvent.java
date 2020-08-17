package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import View.PaintPane;

public class UndoEvent implements EventHandler<ActionEvent> {

    private PaintPane canvas;

    public UndoEvent(PaintPane canvas) {
        this.canvas = canvas;
    }

    @Override
    public void handle(ActionEvent event) {
        canvas.undo();
    }
}
