// File Header comes here

import java.util.Arrays;

// Javadoc style class header comes here
public class VendingMachineTester {

  // TODO complete the implementation of the following tester methods and add their javadoc style
  // method headers

  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
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
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
    // search returning false.

    return false; // default return statement to let this incomplete code compiles with no errors.
                  // Feel free to change it.
  }

  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testgetItemAtIndex() {
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
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    // (2) the items array contains multiple occurrences of the provided item description.

    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.
    return false; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of addItem defined in the VendingMachine class.
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
    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.
  public static boolean testRemoveNextItem() {
    // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), (2) the next item to be removed matching
    // the provided description is at index 0 of the array, (3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
    // is at a middle index of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    return false; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemsSummary defined in the VendingMachine class.
  public static boolean testGetItemsSummary() {
    // Define at least three scenarios: (1) the vending machine is empty, (2) the vending machine
    // contains non duplicate items (no multiple items with the same description), (3) the vending
    // machine contains multiple items with the same description at various index locations.
    
    return false; // default return statement to let this incomplete code compiles with no errors.
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    if (testAddItem()==false){
        return false;
    }
    if (testgetItemAtIndex()==false){
        return false;
    }
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    
    //System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
    System.out.println("testgetItemAtIndex(): " + testgetItemAtIndex());
    System.out.println("testAddItem(): " + testAddItem());
    System.out.println("runAllTests(): " + runAllTests());
    
    
  }

}
