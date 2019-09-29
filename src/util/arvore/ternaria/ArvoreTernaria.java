package util.arvore.ternaria;

import util.fila.*;

public class ArvoreTernaria extends No {

  private No raiz;


  public ArvoreTernaria() {
    raiz = null;
  }

  public No getRaiz() {
    return this.raiz;
  }


  public void inserir(int data) {
    

    //Case a Arvores esteja vazia
    if (isEmpty()) {
      raiz = new No();
      raiz.inserir(data);
      System.out.println("Criando No Raiz " + data);
      System.out.println("Adicionando " + data + " no Data1");
      return;
    }

    //Adicionando Demais itens
    if (!raiz.isFull()) {
      System.out.println("Adicionando " + data + " ao lado do " + raiz.getData1());
      raiz.inserir(data);
    } else {

      //temp.inserir(data);
      pesquisar(raiz, data);

    }

  }

  private void pesquisar(No noInicial, int data) {
    No temp = new No();

    if (data < noInicial.getData1()) {
    //Adicionar No no Ponteiro Left

      if (noInicial.getLeft() != null) {

        adicionarNoPonteiroLeft(noInicial, data);

      } else {
        System.out.println("Criando No Left " + data + " antes do " + noInicial.getData1());
        temp.inserir(data);
        noInicial.setLeft(temp);
      }

      

    } else if (data >= noInicial.getData1() && data < noInicial.getData2()) {
    //Adicionar No no Ponteiro Center

      if (noInicial.getCenter() != null) {

        adicionarNoPonteiroCenter(noInicial, data);

      } else {
        System.out.println("Criando No Center " + data + " depois do " + noInicial.getData1() +
                            " e antes do " + noInicial.getData2());
        temp.inserir(data);
        noInicial.setCenter(temp);
      }

    } else if (data == noInicial.getData1() && data == noInicial.getData2()) {
    //Adicionar No no Ponteiro Center

      if (noInicial.getCenter() != null) {

        adicionarNoPonteiroCenter(noInicial, data);

      } else {
        System.out.println("Criando No Center " + data + " depois do " + noInicial.getData1() +
                            " e antes do " + noInicial.getData2());
        temp.inserir(data);
        noInicial.setCenter(temp);
      }


    } else {
    //Adicionar No no Ponteiro Right

      if (noInicial.getRight() != null) {

        adicionarNoPonteiroRight(noInicial, data);

      } else {
        System.out.println("Criando No Right " + data + " depois do " + noInicial.getData2());
        temp.inserir(data);
        noInicial.setRight(temp);
      }

    }

  }

  private void adicionarNoPonteiroLeft(No noInicial, int data) {

    if (!noInicial.getLeft().isFull()) {
      System.out.println("Adicionando " + data + " ao lado do " + noInicial.getLeft().getData1());
      noInicial.getLeft().inserir(data);
    } else {
      pesquisar(noInicial.getLeft(), data);
    }

  }

  private void adicionarNoPonteiroCenter(No noInicial, int data) {

    if (!noInicial.getCenter().isFull()) {
      System.out.println("Adicionando " + data + " ao lado do " + noInicial.getCenter().getData1());
      noInicial.getCenter().inserir(data);
    } else {
      pesquisar(noInicial.getCenter(), data);
    }

  }

  private void adicionarNoPonteiroRight(No noInicial, int data) {

    if (!noInicial.getRight().isFull()) {
      System.out.println("Adicionando " + data + " ao lado do " + noInicial.getRight().getData1());
      noInicial.getRight().inserir(data);
    } else {
      pesquisar(noInicial.getRight(), data);
    }

  }





