/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: Element
* Funcao: Elemento para construir uma Lista
***********************************************************************/

package util.lista;

public class Element<T> {
  private Element<T> prev;//Elemento anterior
  private Element<T> next;//Elemento posterior
  private T data;//Conteudo do Elemento


  /************************************
  * Nome: Metodo Construtor da Classe
  * Funcao: Construir objetos do tipo Element
  * Parametros: T data 
  * Retorno: null
  ************************************/
  public Element(T data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }


  /************************************
  * Nome: getPrev
  * Funcao: Retornar o Elemento anterior
  * Parametros: void
  * Retorno: Element<T>
  ************************************/
  public Element<T> getPrev() {
    return prev;
  }

  /************************************
  * Nome: getData
  * Funcao: Retornar o conteudo do Elemento
  * Parametros: void
  * Retorno: T (generics)
  ************************************/
  public T getData() {
    return data;
  }

  /************************************
  * Nome: getNext
  * Funcao: Retornar o Elemento posterior
  * Parametros: void
  * Retorno: Element<T>
  ************************************/
  public Element<T> getNext() {
    return next;
  }

  /************************************
  * Nome: setPrev
  * Funcao: Setar o elemento anterior
  * Parametros: Element<T> : prev
  * Retorno: void
  ************************************/
  public void setPrev(Element<T> prev) {
    this.prev = prev;
  }

  /************************************
  * Nome: setNext
  * Funcao: Setar o elemento posterior
  * Parametros: Element<T> : next
  * Retorno: void
  ************************************/
  public void setNext(Element<T> next) {
    this.next = next;
  }

  /************************************
  * Nome: setData
  * Funcao: Setar o conteudo deste elemento
  * Parametros: T : data
  * Retorno: void
  ************************************/
  public void setData(T data) {
    this.data = data;
  }

}//Fim class
