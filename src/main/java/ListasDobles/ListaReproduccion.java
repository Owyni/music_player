package ListasDobles;

public class ListaReproduccion {
    
    private NodoDoble actual;
    private boolean loop = false; // Modo Loop desactivado por defecto :b

    public void agregar(Cancion c) {
        NodoDoble nuevo = new NodoDoble(c);
        if (actual == null) {
            actual = nuevo;
        } else {
            NodoDoble temp = actual;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.anterior = temp;
        }
    }

    public void eliminarActual() {
        if (actual != null) {
            if (actual.anterior != null) {
                actual.anterior.siguiente = actual.siguiente;
            }
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;
            }
            actual = actual.anterior != null ? actual.anterior : actual.siguiente;
        }
    }

    public Cancion getActual() {
        return actual != null ? actual.cancion : null;
    }

    public Cancion siguiente() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return getActual();
    }

    public Cancion anterior() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
        }
        return getActual();
    }

    public String mostrarTodas() {
        if (actual == null) return "Empty List.";

        NodoDoble temp = actual;
        while (temp.anterior != null) {
            temp = temp.anterior;
        }

        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append("- ").append(temp.cancion).append("\n");
            temp = temp.siguiente;
        }
        return sb.toString();
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
    
    public boolean isLoop() {
        return loop;
    }
    
}
