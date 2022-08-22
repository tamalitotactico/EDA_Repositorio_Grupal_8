import javax.swing.event.MouseInputListener;

public class prueba {
    public static void main(String[] args) {
        
        //Creamos Lista
        Grafo <String> myList = new Grafo<String>();
        
        //Creamos primer vertice que no tiene otros adyacentes
        Vertice <String> v1 = new Vertice<String>("1");
        Vertice <String> v2 = new Vertice<String>("2");
        Vertice <String> v3 = new Vertice<String>("3");
        Vertice <String> v4 = new Vertice<String>("4");
        Vertice <String> v5 = new Vertice<String>("5");


        //Creamos un arreglo de vertices el cual contendra los vertices adyacentes de otr vertice cualquiera
        Vertice [] referenciasV1 = {v2,v5};
        v1.setReferencias(referenciasV1);
        myList.add(v1);
        
        Vertice [] referenciasV2 = {v3, v4, v5};
        v2.setReferencias(referenciasV2);
        myList.add(v2);

        Vertice [] referenciasV3 = {v4};
        v3.setReferencias(referenciasV3);
        myList.add(v3);
        
        Vertice [] referenciasV4 = {v5};
        v4.setReferencias(referenciasV4);
        myList.add(v4);

        Vertice [] referenciasV5 = {};
        v5.setReferencias(referenciasV5);
        myList.add(v5);

        
        //Creamos el grafo 2, el cual es un subgrafo del grafo 1, solo se hizo de 3 vectores, los 3 primeros
        //del grafo 1
        Grafo <String> myList2 = new Grafo<String>();

        Vertice <String> v6 = new Vertice<String>("1");
        Vertice <String> v7 = new Vertice<String>("2");
        Vertice <String> v8 = new Vertice<String>("3");
        
        Vertice [] referenciasV6 = {v7};
        v6.setReferencias(referenciasV6);
        
        myList2.add(v6);
        
        Vertice [] referenciasV7 = {v8};
        v7.setReferencias(referenciasV7);
        myList2.add(v7);

        Vertice [] referenciasV8 = {};
        v8.setReferencias(referenciasV8);
        myList2.add(v8);
        
        //Se imprimen ambos grafos para ver como son
        
        System.out.println(myList.toString()+"\n");
        
        System.out.println(myList2.toString());
        
        //Se llama la funcion subgrafo(), el cual devuelve true si detecta que uno de los grafos es un subgrafo del otro
        
        System.out.println(myList.subgrafo(myList, myList2));

        
        

    }
}
