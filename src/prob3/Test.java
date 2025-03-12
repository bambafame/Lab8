package prob3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    List<Marketing> marketingList = new ArrayList<>();

    // Create five instances of Marketing
    Marketing m1 = new Marketing("Alice", "Laptop", 1500.50);
    Marketing m2 = new Marketing("Bob", "Smartphone", 1200.75);
    Marketing m3 = new Marketing("Charlie", "Tablet", 800.25);
    Marketing m4 = new Marketing("David", "Smartwatch", 650.00);
    Marketing m5 = new Marketing("Eve", "Camera", 950.30);

    // Add instances to the list
    marketingList.add(m1);
    marketingList.add(m2);
    marketingList.add(m3);
    marketingList.add(m4);
    marketingList.add(m5);

    //Deleeting m5
    marketingList.remove(m5);
    //Printing the size of the list
    System.out.println(marketingList.size());
    //Retrieve a Marketing at position 2
    Marketing marketingAtPos2 = marketingList.get(2);
    //Update a Marketing at position 1
    Marketing updateM1 = marketingList.set(1, new Marketing("Yaakoub", "Smartphone", 900.50));
    System.out.println("Before sort = "+marketingList);
    //Sort the list for the field salesamount
    MarketingComparator mc = new MarketingComparator();
    Collections.sort(marketingList, mc);

    //Sort the list in natural order using employeename with the criteria of the employee who achieves more than $1000 of salesamount
    List<Marketing> moreThan1000Marketings = listMoreThan1000(marketingList);
    Collections.sort(moreThan1000Marketings, (o1, o2) -> o1.getEmployeename().compareTo(o2.getEmployeename()));
    System.out.println(moreThan1000Marketings);
  }

  public static List<Marketing>  listMoreThan1000(List<Marketing> list){
    List<Marketing> marketings = new ArrayList<>();
    for (Marketing marketing : list) {
      if(marketing != null && marketing.getSalesamount() < 1000)
        marketings.add(marketing);
    }
    return marketings;
  }


}