  public void remover(int data) {
    System.out.println("Remover o numero " + data);

    if (isEmpty()) {
      System.out.println("Arvore vazia");
      return;
    }

    //Veriricar se o Data a ser removido pode ser o Data1
    if (data <= this.raiz.getData1()) {


      if (data == raiz.getData1()) {//Igual ao Data1

        System.out.println("Igual ao Data1");
        //raiz.setData1(null);
        System.out.println("Removeu Data1");

        //Verificar se existe Ponteiro Center
        if (raiz.getCenter() != null) {

          raiz.setData1(getMenorDosMaiores(raiz.getCenter(), raiz));

        } else {//Caso nao existir Ponteiro Center

          if (raiz.getData2() != null && raiz.getLeft() == null) {//Verificar se existe Data2

            //Data2 passa ser o Menor valor
            raiz.setData1(raiz.getData2());

            //Data2 fica vazio
            
            if (raiz.getRight() != null) {
              raiz.setData2(getMaiorDosMenores(raiz.getRight(), raiz));
            } else {
              raiz.setData2(null);
            }

          } else if (raiz.getLeft() != null) {
              
            raiz.setData1(getMaiorDosMenores(raiz.getLeft(), raiz));

          } else {
            System.out.println("Removeu o Data1");
            raiz.setData1(null);
          }

        }
          

      } else {//Menor que o Data1
        System.out.println("Menor que Data1");

        if (raiz.getLeft() != null) {//Pesquisar se Existir Ponteiro Left
          System.out.println("Pesquisar no Ponteiro Left");
          pesquisarRemover(raiz.getLeft(), data);
        } else {
          System.out.println("Elemento nao encontrado");
        }

      }


    } else if (data < this.raiz.getData2()) {//Maior que o Data1 e menor que o Data2
    
      System.out.println("Maior que Data1 e menor que Data2");

      if (raiz.getCenter() != null) {//Pesquisar se Existir Ponteiro Center
        System.out.println("Pesquisar no Ponteiro Center");
        pesquisarRemover(raiz.getCenter(), data);
      } else {
        System.out.println("Elemento nao encontrado");
      }

    } else {//Maior ou igual ao Data2

      if (data == raiz.getData2()) {//Igual ao Data2

        System.out.println("Igual a Data2");
        //raiz.setData2(null);
        System.out.println("Removeu Data2");

        //Verificar se existe Ponteiro Right
        if (raiz.getRight() != null) {

          raiz.setData2(getMenorDosMaiores(raiz.getRight(), raiz));

        } else {//Caso nao existir Ponteiro Right

          //Verificar se existe Ponteiro Center
          if (raiz.getCenter() != null) {
            
            raiz.setData2(getMaiorDosMenores(raiz.getCenter(), raiz));

          } else {

            if (raiz.getLeft() != null) {//Verificando se o Ponteiro Left existe
              System.out.println("Invertendo Valores");
              int data1 = getMaiorDosMenores(raiz.getLeft(), raiz);
              raiz.setData2(raiz.getData1());
              raiz.setData1(data1);

              //Caso o Ponteiro Left ainda exista
              if (raiz.getLeft() != null) {
                raiz.setCenter(raiz.getLeft());
                raiz.setLeft(null);
              }

            }

          }

        }

      } else {//Maior que o Data2
        System.out.println("Maior que o Data2");

        if (raiz.getRight() != null) {
          System.out.println("Pesquisar no Ponteiro Right");
          pesquisarRemover(raiz.getRight(), data);
        } else {
          System.out.println("Elemento nao encontrado");
        }

      }//Fim Maior que Data2


    }//Fim Maior ou Igual


  }//Fim Remover


