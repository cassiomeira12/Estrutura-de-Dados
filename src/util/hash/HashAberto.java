/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: HashAberto
* Funcao: Implementacao de um HashAberto
***********************************************************************/

package util.hash;

public class HashAberto {
  private int tamanho;
  private Integer vetor[];
  private int size;

  //Integer.MAX_VALUE;
  public HashAberto(int tamanho) {
    this.tamanho = tamanho;
    this.vetor = new Integer[tamanho];
    this.size = 0;
  }


  private int calcularIndiceDaTabela(int item) {
    return Math.abs(item)%tamanho;
  }

  public void inserir(int item) {
    int indice = calcularIndiceDaTabela(item);

    if (vetor[indice] == null || vetor[indice] == Integer.MAX_VALUE) {
      vetor[indice] = item;
      size++;
    } else {
      pesquisar(indice, item);
    }
  }

  private void pesquisar(int indice, int item) {

    if (size == tamanho) {
      System.out.println("Hash esta cheio");
      return;
    }

    int i = indice+1;
    for (;i < tamanho; i++) {
      if (vetor[i] == null || vetor[i] == Integer.MAX_VALUE) {
        vetor[i] = item;
        size++;
        return;
      }
    }

    if (i == tamanho) {
      i=0;
      for (;i<indice; i++) {
        if (vetor[i] == null || vetor[i] == Integer.MAX_VALUE) {
          vetor[i] = item;
          size++;
          return;
        }
      }
      System.out.println("O Vetor esta cheio");
    }
  }

  public void remover(int item) {
    int indice = calcularIndiceDaTabela(item);

    if (vetor[indice] == item) {
      vetor[indice] = Integer.MAX_VALUE;
      size--;
    } else {
      pesquisarRemover(indice, item);
    }
  }

  private void pesquisarRemover(int indice, int item) {
    int i = indice+1;
    for (; i<tamanho; i++) {
      if (vetor[i] == item) {
        vetor[i] = Integer.MAX_VALUE;
        size--;
        return;
      }
    }

    if (i == tamanho) {
      i=0;
      for (;i<indice; i++) {
        if (vetor[i] == item) {
          vetor[i] = Integer.MAX_VALUE;
          size--;
          return;
        }
      }
      System.out.println("O item nao foi encontrado");
    }
  }

  public boolean contains(int item) {
    int indice = calcularIndiceDaTabela(item);
    if (vetor[indice] != null && vetor[indice] == item) {
      return true;
    } else {
      return false;
    }
  }


  public void imprimir() {

    for (int i=0; i<tamanho; i++) {
      System.out.println("Posicao("+i+"): " + vetor[i]);
    }

  }

  public boolean isEmpty() {
    return size==0;
  }

  public int size() {
    return size;
  }


}//Fim class