import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Arbol {
    private Nodo raiz;
    private ArrayList<Nodo> nodos;
    private int numNodos;

    public Arbol() {
        raiz = null;
        nodos = new ArrayList<>();
        numNodos = 0;
    }

    public void anadirNodo(Nodo nodo, Nodo padre, String posicion) {
        if (padre == null) {
            if (raiz == null) {
                raiz = nodo;
            } else {
                throw new IllegalArgumentException("La raíz ya existe");
            }
        } else {
            switch (posicion) {
                case "Izquierda1":
                    if (padre.izquierda1 == null) {
                        padre.izquierda1 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo Izq1 ya existe");
                    }
                    break;
                case "Izquierda2":
                    if (padre.izquierda2 == null) {
                        padre.izquierda2 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo Izq2 ya existe");
                    }
                    break;
                case "Derecha1":
                    if (padre.derecha1 == null) {
                        padre.derecha1 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo Der1 ya existe");
                    }
                    break;
                case "Derecha2":
                    if (padre.derecha2 == null) {
                        padre.derecha2 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo Der2 ya existe");
                    }
                    break;
                case "Derecha3":
                    if (padre.derecha3 == null) {
                        padre.derecha3 = nodo;
                    } else {
                        throw new IllegalArgumentException("Hijo Der3 ya existe");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Posición no válida");
            }
        }
        nodos.add(nodo);
        numNodos++;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public String getEtiquetaNodoSiguiente() {
        return String.valueOf((char) ('A' + numNodos));
    }

    public String bfs() {
        StringBuilder resultado = new StringBuilder();
        if (raiz == null) return "";
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(raiz);

        while (!queue.isEmpty()) {
            Nodo nodo = queue.poll();
            resultado.append(nodo.etiqueta).append(" ");
            if (nodo.izquierda1 != null) queue.add(nodo.izquierda1);
            if (nodo.izquierda2 != null) queue.add(nodo.izquierda2);
            if (nodo.derecha1 != null) queue.add(nodo.derecha1);
            if (nodo.derecha2 != null) queue.add(nodo.derecha2);
            if (nodo.derecha3 != null) queue.add(nodo.derecha3);
        }
        return resultado.toString();
    }

    public String dfs() {
        StringBuilder resultado = new StringBuilder();
        if (raiz == null) return "";
        Stack<Nodo> stack = new Stack<>();
        stack.push(raiz);

        while (!stack.isEmpty()) {
            Nodo nodo = stack.pop();
            resultado.append(nodo.etiqueta).append(" ");
            if (nodo.derecha3 != null) stack.push(nodo.derecha3);
            if (nodo.derecha2 != null) stack.push(nodo.derecha2);
            if (nodo.derecha1 != null) stack.push(nodo.derecha1);
            if (nodo.izquierda2 != null) stack.push(nodo.izquierda2);
            if (nodo.izquierda1 != null) stack.push(nodo.izquierda1);
        }
        return resultado.toString();
    }

    public Object[][] getMatrizAdyacencia() {
        int size = nodos.size();
        Object[][] matriz = new Object[size][size];
        HashMap<String, Integer> etiquetaAIndice = new HashMap<>();

        for (int i = 0; i < size; i++) {
            etiquetaAIndice.put(nodos.get(i).etiqueta, i);
        }

        for (int i = 0; i < size; i++) {
            Nodo nodo = nodos.get(i);
            int desdeIndice = etiquetaAIndice.get(nodo.etiqueta);
            if (nodo.izquierda1 != null) matriz[desdeIndice][etiquetaAIndice.get(nodo.izquierda1.etiqueta)] = 1;
            if (nodo.izquierda2 != null) matriz[desdeIndice][etiquetaAIndice.get(nodo.izquierda2.etiqueta)] = 1;
            if (nodo.derecha1 != null) matriz[desdeIndice][etiquetaAIndice.get(nodo.derecha1.etiqueta)] = 1;
            if (nodo.derecha2 != null) matriz[desdeIndice][etiquetaAIndice.get(nodo.derecha2.etiqueta)] = 1;
            if (nodo.derecha3 != null) matriz[desdeIndice][etiquetaAIndice.get(nodo.derecha3.etiqueta)] = 1;
        }

        return matriz;
    }
}