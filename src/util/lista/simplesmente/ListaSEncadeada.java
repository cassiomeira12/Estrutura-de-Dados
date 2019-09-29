/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: ListaSEncadeada
* Funcao: Implementacao de uma Lista Simplesmente Encadeada
***********************************************************************/

package util.lista.simplesmente;

import util.lista.Lista;
import util.lista.Element;

public class ListaSEncadeada<T> implements Lista<T>{
  protected Element<T> head;//Primeiro Elemento da Lista
  protected Element<T> tail;//Último Elemento da Lista
  protected int totalElementos;//Total de Elementos
  

  /************************************
  * Nome: Metodo Construtor da Classe
  * Funcao: Construir objetos do tipo ListaSEncadeada
  * Parametros: void
  * Retorno: null
  ************************************/
  public ListaSEncadeada() {
    this.head = null;
    this.tail = null;
    this.totalElementos = 0;
  }


  /************************************
  * Nome: getHead
  * Funcao: Retornar o primeiro item da lista
  * Parametros: void
  * Retorno: T
  ************************************/
  public T getHead() {
    if (this.head == null) {
      System.out.println("Lista esta vazia - getHead()");
      return null;
    }
    return head.getData();
  }

  /************************************
  * Nome: getTail
  * Funcao: Retornar o ultimo item da lista
  * Parametros: void
  * Retorno: T
  ************************************/
  public T getTail() {
    if (this.tail == null) {
      System.out.println("Lista esta vazia - getTail()");   
      return null;
    }
    return tail.getData();
  }
  
  /************************************
  * Nome: getHeadElement
  * Funcao: Retornar o primeiro Element da lista
  * Parametros: void
  * Retorno: Element<T>
  ************************************/
  public Element<T> getHeadElement() {
    if (this.head == null) {
      System.out.println("Lista esta vazia - getHead()");
      return null;
    }
    return head;
  }

  /************************************
  * Nome: getTailElement
  * Funcao: Retornar o ultimo Element da lista
  * Parametros: void
  * Retorno: Element<T>
  ************************************/
  public Element<T> getTailElement() {
    if (this.tail == null) {
      System.out.println("Lista esta vazia - getTail()");   
      return null;
    }
    return tail;
  }

  /************************************
  * Nome: getElement
  * Funcao: Retornar o Element referente a um Item
  * Parametros: item:T
  * Retorno: Element<T>
  ************************************/
  private Element<T> getElement(T item) {
    //Se a lista estiver vazia
    if (this.isEmpty()) {
      System.out.println("Erro, elemento nao encontrado na lista - getElement()");
      return null;
    }
    
    Element<T> temp = this.head;
    while (temp != null) {
      //Verificar se o elemento atual e o procurado
      if (temp.getData().equals(item)) {
        return temp;
      }
      temp = temp.getNext();
    }//Fim While
    
    //Caso terminou a busca e o elemento nao foi encontrado
    System.out.println("Erro, elemento nao encontrado na lista - getElement()");
    return null;
  }



  
  /************************************
  * Nome: addFirst
  * Funcao: Inserir um objeto no inicio da lista
  * Parametros: item:T
  * Retorno: void
  ************************************/
  @Override
  public void addFirst(T item) {
    Element<T> temp = new Element<T>(item);
    temp.setNext(head);
    if (isEmpty()) {//Se a Lista estiver vazia
      tail = temp;//O primeiro Element eh o Head e o Tail
    }
    head = temp;//O Item torna-se o primeiro Element
    totalElementos++;
  }

  /************************************
  * Nome: add
  * Funcao: Inserir um objeto no fim da lista
  * Parametros: item:T
  * Retorno: void
  ************************************/
  @Override
  public void add(T item) {
    Element<T> temp = new Element<T>(item);
    if (isEmpty()) {//Se a Lista estiver vazia
      head = temp;//O ultimo Element eh o Head e o Tail 
    } else {
      tail.setNext(temp);//O antigo Tail aponta para o Objeto item
    }
    tail = temp;//O Item torna-se o ultimo Element
    totalElementos++;
  }
  
  /************************************
  * Nome: addBefore
  * Funcao: Inserir um item antes de um objeto
  * Parametros: item:T, antes:Element<T>
  * Retorno: void
  ************************************/
  @Override
  public void addBefore(T item, T antes) {
      
    Element<T> antesEl = this.getElement(antes);
    if (antesEl == null) {
      System.out.println("Erro, " + antes + " nao existe na lista - addBefore()");
      return;
    }
    
    Element<T> temp = new Element<T>(item);
    temp.setNext(antesEl);
    
    //Verificar se e o primeiro elemento
    if (antesEl == head) {
      head = temp;
    } else {
      //Procurando o elemento "antes"
      Element<T> antesTemp = head;
      while (antesTemp != null && antesTemp.getNext() != antesEl) {
        antesTemp = antesTemp.getNext();
      }
      antesTemp.setNext(temp);
    }
    totalElementos++;
  }

