/***********************************************************************
* Autor: Cassio Meira Silva
* Matricula: 201610373
* Inicio: --/--/--
* Ultima alteracao: --/--/--
* Nome: Principal
* Funcao: 
***********************************************************************/

import util.arvore.n_aria.*;
import util.lista.*;

public class Principal {

  public static void main(String[] args) {


    ArvoreNAria a = new ArvoreNAria(3);

    a.inserir(20);
    a.inserir(40);
    a.inserir(10);
    a.inserir(15);
    a.inserir(5);
    a.inserir(6);
    a.inserir(8);
    a.inserir(9);
    a.inserir(7);
    a.inserir(20);
    a.inserir(30);
    a.inserir(25);
    a.inserir(35);
    a.inserir(38);
    a.inserir(48);
    a.inserir(50);
    a.inserir(45);
    a.inserir(46);
    a.inserir(43);

    a.remover(5);

    a.imprimirLargura();

  }

}//Fim class
