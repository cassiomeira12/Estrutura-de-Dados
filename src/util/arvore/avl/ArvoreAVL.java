package util.arvore.avl;

import util.arvore.binaria.*;
import util.fila.*;

public class ArvoreAVL {

  private No raiz = null;


  public boolean isEmpty() {
    return raiz == null;
  }

  public void inserir(int data) {
    No no = new No();
    no.setData(data);

    //Caso a arvore esteja vazia
    if (isEmpty()) {
      raiz = no;
      System.out.println("Adicionou " + data + " como raiz");
    } else {
      pesquisar(this.raiz, no, null);
    }

  }

  
  //Pesquisando para adicionar um novo No
  private void pesquisar(No noInicial, No no, No paiInicial) {

    //Adicionar a esquerda se No for menor
    if (no.getData() < noInicial.getData()) {

      if (noInicial.getLeft() != null) {//Verificando se Ponteiro Left existe
        
        pesquisar(noInicial.getLeft(), no, noInicial);//Pesquisando de novo

      } else {

        noInicial.setLeft(no);//Adicionando caso nao exista
        System.out.println("Adicionou " + no.getData() + " a Esquerda do " + noInicial.getData());

      }


      if (noInicial.getFB() == 2) {
        System.out.println("FB do " + noInicial + ": " + noInicial.getFB());

        if (noInicial.getLeft().getFB() == 1) {
          System.out.println("RSD");
          rotacaoSimplesDireita(noInicial, noInicial.getLeft(), paiInicial);
          return;
        } else {
          System.out.println("RDD");
          rotacaoDuplaDireita(noInicial, noInicial.getLeft(), paiInicial);
        }

      }



    } else {//Adicionar a direita se No for maior

      if (noInicial.getRight() != null) {//Verificando se Ponteiro Right existe
        
        pesquisar(noInicial.getRight(), no, noInicial);//Pesquisando de novo

      } else {

        noInicial.setRight(no);//Adicionando caso nao exista
        System.out.println("Adicionou " + no.getData() + " a Direita do " + noInicial.getData());
      }



      if (noInicial.getFB() == -2) {
        System.out.println("FB do " + noInicial + ": " + noInicial.getFB());

        if (noInicial.getRight().getFB() == -1) {
          System.out.println("RSE");
          rotacaoSimplesEsquerda(noInicial, noInicial.getRight(), paiInicial);
        } else {
          System.out.println("RDE");
          rotacaoDuplaEsquerda(noInicial, noInicial.getRight(), paiInicial);
        }

      }
    }

  }//Fim pesquisar


  public void remover(int data) {
    No prevNo;
    No noRemovido;
    No posNo;

    if (isEmpty()) {
      System.out.println("Arvore vazia");
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
        System.out.println("Erro, No nao encontrado");
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


  public void imprimirLargura() {

    if (!this.isEmpty()) {
      
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

  }

  private void rotacaoSimplesEsquerda(No a, No b, No paiA) {

    if (b.getLeft() != null) {//Verificando se o No b tem Ponteiro Right
      a.setRight(b.getLeft());
      b.setLeft(a);
    } else {//Caso o No b nao tenha Ponteiro Right
      b.setLeft(a);
      a.setRight(null);
    }

    if (paiA == null) {//No a era o raiz
      this.raiz = b;
    } else {
      if (a.getData() < paiA.getData()) {
        paiA.setLeft(b);
      } else {
        paiA.setRight(b);
      }
    }

  }//Fim rotacaoSimplesEsquerda

  private void rotacaoSimplesDireita(No a, No b, No paiA) {

    if (b.getRight() != null) {//Verificando se o No b tem Ponteiro Right
      a.setLeft(b.getRight());
      b.setRight(a);
    } else {//Caso o No b nao tenha Ponteiro Right
      b.setRight(a);
      a.setLeft(null);
    }

    if (paiA == null) {//No a era o raiz
      this.raiz = b;
    } else {
      if (a.getData() < paiA.getData()) {
        paiA.setLeft(b);
      } else {
        paiA.setRight(b);
      }
    }

  }//Fim rotacaoSimplesDireita

  private void rotacaoDuplaEsquerda(No a, No b, No paiA) {
    rotacaoSimplesDireita(b, b.getLeft(), a);
    rotacaoSimplesEsquerda(a, a.getRight(), paiA);
  }//Fim rotacaoDuplaEsquerda

  private void rotacaoDuplaDireita(No a, No b, No paiA) {
    rotacaoSimplesEsquerda(b, b.getRight(), a);
    rotacaoSimplesDireita(a, a.getLeft(), paiA);
  }//Fim rotacaoDuplaDireita

}