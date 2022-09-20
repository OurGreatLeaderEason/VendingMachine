// File header comes Here
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   Tester for VendingMachine class
// Course:   CS 300 Fall 2022
//
// Author:   Eason Xiao
// Email:    ( xiao227@wisc.edu email address)
// Lecturer: (Jeff Nyhoff)
//
// Below is a javadoc class header to complete
/**
 * A program that simulates many utilities of the real life vending machine
 * 
 * @Eason Xiao
 *
 */
public class VendingMachine {

  /**
   * Adds/appends an item defined by its description and expirationDate to a vending machine
   * represented by an oversize array of strings defined by the two-dimensional array items and its
   * size itemsCount. The item will be added to the end of the array. If the vending machine is
   * full, the new item won't be added and the method returns the items count passed as input
   * without making any changes to the contents of the array items.
   * 
   * @param description    description of the item to be added to the vending machine
   * @param expirationDate a string parsable to a positive integer which represents the expiration
   *                       date of the item. The date "0" represents January 1st 2023.
   * @param items          a two-dimensional of strings storing items. items[i][0] and items[i][1]
   *                       respectively represent the description and the expiration date of the
   *                       item stored at index i
   * @param itemsCount     number of items in the vending machine
   * @return the size of the vending machine after trying to add the new item
   */
  public static int addItem(String description, String expirationDate, String[][] items,
      int itemsCount) {
    if (itemsCount<items.length){
      int count=0;
      while (items[count]!=null){
        count++;
      }
      items[count]=new String[]{description, expirationDate};
      return itemsCount+1;
    }
    
    // Note that we suppose that the expirationDate is valid, meaning it is correctly
    // parsable to a positive integer
    return itemsCount; // default return statement added to avoid compiler errors. Feel free to change it.
  }

  /**
   * Returns without removing a string representation of the item at the given index within the
   * vending machine defined by the array items and its size itemsCount. This method does not make
   * any changes to the contents of the vending machine.
   * 
   * @param items      two dimensional array storing items within a vending machine where
   *                   items[i][0] represents the description of the item at index i and items[i][1]
   *                   stores its expiration date.
   * @param itemsCount (size) number of items stored in the vending machine
   * @param index      index of an item within the provided vending machine
   * @return a string representation of the item stored at the given index within the vending
   *         machine defined by items and itemsCount. The returned string must have the following
   *         format: "description (expiration date)". If the provided index is out of the range of
   *         indexes 0..itemsCount-1, the method returns "ERROR INVALID INDEX"
   */
  public static String getItemAtIndex(int index, String[][] items, int itemsCount) {
    if (index>=0 && index<itemsCount){
        String[] item=items[index];
        return item[0]+" "+"("+item[1]+")";
    }
    return "ERROR INVALID INDEX"; // default return statement added to avoid compiler errors. Feel free to change it.
  }

