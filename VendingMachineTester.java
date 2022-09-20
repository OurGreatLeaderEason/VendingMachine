//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   Tester for VendingMachine class
// Course:   CS 300 Fall 2022
//
// Author:   Eason Xiao
// Email:    ( xiao227@wisc.edu email address)
// Lecturer: (Jeff Nyhoff)
//

import java.util.Arrays;

// Javadoc style class header comes here
public class VendingMachineTester {

  

  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  /**
   * Checks the correctness of getIndexNextItem defined in the VendingMachine class.
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of containsItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  /**
   * Checks the correctness of containsItem defined in the VendingMachine class
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and 
    String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;
    if (!VendingMachine.containsItem("Water", items, itemsCount)){
      System.out.println(
            "testContainsItem-scenario 1. Problem detected: Your testContainsItem did not "
                + "return the correct boolean value.");
      return false;
    }
    //(2) unsuccessful
    if (VendingMachine.containsItem("Master Ball", items, itemsCount)){
      System.out.println(
            "testContainsItem-scenario 2. Problem detected: Your testContainsItem did not "
                + "return the correct boolean value.");
      return false;
    
    // search returning false.
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
                  // Feel free to change it.
  }

  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  /**
   * Checks the correctness of getItemAtIndex defined in the VendingMachine class.
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetItemAtIndex() {
    // Define at least two test scenarios: 
    //(1) the provided index is out of the range 0..itemsCount-1,
    
    String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    int itemsCount=7;
    if (!VendingMachine.getItemAtIndex(69, items, itemsCount).equals("ERROR INVALID INDEX")){
        System.out.println(
            "testgetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did not return "
                + "ERROR INVALID INDEX when no match found.");
        return false;
    }
    String[][] originalItems=new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if (!Arrays.deepEquals(items, originalItems)){
        System.out.println(
            "testgetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did make "
                + "changes to the content of the array passed as input.");
    }
    //(2) the provided index is in bounds [0..itemsCount-1].
    items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    itemsCount=7;
    if (!VendingMachine.getItemAtIndex(3, items, itemsCount).equals("Water (5)")){
        System.out.println(
            "testgetItemAtIndex-scenario 2. Problem detected: Your getItemAtIndex did not return "
                + "the item at the given index.");
        return false;
    }
    originalItems=new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if (!Arrays.deepEquals(items, originalItems)){
        System.out.println(
            "testgetItemAtIndex-scenario 2. Problem detected: Your getItemAtIndex did make "
                + "changes to the content of the array passed as input.");
    }
    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.

    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  /**
   * Checks the correctness of getItemOccurrences defined in the VendingMachine class.
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    int itemsCount=7;
    if (VendingMachine.getItemOccurrences("Potion", items, itemsCount)!=0){
      System.out.println(
            "testGetItemsOccurrences-scenario 1. Problem detected: Your testGetItemsOccurrences did not return "
                + "the correct amount of duplicates.");
      return false;
    }

    String[][] originalArray = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if(!Arrays.deepEquals(originalArray, items)){
      System.out.println(
            "testGetItemsOccurrences-scenario 1. Problem detected: Your testGetItemsOccurrences made changes "
                + "to the original array.");
      return false;
    }
    // (2) the items array contains multiple occurrences of the provided item description.
    items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if (VendingMachine.getItemOccurrences("Water", items, itemsCount)!=3){
      System.out.println(
            "testGetItemsOccurrences-scenario 2. Problem detected: Your testGetItemsOccurrences did not return "
                + "the correct amount of duplicates.");
      return false;
    }
    originalArray = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if(!Arrays.deepEquals(originalArray, items)){
      System.out.println(
            "testGetItemsOccurrences-scenario 2. Problem detected: Your testGetItemsOccurrences made changes "
                + "to the original array.");
      return false;
    }
    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  /**
   * Checks the correctness of getItemsOccurrencesByExpirationDate defined in the VendingMachine class.
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetItemsOccurrencesByExpirationDate() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    int itemsCount=7;
    if (VendingMachine.getItemsOccurrencesByExpirationDate("Potion", "69", items, itemsCount)!=0){
      System.out.println(
            "testGetItemsOccurrencesByExpirationDate-scenario 1. Problem detected: Your testGetItemsOccurrencesByExpirationDate did not return "
                + "the correct amount of duplicates.");
      return false;
    }

    String[][] originalArray = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if(!Arrays.deepEquals(originalArray, items)){
      System.out.println(
            "testGetItemsOccurrencesByExpirationDate-scenario 1. Problem detected: Your testGetItemsOccurrencesByExpirationDate made changes "
                + "to the original array.");
      return false;
    }
    // (2) the items array contains multiple occurrences of the provided item description.
    items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if (VendingMachine.getItemsOccurrencesByExpirationDate("Water", "10", items, itemsCount)!=2){
      System.out.println(
            "testGetItemsOccurrencesByExpirationDate-scenario 2. Problem detected: Your testGetItemsOccurrencesByExpirationDate did not return "
                + "the correct amount of duplicates.");
      return false;
    }

    originalArray = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    if(!Arrays.deepEquals(originalArray, items)){
      System.out.println(
            "testGetItemsOccurrencesByExpirationDate-scenario 2. Problem detected: Your testGetItemsOccurrencesByExpirationDate made changes "
                + "to the original array.");
      return false;
    }
    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of addItem defined in the VendingMachine class.
  /**
   * Checks the correctness of getItemsOccurrencesByExpirationDate defined in the VendingMachine class.
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testAddItem() {
    // Define at least three test scenarios: 
    //(1) adding a new item to an empty vending machine whose size is zero (provided itemsCount == 0)
    String[][] items = new String[][] {null, null, null,null, null, null, null, null, null};
    int itemsCount=0;
    if (VendingMachine.addItem("Mountain Dew", "69", items, itemsCount)!=1){
        System.out.println(
            "testAddItem-scenario 1. Problem detected: Your testAddItem did not return "
                + "the correct itemsCount.");
        return false;
    }
    String[][] expectedArray=new String[][] {{"Mountain Dew", "69"}, null, null,null, null, null, null, null, null};
    if (!Arrays.deepEquals(expectedArray, items)){
      System.out.println(
            "testAddItem-scenario 1. Problem detected: Your testAddItem did not generate "
                + "the correct array.");
      return false;
    }
    //(2) adding a new item to a non-empty non-full vending machine
    items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    itemsCount=7;
    if (VendingMachine.addItem("Mountain Dew", "69", items, itemsCount)!=8){
        System.out.println(
            "testAddItem-scenario 2. Problem detected: Your testAddItem did not return "
                + "the correct itemsCount.");
        return false;
    }
    expectedArray=new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, {"Mountain Dew", "69"}, null};
    if (!Arrays.deepEquals(expectedArray, items)){
      System.out.println(
            "testAddItem-scenario 2. Problem detected: Your testAddItem did not generate "
                + "the correct array.");
      return false;
    }
    //(3) adding a new item to a full vending machine where the provided itemsCount equals the length of the provided items array.
    items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, {"Mountain Dew", "69"}, {"Rare Candy", "70"}};
    itemsCount=9;
    if (VendingMachine.addItem("Full Restore", "5", items, itemsCount)!=9){
        System.out.println(
            "testAddItem-scenario 3. Problem detected: Your testAddItem did not return "
                + "the correct itemsCount.");
        return false;
    }

    expectedArray=new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, {"Mountain Dew", "69"}, {"Rare Candy", "70"}};
    if (!Arrays.deepEquals(expectedArray, items)){
      System.out.println(
            "testAddItem-scenario 3. Problem detected: Your testAddItem did not generate "
                + "the correct array.");
      return false;
    }
    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.
  /**
   * Checks the correctness of getItemsOccurrencesByExpirationDate defined in the VendingMachine class.
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testRemoveNextItem() {
    // Define at least four test scenarios: 
    //(1) trying to remove a non-existing item from a vending machine (the vending machine can be empty or not)
    String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, null, null};
    int itemsCount=4;
    if (VendingMachine.removeNextItem("Candy", items, itemsCount)!=4){
      System.out.println(
            "testRemoveNextItem-scenario 1. Problem detected: Your testRemoveNextItem did not return "
                + "the correct itemsCount.");
      return false;
    }
    String[][] expectedItems=new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, null, null};
    if (!Arrays.deepEquals(expectedItems, items)){
      System.out.println(
            "testRemoveNextItem-scenario 1. Problem detected: Your testRemoveNextItem did not properly remove "
                + "the element");
      return false;
    }
    //(2) the next item to be removed matching the provided description is at index 0 of the array 
    items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, null, null};
    itemsCount=4;
    if (VendingMachine.removeNextItem("Water", items, itemsCount)!=3){
      System.out.println(
            "testRemoveNextItem-scenario 2. Problem detected: Your testRemoveNextItem did not return "
                + "the correct itemsCount.");
      return false;
    }
    String[][] expectedArray=new String[][] {{"Chocolate", "10"}, {"Juice", "20"},
    {"Water", "5"}, null, null, null};
    if (!Arrays.deepEquals(expectedArray, items)){
      System.out.println(
            "testRemoveNextItem-scenario 2. Problem detected: Your testRemoveNextItem did not properly remove "
                + "the element");
      return false;
    }

    //(3) the next item to be removed is at index itemsCount of the array (at the end of the array)
    items = new String[][] {{"Water", "10"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, null, null};
    itemsCount=4;
    if (VendingMachine.removeNextItem("Water", items, itemsCount)!=3){
      System.out.println(
            "testRemoveNextItem-scenario 3. Problem detected: Your testRemoveNextItem did not return "
                + "the correct itemsCount.");
      return false;
    }

    expectedArray=new String[][] {{"Water", "10"}, {"Chocolate", "10"},
    {"Juice", "20"}, null, null, null};
    if (!Arrays.deepEquals(expectedArray, items)){
      System.out.println(
            "testRemoveNextItem-scenario 3. Problem detected: Your testRemoveNextItem did not properly remove "
                + "the element");
      return false;
    }
    //(4) the next item to be removed is at a middle index of the provided items array.
    items = new String[][] {{"Water", "10"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, null, null};
    itemsCount=4;
    if (VendingMachine.removeNextItem("Chocolate", items, itemsCount)!=3){
      System.out.println(
            "testRemoveNextItem-scenario 4. Problem detected: Your testRemoveNextItem did not return "
                + "the correct itemsCount.");
      return false;
    }

    expectedArray=new String[][] {{"Water", "10"},
    {"Juice", "20"}, {"Water", "5"}, null, null, null};
    if (!Arrays.deepEquals(expectedArray, items)){
      System.out.println(
            "testRemoveNextItem-scenario 4. Problem detected: Your testRemoveNextItem did not properly remove "
                + "the element");
      return false;
    }
    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemsSummary defined in the VendingMachine class.
  /**
   * Checks the correctness of getItemsSummary defined in the VendingMachine class.
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testGetItemsSummary() {
    // Define at least three scenarios: (1) the vending machine is empty, 
    String[][] items = new String[][] {null, null};
    if (!VendingMachine.getItemsSummary(items, 0).equals("")){
      System.out.println(
            "testGetItemsSummary-scenario 1. Problem detected: Your testGetItemsSummary did not properly compile "
                + "an array of null elements");
      return false;
    }
    //(2) the vending machine contains non duplicate items (no multiple items with the same description), 
    items = new String[][] {{"Water", "10"}, {"Chocolate", "69"}};
    if (!VendingMachine.getItemsSummary(items, 2).equals("\n"+"Water"+" ("+"1"+")"+"\n"+"Chocolate"+" ("+"1"+")")){
      System.out.println(
            "testGetItemsSummary-scenario 2. Problem detected: Your testGetItemsSummary did not properly compile "
                + "an array of null elements");
      return false;
    }
    //(3) the vending machine contains multiple items with the same description at various index locations.
    items = new String[][] {{"Water", "10"}, {"Water", "69"}};
    if (!VendingMachine.getItemsSummary(items, 2).equals("\n"+"Water"+" ("+"2"+")")){
      System.out.println(
            "testGetItemsSummary-scenario 3. Problem detected: Your testGetItemsSummary did not properly compile "
                + "an array of null elements");
      return false;
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    if (testAddItem()==false){
        return false;
    }
    if (testGetItemAtIndex()==false){
        return false;
    }
    if (testRemoveNextItem()==false){
      return false;
    }
    if (testGetIndexNextItem()==false){
      return false;
    }
    if (testGetItemsOccurrences()==false){
      return false;
    }
    if (testContainsItem()==false){
      return false;
    }
    if (testGetItemsOccurrencesByExpirationDate()==false){
      return false;
    }
    if (testGetItemsSummary()==false){
      return false;
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    System.out.println("runAllTests(): " + runAllTests());
  }

}
