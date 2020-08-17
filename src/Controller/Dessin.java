package Controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Dessin {

    private double x;
    private double y;
    private double width;
    private double height;
    private final GraphicsContext gc;

    public Dessin(GraphicsContext gc){
        this.gc = gc;
    }

    public void elipse(MouseEvent event) {
        determinePosition(event);
        gc.strokeOval(x,y, width, height);
        gc.fillOval(x,y,width,height);
    }

    public void cercle(MouseEvent event) {
        x = Forme.posX();
        y = Forme.posY();
        width = Math.abs(x - event.getX());
        height = Math.abs(y - event.getY());
        double rayon = Math.max(width,height)/2;
        gc.strokeOval(x-rayon,y-rayon, Math.max(width,height), Math.max(width,height));
        gc.fillOval(x-rayon,y-rayon, Math.max(width,height), Math.max(width,height));
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
