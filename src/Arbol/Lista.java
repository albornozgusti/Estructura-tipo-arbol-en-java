package Arbol;

public abstract class Lista 
{
	protected int tamanio=0;
	
	public abstract Object elemento(int pos);
    public abstract void agregar(Object elem, int pos);
    public abstract void eliminar(int pos);
    public abstract boolean esvacia();
    public abstract boolean incluye(Object elem);
    public int getTamanio() {
		return tamanio;
	}
    public  Recorredor recorredor(Lista l){
		return new Recorredor( l);	
    }
}