  /**
   * Returns without removing the index of the item having the provided description and the smallest
   * expiration date within the vending machine defined by the array items and its size itemsCount.
   * 
   * @param description description of the item to get its index
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return the index of the next item, meaning the item with the given description and the
   *         smallest expiration date. If no match found, return -1.
   */
  public static int getIndexNextItem(String description, String[][] items, int itemsCount) {
    int count=0; 
    for (int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)){
            count++;
        }
    }
    //Case 1: no duplicates
    if (count==1){
      int index=0;
      while (!items[index][0].equals(description)){
        index++;
      }
      return index;
    }
    //Case 2: unknown number of duplicates
    if (count>1){
      String[][] duplicateIndex=new String[count][3];
      int counter=0;
      for(int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)){
          duplicateIndex[counter][0]=Integer.toString(i);
          duplicateIndex[counter][1]=description;
          duplicateIndex[counter][2]=items[i][1];
          counter++;
        }
      }
      int minValue=Integer.MAX_VALUE;
      for (int i=0; i<duplicateIndex.length; i++){
        if (minValue>Integer.parseInt(duplicateIndex[i][2])){
          minValue=Integer.parseInt(duplicateIndex[i][2]);
        }
      }
      String minVal=Integer.toString(minValue);
      for (int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)&&items[i][1].equals(minVal)){
          return i;
        }
      }
    }
    
    // If the vending machine contains more than one item with the given description,
    // return the index o the one with the smallest expiration date.
    //
    return -1; // Case 3: the specified description does not exist
    //Scenario 7, press and hold overtake
  }

  /**
   * Removes the item having the provided description with the smallest expiration date within the
   * vending machine defined by the array items and its size itemsCount. This method should maintain
   * the order of precedence of items in the vending machine. This means that the remove operation
   * involves a shift operation.
   * 
   * @param description description of the item to remove or dispense
   * @param items       array storing items within a vending machine
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return size of the vending machine after removing the item with the given description and the
   *         smallest expiration date. If no match found, this method must return the provided 
   *         itemsCount without making any change to the contents of the vending machine.
   */
  public static int removeNextItem(String description, String[][] items, int itemsCount) {
    int count=0; 
    for (int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)){
            count++;
        }
    }
    if (count==1){
      int nullIndex=0;
      for (int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)){
          items[i]=null;
          nullIndex=i;
        }
      }
      for (int i=nullIndex; i<itemsCount-1; i++){
        items[i]=items[i+1];
        items[i+1]=null;
      }
      return itemsCount-1;
    }
    if (count>1){
      String[][] duplicateIndex=new String[count][3];
      int counter=0;
      for(int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)){
          duplicateIndex[counter][0]=Integer.toString(i);
          duplicateIndex[counter][1]=description;
          duplicateIndex[counter][2]=items[i][1];
          counter++;
        }
      }
      int minValue=Integer.MAX_VALUE;
      for (int i=0; i<duplicateIndex.length; i++){
        if (minValue>Integer.parseInt(duplicateIndex[i][2])){
          minValue=Integer.parseInt(duplicateIndex[i][2]);
        }
      }
      String minVal=Integer.toString(minValue);
      int nullIndex=0;
      for (int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)&&items[i][1].equals(minVal)){
          nullIndex=i;
        }
      }
      items[nullIndex]=null;
      for (int i=nullIndex; i<itemsCount-1; i++){
        items[i]=items[i+1];
        items[i+1]=null;
      }
      return itemsCount-1;
    }
    return itemsCount; 
  }

  /**
   * Returns the number of occurrences of an item with a given description within the vending
   * machine defined by items and itemsCount
   * 
   * @param description description (name) of an item
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return the number of occurrences of an item with a given description within the vending
   *         machine
   */
  public static int getItemOccurrences(String description, String[][] items, int itemsCount) {
    int count=0; 
    for (int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)){
            count++;
        }
    }
    return count; // default return statement added to avoid compiler errors. Feel free to change it.
  }

  /**
   * Checks whether a vending machine defined by the array items and its size itemsCount contains at
   * least an item with the provided description
   * 
   * @param description description (name) of an item to search
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return true if there is a match with description in the vending machine, false otherwise
   */
  public static boolean containsItem(String description, String[][] items, int itemsCount) {
    int count=0; 
    for (int i=0; i<itemsCount; i++){
        if (items[i][0].equals(description)){
            count++;
        }
    }
    if (count>0){
      return true;
    }
    return false; // default return statement added to avoid compiler errors. Feel free to change
                  // it.
  }

  /**
   * Returns the number of items in the vending machine with a specific description and whose
   * expiration dates are greater or equal to a specific expiration date
   * 
   * @param description    description of the item to find its number of occurrences
   * @param expirationDate specific (earliest) expiration date
   * @param items          two dimensional array storing items within a vending machine where
   *                       items[i][0] represents the description of the item at index i and
   *                       items[i][1] stores its expiration date.
   * @param itemsCount     (size) number of items stored in the vending machine
   * @return the number of items with a specific description and whose expiration date is greater or
   *         equal to the given one
   */
  public static int getItemsOccurrencesByExpirationDate(String description, String expirationDate,
      String[][] items, int itemsCount) {
        int count=0; 
        for (int i=0; i<itemsCount; i++){
            if (items[i][1].equals(expirationDate)){
                count++;
            }
        }
    return count; // default return statement added to avoid compiler errors. Feel free to change it.
  }

   
   
  public static String getItemsSummary(String[][] items, int itemsCount) {
    if (itemsCount==0){
      return "";
    }
    String[] descOnly=new String[itemsCount];
      for (int i=0; i<itemsCount; i++){
        descOnly[i]=items[i][0];
      }
      int counter=0;
      int count=0;
      for(int i=0; i<descOnly.length; i++){
        counter=0;
        for(int j=i-1; j>=0; j--){
          if(descOnly[i].equals(descOnly[j])){
            counter++;
          }
        }
        if (counter==0){
          count++;
        }
      }
      String[][] uniqueItems=new String[count][2];
      for (int i=0; i<uniqueItems.length; i++){
        uniqueItems[i]=new String[]{"", "0"};
      }
      int pos=0;
      for (int i=0; i<descOnly.length; i++){
        boolean inUniqueItems=false;
        for (int j=0; j<uniqueItems.length; j++){
          if (uniqueItems[j][0].equals(descOnly[i])){
            inUniqueItems=true;
            uniqueItems[j][1]=Integer.toString(Integer.parseInt(uniqueItems[j][1])+1);
          }
        }
        if (!inUniqueItems){
          uniqueItems[pos][0]=descOnly[i];
          uniqueItems[pos][1]="1";
          pos++;
        }
      }
      String sum="";
      for (int i=0; i<uniqueItems.length; i++){
        sum+="\n"+uniqueItems[i][0]+" ("+uniqueItems[i][1]+")";
      }
      return sum;
  }

}