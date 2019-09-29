/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: Pilha
* Funcao: Interface com principais metodos de uma pilha
***********************************************************************/

package util.pilha;

import util.lista.Element;

public interface Pilha<T> {

  /************************************
  * Nome: push
  * Funcao: Inseri um item na Pilha
  * Parametros: item:T 
  * Retorno: void
  ************************************/
  public void push(T item);

  /************************************
  * Nome: getTop
  * Funcao: Retornar o primeiro Objeto da Pilha
  * Parametros: void
  * Retorno: T
  ************************************/
  public T getTop();

  /************************************
  * Nome: pop
  * Funcao: Retornar e Remove o primeiro da Pilha
  * Parametros: void
  * Retorno: T
  ************************************/
  public T pop();

  /************************************
  * Nome: isEmpty
  * Funcao: Verificar se a Pilha esta vazia
  * Parametros: void
  * Retorno: boolean
  ************************************/
  public boolean isEmpty();

  /************************************
  * Nome: size
  * Funcao: Retornar o total de elementos da Pilha
  * Parametros: void
  * Retorno: int
  ************************************/
  public int size();

  /************************************
  * Nome: addFirst
  * Funcao: Inserir um objeto no inicio da Pilha
  * Parametros: item:T
  * Retorno: void
  ************************************/
  public void clear();

  /************************************
  * Nome: toString
  * Funcao: Retornar uma String com todos os objetos da Pilha
  * Parametros: void
  * Retorno: String
  ************************************/
  public String toString();

}//FIm Interface