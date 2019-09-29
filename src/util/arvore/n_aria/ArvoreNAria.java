package util.arvore.n_aria;

import util.fila.*;
import util.lista.duplamente.ListaDEncadeada;

public class ArvoreNAria {

  private int tamanhoMaximo;
  private ListaDEncadeada<No> raiz;

  //Metodo Construtor da classe AvoreNAria
  public ArvoreNAria(int numero) {
    this.raiz = new ListaDEncadeada<>();
    tamanhoMaximo = numero-1;
  }

  public ListaDEncadeada<No> getRaiz() {
    return raiz;
  }


  public void inserir(int data) {
    //Adicionando ate o raiz ficar cheio
    if (raiz.size() < tamanhoMaximo) {
      //Adicionando o primeiro
      if (raiz.size() == 0) {
        raiz.add(new No(data));
        return;
      }
      if (data >= raiz.get(raiz.size()-1).getData()) {//Adicionar no proximo
        raiz.add(new No(data));
        return;
      } else {//Caso o numero a ser adicionado eh menor que o maior numero do raiz
        buscaBinariaInserir(raiz, data, 0, raiz.size()-1);//Procurando posicao para adicionar
      } 
    } else {//Quando o raiz raiz estiver cheio, criar um novo No
      pesquisarInserir(raiz, data, 0, raiz.size()-1);
    }

  }//Fim inserir


  private void buscaBinariaInserir(ListaDEncadeada<No> raiz, int data, int limiteInf, int limiteSup) {
   // System.out.println("PESQUISANDO");
    int variacao = (limiteSup-limiteInf)/2;
    int posicao = limiteSup-variacao;

    if (data < raiz.get(posicao).getData()) {//Caso for menor
      //System.out.println("Menor que " + raiz.get(posicao).getData());

      //Verificacao caso exista apenas 1 elemento
      if ((posicao) == 0) {
       // System.out.println("Adicionar antes do " + raiz.get(posicao).getData());
        raiz.addBefore(new No(data), raiz.get(0));
        return;
      }

      if ((posicao) != 0 && data > raiz.get(posicao-1).getData()) {

        //System.out.println("Posicao entre " + raiz.get(posicao-1).getData() + " e " + 
      //   raiz.get(posicao).getData() );
        raiz.addAfter(new No(data), raiz.get(posicao-1));

      } else if ((posicao-1) == 0 && data <= raiz.get(0).getData()) {

       // System.out.println("Antes do " + raiz.get(posicao-1).getData());
        raiz.addBefore(new No(data), raiz.get(0));

      } else {
        buscaBinariaInserir(raiz, data, limiteInf, posicao);
      }
    

    } else if (data > raiz.get(posicao).getData()) {//Caso for maior
     // System.out.println("Maior que " + raiz.get(limiteSup).getData());

      if (data < raiz.get(posicao+1).getData()) {

       // System.out.println("Posicao entre " + raiz.get(posicao).getData() + " e " + 
       //  raiz.get(posicao+1).getData() );
        raiz.addAfter(new No(data), raiz.get(posicao));

      } else {
        buscaBinariaInserir(raiz, data, posicao, limiteSup);
      }

    } else {//Caso for igual
     // System.out.println("Valor igual, adicionar depois do " + raiz.get(posicao-1).getData());
      raiz.addAfter(new No(data), raiz.get(posicao-1));
    }

  }

