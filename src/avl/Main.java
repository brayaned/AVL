/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import java.util.Scanner;

/**
 *
 * @author Brayan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, d;int suma=0,aux;
        AVL a = new AVL();
        Scanner sc = new Scanner(System.in);
        int []vector=new int[100];
        for(int i=0;i<vector.length;i++){
            aux=(int) (Math.random()*500);
            if(vector[i]!=aux){
                vector[i]=aux;
            }else break;
        }
        
        
        do {
            System.out.println("1.Insertar");
            System.out.println("2.Retirar");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("ingresando");
                    int c1=0;
                    for(int i=0;i<vector.length;i++){
                        
                        System.out.println(vector[i]);
                        int r=a.insAVL(vector[i],c1);
                        System.out.println(r);
                        suma=suma+r;
                       
                    }
                    //System.out.println(a.insAVL(sc.nextInt(),c1));
                    //System.out.println("if:"+c1);
                    System.out.println("suma"+suma*2);
                    break;
                case 2:
                    System.out.println("ingrese dato");
                    int c=0;
                    d=sc.nextInt();
                    System.out.println(a.retirarAVL(d,c));
                    System.out.println("cant ifs:"+c);
                    break;

            }

        } while (n != 0);
    }

}
