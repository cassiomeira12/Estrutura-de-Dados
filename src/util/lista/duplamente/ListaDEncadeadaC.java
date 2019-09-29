/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: ListaDEncadeadaC
* Funcao: Implementacao de uma Lista Duplamente Encadeada Circular
***********************************************************************/

package util.lista.duplamente;

import util.lista.Element;

public class ListaDEncadeadaC<T> extends ListaDEncadeada<T> {

  /************************************
  * Nome: Metodos de Getters
  * Funcao: Retornar os Objetos
  * Parametros: void
  * Retorno: T
  ************************************/
  @Override
  public T getTail() {
    return head.getPrev().getData();
  }

  /************************************
  * Nome: getTailElement
  * Funcao: Retorna o conteudo do ultimo objeto da lista
  * Parametros: void
  * Retorno: T conteudo
  ************************************/
  @Override
  public Element<T> getTailElement() {
    return head.getPrev();
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
      temp.setNext(temp);
      temp.setPrev(temp);
      this.head = temp;
    } else {
      this.getTailElement().setNext(temp);
      temp.setPrev(this.getTailElement());
      temp.setNext(head);
      head.setPrev(temp);
      this.head = temp;
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
    Element<T> temp = new Element<T>(item);
    if (isEmpty()) {
      temp.setNext(temp);
      temp.setPrev(temp);
      this.head = temp;
    } else {
      this.getTailElement().setNext(temp);
      temp.setPrev(this.getTailElement());
      temp.setNext(this.head);
      head.setPrev(temp);
    }
    totalElementos++;
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
    if (isEmpty()) {
      System.out.println("Lista está vazia - remove()");
      return;
    }

    Element<T> temp = this.head;
    Element<T> prevTemp = this.head.getPrev();

    //Pesquisando pelo Elemento
    while (!temp.getData().equals(item)) {
      prevTemp = temp;
      temp = temp.getNext();
      if (temp == this.head) {
        System.out.println("Elemento não encontrado - remove()");
        return;
      }
    }
    //Removendo o primeiro Elemento
    if (temp == head) {
      prevTemp.setNext(head.getNext());
      head.getNext().setPrev(head.getPrev());
      head = head.getNext();
    } else {
      prevTemp.setNext(temp.getNext());
      temp.getNext().setPrev(prevTemp);
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
      return "Lista está vazia - toString()";
    }

    StringBuilder builder = new StringBuilder("[");
    Element<T> atual = this.head;

    //Percorrendo a lista ate o penultimo Elemento
    while (atual.getNext() != head) {
      builder.append(atual.getData());
      builder.append(", ");
      atual = atual.getNext();
    }

    //Ultimo elemento
    builder.append(atual.getData());
    builder.append("]");
  
    return builder.toString();
  }
  
}//Fim Class