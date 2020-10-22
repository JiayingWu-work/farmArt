package edu.macalester.comp127.FarmArt;

import java.awt.Color;
import java.util.Random;

public class BackgroundType {
    private String type;
    private Random r = new Random();
    private Color color1;
    private Color color2;

    public BackgroundType(String type, Color color1, Color color2) {
        this.type = type;
        this.color1 = color1;
        this.color2 = color2;
    }
    
    public void apply(Tile tile) {
        if (color1 == null || color2 == null) {
            tile.setBackgroundColor(null, null);
            return;
        }

        double redRange = randomFloat() * (color2.getRed() - color1.getRed());
        double greenRange = randomFloat() * (color2.getGreen() - color1.getGreen());
        double blueRange = randomFloat() * (color2.getBlue() - color1.getBlue());

        Color newColor = new Color(
            (int) (color1.getRed() + redRange), 
            (int) (color1.getGreen() + greenRange), 
            (int) (color1.getBlue() + blueRange));
    
        tile.setBackgroundColor(newColor, this);
        
    }

    public String getName() {
        return type;
    }

    private double randomFloat() {
        return r.nextDouble();
    }

}
