
package avl;

import java.awt.Graphics;
import java.util.Stack;


public class AVL {
    Nodo raiz;
    int fila;
    AVL(){
        raiz=null;
    }
    
    void rDerecha(Nodo p, Nodo q){
        p.bal=0;
        q.bal=0;
        p.izq=q.der;
        q.der=p;
    }
    
    void rIzquierda(Nodo p,Nodo q){
        p.bal=0;
        q.bal=0;
        p.der=q.izq;
        q.izq=p;
    }
    
    Nodo drDerecha(Nodo p,Nodo q){
        Nodo r;
        
        r=q.der;
        q.der=r.izq;
        r.izq=q;
        p.izq=r.der;
        r.der=p;
        switch(r.bal){  
            case -1:q.bal=1;
                p.bal=0;
                break;
            case 0:
                q.bal=p.bal=0;
                break;
            case 1:
                q.bal=0;
                p.bal=-1;
                break;
                
        }
        r.bal=0;
        return r;
    }
    
    Nodo drIzquierda(Nodo p,Nodo q){
        Nodo r;
        
        r=q.izq;
        q.izq = r.der;
        r.der=q;
        p.der=r.izq;
        r.izq=p;
        switch(r.bal){
            case -1:
                q.bal=0;
                p.bal=1;
                break;
            case 1:
                q.bal=-1;
                p.bal=0;
                break;
            case 0:
                q.bal=p.bal=0;
                break;
        }
        r.bal=0;
        return r;      
    }
    
    int insAVL(int n,int c){
        Nodo nuevo,p,q,s,pivote,pp;
        int llave,altura;
        
        nuevo=new Nodo(n);
        if(raiz==null){
            c++;
            raiz=nuevo;
            return c;
        }
        
        pp=q=null;
        pivote=p=raiz;
        llave=nuevo.info;
        
        while(p != null){
            if(p.bal != 0){
                c++;
                pp = q;
                pivote = p;
            }
            if(llave == p.info){
                c++;
                return c;
            }else{
                c++;
                q=p;
                if(llave < p.info){
                    c++;
                    p=p.izq;
                }else {
                    c++;
                    p=p.der;
                }   
            }
        }
        
        if(llave < q.info){
            c++;
            q.izq=nuevo;
        }else {
            c++;
            q.der=nuevo;
        }
        if(llave < pivote.info){
            c++;
            s=pivote.izq;
            altura=1;
            
        }else{
            c++;
            s=pivote.der;
            altura=-1;
        }
        
        p=s;
        while(p != nuevo){
            if(llave < p.info){
                c++;
                p.bal=1;
                p=p.izq;
            }else{
                c++;
                p.bal=-1;
                p=p.der;   
            }    
        }
        
        if(pivote.bal==0){
            c++;
            pivote.bal=altura;
            
        }else if(pivote.bal + altura == 0){
            c++;
            pivote.bal=0;
        }else{
            c++;
            if(altura==1){
                c++;
                if(s.bal==1){
                    c++;
                    rDerecha(pivote,s);
                }else{
                    c++;
                    s=drDerecha(pivote,s);
                }
            }else{
                c++;
                if(s.bal==-1){
                    c++;
                    rIzquierda(pivote,s);
                }else{
                    c++;
                    s=drIzquierda(pivote,s);
                }
            }
            if(pp==null){
                c++;
                raiz=s;
            }else if(pp.izq==pivote){
                c++;
                pp.izq=s;
            }else{
                c++;
                pp.der=s;
            }
        }
        return c;
    }
    
    Nodo raizArbol(){
        return raiz;
    }
    
    void initFila(){
        fila=0;
    }
    
    void inorden(Nodo p, Graphics lienzo){
        if(p!=null){
            inorden(p.izq,lienzo);
            lienzo.drawString(""+p.info+" "+p.bal,50,++fila*15);
            inorden(p.der,lienzo);
        }
        
    }
    void preorden(Nodo p,Graphics lienzo){
        if(p!=null){
            lienzo.drawString(""+p.info+" "+p.bal,90,++fila*15);
            preorden(p.izq,lienzo);
            preorden(p.der,lienzo);
        }
    }
    void posorden(Nodo p,Graphics lienzo){
        if(p!=null){
            posorden(p.izq,lienzo);
            posorden(p.der,lienzo);
            lienzo.drawString(""+p.info+" "+p.bal,130, ++fila*15);
        }
    }
    
