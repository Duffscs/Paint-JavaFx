package Controller;

import View.PaintPane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Dessin {

    private double x;
    private double y;
    private double width;
    private double height;
    private final GraphicsContext gc;

    public Dessin(PaintPane canvas, Color fill){
        this.gc = canvas.getGraphicsContext2D();
        canvas.clear();
        canvas.load(EventCliquePresse.img);
        gc.setFill(fill);
    }

    public void elipse(MouseEvent event) {
        determinePosition(event);
        gc.fillOval(x,y,width,height);
        gc.strokeOval(x,y, width, height);
    }

    public void cercle(MouseEvent event) {
        x = Forme.posX();
        y = Forme.posY();
        width = Math.abs(x - event.getX());
        height = Math.abs(y - event.getY());
        double rayon = Math.max(width,height);
        gc.fillOval(x-rayon,y-rayon, rayon*2, rayon*2);
        gc.strokeOval(x-rayon,y-rayon, rayon*2, rayon*2);
    }

    private void determinePosition(MouseEvent event) {
        x = Forme.posX();
        y = Forme.posY();
        width = event.getX() - x;
        height = event.getY()- y;
        if(width < 0){
            x = event.getX();
            width *= -1;
        }
        if(height < 0){
            y = event.getY();
            height *= -1;
        }
    }

    public void rectangle(MouseEvent event) {
        determinePosition(event);
        gc.strokeRect(x,y,width,height);
        gc.fillRect(x,y,width,height);
    }

    public void ligne(MouseEvent event) {

        x = Forme.posX();
        y = Forme.posY();
        gc.strokeLine(x, y, event.getX(), event.getY());

    }

    public void dessiner() {
        gc.stroke();
        gc.closePath();
    }

}
