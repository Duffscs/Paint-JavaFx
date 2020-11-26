package Controller;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import View.Menu;
import View.PaintPane;

public class EventCliqueRelache implements EventHandler<MouseEvent> {
    private PaintPane canvas;
    private GraphicsContext gc;
    private Menu menu;

    private double x;
    private double y;
    private double width;
    private double height;

    public EventCliqueRelache(PaintPane canvas, Menu menu) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.menu = menu;
    }

    @Override
    public void handle(MouseEvent event) {

        Dessin dessin = new Dessin(canvas, menu.couleurRemplissage());
        switch (menu.outil()){
            case "dessiner":
                dessin.dessiner();
                break;
            case "ellipse":
                dessin.elipse(event);
                break;
            case "cercle":
                dessin.cercle(event);
                break;
            case "effacer":
                gc.setStroke(Color.WHITE);
                dessin.dessiner();
                break;
            case "rectangle":
                dessin.rectangle(event);
                break;
            case "ligne":
                dessin.ligne(event);
                break;
            default:
                System.out.println("default");
        }
        canvas.undoClear();
        canvas.redoClear();
        EventCliquePresse.img = canvas.actualImg();
    }
}

