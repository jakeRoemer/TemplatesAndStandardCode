package dataStructures;

//Implementing a list with an array is so that a new object is not
//created or destroyed when modifying the list
//In other words, this is a wrapper that will treat an array with the same operations as a list,
//but will not grow or shrink to avoid creating and destroying new objects during use
//TODO: make abstract, only works with integers for now
public class ListAsArray {
  
  private static int [] array;
  private static int length = 0;
  private static int tailIndex = 0;
  
  public ListAsArray (int size) {
	  array = new int[size];
  }
  
  public int size() {
	if (length < 0) {
		System.out.println("error");
	}
    return length;
  }
  
  public boolean isEmpty() {
    return length == 0;
  }
  
  public int indexOf (int i) {
    int index = 0;
    for (int k = 0; k < array.length; k++) {
      if (array[k] == i) {
        return index;
      }
      index++; //stack for thread scheduling techniques
    }
    return -1;
  }
  
  public boolean contains (int i) {
    return indexOf(i) != -1;
  }
  
  public void add (int i) {
    array[tailIndex] = i;
    tailIndex++;
    length++;
  }
  
  public void add (int index, int val) {
	int start = tailIndex;
	if (tailIndex == array.length) {
		start--;
		tailIndex--;
		length--;
	}
    for (int i = start-1; i >= index; i--) {
      array[i+1] = array[i]; 
    }
    array[index] = val;
    tailIndex++;
    length++;
  }
  
  public void remove (int index) {
    for (int i = index; i < tailIndex-1; i++) {
    	array[i] = array[i+1]; 
    }
    tailIndex--;
    length--;
  }
  
  public int get (int index) {
	  return array[index];
  }
  
  public String toString() {
	  String s = "[";
	  if (isEmpty()) {
		  return s += "]";
	  }
	  for (int i = 0; i < length-1; i++) {
		  s += array[i] + ", ";
	  }
	  s += array[length-1] + "]";
	  return s;
  }
}