  private void pesquisarInserir(ListaDEncadeada<No> raiz, int data, int limiteInf, int limiteSup) {
    int variacao = (limiteSup-limiteInf)/2;
    int posicao = limiteSup-variacao;

   // System.out.println("\nADICIONAR " + data + " LimS " + limiteSup + " LimInf " + limiteInf);

    if (data < raiz.get(posicao).getData()) {//Caso for menor
     // System.out.println("Menor que " + raiz.get(posicao).getData());

      //Verificacao caso exista apenas 1 elemento
      if (posicao == 0) {
      //  System.out.println("Adicionar antes do " + raiz.get(posicao).getData());
        //System.out.println("kkkkkkkkkkkkkkkkkkkkkk");

        //Verificando se o Ponteiro existe
        if (raiz.get(posicao).getLeft() != null) {
       //   System.out.println("Ponteiro  Left ja existe na posicao " + posicao);
          adicionarNo(raiz.get(posicao).getLeft(), data);
        
        } else {
        //  System.out.println("Criando Ponteiro Left na posicao " + posicao);
          
          ListaDEncadeada<No> temp = new ListaDEncadeada<>();

          raiz.get(posicao).setLeft(temp);

          adicionarNo(temp, data);
        }

        return;
      }


      if (posicao != 0 && data > raiz.get(posicao-1).getData()) {

        //System.out.println("Posicao entre " + raiz.get(posicao-1).getData() + " e " + 
       //  raiz.get(posicao).getData() );
        //raiz.addAfter(new No(data), raiz.get(limiteSup-posicao-1));

        //Verificando se o Ponteiro existe
        if (raiz.get(posicao-1).getRight() != null && raiz.get(posicao).getLeft() != null) {
        //  System.out.println("Ponteiro Right ja existe na posicao " + (posicao-1));
          adicionarNo(raiz.get(posicao-1).getRight(), data);
        
        } else {
       //   System.out.println("Criando Ponteiro Right na posicao " + (posicao-1));
          
          ListaDEncadeada<No> temp = new ListaDEncadeada<>();

          raiz.get(posicao-1).setRight(temp);
          raiz.get(posicao).setLeft(temp);

          adicionarNo(temp, data);
        }

      } else if ((posicao-1) == 0 && data == raiz.get(posicao-1).getData()) {
        //Quando o numero eh igual, adicionar no ponteiro Right
      //  System.out.println("Valor igual, adicionar depois do " + raiz.get(posicao-1).getData());


        //Verificando se o Ponteiro existe
        if (raiz.get(posicao-1).getRight() != null && raiz.get(posicao).getLeft() != null) {
        //  System.out.println("Ponteiro Right ja existe na posicao " + (posicao-1));
          adicionarNo(raiz.get(posicao-1).getRight(), data);

        } else {
       //   System.out.println("Criando Ponteiro Right na posicao " + (posicao-1));
          ListaDEncadeada<No> temp = new ListaDEncadeada<>();

          raiz.get(posicao-1).setRight(temp);
          raiz.get(posicao).setLeft(temp);

          adicionarNo(temp, data);
        }


      } else if ((posicao-1) == 0 && data <= raiz.get(0).getData()) {

       // System.out.println("Antes do " + raiz.get(posicao-1).getData());
        //raiz.addBefore(new No(data), raiz.get(0));

        //Verificando se o Ponteiro existe
        if (raiz.get(posicao-1).getLeft() != null) {
        //  System.out.println("Ponteiro Left ja existe na posicao " + (posicao-1));
          adicionarNo(raiz.get(posicao-1).getLeft(), data);

        } else {
        //  System.out.println("Criando Ponteiro Left na posicao " + (posicao-1));
          ListaDEncadeada<No> temp = new ListaDEncadeada<>();

          raiz.get(posicao-1).setLeft(temp);

          adicionarNo(temp, data);
        }


      } else {
        pesquisarInserir(raiz, data, limiteInf, posicao);
      }
    

    } else if (data > raiz.get(posicao).getData()) {//Caso for maior
     // System.out.println("Maior que " + raiz.get(posicao).getData());

      //System.out.println("posicao " + posicao);

      if (posicao+1 == tamanhoMaximo) {//Adicionando na ultima posicao

        if (raiz.get(posicao).getRight() != null) {
        //  System.out.println("Ponteiro Right ja existe na posicao " + posicao);
          adicionarNo(raiz.get(posicao).getRight(), data);
        } else {
        //  System.out.println("Criando Ponteiro Right na posicao " + posicao);
          ListaDEncadeada<No> temp = new ListaDEncadeada<>();

          raiz.get(posicao).setRight(temp);

          adicionarNo(temp, data);
        }
        return;
      }


      if (data < raiz.get(posicao+1).getData()) {

     //   System.out.println("Posicao entre " + raiz.get(posicao).getData() + " e " + 
       //  raiz.get(posicao+1).getData() );

        //Verificando se o Ponteiro existe
        if (raiz.get(posicao).getRight() != null && raiz.get(posicao+1).getLeft() != null) {
        //  System.out.println("Ponteiro Right ja existe na posicao " + posicao);
          adicionarNo(raiz.get(posicao).getRight(), data);

        } else {
        //  System.out.println("Criando Ponteiro Right na posicao " + posicao);
          ListaDEncadeada<No> temp = new ListaDEncadeada<>();

          raiz.get(posicao).setRight(temp);
          raiz.get(posicao+1).setLeft(temp);

          adicionarNo(temp, data);
        }

        //raiz.addAfter(new No(data), raiz.get(limiteSup-posicao));

      } else {
        pesquisarInserir(raiz, data, posicao, limiteSup);
      }

    } else {//Caso for igualsss
    //  System.out.println("Valor igual, adicionar depois do " + raiz.get(posicao).getData());
      //raiz.addAfter(new No(data), raiz.get((limiteSup-posicao)-1));

      if (posicao+1 == tamanhoMaximo) {//Adicionando na ultima posicao

        if (raiz.get(posicao).getRight() != null) {
       //   System.out.println("Ponteiro Right ja existe na posicao " + posicao);
          adicionarNo(raiz.get(posicao).getRight(), data);
        } else {
       //   System.out.println("Criando Ponteiro Right na posicao " + posicao);
          ListaDEncadeada<No> temp = new ListaDEncadeada<>();

          raiz.get(posicao).setRight(temp);

          adicionarNo(temp, data);
        }
        return;
      
      } else {
        //Verificando se o Ponteiro existe
        if (raiz.get(posicao).getRight() != null && raiz.get(posicao+1).getLeft() != null) {
      //    System.out.println("Ponteiro Right ja existe na posicao " + posicao);
          adicionarNo(raiz.get(posicao).getRight(), data);

        } else {
        //  System.out.println("Criando Ponteiro Right na posicao " + posicao);
          ListaDEncadeada<No> temp = new ListaDEncadeada<>();

          raiz.get(posicao).setRight(temp);
          raiz.get(posicao+1).setLeft(temp);

          adicionarNo(temp, data);
        }
          
      }
      
    }
  }

