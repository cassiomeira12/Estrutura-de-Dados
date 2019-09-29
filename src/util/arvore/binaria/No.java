package util.arvore.binaria;


public class No {

  private No left;//Ponteiro para o No da Esquerda
  private No right;//Ponteiro para o No da Direita
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
  public No getLeft() {
    return left;
  }

  public void setLeft(No left) {
    this.left = left;
  }

  public No getRight() {
    return right;
  }

  public void setRight(No right) {
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

    //System.out.println("Left " + left);

    if (isLeaf()) {
      return 0;
    }

    if (left != null && right != null) {
      int proLeft = left.getProfundidade()+1;
      int proRight = right.getProfundidade()+1;
      
      //Retornando o maior valor
      if (proLeft > proRight) {
        return proLeft;
      } else {
        return proRight;
      }
    }

    if (left != null) {
      return left.getProfundidade()+1;
    } else {
      return right.getProfundidade()+1;
    }

  }

  public void aumentarProfundidade() {
    this.profundidade++;
  }

  public void diminuirProfundidade() {
    this.profundidade--;
  }

  public void setProfundidade(int profundidade) {
    this.profundidade = profundidade;
  }

  public int getFB() {
    int alturaEsq = 0;
    int alturaDir = 0;

    if (left != null) {
      alturaEsq = left.getProfundidade()+1;
    }

    if (right != null) {
      alturaDir = right.getProfundidade()+1;
    }

    return (alturaEsq-alturaDir);
  }

  @Override
  public String toString() {
    return String.valueOf(data);
  }



}
