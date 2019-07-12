
package avl;


public class Nodo {
    int info;
    int bal;
    Nodo izq;
    Nodo der;
    Nodo(int n){
        info=n;
        bal=0;
        izq=der=null;
    }
}
