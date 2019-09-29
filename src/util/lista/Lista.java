/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: Lista
* Funcao: Interface com principais metodos de uma lista
***********************************************************************/

package util.lista;

public interface Lista<T> {

  /************************************
  * Nome: addFirst
  * Funcao: Inserir um objeto no inicio			 da lista
  * Parametros: item:T
  * Retorno: void
  ************************************/
  public void addFirst(T item);

  /************************************
  * Nome: add
  * Funcao: Inserir um objeto no fim da lista
  * Parametros: item:T
  * Retorno: void
  ************************************/
  public void add(T item);

  /************************************
  * Nome: addBefore
  * Funcao: Inserir um item antes de um objeto
  * Parametros: item:T, antes:Element<T>
  * Retorno: void
  ************************************/
  public void addBefore(T item, T antes);

  /************************************
  * Nome: addAfter
  * Funcao: Inserir um item depois de um objeto
  * Parametros: item:T, depois:Element<T>
  * Retorno: void
  ************************************/
  public void addAfter(T item, T depois);
  
  /************************************
  * Nome: get
  * Funcao: Retorna um Objeto a partir do seu index
  * Parametros: index:int
  * Retorno: T
  ************************************/
  public T get(int index);

  /************************************
  * Nome: contains
  * Funcao: Verificar se a lista contem um item
  * Parametros: item:T
  * Retorno: boolean
  ************************************/
  public boolean contains(T item);

  /************************************
  * Nome: remove
  * Funcao: Remove um objeto da lista 
  * Parametros: item:T
  * Retorno: void
  ************************************/
  public void remove(T item);

  /************************************
  * Nome: indexOf
  * Funcao: Retornar o indice de um objeto
  * Parametros: item:T
  * Retorno: int
  ************************************/
  public int indexOf(T item);

  /************************************
  * Nome: isEmpty
  * Funcao: Verificar se a lista esta vazia
  * Parametros: void
  * Retorno: boolean
  ************************************/
  public boolean isEmpty();

  /************************************
  * Nome: size
  * Funcao: Retornar o total de elementos da lista
  * Parametros: void
  * Retorno: int
  ************************************/
  public int size();

  /************************************
  * Nome: clear
  * Funcao: Limpa a lista
  * Parametros: void
  * Retorno: void
  ************************************/
  public void clear();

  /************************************
  * Nome: toString
  * Funcao: Retornar uma String com todos os objetos da lista
  * Parametros: void
  * Retorno: String
  ************************************/
  public String toString();
  
}//Fim Interface
