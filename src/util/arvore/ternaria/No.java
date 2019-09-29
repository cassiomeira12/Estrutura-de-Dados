package util.arvore.ternaria;


public class No {

  private No left;//Ponteiro para o No da Esquerda
  private No center;//Ponteiro para o No do Centro
  private No right;//Ponteiro para o No da Direita

  private Integer data1;//Primiero conteudo
  private Integer data2;//Segundo conteudo


  public No() {
    this.left = null;
    this.center = null;
    this.right = null;
    this.data1 = null;
    this.data2 = null;
  }

  public void inserir(int data) {
    
    if (data1 != null) {//Verificando se tem valor no Data1
      
      if (data < data1) {
        this.setData2(data1);
        this.setData1(data);
        System.out.println("Invertendo Datas");
      } else {
        this.setData2(data);
      }

    } else {//Adicionando primeiro valor
      this.setData1(data);
    }

  }



  public boolean isLeaf() {
    return (left == null && center == null && right == null);
  }

  public boolean isFull() {
    return (data1 != null && data2 != null);
  }




  public void setLeft(No left) {
    this.left = left;
  }

  public No getLeft() {
    return left;
  }

  public void setCenter(No center) {
    this.center = center;
  }

  public No getCenter() {
    return center;
  }

  public void setRight(No right) {
    this.right = right;
  }

  public No getRight() {
    return right;
  }

  public void setData1(Integer data1) {
    this.data1 = data1;
  }

  public Integer getData1() {
    return data1;
  }

  public void setData2(Integer data2) {
    this.data2 = data2;
  }

  public Integer getData2() {
    return data2;
  }


}