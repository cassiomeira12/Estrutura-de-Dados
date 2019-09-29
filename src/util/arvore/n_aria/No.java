package util.arvore.n_aria;

import util.lista.duplamente.ListaDEncadeada;


public class No {

  private ListaDEncadeada<No> left;//Ponteiro para o Lista da Esquerda
  private ListaDEncadeada<No> right;//Ponteiro para o Lista da Direita
  private Integer data;//Conteudo do No

  private int altura;
  private int profundidade;



  /************************************
  * Nome: Metodo Construtor da Classe
  * Funcao: Construir objetos do tipo No
  * Parametros: T data 
  * Saida: null
  ************************************/
  public No() {
    this.data = null;
    this.left = null;
    this.right = null;

    this.altura = 0;
    this.profundidade = 0;
  }


  /************************************
  * Nome: Metodo Construtor da Classe
  * Funcao: Construir objetos do tipo No
  * Parametros: T data 
  * Saida: null
  ************************************/
  public No(int data) {
    this.data = data;
    this.left = null;
    this.right = null;

    this.altura = 0;
    this.profundidade = 0;
  }



  /************************************
  * Nome: Metodos Getters e Setters
  * Funcao: Retornar os Objetos
  * Parametros: void
  * Saida: No ou T (generics)
  ************************************/
  public ListaDEncadeada<No> getLeft() {
    return left;
  }

  public void setLeft(ListaDEncadeada<No> left) {
    this.left = left;
  }

  public ListaDEncadeada<No> getRight() {
    return right;
  }

  public void setRight(ListaDEncadeada<No> right) {
    this.right = right;
  }

  public Integer getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void limpar() {
    this.left = null;
    this.right = null;
  }

  public boolean isLeaf() {
    return (this.left == null && this.right == null);
  }


  public Integer getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public int getProfundidade() {
    return profundidade;
  }

  public void setProfundidade(int profundidade) {
    this.profundidade = profundidade;
  }

  @Override
  public String toString() {
    return String.valueOf(data);
  }



}