  private void adicionarNo(ListaDEncadeada<No> raiz, int data) {
    //Adicionando ate o NO ficar cheio
    if (raiz.size() < tamanhoMaximo) {
      //Adicionando o primeiro
      if (raiz.size() == 0) {
        raiz.add(new No(data));
        return;
      }
      if (data >= raiz.get(raiz.size()-1).getData()) {//Adicionar no proximo
        raiz.add(new No(data));
        return;
      } else {//Caso o numero a ser adicionado eh menor que o maior numero do NO
        buscaBinariaInserir(raiz, data, 0, raiz.size()-1);//Procurando posicao para adicionar
      } 
    } else {//Quando o NO NO estiver cheio, criar um novo No
      pesquisarInserir(raiz, data, 0, raiz.size()-1);
    }
  }


  public void remover(int data) {

    //Removendo o unico elemento do raiz
    if (raiz.size() == 1 && data == raiz.get(0).getData()) {

      if (raiz.get(0).getRight() != null) {
        raiz.get(0).setData(getMenorDosMaiores(raiz.get(0).getRight(), raiz, 0));
      } else if (raiz.get(0).getLeft() != null) {
        raiz.get(0).setData(getMenorDosMaiores(raiz.get(0).getLeft(), raiz, 0));
      } else {
        raiz.remove(raiz.get(0));
      }

      return;
    }

    //Busca binaria no No raiz
    buscaBinariaRemover(raiz, null, 0, data, 0, raiz.size()-1);
  }


