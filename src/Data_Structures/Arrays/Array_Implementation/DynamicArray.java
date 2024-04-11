package Data_Structures.Arrays.Array_Implementation;

/* Implementation of our own Dynamic Array Data Structure */

public class DynamicArray<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private  Object[] array;
  private int size;


  public DynamicArray(){
    array = new Object[DEFAULT_CAPACITY];
    size = 0;
  }

  public DynamicArray(int initialCapacity)
  {
    if(initialCapacity < 0){
      throw new IllegalArgumentException("Illegal capacity: " + initialCapacity );
    }
    array = new Object[initialCapacity];
    size = 0;
  }
  public int size()
  {
    return size;
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  public void add(T item)
  {
    if(size == array.length)
    {
      increaseCapacity();
    }
    array[size++] = item;
  }

  public void add(int index, T item)
  {
    if(index < 0 || index >= size)
    {
      throw new IndexOutOfBoundsException("Invalid index: " + index);
    }
    if(size == array.length)
    {
      increaseCapacity();
    }
    shiftRight(index);
    array[index] = item;
    size++;
  }

  public void remove(int index)
  {
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Invalid index: " + index);
    }
    shiftLeft(index);
    array[--size] = null;
  }

  @SuppressWarnings("unchecked")
  public T get(int index)
  {
    if(index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Invalid index: " + index);
    }
    return (T) array[index];
  }


  private void increaseCapacity()
  {
    int newCapacity = array.length * 2;
    Object[] newArray = new Object[newCapacity];
    System.arraycopy(array, 0, newArray, 0,size);
    array = newArray;
  }

  private void shiftRight(int index)
  {
    for(int i = size; i > index; i--)
    {
      array[i] = array[i - 1];
    }
  }

  private void shiftLeft(int index)
  {
    for(int i = index; i < size - 1; i++)
    {
      array[i] = array[i + 1];
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < size; i++) {
      sb.append(array[i]);
      if (i < size - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }


  public static void main(String[] args) {
    DynamicArray<Integer> list  = new DynamicArray<>();

    // Adding elements
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    // Printing the list
    System.out.println("List: " + list);

    // Adding an element at a specific position
    list.add(2, 10);

    // Printing the list after addition
    System.out.println("List after addition: " + list);

    // Getting an element
    System.out.println("Element at position 2: " + list.get(2));

    // Removing an element
    list.remove(3);

    // Printing the list after removal
    System.out.println("List after removal: " + list);

    // Checking the size and if the list is empty
    System.out.println("Size of the list: " + list.size());
    System.out.println("Is the list empty? " + list.isEmpty());

  }

}
