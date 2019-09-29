/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: PilhaEncadeada
* Funcao: Implementacao de uma Pilha Encadeada
***********************************************************************/

package util.pilha;

import util.lista.simplesmente.ListaSEncadeada;
import util.lista.Element;

public class PilhaEncadeada<T> implements Pilha<T> {
  private ListaSEncadeada<T> lista = new ListaSEncadeada<T>();


  /************************************
  * Nome: push
  * Funcao: Inseri um item na Pilha
  * Parametros: item:T 
  * Retorno: void
  ************************************/
  @Override
  public void push(T item) {
    lista.addFirst(item);
  }

  /************************************
  * Nome: getTop
  * Funcao: Retornar o primeiro Objeto da pilha
  * Parametros: void
  * Retorno: T
  ************************************/
  @Override
  public T getTop() {
    return lista.getHead();
  }

  /************************************
  * Nome: pop
  * Funcao: Retornar e Remove o primeiro da pilha
  * Parametros: void
  * Retorno: T
  ************************************/
  @Override
  public T pop() {
    T top = lista.getHead();
    lista.remove(lista.getHead());
    return top;
  }

  /************************************
  * Nome: isEmpty
  * Funcao: Verificar se a pilha esta vazia
  * Parametros: void
  * Retorno: boolean
  ************************************/
  @Override
  public boolean isEmpty() {
    return lista.isEmpty();
  }

  /************************************
  * Nome: size
  * Funcao: Retornar o total de elementos da pilha
  * Parametros: void
  * Retorno: int
  ************************************/
  @Override
  public int size() {
    return lista.size();
  }

  /************************************
  * Nome: addFirst
  * Funcao: Inserir um objeto no inicio da lista
  * Parametros: item:T
  * Retorno: void
  ************************************/
  @Override
  public void clear() {
    lista.clear();
  }

  /************************************
  * Nome: toString
  * Funcao: Retornar uma String com todos os objetos da pilha
  * Parametros: void
  * Retorno: String
  ************************************/
  @Override
  public String toString() {
    if (isEmpty()) {
      return "A lista está vazia";
    }

    StringBuilder builder = new StringBuilder("[");
    Element<T> atual = lista.getHeadElement();

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

}//Fim Class