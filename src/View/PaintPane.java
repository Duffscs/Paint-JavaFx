package View;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;
import java.util.List;

public class PaintPane extends Canvas {

    private final List<WritableImage> undo;
    private final List<WritableImage> redo;
    private WritableImage actualImg;

    public PaintPane(double width, double height) {
        super(width, height);
        this.undo = new ArrayList<>();
        this.redo = new ArrayList<>();
        undoSave();
        load(lastElement(undo));
        undo.remove(0);
    }

    public void clear(){
        this.getGraphicsContext2D().clearRect(0,0,getWidth(),getHeight());
    }

    public void undoSave(){
        undo.add(actualImg());
    }

    public void redoSave(){
        redo.add(actualImg());
    }

    public void redoClear(){
        redo.clear();
    }

    public void undoClear(){
        if(undo.size() > 100){
            undo.remove(0);
        }
    }

    public void undo(){
        if(!undo.isEmpty()){
            redoSave();
            load(lastElement(undo));
            undo.remove(lastElement(undo));
        }
    }

    public void redo(){
        if(!redo.isEmpty()){
            undoSave();
            load(lastElement(redo));
            redo.remove(lastElement(redo));
        }
    }

    public WritableImage actualImg(){
        actualImg = new WritableImage((int) getWidth(),(int) getHeight());
        actualImg = this.snapshot(null,actualImg);
        return actualImg;
    }

    public void load(WritableImage img){
        clear();
        this.actualImg =img;
        this.getGraphicsContext2D().drawImage(img,0,0);
    }

    public WritableImage lastElement(List<WritableImage> list){
        WritableImage ret = new WritableImage((int) getWidth(),(int) getHeight());
        if(!list.isEmpty())
            ret = list.get(list.size()-1);
        return ret;
    }


}
