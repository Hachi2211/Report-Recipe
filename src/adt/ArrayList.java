package adt;

import java.util.Comparator;


/**
 *
 * @author lihock
 * @param <T>
 */
public class ArrayList<T extends Comparable<T>> implements ListInterface<T> {
    
    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 30;
    private int pivotIndex;

    public ArrayList() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        pivotIndex=0;
        numberOfEntries=0;
    }

    public ArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Comparable[initialCapacity];
        pivotIndex=0;
    }
    @Override
    public ListInterface<T> copy(){
        ListInterface<T> copiedList = new ArrayList<>(numberOfEntries);
        for (int i = 0; i < numberOfEntries; i++) {
            copiedList.add(array[i]);
        }
        return copiedList;      
    }
    @Override
    public boolean add(T newEntry) {
        boolean isSuccessful=true;
        if(!isFull()){
            array[numberOfEntries]= newEntry;
            numberOfEntries++;
        }
        else {
             doubleArray();
             add(newEntry);
        }
        return isSuccessful;
    }
    @Override
    public boolean addMany(ListInterface<T> entries){
        boolean isSuccessful=true;
        for(int i=1;i<=entries.getNumberOfEntries()&&isSuccessful;i++){
            isSuccessful=add(entries.getItem(i));
        }
        return isSuccessful;
    }
    @Override
    public boolean add(T newEntry, int position) {
        boolean isSuccessful=true;
        //postion start from 1
        if(!isFull()&& position>=1 && position<=numberOfEntries+1){
            makeRoom(position);
            array[position-1]=newEntry;
            numberOfEntries++;
        }
        else {
             doubleArray();
             add(newEntry,position);
        }
        return isSuccessful;
    }
    @Override
    public ListInterface<T> removeAnother(ListInterface<T> entries){
    ListInterface<T> list=new ArrayList<>(numberOfEntries);
    for (int i = 0; i < numberOfEntries; i++) {
        for (int j = 1; j <= entries.getNumberOfEntries(); j++) {
            if (array[i] != null && array[i].equals(entries.getItem(j))) {
                removeGap(i+1);
                numberOfEntries--;
            }
        }
        list=this;
    }
    return list;
    }
    @Override
    public T remove(int givenPosition) {
        T result=null;
        if(givenPosition>=1 && givenPosition<=numberOfEntries){
            result=array[givenPosition-1];
            array[givenPosition-1]=null;
            if(givenPosition<numberOfEntries)
            removeGap(givenPosition);        
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public void clear() {
        for(int i=0;i<numberOfEntries;i++)
            array[i]=null;
        numberOfEntries=0;
    }

    @Override
    public T getItem(int givenPosition) {
        T item=null;
        if(givenPosition>=1 && givenPosition<=numberOfEntries)
            item=array[givenPosition-1];
        return item;
    }
    
    @Override
    public ListInterface<T> searchObjByAttrib (T targetObject, Comparator comparator) {
        ArrayList<T> result = new ArrayList();
        T currentObject = null;
        
        for(int i=0;i<numberOfEntries;i++){
            currentObject = array[i];
            if (comparator.compare(currentObject, targetObject) == 0) {
                result.add(currentObject);
            } else if (comparator.compare(currentObject, targetObject) > 0) {
                //since list is sorted before search, stop traversing if the next object is greater than target object
                break;
            }
        }
        return result;
    }
    
    @Override
    public T searchFirstObjByAttrib (T targetObject, Comparator comparator) {
        T currentObject = null;
        T result = null;
        
        for(int i=0;i<numberOfEntries;i++){
            currentObject = array[i];
            if (comparator.compare(currentObject, targetObject) == 0) {
                result = currentObject;
            } else if (comparator.compare(currentObject, targetObject) > 0) {
                //since list is sorted before search, stop traversing if the next object is greater than target object
                break;
            }
        }
        return result;
    }
    
    @Override
    public int searchObjIndexByAttrib (T targetObject, Comparator comparator) {
        T currentObject = null;
        for(int i=0;i<numberOfEntries;i++){
            currentObject = array[i];
            if (comparator.compare(currentObject, targetObject) == 0) {
                return i;
            } else if (comparator.compare(currentObject, targetObject) > 0) {
                break;
            }
        }
        //if not found, return -1
        return -1;
    }
    
    @Override
    public T searchFirst(T criteria) {
        T item=null;
        for(int i=0;i<numberOfEntries;i++){
            if(array[i].equals(criteria))
                item=array[i];
        }
        return item;
    }
    
    @Override
    public int indexOf(T item) {
        int index = -1; // Initialize index to -1, indicating item not found
        if (this.contains(item)) {
            index = 0;
            while (!array[index].equals(item) && index < numberOfEntries) {
                index++;
            }
        }
        return index;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful=true;
        if(givenPosition>=1 && givenPosition<=numberOfEntries){
            array[givenPosition-1]=newEntry;
        }
        else
            isSuccessful=false;
        return isSuccessful;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
         return numberOfEntries == array.length;
    }

    @Override
    public boolean bubbleSort() {
        //buble sort
        boolean isSuccessful=true;
        if(numberOfEntries>0)
         for (int i = 0; i < numberOfEntries - 1; i++) {
            for (int j = 0; j < numberOfEntries - i - 1; j++) {
                // Compare adjacent elements and swap if necessary
                if (((Comparable<T>) array[j]).compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
         }
        else
            isSuccessful=false;
         return isSuccessful;
    }

    //quick sort
    @Override
    public void quickSort(int first,int last) {  
        if (first < last) {
           partition(first, last);
           quickSort(first, pivotIndex-1);
           quickSort(pivotIndex+1, last);
        }
    }
    private void partition(int first, int last) {
        T pivot = array[first];
        int lastS1 = first;
        for (int firstUnknown = first + 1; firstUnknown <= last; ++firstUnknown) {
            if (array[firstUnknown].compareTo(pivot) < 0) {
                ++lastS1;
                swap(firstUnknown, lastS1);
            }
        }
        swap(first, lastS1);
        pivotIndex=lastS1;
    }
    private void swap(int first, int last){
        T temp;
        temp=array[first];
        array[first]=array[last];
        array[last]=temp;
    }
    
    @Override
    public void quickSortByAttrib(int first,int last, Comparator comparator) {  
        if (first < last) {
           partitionByAttrib(first, last, comparator);
           quickSortByAttrib(first, pivotIndex-1, comparator);
           quickSortByAttrib(pivotIndex+1, last, comparator);
        }
    }
    private void partitionByAttrib(int first, int last, Comparator comparator) {
        T pivot = array[first];
        T currentItem = null;
        int currentLast = first;
        for (int currentKey = first + 1; currentKey <= last; ++currentKey) {
            currentItem = array[currentKey];
            if (comparator.compare(currentItem,pivot) < 0) {
                ++currentLast;
                swap(currentKey, currentLast);
            }
        }
        swap(first, currentLast);
        pivotIndex=currentLast;
    }
    
    
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries)&&anEntry!=null; index++) {
            if (anEntry.equals(array[index])) {
              found = true;
            }
        }
        return found;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }
    
    public void makeRoom(int position){
        for(int index=numberOfEntries-1;index<position-1;index--){
            array[index+1]=array[index];
        }
    }
    
    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }
        return outputStr;
    }

    public void removeGap(int givenPosition){
        int removedIndex=givenPosition-1;
        int lastIndex=numberOfEntries-1;
        //move 1 step forward
        for(int index=removedIndex;index<lastIndex;index++)
            array[index]=array[index+1];
        array[lastIndex]=null;// free the lastIndex memory
    }
    
      private void doubleArray() {
       T[] oldArray =array;
       array = (T[])new Comparable[2*oldArray.length];//double array
       
       //loop to copy old array to the new doubled array
       for(int i=0;i<oldArray.length;i++){
           array[i]=oldArray[i];
       }
    }
}