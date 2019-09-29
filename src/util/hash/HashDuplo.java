/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: HashDuplo
* Funcao: Implementacao de um Hash Duplo
***********************************************************************/

package util.hash;

public class HashDuplo {

  private int tamanho;
  private Integer vetor[];

  public HashDuplo(int tamanho) {
    this.tamanho = tamanho;
    this.vetor = new Integer[tamanho];
  }

  private int funcao1(int item) {
    return Math.abs(item)%tamanho;
  }

  private int funcao2(int item) {
    return (Math.abs(item)^2)%tamanho;
  }

  public void inserir(int item) {
    int indice = funcao1(item);//Calculando Funcao1
    if (vetor[indice] == null) {
      vetor[indice] = item;//Adicionando na posicao da Funcao1
    } else {
      indice = funcao2(item);//Calculando Funcao2
      if (vetor[indice] == null) {
        vetor[indice] = item;//Adicionando na posicao da Funcao2
      } else {
        pesquisarInserir(item, indice);
      }
    }
    
  }

  private void pesquisarInserir(int item, int posicao) {
    int i = posicao+1;
    for (;i < tamanho; i++) {
      if (vetor[i] == null) {
        vetor[i] = item;
        return;
      }
    }

    if (i == tamanho) {
      i=0;
      for (;i<posicao; i++) {
        if (vetor[i] == null) {
          vetor[i] = item;
          return;
        }
      }
      System.out.println("O Vetor esta cheio");
    }
  }

  public void remover(int item) {
    int indice = funcao1(item);
    if (vetor[indice] == item) {
      vetor[indice] = null;
    } else {
      indice = funcao2(item);
      if (vetor[indice] == item) {
        vetor[indice] = null;
      } else {
        pesquisarRemover(item, indice);
      }
    }
  }

  private void pesquisarRemover(int item, int posicao) {
    int i = posicao+1;
    for (;i < tamanho; i++) {
      if (vetor[i] == item) {
        vetor[i] = null;
        System.out.println("O item " + item + " foi removido na posicao " + i);
        return;
      }
    }

    if (i == tamanho) {
      i=0;
      for (;i<posicao; i++) {
        if (vetor[i] == item) {
          vetor[i] = null;
          System.out.println("O item " + item + " foi removido na posicao " + i);
          return;
        }
      }
      System.out.println("Item nao encontrado");
    }
  }

  public boolean contains(int item) {
    int indice = funcao1(item);

    if (vetor[indice] != null && vetor[indice] == item) {
      return true;
    } else {
      indice = funcao2(item);
      if (vetor[indice] != null && vetor[indice] == item) {
        return true;
      } else {

        for (int i=indice+1; i<tamanho; i++) {
          if (vetor[i] != null && vetor[i] == item) {
            return true;
          }
        }

        for (int i=0; i<indice; i++) {
          if (vetor[i] != null && vetor[i] == item) {
            return true;
          }
        }

        return false;
      }
    }
  }

  public void imprimir() {
    System.out.print("\n[");
    for (int i=0; i<tamanho; i++) {
      System.out.print(vetor[i] + ", ");
    }
    System.out.println("]");
  }

}//Fim class