  private void buscaBinariaRemover(ListaDEncadeada<No> raiz, ListaDEncadeada<No> preNo, int posicaoPreNo, int data, int limiteInf, int limiteSup) {

  //  System.out.println("PESQUISANDO PARA REMOVER O " + data);
    int variacao = (limiteSup-limiteInf)/2;
    int posicao = limiteSup-variacao;
   // System.out.println("posicao " + posicao);
    if (data < raiz.get(posicao).getData()) {//Caso for menor
     // System.out.println("Menor que " + raiz.get(posicao).getData());


      //Verificacao caso exista apenas 1 elemento
      if (posicao == 0) {
        //Pesquisar no Ponteiro Left
        if (raiz.get(posicao).getLeft() != null) {
         // System.out.println("Pesquisar no Ponteiro Left da posicao " + posicao);
          
          ListaDEncadeada<No> raizPesquisar = raiz.get(posicao).getLeft();
          buscaBinariaRemover(raizPesquisar, raiz, posicao, data, 0, (raizPesquisar.size()-1));

        } else {//Caso nao exista o Ponteiro, elemento nao encontrado
          System.out.println("Erro, elemento nao encontrado");
        }
        return;
      }


      if ((posicao) != 0 && data > raiz.get(posicao-1).getData()) {
       // System.out.println("Posicao entre " + raiz.get(posicao-1).getData() + " e " + 
        // raiz.get(posicao).getData() );

        //Verificar se o Ponteiro existe
        if (raiz.get(posicao-1).getRight() != null && raiz.get(posicao).getLeft() != null) {
         // System.out.println("Pesquisar no Ponteiro Right na posicao " + (posicao-1));

          ListaDEncadeada<No> raizPesquisar = raiz.get(posicao-1).getRight();
          buscaBinariaRemover(raizPesquisar, raiz, (posicao-1), data, 0, (raizPesquisar.size()-1));

        } else {//Caso o Ponteiro nao exista
          System.out.println("Erro, elemento nao encontrado");
        }

      } else if ((posicao-1) == 0 && data <= raiz.get(0).getData()) {

        //Verificando se eh igual
        if (data == raiz.get(posicao-1).getData()) {

          System.out.println("Valor igual, na posicao " + (posicao-1));

          //FUNCAO AQUI
          reOrganizar(raiz, posicao-1);



        } else {//Se nao for igual, eh menor, pesquisar no Ponteiro Left
         // System.out.println("Pesquisar no Ponteiro Left da posicao " + (posicao-1));

          //Verificando se o Ponteiro Left existe
          if (raiz.get(posicao-1).getLeft() != null) {
            ListaDEncadeada<No> raizPesquisar = raiz.get(posicao-1).getLeft();
            buscaBinariaRemover(raizPesquisar, raiz, (posicao-1), data, 0, (raizPesquisar.size()-1));

          } else {//Caso o Ponteiro nao exista
            System.out.println("Erro, elemento nao encontrado");
          }


        }

      } else {
        buscaBinariaRemover(raiz, preNo, posicaoPreNo, data, limiteInf, posicao);
      }
    


    } else if (data > raiz.get(posicao).getData()) {//Caso for maior
      //System.out.println("Maior que " + raiz.get(limiteSup).getData());

      //Verificar caso exista apenas 1 elemento
      if (posicao == 0) {
        //Verificar se o Ponteiro Right existe
        if (raiz.get(posicao).getRight() != null) {
        //  System.out.println("Pesquisar no Ponteiro Right da posicao " + posicao);

          ListaDEncadeada<No> raizPesquisar = raiz.get(posicao).getRight();
          buscaBinariaRemover(raizPesquisar, raiz, posicao, data, 0, (raizPesquisar.size()-1));

        } else {
          System.out.println("Erro, elemento nao encontrado");
        }
        return;
      }

      //Verificando se esta na ultima posicao
      if (posicao+1 == tamanhoMaximo) {
        //Verificar se o Ponteiro Right existe
        if (raiz.get(posicao).getRight() != null) {
        //  System.out.println("Pesquisar no Ponteiro Rigth da posicao " + posicao);

          ListaDEncadeada<No> raizPesquisar = raiz.get(posicao).getRight();
          buscaBinariaRemover(raizPesquisar, raiz, posicao, data, 0, (raizPesquisar.size()-1));

        } else {
          System.out.println("Erro, elemento nao encontrado");
        }
        return;
      }


      //Verificando se ele eh menor que o Proximo
      if (data < raiz.get(posicao+1).getData()) {
      //  System.out.println("Posicao entre " + raiz.get(posicao).getData() + " e " + 
        // raiz.get(posicao+1).getData() );

        //Verificar se o Ponteiro Right existe
        if (raiz.get(posicao).getRight() != null && raiz.get(posicao+1).getLeft() != null) {
        //  System.out.println("Pesquisar no Ponteiro Right da posicao " + posicao);

          ListaDEncadeada<No> raizPesquisar = raiz.get(posicao).getRight();
          buscaBinariaRemover(raizPesquisar, raiz, posicao, data, 0, (raizPesquisar.size()-1));

        } else {
          System.out.println("Erro, elemento nao encontrado");
        }

      } else {//Caso o data seja maior que o proximo
        buscaBinariaRemover(raiz, preNo, posicaoPreNo, data, posicao, limiteSup);
      }




    } else if (data == raiz.get(posicao).getData()) {//Caso for igual
      System.out.println("Valor igual, na posicao " + posicao);
      System.out.println("Removendo o valor " + data);


      //Verificar se so existe 1 elemento
      if (raiz.size() == 1) {

        if (preNo != null) {

          if (data >= preNo.get(posicaoPreNo).getData()) {//Verificar se o Data eh maior que o preNo


            if (raiz.get(0).getRight() != null) {//Verificando se tem o Ponteiro Right
              raiz.get(0).setData(getMenorDosMaiores(raiz.get(0).getRight(), raiz, 0));
            } else if (raiz.get(0).getLeft() != null) {//Verificando se tem o Ponteiro Left
              raiz.get(0).setData(getMenorDosMaiores(raiz.get(0).getLeft(), raiz, 0));
            } else {
              //Removendo o No
              if (posicaoPreNo+1 == tamanhoMaximo) {//Verificando se a Posicao eh a ultima
                preNo.get(posicaoPreNo).setRight(null);//Perdendo a referencia do Ponteiro Right
              } else {//Qualquer outro caso
                preNo.get(posicaoPreNo).setRight(null);//Perdendo a referencia do Ponteiro Right
                preNo.get(posicaoPreNo+1).setLeft(null);//Perdendo a referencia do Ponteiro Left
              }

            }
            


          } else {//Caso o Data for menor

            if (raiz.get(0).getRight() != null) {//Verificando se tem o Ponteiro Right
              raiz.get(0).setData(getMenorDosMaiores(raiz.get(0).getRight(), raiz, 0));
            } else if (raiz.get(0).getLeft() != null) {//Verificando se tem o Ponteiro Left
              raiz.get(0).setData(getMenorDosMaiores(raiz.get(0).getLeft(), raiz, 0));
            } else {
              //Removendo o No
              if (posicaoPreNo == 0) {//Verificando se a Posicao eh a primeira
                preNo.get(posicaoPreNo).setLeft(null);//Perdendo a referencia do Ponteiro Left
              } else {//Qualquer outro caso
                preNo.get(posicaoPreNo).setLeft(null);//Perdendo a referencia do Ponteiro Right
                preNo.get(posicaoPreNo-1).setRight(null);//Perdendo a referencia do Ponteiro Left
              }

            }


          }
          

        } else {//Caso existir mais de 1
          reOrganizar(raiz, posicao);
        }

      } else {//Caso existir mais de 1
        reOrganizar(raiz, posicao);
      }






    } else {//Caso o valor nao exista
      System.out.println("Erro, valor nao encontrado");
    }

  }//Fim BuscaBinariaRemover


