package Controller;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import View.Menu;
import View.PaintPane;

public class EventSourisDragged implements EventHandler<MouseEvent> {

    private PaintPane canvas;
    private GraphicsContext gc;
    private Menu menu;

    public EventSourisDragged(PaintPane canvas, Menu menu) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.menu = menu;
    }

    @Override
    public void handle(MouseEvent event) {

        Dessin dessin = new Dessin(canvas, menu.couleurRemplissage());
        gc.setFill(Color.TRANSPARENT);
        switch (menu.outil()){
            case "dessiner":
                dessiner(event);
                break;
            case "effacer":
                gc.setStroke(Color.WHITE);
                dessiner(event);
                break;
            case "rectangle":
                dessin.rectangle(event);
                break;
            case "ellipse":
                dessin.elipse(event);
                break;
            case "cercle":
                dessin.cercle(event);
                break;
            case "ligne":
                dessin.ligne(event);
                break;
            default:;

        }
    }

    private void dessiner(MouseEvent event) {
        gc.lineTo(event.getX(),event.getY());
        gc.stroke();
    }

}
