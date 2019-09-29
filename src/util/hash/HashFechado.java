/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: HashFechado
* Funcao: Implementacao de um Hash Fechado
***********************************************************************/

package util.hash;

import util.arvore.avl.ArvoreAVL;
import util.arvore.n_aria.ArvoreNAria;

public class HashFechado {

  private int tamanho;
  private ArvoreNAria table[];

  public HashFechado(int tamanho) {
    this.tamanho = tamanho;
    this.table = new ArvoreNAria[tamanho];
    for (int i=0; i<tamanho; i++) {
      table[i] = new ArvoreNAria(tamanho);
    }
  }

  private int calcularIndiceDaTabela(int item) {
    return Math.abs(item)%tamanho;
  }

  public void inserir(int item) {
    int indice = calcularIndiceDaTabela(item);
    table[indice].inserir(item);
  }

  public void remover(int item) {
    int indice = calcularIndiceDaTabela(item);
    table[indice].remover(item);
  }

  public void imprimir() {

    for (int i=0; i<tamanho; i++) {
      System.out.println("\n\n");
      table[i].imprimirLargura();
      System.out.println("\n\n");
    }    

  }

}//Fim class