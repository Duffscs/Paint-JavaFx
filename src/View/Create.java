package View;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Create {

    public static Label label(String textelbl){
        return label(textelbl, "#000000", 12, Pos.CENTER_LEFT);
    }

    public static Label label(String textelbl,Pos pos){
        return label(textelbl,"Black",13,pos);
    }

    public static Label label(String textelbl, String color){
        return label(textelbl, color, 12, Pos.CENTER_LEFT);
    }

    public static Label label(String textelbl, String color, int size, Pos pos) {
        final Label label = new Label(textelbl);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(pos);
        label.setTextFill(Color.web(color));
        label.setFont(Font.font("Verdana", FontWeight.NORMAL,size));
        return label;
    }

    public static TextField createTextField(int width) {
        final TextField textField = new TextField("");
        textField.setAlignment(Pos.CENTER_LEFT);
        textField.setMaxWidth(width);

        return textField;
    }

    public static ToggleButton iconToggleButton(String nom, int taille, String imgUrl){
        ToggleButton btn = new ToggleButton();
        iconButtonBase(nom, taille, imgUrl, btn);
        return btn;
    }
    public static Button iconButton(String nom, int taille, String imgUrl){
        Button btn = new Button();
        iconButtonBase(nom, taille, imgUrl, btn);
        return btn;
    }

    public static ButtonBase iconButtonBase(String nom, int taille, String imgUrl, ButtonBase btn){
        ImageView img = new ImageView("file:"+imgUrl);
        img.setFitHeight(taille-20);
        img.setFitWidth(taille-20);
        btn.setGraphic(img);
        btn.setPrefWidth(taille);
        btn.setPrefHeight(taille);
        btn.setTooltip(new Tooltip(nom));
        return btn;
    }
}
