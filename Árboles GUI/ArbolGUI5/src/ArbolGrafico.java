import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ArbolGrafico extends JPanel {
    private Arbol arbol;

    public ArbolGrafico(Arbol arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int x = panelWidth / 2;
        int y = 50;
        int dimensionX = panelWidth / 4;
        int dimensionY = 50;
        dibujarArbol(g2d, arbol.getRaiz(), x, y, dimensionX, dimensionY);
    }

    public void dibujarArbol(Graphics2D g2d, Nodo nodo, int x, int y, int dimensionX, int dimensionY) {
        if (nodo != null) {
            g2d.fillOval(x - 15, y - 15, 30, 30);
            g2d.drawString(nodo.etiqueta, x - 10, y + 5);
            nodo.x = x;
            nodo.y = y;

            if (nodo.izquierda1 != null) {
                g2d.drawLine(x, y, x - dimensionX, y + dimensionY);
                dibujarArbol(g2d, nodo.izquierda1, x - dimensionX, y + dimensionY, dimensionX / 2, dimensionY);
            }

            if (nodo.izquierda2 != null) {
                g2d.drawLine(x, y, x - dimensionX / 2, y + dimensionY);
                dibujarArbol(g2d, nodo.izquierda2, x - dimensionX / 2, y + dimensionY, dimensionX / 2, dimensionY);
            }

            if (nodo.derecha1 != null) {
                g2d.drawLine(x, y, x + dimensionX / 2, y + dimensionY);
                dibujarArbol(g2d, nodo.derecha1, x + dimensionX / 2, y + dimensionY, dimensionX / 2, dimensionY);
            }

            if (nodo.derecha2 != null) {
                g2d.drawLine(x, y, x + dimensionX, y + dimensionY);
                dibujarArbol(g2d, nodo.derecha2, x + dimensionX, y + dimensionY, dimensionX / 2, dimensionY);
            }

            if (nodo.derecha3 != null) {
                g2d.drawLine(x, y, x + (dimensionX * 3 / 2), y + dimensionY);
                dibujarArbol(g2d, nodo.derecha3, x + (dimensionX * 3 / 2), y + dimensionY, dimensionX / 2, dimensionY);
            }
        }
    }
}