  /************************************
  * Nome: addAfter
  * Funcao: Inserir um item depois de um objeto
  * Parametros: item:T, depois:Element<T>
  * Retorno: void
  ************************************/
  @Override
  public void addAfter(T item, T depois) {
    
    Element<T> depoisEl = this.getElement(depois);
    if (depoisEl == null) {
      System.out.println("Erro, " + depois + " nao existe na lista - addAfter()");
      return;
    }
    
    Element<T> temp = new Element<T>(item);
    //Caso o Element depois seja o Tail
    if (depoisEl == tail) {
      depoisEl.setNext(temp);
      tail = temp;//O Temp torna-se o Tail
    } else {
      temp.setNext(depoisEl.getNext());
      depoisEl.setNext(temp);
    }
    totalElementos++;
  }
  
  /************************************
  * Nome: get
  * Funcao: Retorna um Objeto a partir do seu index
  * Parametros: index:int
  * Retorno: T
  ************************************/
  @Override
  public T get(int index) {
    //Posicao invalida
    if (index > this.totalElementos || index <= -1) {
      throw new IndexOutOfBoundsException("Erro, posicao invalida - get()");
    }

    //Se for o ultimo elemento
    if (index == this.totalElementos-1) {
      return this.getTail();
    }
    
    Element<T> temp = this.head;
    for (int i=0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getData();
  }

  /************************************
  * Nome: contains
  * Funcao: Verificar se a lista contem um item
  * Parametros: item:T
  * Retorno: boolean
  ************************************/
  @Override
  public boolean contains(T item) {
    //Se a lista estiver vazia
    if (isEmpty()) {return false;}

    Element<T> temp = this.head;
    while (temp != null) {
      //Verificar se o elemento atual e o procurado
      if (temp.getData().equals(item)) {
        return true;
      }
      temp = temp.getNext();
    }//Fim While
    return false;
  }

  /************************************
  * Nome: remove
  * Funcao: Remove um objeto da lista 
  * Parametros: item:T
  * Retorno: void
  ************************************/
  @Override
  public void remove(T item) {
    //Se a lista estiver vazia
    if (isEmpty()) {
      System.out.println("A lista está vazia - remove()");
      return;
    }

    Element<T> temp = head;
    Element<T> antesTemp = null;
  
    //Pesquisando os itens
    while (temp != null && !temp.getData().equals(item)) {
      antesTemp = temp;
      temp = temp.getNext();
    }
    //Caso tenha terminado a lista e não foi encontrado o elemento
    if (temp == null) {
      System.out.println("Elemento não encontrado - remove()");
      return;
    }
    //Removendo o primeiro elemento
    if (temp == head) {
      head = temp.getNext();
    } else {
      //Removendo um elemento entre dois elementos
      //O anterior ao elemento passa a apontar para o elemento que está a frente do elemento
      antesTemp.setNext(temp.getNext());
    }
    //Removendo o ultimo elemento
    if (temp == tail) {
      tail = antesTemp;
    }
    totalElementos--;
  }
  
  /************************************
  * Nome: indexOf
  * Funcao: Retornar o indice de um objeto
  * Parametros: item:T
  * Retorno: int
  ************************************/
  @Override
  public int indexOf(T item) {
    Element<T> temp = this.head;
    int index = 0;
    while (temp != null) {
      if (temp.getData().equals(item)) {
        return index;
      }
      temp = temp.getNext();
      index++;
    }//Fim While
    System.out.println("Erro, elemento não encontrado -  indexOf()");
    return -1;//VERIFICAR ISSO
  }
  
  /************************************
  * Nome: isEmpty
  * Funcao: Verificar se a lista esta vazia
  * Parametros: void
  * Retorno: boolean
  ************************************/
  @Override
  public boolean isEmpty() {
    return (head == null);
  }
  
  /************************************
  * Nome: size
  * Funcao: Retornar o total de elementos da lista
  * Parametros: void
  * Retorno: int
  ************************************/
  @Override
  public int size() {
    return totalElementos;
  }
  
  /************************************
  * Nome: clear
  * Funcao: Limpa a lista
  * Parametros: void
  * Retorno: void
  ************************************/
  @Override
  public void clear() {
    this.head = null;
    this.tail = null;
    this.totalElementos = 0;
  }
  
  /************************************
  * Nome: toString
  * Funcao: Retornar uma String com todos os objetos da lista
  * Parametros: void
  * Retorno: String
  ************************************/
  @Override
  public String toString() {  
    if (isEmpty()) {
      return "A lista está vazia - toString()";
    }

    StringBuilder builder = new StringBuilder("[");
    Element<T> atual = this.head;
    
    // Percorrendo até o penúltimo elemento.
    for (int i = 0; atual.getNext() != null; i++) {
      builder.append(atual.getData());
      builder.append(", ");
      atual = atual.getNext();
    }
    // último elemento
    builder.append(atual.getData());
    builder.append("]");

    return builder.toString();
  }

}//Fim class