public class Nodo {
    int x, y;
    String etiqueta;
    Nodo izquierda1, izquierda2, derecha1, derecha2, derecha3;

    public Nodo(int x, int y, String etiqueta) {
        this.x = x;
        this.y = y;
        this.etiqueta = etiqueta;
        this.izquierda1 = null;
        this.izquierda2 = null;
        this.derecha1 = null;
        this.derecha2 = null;
        this.derecha3 = null;
    }

    @Override
    public String toString() {
        return etiqueta + " (" + x + ", " + y + ")";
    }
}