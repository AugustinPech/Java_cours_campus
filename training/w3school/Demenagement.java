package training.w3school;
public class Demenagement {
      public static void print1D(int mat[])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)
                System.out.print(mat[i] + " ");
    }
  public static void main(String[] args){
  int nbcolis=34; //nombre de colis
  int truckl=9;
  int[] stock = new int[nbcolis];

  for ( int i=0; i<nbcolis; i++) {
  stock[i]=i+1;
  }

  int[] truck = new int[truckl];
  int[] land = new int[nbcolis];

  int i=0;
  while (i<(nbcolis)) {
  int j=0;
  while  (j<(truckl) && stock[nbcolis-1] !=0) {
    truck[j] = stock[i+j];
    stock[i+j]=0;
    System.out.println("j= " + j + "i= " + i);
    j++;
  }
  int k=0;
  while (k<(truckl) && land[nbcolis-1] ==0) {
    land[i+k]=truck[k];
    truck[k]=0;
    k++;
    System.out.println("k= " + k + "i= " + i);
  }
  i=i+truckl;
  }

  System.out.println ("s  |  l  |  t");
  System.out.println ("----------------");
  for (int j=0; j<stock.length; j++) {
    if (j<truck.length) {
      System.out.print(stock[j] + "  |  " + land[j]+ "  |  ");
      System.out.println(truck[j]);
    } else {
      System.out.println(stock[j] + "  |  " + land[j]+ "  |  ");
    }
  }
}
}
