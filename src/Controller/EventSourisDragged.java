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

        Dessin dessin = new Dessin(gc);

        switch (menu.outil()){
            case "dessiner":
                dessiner(event);
                break;
            case "effacer":
                gc.setStroke(Color.WHITE);
                dessiner(event);
                break;
            case "rectangle":
                init();
                dessin.rectangle(event);
                break;
            case "ellipse":
                init();
                dessin.elipse(event);
                break;
            case "cercle":
                init();
                dessin.cercle(event);
                break;
            case "ligne":
                init();
                dessin.ligne(event);
                break;
            default:;

        }
        gc.setFill(menu.couleurRemplissage());
    }

    private void init() {
        canvas.clear();
        canvas.load(EventCliquePresse.img);
        gc.setFill(Color.TRANSPARENT);
    }

    private void dessiner(MouseEvent event) {
        gc.lineTo(event.getX(),event.getY());
        gc.stroke();
    }

}
