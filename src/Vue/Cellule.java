package Vue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
* La classe HexagonalButton permet de créer un bouton avec une forme hexagonale
*/
public class Cellule extends JLabel {
    private static final long serialVersionUID = -7142502695252118612L;
    private Point coord;
    private Sol terrain;
    private Unite unite;
    private Polygon hexagonalShape;
    
    public Cellule(Point coord, Sol ter) throws IOException {
        super();
        hexagonalShape = getHexPolygon();
        this.coord = coord;
        this.terrain = ter;
        this.unite = null;
    }
    
    public Cellule(Point coord, Sol terrain, Unite unite) {
        super();
        hexagonalShape = getHexPolygon();
        this.terrain = terrain;
        this.unite = unite;
        this.coord = coord;
    }
    
    
    /**
    * Genere un bouton de forme hexagonale
    * @return Polygon avec les formes d'un bouton hexagonale
    */
    private Polygon getHexPolygon() {
        Polygon hex = new Polygon();
        int w = getWidth() - 1;
        int h = getHeight() - 1;
        int ratio = (int) (h * .25);
        
        hex.addPoint(w / 2, 0);
        hex.addPoint(w, ratio);
        hex.addPoint(w, h - ratio);
        hex.addPoint(w / 2, h);
        hex.addPoint(0, h - ratio);
        hex.addPoint(0, ratio);
        
        return hex;
    }
    
    public void setEmplacement(Point p){
        this.coord = p;
    }
    
    @Override
    public String toString() {
        return "Cellule :"+"[x: "+String.valueOf(coord.x)+", y: "+String.valueOf(coord.y)+"]";
    }
    
    // Getters and setters : 
    
    
    public Sol getTerrain() {
        return this.terrain;
    }
    
    public void setTerrain(Sol terrain) {
        this.terrain = terrain;
    }
    
    public Polygon getHexagonalShape() {
        return this.hexagonalShape;
    }
    
    public void setHexagonalShape(Polygon hexagonalShape) {
        this.hexagonalShape = hexagonalShape;
    }
    
    public Point getCoord() {
        return this.coord;
    }
    
    public void setCoord(Point coord) {
        this.coord = coord;
    }
    
    // END Getters and setters
    
    /*
    * (non-Javadoc)
    * @see java.awt.Component#contains(java.awt.Point)
    */
    @Override
    public boolean contains(java.awt.Point point) {
        return hexagonalShape.contains(point);
    }
    
    /*
    * (non-Javadoc)
    * @see javax.swing.JComponent#contains(int, int)
    */
    @Override
    public boolean contains(int x, int y) {
        return hexagonalShape.contains(x, y);
    }
    
    /*
    * (non-Javadoc)
    * @see java.awt.Component#setSize(java.awt.Dimension)
    */
    @Override
    public void setSize(Dimension d) {
        super.setSize(d);
        hexagonalShape = getHexPolygon();
    }
    
    /*
    * (non-Javadoc)
    * @see java.awt.Component#setSize(int, int)
    */
    @Override
    public void setSize(int w, int h) {
        super.setSize(w, h);
        hexagonalShape = getHexPolygon();
    }
    
    /*
    * (non-Javadoc)
    * @see java.awt.Component#setBounds(int, int, int, int)
    */
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        hexagonalShape = getHexPolygon();
    }
    
    /*
    * (non-Javadoc)
    * @see java.awt.Component#setBounds(java.awt.Rectangle)
    */
    @Override
    public void setBounds(Rectangle r) {
        super.setBounds(r);
        hexagonalShape = getHexPolygon();
    }
    
    /*
    * (non-Javadoc)
    * @see javax.swing.JComponent#processMouseEvent(java.awt.event.MouseEvent)
    */
    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (contains(e.getPoint()))
        super.processMouseEvent(e);
    }
    
    /*
    * (non-Javadoc)
    * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
    */
    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        //g.fillRect(0, 0, getWidth(), getHeight());
        //g.setColor(getBackground());
        //g.drawPolygon(hexagonalShape);
        g.setClip(hexagonalShape);
        // draw the image
        if (unite!=null) {
            try {
                g.drawImage(ImageIO.read(new File("assets"+File.separator+"images"+File.separator+"Terrain"+File.separator+terrain.toString()+".jpg")), 0, 0, null);
                g.drawImage(ImageIO.read(new File("assets"+File.separator+"images"+File.separator+"Unite"+File.separator+unite.toString()+".png")), 25, 20, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                g.drawImage(ImageIO.read(new File("assets"+File.separator+"images"+File.separator+"Terrain"+File.separator+terrain.toString()+".jpg")), 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        //g.fillPolygon(hexagonalShape);
    }
    
    /*
    * (non-Javadoc)
    * @see javax.swing.AbstractButton#paintBorder(java.awt.Graphics)
    */
    @Override
    protected void paintBorder(Graphics g) {
        // Does not print border
    }
    
    //public 
}