import java.util.concurrent.ThreadLocalRandom;

public class Liste {
  
  private int[] array;
  
  public Liste(int laenge) {
    this.array = new int[laenge];
  }
  
  public int[] getListe() {
    return this.array;
  }

  
  public void randomize() {
    for (int i = 0; i < array.length; i++) {
      array[i] = getRandomInt(0, 100);
    }
  }
    
 
  // sorting algorithms
  public void bubbleSort() {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if(array[i] < array[j]) swap(i,j);
      }
    }
  }
  
  public void insertionSort() {
    for (int i = 1; i < array.length; i++) {
      int val = array[i];
      int j = i;
      while (j > 0 && array[j - 1] > val) {
        array[j] = array[j - 1];
        j--;
      }
      array[j] = val;

    }
    
  }
  
  // utility
  private int getRandomInt(int min, int max) {
    // https://stackoverflow.com/a/363692
    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }
  
  private void swap(int a, int b) {
    int store = array[a];
    array[a] = array[b];
    array[b] = store;
  }


}

