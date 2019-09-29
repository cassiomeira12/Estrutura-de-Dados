package util.arvore.binaria;

import util.fila.*;

public class ArvoreBinaria {

  private No raiz;


  /************************************
  * Nome: Metodo Construtor da Classe
  * Funcao: Construir objetos do tipo ArvoreBinaria
  * Parametros: void
  * Saida: null
  ************************************/
  public ArvoreBinaria() {
    this.raiz = null;
  }

  public No getRaiz() {
    return raiz;
  }

  public void inserir(int data) {
    No no = new No();
    no.setData(data);

    //Caso a arvore esteja vazia
    if (isEmpty()) {
      raiz = no;
      //System.out.println("Adicionou " + data + " como raiz");
    } else {
      pesquisar(this.raiz, no);
    }

  }

  //Pesquisando para adicionar um novo No
  private void pesquisar(No noInicial, No no) {

    //Adicionar a esquerda se No for menor
    if (no.getData() < noInicial.getData()) {

      if (noInicial.getLeft() != null) {//Verificando se ja existe
        pesquisar(noInicial.getLeft(), no);//Chamando na inserir
      } else {
        noInicial.setLeft(no);//Adicionando caso nao exista
        //System.out.println("Adicionou " + no.getData() + " a Esquerda do " + noInicial.getData());
      }

    } else {//Adicionar a direita se No for maior

      if (noInicial.getRight() != null) {
        pesquisar(noInicial.getRight(), no);
      } else {
        noInicial.setRight(no);
        //System.out.println("Adicionou " + no.getData() + " a Direita do " + noInicial.getData());
      }

    }

  }

  public void remover(int data) {
    No prevNo;
    No noRemovido;
    No posNo;

    if (isEmpty()) {
      //System.out.println("Arvore vazia");
      return;
    }

    //Verificar se o item a ser removido eh o raiz
    if (this.raiz.getData() == data) {
      noRemovido = this.raiz;

      //Pegar menor valor do lado direito
      if (noRemovido.getRight() != null) {
        this.raiz.setData(getMenorDosMaiores(raiz.getRight(), raiz));

      } else if (noRemovido.getLeft() != null) {//Pegar maior valor do lado esquerdo
        this.raiz.setData(getMaiorDosMenores(raiz.getLeft(), raiz));

      } else {//Caso a raiz seja um No folha
        this.raiz = null;
      }

    } else {//Case nao for o raiz
      noRemovido = null;
      prevNo = this.raiz;
      posNo = this.raiz;

      //Procurando No a ser removido
      while (posNo != null && posNo.getData() != data) {

        if (data < posNo.getData()) {
          prevNo = posNo;
          posNo = posNo.getLeft();
        } else {
          prevNo = posNo;
          posNo = posNo.getRight();
        }

      }//Fim while

      if (posNo != null) {//Elemento encontrado
        noRemovido = posNo;

        //Caso o No seja uma folha
        if (noRemovido.isLeaf()) {
          
          //Verificando se em qual ramo esta o elemento a ser removido
          if (noRemovido.getData() < prevNo.getData()) {
            //No a ser removido esta a esquerda
            prevNo.setLeft(null);
          } else {
            //No a ser removido esta a direita
            prevNo.setRight(null);
          }

        } else {//Caso for um SubArvore

          //Pegar menor valor do lado direito
          if (noRemovido.getRight() != null) {
            noRemovido.setData(getMenorDosMaiores(noRemovido.getRight(), noRemovido));

          } else if (noRemovido.getLeft() != null) {//Pegar maior valor do lado esquerdo
            noRemovido.setData(getMaiorDosMenores(noRemovido.getLeft(), noRemovido));

          }

        }

      } else {//Elemento nao encontrado
        //System.out.println("Erro, No nao encontrado");
      }

    }

  }//Fim remover

  //Retorna o menor valor do Ponteiro Right
  private int getMenorDosMaiores(No raiz, No preNo) {

    if (raiz.getLeft() != null) {//Verificando se tem o Ponteiro Left
      return getMenorDosMaiores(raiz.getLeft(), raiz);
    } else if (raiz.getRight() != null) {//Verificando se tem o Ponteiro Right
      int data = raiz.getData();
      raiz.setData(getMenorDosMaiores(raiz.getRight(), raiz));
      return data;
    }

    int data = raiz.getData();
    
    //Removendo o Ponteiro do preNo
    if (raiz.getData() >= preNo.getData()) {
      preNo.setRight(null);
    } else {
      preNo.setLeft(null);
    }

    return data;
  }

  //Retorna o maior valor do Ponteiro Left
  private int getMaiorDosMenores(No raiz, No preNo) {

    if (raiz.getRight() != null) {
      return getMaiorDosMenores(raiz.getRight(), raiz);
    } else if (raiz.getLeft() != null) {
      int data = raiz.getData();
      raiz.setData(getMaiorDosMenores(raiz.getLeft(), raiz));
      return data;
    }

    int data = raiz.getData();
    
    //Removendo o Ponteiro do preNo
    if (raiz.getData() >= preNo.getData()) {
      preNo.setRight(null);
    } else {
      preNo.setLeft(null);
    }

    return data;
  }


  //Comeca a imprimir da raiz para os elementos da esquerda e depois direita 
  public void preOrdem(No no) {

    if (no != null) {
      System.out.println(no.getData());
      preOrdem(no.getLeft());
      preOrdem(no.getRight());
    }

  }


  //Comeca a imprimir das folhas a esquerda para as folhas a direita ate a raiz
  public void posOrdem(No no) {

    if (no != null) {
      posOrdem(no.getLeft());
      posOrdem(no.getRight());
      System.out.println(no.getData());
    }

  }

  public void emOrdem(No no) {

    if (no != null) {
      emOrdem(no.getLeft());
      System.out.println(no.getData());
      emOrdem(no.getRight());
    }

  }

  public void imprimirLargura() {
    FilaEncadeada<No> nivelAtual = new FilaEncadeada<>();
    FilaEncadeada<No> proximoNivel = new FilaEncadeada<>();

    nivelAtual.add(this.raiz);

    while (!nivelAtual.isEmpty()) {
      No temp = nivelAtual.get();

      if (!temp.isLeaf()) {
        System.out.print(temp.getData() + " ");
        if (temp.getLeft() != null) {
          proximoNivel.add(temp.getLeft());
        }

        if (temp.getRight() != null) {
          proximoNivel.add(temp.getRight());
        }

      } else {
        System.out.print(temp.getData() + " ");
      }

      if (nivelAtual.isEmpty()) {
        System.out.println("");
        nivelAtual = proximoNivel;
        proximoNivel = new FilaEncadeada<>();
      }

    }//Fim while

  }

  public boolean isEmpty() {
    return raiz == null;
  }

}//Fim class