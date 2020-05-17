
public class ArbolNario {

    private NodoArbolNario raiz;

    public ArbolNario(int dato) {
        raiz = new NodoArbolNario(dato);
    }

    public void insertar(ArbolNario arbol) {
        raiz.getHijos().insertar(arbol.raiz);
    }

    // ------------------------------------------------------------------------
    public void mostrarProfundidadRecursivo() {
        System.out.print("Profundidad Recursivo: ");

        if (raiz != null) {
            mostrarProfundidadRecursivo(raiz);
        }

        System.out.println();
    }

    private void mostrarProfundidadRecursivo(NodoArbolNario dato) {
        if (dato != null) {
            System.out.print(dato.getDato() + " ");
            IteradorAdelanteListaNodosArbolNario itf = dato.getHijos().getIteradorAdelante();
            while (itf.hasNext()) {
                mostrarProfundidadRecursivo(itf.next());
            }
        }
    }

    // ------------------------------------------------------------------------
    public void mostrarProfundidadIterativo() {
        System.out.print("Profundidad Iterativo: ");

        if (raiz != null) {
            PilaNodosArbolNario pila = new PilaNodosArbolNario();
            NodoArbolNario aux;
            pila.apilar(raiz);
            while (!pila.vacia()) {
                aux = pila.desapilar();
                System.out.print(aux.getDato() + " ");
                IteradorAtrasListaNodosArbolNario itb = aux.getHijos().getIteradorAtras();
                while (itb.hasPrevious()) {
                    pila.apilar(itb.previous());
                }
            }
        }

        System.out.println();
    }

    // ------------------------------------------------------------------------
    public void mostrarAmplitud() {
        System.out.print("Amplitud: ");

        if (raiz != null) {
            ColaNodosArbolNario cola = new ColaNodosArbolNario();
            cola.encolar(raiz);
            NodoArbolNario aux; //declaramos solo una referencia
            while (!cola.vacia()) {
                aux = cola.desencolar();
                System.out.print(aux.getDato() + " ");
                IteradorAdelanteListaNodosArbolNario itf = aux.getHijos().getIteradorAdelante();
                while (itf.hasNext()) {
                    cola.encolar(itf.next());
                }
            }

        }

        System.out.println();
    }
}