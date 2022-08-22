package Ejercicio1;

import java.util.ArrayList;

public class ListaAdyacencia <V extends Comparable<V>>  {

    protected ArrayList <ArrayList <Vertice <V>> > list = new ArrayList<ArrayList <Vertice<V>> >();
    
    public ListaAdyacencia(){
    }

    public ListaAdyacencia(ArrayList < ArrayList <Vertice <V>> > lista){
        this.list = lista;
    }

    public void add(Vertice <V> vertice){
        ArrayList <Vertice<V>> arrayReferencias = new ArrayList<>();
        arrayReferencias.add(vertice);
        this.list.add(arrayReferencias);

        //Revisar quein es su vertice adyacente para enlazarlos entre los os si es que no lo estan
        enlazarVAdyacente(vertice);
        
    }

    public void enlazarVAdyacente( Vertice<V> vertice){
        ArrayList <Vertice<V>> referencias = vertice.punteros;

        //Iteramos sobre cada referencia
        for (int i = 0; i < referencias.size(); i++) {
            Vertice v = referencias.get(i);
            //Buscar por las referencias de este nodo para ver si tambien lo tiene enlazaddo
            if(!estaEnlazado(v ,vertice)){
                v.punteros.add(vertice);
            }
        }
    }

    public  boolean estaEnlazado(Vertice <V> verticeComprobar, Vertice <V> verticeIns){
        
        for(int i = 0 ; i < verticeComprobar.punteros.size() ;i++){
            if(verticeComprobar.punteros.get(i) == verticeIns){
                System.out.println("Ya esta referenciado");
            }
        }

        return false;

    }

    public String toString(){
        String str = "";
        for(int i = 0 ; i < this.list.size(); i++){
            for(int j = 0 ; j < this.list.get(i).size() ; j++){
                str += list.get(i);
            }
            str += "\n";
        }

        return str;
    }

}