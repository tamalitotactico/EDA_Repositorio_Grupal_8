import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grafo <V extends Comparable<V>>  {

    protected ArrayList <Vertice <V>> list = new ArrayList <Vertice<V>>();
    
    public Grafo(){
    }

    public Grafo( ArrayList <Vertice <V>> lista){
        this.list = lista;
    }

    public void add(Vertice <V> vertice){
        //ArrayList <Vertice<V>> arrayReferencias = new ArrayList<>();
        //arrayReferencias.add(vertice);
        this.list.add(vertice);

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
                return true;
            }
        }

        return false;

    }

    public String toString(){
        String str = "";
        for(int i = 0 ; i < this.list.size(); i++){
                str += list.get(i) + " ----> " + list.get(i).punteros;
            str += "\n";
        }

        return str;
    }
    
    public ArrayList <Vertice <V>> getList(){
    	return this.list;
    }
    
    public boolean subgrafo(Grafo a, Grafo b) {
    	//Crea 2 listas de vertices, luego se determina cual es el grafo con menos cantidad de vectores
    	
    	ArrayList <Vertice <V>> listamayor;
    	ArrayList <Vertice <V>> listamenor;
    	if(a.getList().size()>=b.getList().size()) {
    		listamayor =a.getList(); 
    		listamenor = b.getList();
    	}else {
    		listamayor = b.getList();
    		listamenor =a.getList(); 
    	}
    	
		int matches = 0;

		//Se empieza en el primer vector, de este se comparan las referencias de este con todos los vectores 
		//del grafo mas grande, si luego de revisar todos los vectores del grafo grande no hay ningun match
		//se retornara false, si en cambio hay un match se pasara al siguiente vector del grafo mas pequeño
		//Si todos los vectores del grafo pequeño tienen match se retorn True.
    	for(int i=0;i<listamenor.size();i++) {
    		for(int j=0;j<listamayor.size();j++) {
    			matches = 0;
        		for(int k=0;k<listamayor.get(j).punteros.size();k++) {
        			for(int l=0;l<listamenor.get(i).punteros.size();l++) {
        				if(listamenor.get(i).punteros.get(l).valor.equals(listamayor.get(j).punteros.get(k).valor)) {
        					matches++;
        				}
        			}
        		}
        		if(matches==listamenor.get(i).punteros.size()) {
        			break;
        		}
        		else if(j==listamayor.size()-1){
        			return false;
        		}
        	}
    	}
    	return true;
    }

}