  private void reOrganizar(ListaDEncadeada<No> raiz, int posicao) {
   // System.out.println("Re Organizando");

    if (raiz.get(posicao).getRight() != null) {
      raiz.get(posicao).setData(getMenorDosMaiores(raiz.get(posicao).getRight(), raiz, posicao));
    } else if (raiz.get(posicao).getLeft() != null) {
      raiz.get(posicao).setData(getMaiorDosMenores(raiz.get(posicao).getLeft(), raiz, posicao));
    } else {


      //Verificando se eh a ultima posicao
      if (posicao == raiz.size()-1) {

        for (int i=posicao; i>0;) {
          raiz.get(i).setData(raiz.get(--i).getData());
          if (raiz.get(i).getLeft() != null) {//Verificando se tem o Ponteiro Left
            raiz.get(i).setData(getMaiorDosMenores(raiz.get(i).getLeft(), raiz, i));
            break;
          }
          //Verificando se foi subtituido todos os valores
          if (i == 0) {
            raiz.remove(raiz.get(0));//Removendo a copia do primeiro
          }

        }//Fim for
        return;
      }
            
      //Caso No estiver completo
      if (raiz.size() == tamanhoMaximo) {

        for (int i=posicao; i<raiz.size()-1;) {
          raiz.get(i).setData(raiz.get(++i).getData());
          if (raiz.get(i).getRight() != null) {//Verificando se tem o Ponteiro Right
            raiz.get(i).setData(getMenorDosMaiores(raiz.get(i).getRight(), raiz, i));
            break;
          }
          //Verificando se  foi substituido todos os valores
          if (i == raiz.size()-1) {
            raiz.remove(raiz.get(raiz.size()-1));//Removendo a copia do ultimo
          }

        }//Fim for

        //Verificacao de seguranca
        if (raiz.size() != tamanhoMaximo) {

          for (int i=posicao; i>0;) {

            if (raiz.get(--posicao).getLeft() != null) {
              raiz.addBefore(new No(0), raiz.get(posicao));

              if (posicao == 0) {
                raiz.get(posicao).setRight(raiz.get(posicao+1).getLeft());
                raiz.get(posicao).setData(getMenorDosMaiores(raiz.get(posicao).getRight(), raiz, posicao));
                return;
              }

              raiz.get(posicao).setRight(raiz.get(posicao+1).getLeft());
              raiz.get(posicao-1).setRight(null);
              raiz.get(posicao).setData(getMenorDosMaiores(raiz.get(posicao).getRight(), raiz, posicao));
              return;
            }

          }

        }

      


      } else {//Caso nao esteja completo, apenas remove o Elemento que vai sair
        raiz.remove(raiz.get(posicao));
      }
            
    }

  }


