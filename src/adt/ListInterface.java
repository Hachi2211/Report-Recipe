package adt;

import java.util.Comparator;

/**
 *
 * @author lihock
 */
public interface ListInterface<T extends Comparable<T>>{
  public ListInterface<T> copy();
  public boolean add(T newEntry);
  public boolean addMany (ListInterface<T> entries);
  public boolean add(T newEntry,int position);
  public T remove(int givenPosition);
  public ListInterface<T> removeAnother(ListInterface<T> entries);
  public void clear();
  public T getItem(int givenPosition);
  public T searchFirst(T criteria);
  public T searchFirstObjByAttrib (T targetObject, Comparator comparator);
  public int indexOf(T item);
  public boolean replace(int givenPosition, T newEntry); 
  public boolean isEmpty();
  public boolean isFull();
  public void quickSort(int first, int last);
  public boolean bubbleSort();
  public boolean contains(T anEntry);
  public int getNumberOfEntries();
  public ListInterface<T> searchObjByAttrib (T targetObject, Comparator comparator);
  public int searchObjIndexByAttrib (T targetObject, Comparator comparator);
  public void quickSortByAttrib(int first,int last, Comparator comparator);
}