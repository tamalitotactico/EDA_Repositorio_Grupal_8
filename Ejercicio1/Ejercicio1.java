package Ejercicio1;
public class Ejercicio1{
    public static void main(String[] args) {
        
        //Creamos Lista
        ListaAdyacencia <String> myList = new ListaAdyacencia<String>();
        
        //Creamos primer vertice que no tiene otros adyacentes
        Vertice <String> v1 = new Vertice<String>("a");

        //Creamos un arreglo de vertices el cual contendra los vertices adyacentes de otr vertice cualquiera
        Vertice [] referenciasV2 = {v1};
        Vertice <String> v2 = new Vertice<String>("b" , referenciasV2);

        Vertice [] referenciasV3 = {v1, v2};
        Vertice <String> v3 = new Vertice<String>("c" , referenciasV3);

        Vertice [] referenciasV4 = {v1, v2 , v3};
        Vertice <String> v4 = new Vertice<String>("d" , referenciasV4);

        myList.add(v1);
        myList.add(v2);
        myList.add(v3);
        myList.add(v4);

        System.out.println(myList);
        
        //Comprobamos las referencias
        System.out.println(v1.punteros);
    }
}