/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: ListaSEncadeadaC
* Funcao: Implementacao de uma Lista Simplesmente Encadeada Circular
***********************************************************************/

package util.lista.simplesmente;

import util.lista.Element;

public class ListaSEncadeadaC<T> extends ListaSEncadeada<T> {

  /************************************
  * Nome: getTail
  * Funcao: Retornar os Objetos
  * Parametros: void
  * Retorno: T
  ************************************/
  @Override
  public T getTail() {
    return this.getTailElement().getData();
  }

  /************************************
  * Nome: getTailElement
  * Funcao: Retorna o conteudo do ultimo objeto da lista
  * Parametros: void
  * Retorno: Element<T>
  ************************************/
  @Override
  public Element<T> getTailElement() {
    if (this.isEmpty()) {
      System.out.println("Lista esta vazia - getTail()");
      return null;
    }
      
    Element<T> temp = this.head.getNext();
    while (temp.getNext() != this.head) {
      temp = temp.getNext();
    }
    return temp;
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
    if (isEmpty()) {
      head = temp;
      temp.setNext(head); 
    } else {
      add(item);
      head = getTailElement();
    }
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
    if (isEmpty()) {//Se a lista estiver vazia
      this.addFirst(item);//Inserir no inicio
    } else {
      Element<T> ultimo = this.getTailElement();
      Element<T> temp = new Element<T>(item);
      temp.setNext(head);
      ultimo.setNext(temp);
      totalElementos++;
    }
  }

  /************************************
  * Nome: contains
  * Funcao: Verificar se a lista contem um item
  * Parametros: item:T
  * Retorno: boolean
  ************************************/
  @Override
  public boolean contains(T item) {
    //Verificar se a lista esta vazia
    if (isEmpty()) {
      return false;
    }

     Element<T> temp = head;

     //Se for o primeiro elemento
     if (temp.getData().equals(item)) {
      return true;
     }

     while (temp.getNext() != head) {
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

    //Pesquisando o elemento Item
    while (temp.getNext() != head && !temp.getData().equals(item)) {
      antesTemp = temp;
      temp = temp.getNext();
    }

    //Terminou o busca e nao encontrou o tiem
    if (!temp.getData().equals(item)) {
      System.out.println("Não foi possivel encontrar o Item - remove()");
      return;
    }

    if (temp == head) {//Se o item for o Head
      antesTemp = getTailElement();
      antesTemp.setNext(temp.getNext());
      head = temp.getNext();
    } else {
      //Removendo um elemento entre dois elementos
      //O anterior ao elemento passa a apontar para o elemento que está a frente do elemento
      antesTemp.setNext(temp.getNext());
    }
    
    totalElementos--;
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
    Element<T> atual = head;

    //Percorrer ate o punultimo elemento
    while (atual.getNext() != head) {
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