  private void pesquisarRemover(No raiz, int data) {
    System.out.println("Remover o numero " + data);


    //Veriricar se o Data a ser removido pode ser o Data1
    if (data <= raiz.getData1()) {


      if (data == raiz.getData1()) {//Igual ao Data1

        System.out.println("Igual ao Data1");
        //raiz.setData1(null);
        System.out.println("Removeu Data1");

        //Verificar se existe Ponteiro Center
        if (raiz.getCenter() != null) {
          
          raiz.setData1(getMenorDosMaiores(raiz.getCenter(), raiz));

        } else {//Caso nao existir Ponteiro Center

          if (raiz.getData2() != null && raiz.getLeft() == null) {//Verificar se existe Data2
            //Data2 passa ser o Menor valor
            raiz.setData1(raiz.getData2());

            //Data2 fica vazio
            
            if (raiz.getRight() != null) {

              raiz.setData2(getMaiorDosMenores(raiz.getRight(), raiz));

            } else {
              raiz.setData2(null);
            }


          } else if (raiz.getLeft() != null) {

            raiz.setData1(getMaiorDosMenores(raiz.getLeft(), raiz));

          } else {
            System.out.println("Removeu o Data1");
            raiz.setData1(null);
          }

        }

          

      } else {//Menor que o Data1
        System.out.println("Menor que Data1");

        if (raiz.getLeft() != null) {//Pesquisar se Existir Ponteiro Left
          System.out.println("Pesquisar no Ponteiro Left");
          pesquisarRemover(raiz.getLeft(), data);
        } else {
          System.out.println("Elemento nao encontrado");
        }

      }


    } else if (data < raiz.getData2()) {//Maior que o Data1 e menor que o Data2
    
      System.out.println("Maior que Data1 e menor que Data2");

      if (raiz.getCenter() != null) {//Pesquisar se Existir Ponteiro Center
        System.out.println("Pesquisar no Ponteiro Center");
        pesquisarRemover(raiz.getCenter(), data);
      } else {
        System.out.println("Elemento nao encontrado");
      }


    } else {//Maior ou igual ao Data2

      if (data == raiz.getData2()) {//Igual ao Data2

        System.out.println("Igual a Data2");
        //raiz.setData2(null);
        System.out.println("Removeu Data2");

        //Verificar se existe Ponteiro Right
        if (raiz.getRight() != null) {

          raiz.setData2(getMaiorDosMenores(raiz.getRight(), raiz));

        } else {//Caso nao existir Ponteiro Right

          //Verificar se existe Ponteiro Center
          if (raiz.getCenter() != null) {

            raiz.setData2(getMaiorDosMenores(raiz.getCenter(), raiz));

          } else {

            if (raiz.getLeft() != null) {//Verificando se o Ponteiro Left existe
              System.out.println("Invertendo Valores");
              int data1 = getMaiorDosMenores(raiz.getLeft(), raiz);
              raiz.setData2(raiz.getData1());
              raiz.setData1(data1);

              //Caso o Ponteiro Left ainda exista
              if (raiz.getLeft() != null) {
                raiz.setCenter(raiz.getLeft());
                raiz.setLeft(null);
              }

            }

          }

        }


      } else {//Maior que o Data2
        System.out.println("Maior que o Data2");

        if (raiz.getRight() != null) {
          System.out.println("Pesquisar no Ponteiro Right");
          pesquisarRemover(raiz.getRight(), data);
        } else {
          System.out.println("Elemento nao encontrado");
        }

      }//Fim Maior que Data2


    }//Fim Maior ou Igual
    
  }

