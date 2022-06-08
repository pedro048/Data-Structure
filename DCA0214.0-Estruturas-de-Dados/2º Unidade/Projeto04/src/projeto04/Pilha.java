package projeto04;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Pilha<T>{
	LinkedList<T> conteudo; 
	
	public Pilha () {
		conteudo = new LinkedList<>();
	}
	public boolean estaVazia(){
		return conteudo.isEmpty();
	}
	public void empilha(T novoElemento){
		conteudo.addFirst(novoElemento);
	}
	public T desempilha () {	
		return conteudo.removeFirst();	
	}
	public T topo(){
		return conteudo.getFirst();
	}
	public String toString(){
		return conteudo.toString();
	}
	public void reinicialize(){
		conteudo.clear();
	}
        public String toStringInverse(){
            Iterator it = conteudo.descendingIterator();
            String str = "[";
            while(it.hasNext()){
                str = str + it.next().toString() + ",";
            }
            str = str +"]";
            
            return str;
        }
         static void test1() {
            Pilha<Double> aPilha = new Pilha<>();
            aPilha.empilha(1.1);
            aPilha.empilha(2.1);
            aPilha.empilha(3.1);
            aPilha.empilha(4.1);
            aPilha.empilha(5.1);
            Double valor;
            valor = aPilha.topo();
            System.out.println("topo pilha = " + valor);
            valor = aPilha.desempilha();
            System.out.println("topo pilha = " + valor);
            valor = aPilha.desempilha();
            System.out.println("topo pilha = " + valor);
            valor = aPilha.desempilha();
            System.out.println("topo pilha = " + valor);
            valor = aPilha.topo();
            System.out.println("topo pilha = " + valor);
            valor = aPilha.desempilha();
            System.out.println("topo pilha = " + valor);
        }
         
        static void test2() {
            Pilha<Double> aPilha = new Pilha<>();
            System.out.println(aPilha);
            aPilha.empilha(1.1);
            System.out.println(aPilha);
            aPilha.empilha(2.1);
            System.out.println(aPilha);
            aPilha.empilha(3.1);
            System.out.println(aPilha);
            Double valor;
            valor = aPilha.desempilha();
            System.out.println("topo pilha = " + valor);
            System.out.println(aPilha);
            valor = aPilha.desempilha();
            System.out.println("topo pilha = " + valor);
            System.out.println(aPilha);
            valor = aPilha.desempilha();
            System.out.println("topo pilha = " + valor);
            System.out.println(aPilha);
    }
        
        public static void main(String[] args) {
            //test1();
            test2();
        }
    }
