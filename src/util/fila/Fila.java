/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: Fila
* Funcao: Interface com principais metodos de uma Fila
***********************************************************************/

package util.fila;

public interface Fila<T> {

  /************************************
  * Nome: add
  * Funcao: Adicionar um item no fim da Fila
  * Parametros: item:T
  * Retorno: void
  ************************************/
  public void add(T item);

  /************************************
  * Nome: getTop
  * Funcao: Retornar o primeiro Objeto da Fila
  * Parametros: void
  * Retorno: T
  ************************************/
  public T getTop();

  /************************************
  * Nome: get
  * Funcao: Retornar e remove o primeiro da Fila
  * Parametros: void
  * Retorno: T
  ************************************/
  public T get();

  /************************************
  * Nome: isEmpty
  * Funcao: Verificar se a Fila esta vazia
  * Parametros: void
  * Retorno: boolean
  ************************************/
  public boolean isEmpty();

  /************************************
  * Nome: size
  * Funcao: Retornar o tamanho da Fila
  * Parametros: void
  * Retorno: int
  ************************************/
  public int size();

  /************************************
  * Nome: clear
  * Funcao: Limpa a Fila
  * Parametros: void
  * Retorno: void
  ************************************/
  public void clear();

  /************************************
  * Nome: toString
  * Funcao: Retornar Todos os elementos da Fila
  * Parametros: void
  * Retorno: String
  ************************************/
  public String toString();

}//Fim Interface