  //Ponteiro Left
  private int getMaiorDosMenores(No raiz, No preNo) {
    
    if (raiz.getRight() != null) {//Pesquisando no Ponteiro Right
    //Caso o Ponteiro Right exista, o maior estara nele

      //Buscar de novo
      return getMaiorDosMenores(raiz.getRight(), raiz);

    } else if (raiz.getData2() != null) {//Verificando se o Data2 existe
    //Case o Data2 exista, ele e o Maior
      int data2 = raiz.getData2();
      //Retornar o Data2

      //Verificando de existe o Ponteiro Center
      if (raiz.getCenter() != null) {
        //Buscar no Ponteiro Center o substituto do Data2--------------------------------------
        int data22 = getMaiorDosMenores(raiz.getCenter(), raiz);

        //Verificando se o Novo Data2 eh menor que o Data1
        if (data2 < raiz.getData1()) {
          raiz.setData2(raiz.getData1());
          raiz.setData1(data2);

          //Movendo o Ponteiro Center para o Right
          raiz.setRight(raiz.getCenter());
          raiz.setCenter(null);

          //Verificando se existem Ponteiros para mover
          if (raiz.getLeft() != null) {
            raiz.setCenter(raiz.getLeft());
            raiz.setLeft(null);
          }


        } else {//Caso ele nao for menor, adiciona no Data2
          raiz.setData2(data22);
        }

        //TALVEZ SEJA MELHOR O ADICIONAR

      } else {//Caso o Ponteiro Center nao exista
        //Data2 fica vazio

        //Veriricando se o Ponteiro Left existe
        if (raiz.getLeft() != null) {
          //Buscar no Ponteiro Center o substituto do Data2
          int data22 = getMaiorDosMenores(raiz.getLeft(), raiz);

          //Verificando se o novo Data2 eh menor que o Data1
          if (data22 < raiz.getData1()) {
            raiz.setData2(raiz.getData1());
            raiz.setData1(data22);

            //Verificando se existem Ponteiros para mover
            if (raiz.getLeft() != null) {
              raiz.setCenter(raiz.getLeft());
              raiz.setLeft(null);
            }
          
          } else {
            raiz.setData2(data22);
          }


        } else {//Caso o Ponteiro Left nao exista
          raiz.setData2(null);
        }

      }

      return data2;//Retornando Data2

    } else if (raiz.getCenter() != null) {//Pesquisando no Ponteiro Center
    //Caso o Ponteiro Center exista, o maior estara nele

      //Buscar de novo
      return getMaiorDosMenores(raiz.getCenter(), raiz);

    } else {//O maior valor eh o Data1
      int data1 = raiz.getData1();
      //Retornar o Data1


      if (data1 >= preNo.getData2()) {
        preNo.setRight(null);
      } else if (data1 >= preNo.getData1()) {
        preNo.setCenter(null);
      } else {
        preNo.setLeft(null);
      }

      return data1;
    }


  }//Fim metodo

  //Ponteiro Center e Right
  private int getMenorDosMaiores(No raiz, No preNo) {
    
    if (raiz.getLeft() != null) {//Pesquisando no Ponteiro Left

      //Bucar de novo
      return getMenorDosMaiores(raiz.getLeft(), raiz);

    } else {//Menor valor eh o Data1
      int data1 = raiz.getData1();

      if (raiz.getCenter() != null) {
        //Substituir valor da Data1 pelo menor valor do Ponteiro Center
        raiz.setData1(getMenorDosMaiores(raiz.getCenter(), raiz));
      
      } else if (raiz.getData2() != null) {
        //Caso o Data2 existir, colcoar Data2 no Data1
        raiz.setData1(raiz.getData2());

        if (raiz.getRight() != null) {
          //Substituir valor do Data2 pelo menor valor do Ponteiro Right
          raiz.setData2(getMenorDosMaiores(raiz.getRight(), raiz));
        } else {
          raiz.setData2(null);
        }

      } else {//Caso seja uma folha


        if (data1 >= preNo.getData2()) {
          preNo.setRight(null);
        } else if (data1 >= preNo.getData1()) {
          preNo.setCenter(null);
        } else {
          preNo.setLeft(null);
        }

      }

      return data1;

    }

  }




