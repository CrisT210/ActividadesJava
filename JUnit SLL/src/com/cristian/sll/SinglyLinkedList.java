package com.cristian.sll;

public class SinglyLinkedList {
	
public Node head;
	
    public SinglyLinkedList() {
    	head = null;
    }
    //Los metodos de la SLL van aqui. Al principio, les mostraremos cómo agregar nodos a la lista.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    
    public void remove() {
    	Node aux = head;
    	boolean encontrado = false;
    	while(aux != null) {
    		if(aux.next != null && aux.next.next == null && encontrado == false) {
    			System.out.println("El valor "+ aux.next.value +" sera eliminado");
    			aux.next = null;
    			encontrado = true;
    			System.out.println("valor eliminado");
    		}else {
    			aux = aux.next;
    		}
		}
    }
    
    public void removeFront() {
    	Node aux = head;
    	if(head != null) {
    		if(aux != null && aux.next == null) {
        		System.out.println("El nodo "+ aux.value +" sera eliminado");
        		head = aux.next;
        	}
        	if(aux != null && aux.next != null){
        		System.out.println("El nodo "+ aux.value +" sera eliminado");
        		head = aux.next;
        	}
    	}else {
    		System.out.println("La lista se encuentra vacia");
    	}
    }
    
    public void printValues() {
    	System.out.println("Listado de todos los elementos de la pila");
    	Node aux = head;
    	int posicion = 0;
    	if(head != null) {
    		while(aux != null) {
    			System.out.println("Valor nodo posicion("+ posicion +"): "+ aux.value);
    			aux = aux.next;
    			posicion++;
    		}
    	}else {
    		System.out.println("La lista se encuentra vacia");
    	}    		
    }
    
    public void find(int value) {
    	System.out.println("Encontrar el valor "+ value);
    	Node aux = head;
    	int posicion = 0;
    	if(head != null) {
    		while(aux != null) {
    			if(aux.value == value) {
    				System.out.println("Valor "+ aux.value +" encontrado en la posiscion: "+ posicion);
    				aux = aux.next;
    			}else {
    				aux = aux.next;
    				posicion++;
    			}
    		}
    	}else {
    		System.out.println("La lista se encuentra vacia");
    	}
    }

}