  private int getMaiorDosMenores(ListaDEncadeada<No> raiz, ListaDEncadeada<No> preNo, int posicao) {
    
    if (raiz.get(raiz.size()-1).getRight() != null) {
      return getMaiorDosMenores(raiz.get(raiz.size()-1).getRight(), raiz, (raiz.size()-1));

    } else {
   //   System.out.println("Maior valor na posicao " + (raiz.size()-1));

      int data = raiz.get(raiz.size()-1).getData();

      //Verificar se o Ponteiro Left existe
      if (raiz.get(raiz.size()-1).getLeft() != null) {
        raiz.get(raiz.size()-1).setData(getMaiorDosMenores(raiz.get(raiz.size()-1).getLeft(), raiz, (raiz.size()-1)));
      
      } else {

        //Caso o No so tenho um Elemento
        if (raiz.size() == 1) {

          if (data >= preNo.get(posicao).getData()) {//Verificar se o Data eh maior que o preNo

            if (posicao+1 == tamanhoMaximo) {//Verificando se a Posicao eh a ultima
              preNo.get(posicao).setRight(null);//Perdendo a referencia do Ponteiro Right
            } else {//Qualquer outro caso
              preNo.get(posicao).setRight(null);//Perdendo a referencia do Ponteiro Right
              preNo.get(posicao+1).setLeft(null);//Perdendo a referencia do Ponteiro Left
            }


          } else {//Caso o Data for menor

            if (posicao == 0) {//Verificando se a Posicao eh a primeira
              preNo.get(posicao).setLeft(null);//Perdendo a referencia do Ponteiro Left
            } else {//Qualquer outro caso
              preNo.get(posicao).setLeft(null);//Perdendo a referencia do Ponteiro Right
              preNo.get(posicao-1).setRight(null);//Perdendo a referencia do Ponteiro Left
            }

          }


        }  else {//Caso tiver mais de 1 Elemento
          reOrganizar(raiz, (raiz.size()-1));
        }


      }


    

      return data;
    }
    
  }


