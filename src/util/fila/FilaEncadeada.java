/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: FilaEncadeada
* Funcao: Implementacao de uma Fila Encadeada
***********************************************************************/

package util.fila;

import util.lista.simplesmente.ListaSEncadeada;

public class FilaEncadeada<T> implements Fila<T> {
  private ListaSEncadeada<T> lista = new ListaSEncadeada<T>();


  /************************************
  * Nome: add
  * Funcao: Adicionar um item na Fila
  * Parametros: item:T
  * Retorno: void
  ************************************/
  @Override
  public void add(T item) {
    lista.add(item);
  }

  /************************************
  * Nome: getTop
  * Funcao: Retornar o primeiro item da Fila
  * Parametros: void
  * Retorno: T
  ************************************/
  public T getTop() {
    return lista.getHead();
  }
  
  /************************************
  * Nome: get
  * Funcao: Retornar e remove o primeiro item da Fila
  * Parametros: void
  * Retorno: T
  ************************************/
  @Override
  public T get() {
    T temp = lista.getHead();
    lista.remove(temp);
    return temp;
  }

  /************************************
  * Nome: isEmpty
  * Funcao: Verificar se a Fila esta vazia
  * Parametros: void
  * Retorno: boolean
  ************************************/
  @Override
  public boolean isEmpty() {
    return lista.isEmpty();
  }

  /************************************
  * Nome: size
  * Funcao: Retornar o tamanho da Fila
  * Parametros: void
  * Retorno: int
  ************************************/
  @Override
  public int size() {
    return lista.size();
  }

  /************************************
  * Nome: clear
  * Funcao: Limpa a Fila
  * Parametros: void
  * Retorno: void
  ************************************/
  @Override
  public void clear() {
    while (!lista.isEmpty()) {
      lista.remove(lista.getHead());
    }
  }
  
  /************************************
  * Nome: toString
  * Funcao: Retornar Todos os elementos da Fila
  * Parametros: void
  * Retorno: String
  ************************************/
  @Override
  public String toString() {
    return lista.toString();
  }
  
}//Fim class