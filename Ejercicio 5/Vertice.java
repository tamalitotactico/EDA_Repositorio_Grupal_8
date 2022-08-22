import java.util.ArrayList;
public class Vertice <V extends Comparable<V>>{
    V valor;
    ArrayList <Vertice <V>> punteros = new ArrayList<Vertice <V>>();

    public Vertice (V valor){
        this.valor = valor;
    }

    public Vertice (V valor , Vertice [] referencias){
        this.valor = valor;
        //Insertamos la referencias
        for(int i = 0;  i < referencias.length ; i++){
            this.punteros.add(referencias[i]);
        }

    }
    
    public void setReferencias(Vertice [] referencias) {
        for(int i = 0;  i < referencias.length ; i++){
            this.punteros.add(referencias[i]);
        }    }

    public V getValor(){
        return this.valor;
    }

    public String toString(){
        return "[ " + valor + " ]";
    }
}
