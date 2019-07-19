package Arbol;

public class Recorredor {

    private Lista lista;
    private int actual;

    public Recorredor(Lista l){
        actual = 0;
        lista = l;
    }
   
    public void comenzar(){//se prepara para recorrer los elementos de la lista (iniciando en 0)
        this.actual = 0;
    }

    
    public Object elemento(){//retorna el elemento actual
        return lista.elemento(actual);
    }

    public void proximo(){//avanza al siguiente elemento de la lista
        if (fin() == true)
            this.actual ++;
    }
    
    public Boolean fin(){//determina si llego o no al final de la lista
        if (actual <lista.tamanio)
            return true;
        else
            return false;
    }

    public void agregar(ArbolGeneral elem){//agrega el elemento en la posicion actual
        lista.agregar(elem, actual);
    }

    public void eliminar(){//elimina el elemento contenido en la posicion actual
        lista.eliminar(actual);//elimina el indice indicado, no lo deja nulo, lo elimina completamente
    }
}