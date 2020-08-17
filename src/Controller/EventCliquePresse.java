package Controller;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import View.Menu;
import View.PaintPane;

public class EventCliquePresse implements EventHandler<MouseEvent> {

    private PaintPane canvas;
    private GraphicsContext gc;
    private Menu menu;
    public static WritableImage img;

    public EventCliquePresse(PaintPane canvas, Menu menu) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.menu = menu;
        new Forme();
    }

    @Override
    public void handle(MouseEvent event) {

        canvas.undoSave();
        img = canvas.actualImg();
        gc.setLineWidth(menu.getSize());
        gc.setStroke(menu.couleurBordure());
        gc.setFill(menu.couleurRemplissage());

        switch (menu.outil()){
            case "dessiner":
                dessiner(event);
                break;
            case "effacer":
                gc.setStroke(Color.WHITE);
                dessiner(event);
                break;
            default:
                setPos(event);
        }
    }

    private void setPos(MouseEvent event) {
        Forme.setPosX(event.getX());
        Forme.setPosY(event.getY());
    }

    private void dessiner(MouseEvent event) {
        gc.beginPath();
        gc.lineTo(event.getX(), event.getY());
        gc.stroke();
    }

}
