/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: ListaDEncadeada
* Funcao: Implementacao de uma Lista Duplamente Encadeada
***********************************************************************/

package util.lista.duplamente;

import util.lista.Lista;
import util.lista.Element;

public class ListaDEncadeada<T> implements Lista<T> {
  protected Element<T> head;//Primeiro Elemento da lista
  protected Element<T> tail;//Ultimo Elemento da lista
  protected int totalElementos;//Total de Elementos da lista
  
  /************************************
  * Nome: Metodo Construtor da Classe
  * Funcao: Construir objetos do tipo ListaDEncadeada
  * Parametros: void
  * Retorno: null
  ************************************/
  public ListaDEncadeada() {
    this.head = null;
    this.tail = null;
    this.totalElementos = 0;
  }


  /************************************
  * Nome: getHead
  * Funcao: Retornar o primeiro Item da lista
  * Parametros: void
  * Retorno: T
  ************************************/
  public T getHead() {
    return head.getData();
  }

  /************************************
  * Nome: getTail
  * Funcao: Retornar o ultimo Item da lista
  * Parametros: void
  * Retorno: T
  ************************************/
  public T getTail() {
    return tail.getData();
  }
  
  /************************************
  * Nome: getHeadElement
  * Funcao: Retornar o primeiro Elemento da lista
  * Parametros: void
  * Retorno: Element<T>
  ************************************/
  public Element<T> getHeadElement() {
    return head;
  }

  /************************************
  * Nome: getTailElement
  * Funcao: Retorna o ultimo Elemento da lista
  * Parametros: void
  * Retorno: Element<T>
  ************************************/
  public Element<T> getTailElement() {
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
  * Nome: add
  * Funcao: Adiciona um item numa posicao
  * Parametros: index:int, item:T
  * Retorno: void
  ************************************/
  public void add(int index, T item) {
    
    //Posicao invalida
    if (index > this.totalElementos || index <= -1) {
      throw new IndexOutOfBoundsException("Erro, posicao invalida - add()");
    }
    //Adicionar no Comeco da Lista
    if (index == 0) {
      this.addFirst(item);
      return;
    }
    //Adicionando no final
    if (index == this.totalElementos) {
      Element<T> temp = new Element<T>(item);
      this.tail.setNext(temp);
      temp.setPrev(this.tail);
      this.tail = temp;
      this.totalElementos++;
      return;
    }
    
    Element<T> temp = this.getHeadElement();
    for (int i=0; i<this.totalElementos; i++) {
      if (i == index) {
        Element<T> elemento = new Element<T>(item);
        elemento.setNext(temp);
        elemento.setPrev(temp.getPrev());
        temp.getPrev().setNext(elemento);
        temp.setPrev(elemento);
        totalElementos++;
        return;
      }
      temp = temp.getNext();
    }
  }




  /************************************
  * Nome: addFirst
  * Funcao: Inserir um objeto no inicio da lista
  * Parametros: item:T
  * Retorno: void
  ************************************/
  @Override
  public void addFirst(T item) {
    Element<T> temp;
    if (isEmpty()) {
      temp = new Element<T>(item);
      this.tail = temp;
    } else {
      temp = new Element<T>(item);
      temp.setNext(head);
    }
    this.head = temp;
    totalElementos++;
  }

  /************************************
  * Nome: add
  * Funcao: Inserir um objeto no fim da lista
  * Parametros: Objeto a ser inserido
  * Retorno: void
  ************************************/
  @Override
  public void add(T item) {
    Element<T> temp = new Element<T>(item);
    if (isEmpty()) {
      this.head = temp;
    } else {
      temp.setPrev(tail);
      tail.setNext(temp);
    }
    this.tail = temp;
    totalElementos++;
  }
  
  /************************************
  * Nome: addBefore
  * Funcao: Inserir um item antes de um objeto
  * Parametros: item:T, antes:T
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

    if (antesEl == head) {
      antesEl.setPrev(temp);
      head = temp;
    } else {
      temp.setPrev(antesEl.getPrev());
      antesEl.getPrev().setNext(temp);
      antesEl.setPrev(temp);
    }
    totalElementos++;
  }
  
  /************************************
  * Nome: addAfter
  * Funcao: Inserir um item depois de um objeto
  * Parametros: item:T, depois:T
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
    temp.setPrev(depoisEl);
    
    //Caso o Element depois seja o Tail
    if (depoisEl == tail) {
      depoisEl.setNext(temp);
      tail = temp;//O Temp torna-se o Tail
    } else {
      depoisEl.getNext().setPrev(temp);
      temp.setNext(depoisEl.getNext());
      depoisEl.setNext(temp);
      temp.setPrev(depoisEl);
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
    for (int i=0; i<index; i++) {
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
    while (temp.getNext() != null) {
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
  * Parametros: T, conteudo do objeto
  * Retorno: void
  ************************************/
  @Override
  public void remove(T item) {
    if (isEmpty()) {
      System.out.println("A lista está vazia - remove()");
      return;
    }

    Element<T> temp = this.head;
    Element<T> prevTemp = null;

    //Pesquisando os itens 
    while (temp != null && !temp.getData().equals(item)) {
      prevTemp = temp;
      temp = temp.getNext();
    }
    //Caso tenha terminado a lista e não foi encontrado o elemento
    if (temp == null) {
      System.out.println("Elemento não encontrado - remove()");
      return;
    } else {//O elemento existe na lista
      //Removendo o primeiro elemento
      if (temp == head) {
        if (temp.getNext() != null) {//Caso exista o proximo elemento
          //System.out.println("Entrou");
          head = temp.getNext();
          head.setPrev(null);
        } else {//Caso so exista o head
          head = null;
        }
      } else if (temp == tail) { 
        //Removendo o ultimo elemento
        prevTemp.setNext(null);
        this.tail = prevTemp;
      } else {
        //Removendo um elemento entre dois elementos
        //O anterior ao elemento passa a apontar para o elemento que está a frente do elemento
        prevTemp.setNext(temp.getNext());
        temp.getNext().setPrev(prevTemp);
      }
      totalElementos--;
    }
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
    System.out.println("Erro, elemento não encontrado - indexOf()");
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
    return (totalElementos == 0);
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

    //Percorrendo a lista ate o penultimo Elemento
    while (atual.getNext() != null) {
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