    Nodo bal_der(Nodo q, int []terminar){
        Nodo t=null;
        switch(q.bal){
            case 1:
                q.bal=0;
                break;
            case -1:
                t=q.der;
                switch(t.bal){
                    case 1:
                        t=drIzquierda(q,t);
                        break;
                    case -1:
                        rIzquierda(q,t);
                        break;
                    case 0:
                        q.der=t.izq;
                        t.izq=q;
                        t.bal=1;
                        terminar[0]=1;
                        break;
                }
                break;
            case 0:
                q.bal=-1;
                terminar[0]=1;
                break;
                
        }
        return t;
    }
    
    Nodo bal_izq(Nodo q, int []terminar){
        Nodo t=null;
        switch(q.bal){
            case -1:
                q.bal=0;
                break;
            case 1:
                t=q.izq;
                switch(t.bal){
                    case 1:
                        rDerecha(q,t);
                        break;
                    case -1:
                        drDerecha(q,t);
                        break;
                    case 0:
                        q.izq=t.der;
                        t.der=q;
                        t.bal=-1;
                        terminar[0]=1;
                        break;
                        
                }
                break;
            case 0:
                q.bal=1;
                terminar[0]=1;
                break;
                
        }
        return t;
    }
    
    int retirarAVL(int n,int c){
        Stack pila=new Stack();
        Nodo p,q,t,r;
        int llave, accion;
        
        int []terminar=new int[1];
        
        boolean encontro=false;
        
        if(raiz==null){
            c++;
            return c;
        }
        terminar[0]=0;
        p=raiz;
        while(!encontro && p!=null){
            pila.push(p);
            if(n<p.info){
                c++;
                p=p.izq;
            }else if(n>p.info){
                c++;
                p=p.der;
            }else {
                c++;
                encontro=true;
            }
            
        }
        if(!encontro){
            c++;
            return c;
        }    
        t=null;
        p=(Nodo)pila.pop();
        llave=p.info;
        if(p.izq==null && p.der==null){
            c++;
            accion=0;
        }else if(p.der==null){
            accion=1;
            c++;
        }else if(p.izq==null){
            c++;
            accion=2;
        }else {
            c++;
            accion=3;
        }
        if(accion==0 || accion==1 || accion==2){
            c++;
            if(!pila.empty()){
                c++;
                q=(Nodo)pila.pop();
                if(llave<q.info){
                    c++;
                    switch(accion){
                        case 0:
                        case 1:
                            q.izq=p.izq;
                            t=bal_der(q,terminar);
                            break;
                        case 2:
                            q.izq=p.der;
                            t=bal_der(q,terminar);
                            break;                            
                    }
                }else{
                    c++;
                    switch(accion){
                        case 0:
                        case 2:
                            q.der=p.der;
                            t=bal_izq(q,terminar);
                            break;
                        case 1:
                            q.der=p.izq;
                            t=bal_izq(q,terminar);
                            break;                  
                    }
                }
                            
            }else{
                c++;
                switch(accion){
                    case 0:
                        raiz=null;
                        terminar[0]=1;
                        break;
                    case 1:
                        raiz=p.izq;
                        break;
                    case 2:
                        raiz=p.der;
                        break;
                }
            }
            
            
        }else{
            pila.push(p);
            r=p;
            p=r.der;
            q=null;
            while(p.izq!=null){
                pila.push(p);
                q=p;
                p=p.izq;
                
            }
            llave=r.info=p.info;
            if(q!=null){
                c++;
                q.izq=p.der;
                t=bal_der(q,terminar);
                
            }
            else{
                c++;
                r.der=p.der;
                t=bal_izq(r,terminar);
                
            }
            q=(Nodo)pila.pop();
            
        }
        
        while(!pila.empty() && terminar[0]==0){
            q=(Nodo)pila.pop();
            if(llave<q.info){
                c++;
                if(t!=null){
                    c++;
                    q.izq=t;
                    t=null;
                }
                t=bal_der(q,terminar);
            }
            else{
                c++;
                if(t!=null){
                    c++;
                    q.der=t;
                    t=null;
                }
                t=bal_izq(q,terminar);
            }
        }
        
        if(t!=null){
            c++;
            if(pila.empty()==true){
                c++;
                raiz=t;
                
            }
            else{
                c++;
                q=(Nodo)pila.pop();
                if(llave==q.info){
                    c++;
                    q.izq=t;
                }else{
                    c++;
                    q.der=t;
                }
                
            }
        }
        return c;
    }
}
