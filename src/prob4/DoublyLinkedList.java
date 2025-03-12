package prob4;

public class DoublyLinkedList {

  Node header;
  DoublyLinkedList(){
    header = new Node();
  }
  //1. adds to the end of the list
  public void addLast(String item){
    Node newNode = new Node();
    newNode.value = item;
    //if(header.value == null) header = newNode;
    Node current = header;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
    newNode.previous = current;
  }
  // 2. Remove by passing object
  public boolean remove(String item){
    //Implement
    if(item == null || header == null) return false;
    Node current = header;
    while(current.next != null){
      if(current.next.value.equals(item)){
        current.next = current.next.next;
        if(current.next != null) current.next.previous = current;
        return true;
      }else{
        current = current.next;
      }
    }
    return false;
  }

  // 3. Remove the First Node

  public boolean removeFirst() {
    // Implement
    if(header == null) return false;
    if(header.next == null){
      header = null;
      return true;
    }else {
      header.next = header.next.next;

      if (header.next != null)
        header.next.previous = header;
      return true;
    }
  }


  // 4. Prints the list from last to first
  public void printReverse() {
    // Implement
    if(header == null) return;
    Node current = header;
    while(current.next != null){
      current = current.next;
    }
    StringBuilder sb = new StringBuilder();
    while (current.previous != null){
      sb.append(current.value);
      sb.append(" ");
      current = current.previous;
    }
    //sb.append(current.value);
    System.out.println(sb.toString().trim());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    toString(sb, header);
    return sb.toString();

  }
  private void toString(StringBuilder sb, Node n) {
    if(n==null) return;
    if(n.value != null) sb.append(" " + n.value);
    toString(sb, n.next);
  }

  class Node {
    String value;
    Node next;
    Node previous;

    public String toString() {
      return value == null ? "null" : value;
    }
  }

  public static void main(String[] args){
    DoublyLinkedList list = new DoublyLinkedList();
    list.addLast("Bob");
    list.addLast("Harry");
    list.addLast("Steve");
    list.addLast("Henry");
    // Call all your implemented Methods
    System.out.println("Original List :");
    System.out.println(list);

    System.out.println("Is the first element removed ? " + list.removeFirst());
    String s = "Henry";
    System.out.println("Is " + s + " removed from the list ? " + list.remove(s));
    System.out.println("List after performing remove and removeFirst:");
    System.out.println(list);
    System.out.println("Reversed List : ");
    list.printReverse();
  }
}