  /*
  private void reOrganizar(No raiz) {
    System.out.println("\nReorganizando");

    if (raiz.getData1() == null) {//Verificando se o Data1 esta vazio

      if (raiz.getData2() != null && raiz.getCenter() == null) {//Colocar Data2 no Lugar do Data1

        raiz.setData1(raiz.getData2());
        //Data2 fica vazio
        raiz.setData2(null);
        System.out.println("Colocou Data2 no lugar do Data1");

        if (raiz.getRight() != null) {//Verificar se existe o Ponteiro Right
          raiz.setCenter(raiz.getRight());
          raiz.setRight(null);
          System.out.println("Colocou Ponteiro Right no Center");
        }

      } else {  

        if (raiz.getCenter() != null) {//Re Organizar pegando o Data1 do Ponteiro Center

          raiz.setData1(raiz.getCenter().getData1());
          raiz.getCenter().setData1(null);
          System.out.println("Colocou Data1 do Center no lugar do Data1 da raiz");
          reOrganizar(raiz.getCenter());
        
        } else if (raiz.getLeft() != null) {//Re Organizar pegando o Data2 do Ponteiro Left
          
          //Verificando se Existe primeiro
          if (raiz.getLeft().getData2() != null) {
            raiz.setData1(raiz.getLeft().getData2());
            raiz.getLeft().setData2(null);
            System.out.println("Colocou Data2 do Left no lugar do Data1 da raiz");
            reOrganizar(raiz.getLeft());
          
          } else {//Pegado o Data1 caso o Data2 nao existir
            raiz.setData1(raiz.getLeft().getData1());
            raiz.getLeft().setData1(null);
            System.out.println("Colocou Data1 do Left no lugar do Data1 da raiz");
            reOrganizar(raiz.getLeft());
          }

        }//Fim Ponteiro Left

      }





    } else if (raiz.getData2() == null) {//Verificando se o Data2 esta vazio

      if (raiz.getRight() != null) {//Re Organizar pegando o Data1 do Ponteiro Right
        raiz.setData2(raiz.getRight().getData1());
        raiz.getRight().setData1(null);
        System.out.println("Colocou Data1 do Right no lugar do Data2 da raiz");

        reOrganizar(raiz.getRight());
      } else if (raiz.getCenter() != null) {//Re Organizar pegando o Data2 do Ponteiro Center

        //Verificando se Exite primeiro
        if (raiz.getCenter().getData2() != null) {
          raiz.setData2(raiz.getCenter().getData2());
          raiz.getCenter().setData2(null);
          System.out.println("Colocou Data2 do Center no lugar do Data2 da raiz");
          reOrganizar(raiz.getCenter());
        
        } else {//Pegando o Data1 caso o Data2 nao existir
          raiz.setData1(raiz.getCenter().getData1());
          raiz.getCenter().setData1(null);
          System.out.println("Colocou Data1 do Center no lugar do Data1 da raiz");
          reOrganizar(raiz.getCenter());
        }

      }//Fim Ponteiro Center

    }//Fim Verificacao do Data2

  }
  */

  public void imprimirLargura() {
    FilaEncadeada<No> nivelAtual = new FilaEncadeada<>();
    FilaEncadeada<No> proximoNivel = new FilaEncadeada<>();

    nivelAtual.add(this.raiz);

    while (!nivelAtual.isEmpty()) {
      No temp = nivelAtual.get();

      if (!temp.isLeaf()) {

        if (temp.getData1() != null) {
          System.out.print("(");
          System.out.print(temp.getData1() + " ");

          if (temp.getData2() != null) {
            System.out.print(temp.getData2());
            System.out.print(")");
          } else {
            System.out.print(")");
          }


        } else {
          if (temp.getData2() != null) {
            System.out.print("(");
            System.out.print(temp.getData2());
            System.out.print(")");
          }
        }


        if (temp.getLeft() != null) {
          proximoNivel.add(temp.getLeft());
        }

        if (temp.getCenter() != null) {
          proximoNivel.add(temp.getCenter());
        }

        if (temp.getRight() != null) {
          proximoNivel.add(temp.getRight());
        }



      } else {
        /*
        if (temp.getData1() != null) {
          System.out.print(temp.getData1() + " ");
        }

        if (temp.getData2() != null) {
          System.out.print(temp.getData2() + " ");
        }*/

        if (temp.getData1() != null) {
          System.out.print("(");
          System.out.print(temp.getData1() + " ");

          if (temp.getData2() != null) {
            System.out.print(temp.getData2());
            System.out.print(")");
          } else {
            System.out.print(")");
          }


        } else {
          if (temp.getData2() != null) {
            System.out.print("(");
            System.out.print(temp.getData2());
            System.out.print(")");
          }
        }



      }


      if (nivelAtual.isEmpty()) {
        System.out.println("");
        nivelAtual = proximoNivel;
        proximoNivel = new FilaEncadeada<>();
      }

    }//Fim while


  }

  public void emOrdem(No raiz) {

    if (raiz != null) {

      emOrdem(raiz.getLeft());

      if (raiz.getData1() != null) {
        System.out.println(raiz.getData1());
      }

      emOrdem(raiz.getCenter());

      if (raiz.getData2() != null) {
        System.out.println(raiz.getData2());
      }

      emOrdem(raiz.getRight());

    }

  }

  public boolean isEmpty() {
    return this.raiz == null;
  }


}