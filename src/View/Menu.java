package View;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Menu extends VBox {

    private final ToggleButton btnDessiner;
    private final ToggleButton btnLigne;
    private final ToggleButton btnRectangle;
    private final ToggleButton btnCercle;
    private final ToggleButton btnElipse;
    private final ToggleButton btnEffacer;
    private final Label lblColor;
    private final ColorPicker colorBordure;
    private final Label lblRemplissage;
    private final ColorPicker colorRemplissage;
    private final ToggleGroup tools;
    private final Button undo;
    private final Button redo;
    private final Slider slider;
    private final Label line_width;
    private final Button btnImport;

    public Menu() {
        btnDessiner = new ToggleButton("Dessiner");
        btnLigne = new ToggleButton("Ligne");
        btnRectangle = new ToggleButton("Rectangle");
        btnCercle = new ToggleButton("Cercle");
        btnElipse = new ToggleButton("Ellipse");
        btnEffacer = new ToggleButton("Effacer");
        colorBordure = new ColorPicker(Color.BLACK);
        colorRemplissage = new ColorPicker(Color.TRANSPARENT);
        btnDessiner.setSelected(true);
        tools = new ToggleGroup();
        ToggleButton[] toolsArr = {btnDessiner, btnLigne, btnRectangle, btnCercle, btnElipse, btnEffacer};
        undo = new Button("Undo");
        redo = new Button("Redo");
        slider = new Slider();
        line_width = Create.label("",Pos.BASELINE_LEFT);
        btnImport = new Button("Import");

        slider.valueProperty().addListener(e->{
            double width = slider.getValue();
            line_width.setText(String.format("Bordure : %.0f", width));
        });
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setValue(3.0);

        int largeur = 120;
        for (ToggleButton tool : toolsArr) {
            tool.setPrefWidth(largeur);
            tool.setToggleGroup(tools);
        }

        undo.setPrefWidth(largeur);
        redo.setPrefWidth(largeur);
        slider.setPrefWidth(largeur);
        btnImport.setPrefWidth(largeur);

        lblColor = Create.label("Couleur :",Pos.BASELINE_LEFT);
        colorBordure.setPrefWidth(largeur);
        lblRemplissage = Create.label("Remplissage :", Pos.BASELINE_LEFT);
        colorRemplissage.setPrefWidth(largeur);

        this.setSpacing(10);
        this.setPrefWidth((largeur + 30));
        this.getChildren().addAll(btnDessiner, btnLigne, btnRectangle, btnCercle, btnElipse, btnEffacer, lblColor, colorBordure,lblRemplissage, colorRemplissage,line_width,slider,undo,redo,btnImport);
        this.setStyle("-fx-background-color: #999999; -fx-padding: 15");
    }

    public String outil(){
        if(btnDessiner.isSelected())
            return "dessiner";

        if(btnElipse.isSelected())
            return "ellipse";

        if(btnCercle.isSelected())
            return "cercle";

        if(btnEffacer.isSelected())
            return "effacer";

        if(btnRectangle.isSelected())
            return "rectangle";

        if(btnLigne.isSelected())
            return "ligne";

        return "";
    }

    public Button undo() {
        return this.undo;
    }

    public Button redo() {
        return this.redo;
    }

    public Color couleurBordure(){
        return colorBordure.getValue();
    }

    public Color couleurRemplissage(){
        return colorRemplissage.getValue();
    }

    public double getSize(){
        return slider.getValue();
    }

    public Button btnImport() {
        return this.btnImport;
    }
}
