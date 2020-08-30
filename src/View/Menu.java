package View;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Menu extends HBox {

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
    private final Label lineWidth;
    private final Button btnImport;
    private final Button btnExport;

    public Menu() {
        int taille = 50;
        btnDessiner = Create.iconToggleButton("Pinceau", taille, "./icon/pinceau.png");
        btnLigne = Create.iconToggleButton("Ligne", taille, "./icon/ligne.png");
        btnRectangle = Create.iconToggleButton("Rectangle", taille, "./icon/rectangle.png");
        btnCercle = Create.iconToggleButton("Cercle", taille, "./icon/cercle.png");
        btnElipse = Create.iconToggleButton("Oval", taille, "./icon/oval.png");
        btnEffacer = Create.iconToggleButton("Gomme", taille, "./icon/eraser.png");
        colorBordure = new ColorPicker(Color.BLACK);
        colorRemplissage = new ColorPicker(Color.TRANSPARENT);
        btnDessiner.setSelected(true);
        tools = new ToggleGroup();
        ToggleButton[] toolsArr = {btnDessiner, btnLigne, btnRectangle, btnCercle, btnElipse, btnEffacer};
        slider = new Slider();
        lineWidth = Create.label("",Pos.BASELINE_LEFT);
        undo = Create.iconButton("Annuler", taille, "./icon/undo.png");
        redo = Create.iconButton("Refaire", taille, "./icon/redo.png");
        btnImport = Create.iconButton("Importer", taille, "./icon/import.png");
        btnExport = Create.iconButton("Sauvegarder", taille, "./icon/save.png");

        slider.valueProperty().addListener(e->{
            double width = slider.getValue();
            lineWidth.setText(String.format("Bordure : %.0f", width));
        });
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setValue(3.0);

        int largeur = 120;
        for (ToggleButton tool : toolsArr) {
            tool.setToggleGroup(tools);
        }

        slider.setPrefWidth(largeur);

        lblColor = Create.label("Couleur :",Pos.BASELINE_LEFT);
        colorBordure.setPrefWidth(largeur);
        lblRemplissage = Create.label("Remplissage :", Pos.BASELINE_LEFT);
        colorRemplissage.setPrefWidth(largeur);

        this.setSpacing(10);
        this.setMaxHeight((largeur + 30));
        this.getChildren().addAll(
                btnDessiner, btnLigne, btnRectangle, btnCercle, btnElipse, btnEffacer,
                lblColor, colorBordure,lblRemplissage, colorRemplissage, lineWidth,slider,
                undo,redo,btnImport,btnExport
        );
        this.setStyle("-fx-background-color: #999999; -fx-padding: 15;");
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

    public Button btnExport() {
        return this.btnExport;
    }
}
