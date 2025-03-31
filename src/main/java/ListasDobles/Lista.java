package ListasDobles;

public class Lista {
    private Nodo inicio;
    private Nodo fin;
    private int cantidad;

    public Lista() {
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }

    public boolean vacia(){
        return inicio == null && fin == null;
    }

    public void agregarInicio(Object dato){
        if(vacia()){
            inicio = fin = new Nodo(dato, null, null);
        }else{
            Nodo nuevo = new Nodo(dato, null, inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
        cantidad++;
    }

    public void agregarFinal(Object dato){
        if(vacia()){
            inicio = fin = new Nodo(dato, null, null);
        }else{
            Nodo nuevo = new Nodo(dato, fin, null);
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        cantidad++;
    }

    public String reproducirInicioAFin(){
        String salida = "";

        if(!vacia()){
            Nodo aux = inicio;
            while(aux != null){
                salida += aux.getDato()+" "; //Aquí llamar los datos para la música
                aux = aux.getSiguiente();
            }
        }

        return salida;
    }

    public String reproducirFinAInicio(){
        String salida = "";

        if(!vacia()){
            Nodo aux = fin;
            while(aux != null){
                salida += aux.getDato()+" "; //Aquí llamar los datos para la música
                aux = aux.getAnterior();
            }
        }

        return salida;
    }

    public void eliminarInicio(){
        if(!vacia()){
            if(inicio == fin){
                inicio = fin = null;
            }else{
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }
            cantidad--;
        }
    }

        public void eliminarFinal(){
            if(!vacia()){
                if(inicio == fin){
                    inicio = fin = null;
                }else{
                    fin = fin.getAnterior();
                    fin.setSiguiente(null);
                }
                cantidad--;
            }
    }

    //Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }
}