  private int getMenorDosMaiores(ListaDEncadeada<No> raiz, ListaDEncadeada<No> preNo, int posicao) {
    
    //Verificando se o Ponteiro da Left existe
    if (raiz.get(0).getLeft() != null) {
      return getMenorDosMaiores(raiz.get(0).getLeft(), raiz, 0);

    } else {//O menor valor eh o da Primeira Posicao
      //System.out.println("Menor valor na posicao 0");

      int data = raiz.get(0).getData();

      //Verifiando se o Ponteiro Right existe para colocar no lugar da posicao 1
      if (raiz.get(0).getRight() != null) {
        raiz.get(0).setData(getMenorDosMaiores(raiz.get(0).getRight(), raiz, 0));

      } else {//Caso o Ponteiro Right nao exista

        //Caso o No so tenho um Elemento
        if (raiz.size() == 1) {
          //O No raiz deve perder a referencia desse No

          if (data >= preNo.get(posicao).getData()) {//Verificar se o Data e maior que o preNo


            if (posicao+1 == tamanhoMaximo) {//Verificando se a Posicao eh a ultima
              preNo.get(posicao).setRight(null);//Perdendo a referencia do Ponteiro Right
            } else {//Qualquer outro caso
              preNo.get(posicao).setRight(null);//Perdendo a referencia do Ponteiro Right
              preNo.get(posicao+1).setLeft(null);//Perdendo a referencia do Ponteiro Left
            }


          } else {//Caso o Data for menor que o preNo


            if (posicao == 0) {//Verificando se a Posicao eh a primeira
              preNo.get(posicao).setLeft(null);//Perdendo a referencia do Ponteiro Left
            } else {//Qualquer outro caso
              preNo.get(posicao).setLeft(null);//Perdendo a referencia do Ponteiro Right
              preNo.get(posicao-1).setRight(null);//Perdendo a referencia do Ponteiro Left
            }


          }


        } else {//Caso o No tenha mais de 1 elemento

          reOrganizar(raiz, 0);

          /*
          //Caso No estiver completo
          if (raiz.size() == tamanhoMaximo) {

            for (int i=0; i<raiz.size()-1;) {
              raiz.get(i).setData(raiz.get(++i).getData());
              if (raiz.get(i).getRight() != null) {//Verificando se tem o Ponteiro Right
                raiz.get(i).setData(getMenorDosMaiores(raiz.get(i).getRight(), raiz, i));
                break;
              }
            }//Fim for

          } else {//Caso nao esteja completo, apenas remove o Elemento que vai sair
            raiz.remove(raiz.get(0));
          }
          */

        }

        
      }//Fim caso o Ponteiro Right nao exista





      return data;
    }


  }

  public void emOrdem(ListaDEncadeada<No> raiz) {

    if (raiz != null) {

      for (int i=0; i<raiz.size(); i++) {

        if (i == 0) {
          emOrdem(raiz.get(i).getLeft());
        }

        System.out.println(raiz.get(i).getData());

        emOrdem(raiz.get(i).getRight());

      }

    }

  }

  
  public void imprimirLargura() {
    FilaEncadeada<ListaDEncadeada<No>> nivelAtual = new FilaEncadeada<>();
    FilaEncadeada<ListaDEncadeada<No>> proximoNivel = new FilaEncadeada<>();

    if (raiz.isEmpty()) {
      System.out.println("Arvore vazia");
      return;
    }

    nivelAtual.add(raiz);

    while (!nivelAtual.isEmpty()) {
      ListaDEncadeada<No> temp = nivelAtual.get();

      System.out.print("(");
      for (int i=0; i<temp.size(); i++) {

        if (i==0) {
          if (temp.get(i).getLeft() != null) {
            //System.out.print("Ponteiro existe ");
            proximoNivel.add(temp.get(i).getLeft());
          }
        }

        System.out.print(temp.get(i).getData() + " ");

        if (temp.get(i).getRight() != null) {
          //System.out.println(temp.get(i));
          proximoNivel.add(temp.get(i).getRight());
        }

      }
      System.out.print(")");

      if (nivelAtual.isEmpty()) {
        System.out.println("");
        nivelAtual = proximoNivel;
        proximoNivel = new FilaEncadeada<>();
      }


    }//Fim while

  }//Fim Imprimir


}//Fim class