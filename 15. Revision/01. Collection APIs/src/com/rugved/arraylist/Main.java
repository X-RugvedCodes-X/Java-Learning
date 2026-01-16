package com.rugved.arraylist;

// import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
// import java.util.Collections;
// import java.util.Comparator;
import java.util.List;

// * There are primarily these many interfacess: Collection, List, Set, Queue, Deque, Map
// * Collection is parent of everyone, Also Iterable interface is parent of Collection
// * These interfaces are implemented by certain classes
// * Eg. ArrayList implements List, LinkedList implements List, etc
// ^ For more check in the diagrams

public class Main {
  public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    // System.out.println("hello, world !");

    // * ArrayList is a Dynamic Array Like Data structure unlike a regular array which has fixed size

    // ArrayList<Integer> list = new ArrayList<>();  // * ArrayList<Integer>(); Skip this from Java 7

    // ^ Checking Initial Capacity of ArrayList (Mind You Capacity means how many elements it can hold; it grows dynamically)
    // * Interally written in ArrayList Implementation, which proves default capacity is 10, where it increases 1.5 times of the origial when full
    // private static final int DEFAULT_CAPACITY = 10;  
    
    // ^ Adding Elements in ArrayList (addition at last takes constant time O(1))
    // list.add(1);
    // list.add(2);
    // list.add(10);

    // ^ Accessing Elements in ArrayList (.get(index) - constant time)
    // System.out.println(list.get(0));
    // System.out.println(list.get(1));
    // System.out.println(list.get(2));
    // ! throws exception - java.lang.IndexOutOfBoundsException
    // System.out.println(list.get(3));

    // ^ Checking Size of ArrayList (Mind You size() gives number of elements present in the ArrayList)
    // System.out.println(list.size());    // * 3

    // ^ Iteration in ArrayList using for loop
    // for (int i = 0; i < list.size(); ++i) {
    //   System.out.println(list.get(i));
    // }

    // ^ Iteration in ArrayList using Ranged Based for loop
    // for (Integer number : list) {
    //   System.out.println(number);
    // }

    // ^ Removal of Elements From the List
    // list.remove(2);          // * Removes first occurence of that element if present, if not then does nothing, return type is boolean
    // printArrayList(list);    // * [1, 10]

    // * Upper Statement Commented so state of list is: [1, 2, 10]
    // ^ Insertion in Between 
    // list.add(2, 5);   // * return type is void and throws index out of bounds exception if specified index is out of limit
    // printArrayList(list);     // * [1, 2, 5, 10]

    // * Replacing an Element
    // list.set(2, 7); // * Replaces and returns the element which was previously at its place (Here it returns 5), return type is Integer in this case
    // printArrayList(list);     // * [1, 2, 7, 10]

    // * By This we mention a default capacity, so as to reduce the process of copying and dynamically increasing size overhead
    // ArrayList<Integer> list = new ArrayList<>(1000);  
    // System.out.println(list.size());      // * 0
    // System.out.println(list.get(0));     // ! java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0

    // * Used to set Minimum Capacity
    // list.ensureCapacity(1000);      

    // * Way to Get Capacity of ArrayList (Using Reflections) 
    // ! Does not work in Newer JDK Versions
    // ArrayList<Integer> list = new ArrayList<>();
    // Field field = ArrayList.class.getDeclaredField("elementData");
    // field.setAccessible(true);
    // Object[] elementData = (Object[]) field.get(list);
    // System.out.println("ArrayList Capacity: " + elementData.length);

    // * Best Practice is 
    // ArrayList<Integer> arrayList = new ArrayList<>(500);
    // arrayList.ensureCapacity(700);      // * make sure it can hold at least 700
    // arrayList.trimToSize();                         // * reduce capacity to current size

    List<String> list1 = new ArrayList<>();
    // System.out.println(list1.getClass().getName());
    
    // ^ Ways to create ArrayList on the fly
    // * Arrays.asList() method returns a fixed size list we cannot add anything to it or remove from it, but we can replace the element in it
    List<String> list2 = Arrays.asList("Monday", "Tuesday");
    // System.out.println(list2.getClass().getName());   // * java.util.Arrays$ArrayList
    // list2.add("Wednesday"); // ! Throws Exception java.lang.UnsupportedOperationException
    list2.set(1, "Sunday");   // * We can replace though
    // System.out.println(list2);      // * [Monday, Sunday]
    // list2.remove(1);    // ! java.lang.UnsupportedOperationException
    // System.out.println(list2);

    String[] array = {"Apple", "Banana", "Watermelon"};
    List<String> list3 = Arrays.asList(array);
    // System.out.println(list3.getClass().getName());   // * java.util.Arrays$ArrayList

    // * In Newer Java Versions (Java 9) we can also do 
    // * This returns an unmodifiable list 
    // * Important to note that in this we can't even replace any element
    // List<Integer> list4 = List.of(1, 2, 3);
    // list4.set(1, 0);  // ! java.lang.UnsupportedOperationException
    // System.out.println(list4);

    // * We can even do this to get a perfectly Modifiable ArrayList
    List<String> list5 = new ArrayList<>(list3);    // * So in this constructor we can either give a capacity or a collection
    // * Addition at end takes constant time
    list5.add("Mongo");
    list5.add("Cherry");
    list5.add("Strawberry");
    // System.out.println(list5);    // * [Apple, Banana, Watermelon, Mongo, Cherry, Strawberry]

    list5.add(2, "Pineapple");    // * [Apple, Banana, Pineapple, Watermelon, Mongo, Cherry, Strawberry]
    // System.out.println(list5);

    List<String> list6 = List.of("Orange", "Kiwi", "Chickoo");
    list5.addAll(list6);
    // System.out.println(list5);    // * Apple, Banana, Pineapple, Watermelon, Mongo, Cherry, Strawberry, Orange, Kiwi, Chickoo]

    // * Removing Element By Value - removes first occurence, takes an object as parameter
    list5.remove("Mango");
    // System.out.println(list5);    // * [Apple, Banana, Pineapple, Watermelon, Mongo, Cherry, Strawberry, Orange, Kiwi, Chickoo]

    // * Caveats To remember while removing by object Value, By Default remove method takes Object type as argument and not primitive
    List<Integer> list7 = new ArrayList<>();
    list7.add(1);
    list7.add(2);
    list7.add(3);
    // list7.remove(2); // & It will remove the value at index 2, though we intended to remove the literal value 2
    // list7.remove(Integer.valueOf(2));   // * Now this is correct, as we pass an object
    // printArrayList(list7);    // * [1, 3]

    // * Time Complexity of Removal Operation
    // * Time Complexity: O(n)
    // * -> Access by index → O(1)
    // * -> Shifting elements → O(n)
    // list.remove(index);    

    // * Removing Last Element
    // * Time Complexity: O(1) (amortized)
    // list.remove(list.size() - 1);

    // * contains method checks if an element present in list or not
    // System.out.println(list7.contains(3));    // * true
    // System.out.println(list7.contains(2));    // ! false

    // ^ From List to Array
    List<Integer> list8 = new ArrayList<>();
    list8.add(10);
    list8.add(20);
    list8.add(30);
    list8.add(40);
    Object[] array1 = list8.toArray();
    // Integer[] array2 = list8.toArray(new Integer[0]);    // * Syntax is: list.toArray(new Object[0]);
    // Integer[] array2 = (Integer[]) list8.toArray();      // * Another way
    
    // ^ Sorting An ArrayList (Using Collections Class and list.sort(Comparator))
    List<Integer> list9 = new ArrayList<>();
    list9.add(20);
    list9.add(30);
    list9.add(10);
    list9.add(40);
    // Collections.sort(list9);
    // printArrayList(list9);      // * [10, 20, 30, 40]
    // * Traditionally it's done the below way
    // class MyComparator implements Comparator<Integer> {
    //   @Override
    //   public int compare(Integer o1, Integer o2) {
    //     return o1 - o2;
    //   }
    // }
    // list9.sort(new MyComparator());
    list9.sort(null);           // * Using Natural Order of Sorting
    // printArrayList(list9);        // * [10, 20, 30, 40]
    // * Sort using Comparator (var keyword is from Java 11 used in Lambdas)
    // list9.sort((var num1, var num2) -> {
     // return num1 - num2;     // * For Ascending
    //   return num2 - num1;     // * For Descending
    // });
    list9.sort((num1, num2) -> num2 - num1);    // * Shorter Way
    // printArrayList(list9);    // * [40, 30, 20, 10]

    // ^ Comparator - It is an interface used for custom ordering based on our preference
    List<String> words = Arrays.asList("banana", "apple", "date");
    words.sort(null);     // * [apple, banana, date]
    // * But we want that the smallest size word appears first (based on length of string)
    // * Comparator is a functional Interface using the compare method which takes two objects of same type 
    // * int compare(T o1, T o2);
    // class StringLenghtComparator implements Comparator<String> {
    //   @Override
    //   public int compare(String word1, String word2) {
        // * For Descending order sort in length
    //     return word2.length() - word1.length();
    //   }
    // }
    // words.sort(new StringLenghtComparator());

    // * using lambdas
    // * Ascending
    // words.sort((var word1, var word2) -> {
    //   return word1.length() - word2.length();
    // });
    // printArrayList(words);  // * [date, apple, banana]

    // * Descending
    // words.sort((var word1, var word2) -> {
    //   return word2.length() - word1.length();
    // });
    // printArrayList(words);  // * [banana, apple, date]

    // ^ Using Comparator on Custom objects
    List<Student> students = new ArrayList<>();
    students.add(new Student("Hemant", 7.09));
    students.add(new Student("Rugved", 9.09));
    students.add(new Student("Sanskar", 8.09));
    // for (Student student : students) {
    //   System.out.println(student);  
    // }
    // System.out.println(students);

    // students.sort((var student1, var student2) -> {
    //   if (student2.getGpa() - student1.getGpa() > 0)
    //     return 1;
    //   else if(student2.getGpa() - student1.getGpa() < 0)
    //     return -1;
    //   else 
    //     return 0;
    // });
    // for (Student student : students) {
    //   System.out.println(student);  
    // }
    /*
    * Student -> Name: Rugved, GPA: 9.09
    * Student -> Name: Sanskar, GPA: 8.09
    * Student -> Name: Hemant, GPA: 7.09
    */

    // * Sorting using Another Technique using Method reference 
    // Comparator<Student> comparator = Comparator.comparing(Student::getGpa); // * Don't write getGpa() just the function name no function call
    // students.sort(comparator);
    // for (Student student : students) {
    //   System.out.println(student);  
    // }
    students.add(new Student("Shraddha", 8.09));
    students.add(new Student("Sameer", 8.09));
    // As now Two Students have same gpa we want Sameer to be first then Sanskar and then Shraddha so for that we do
    // Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName); // * Don't write getGpa() just the function name no function call
    // students.sort(comparator);
    // for (Student student : students) {
    //   System.out.println(student);  
    // }
    /*
    * Student -> Name: Rugved, GPA: 9.09
    * Student -> Name: Sameer, GPA: 8.09
    * Student -> Name: Sanskar, GPA: 8.09
    * Student -> Name: Shraddha, GPA: 8.09
    * Student -> Name: Hemant, GPA: 7.09
    */

    // * For the Same Above result we can even do 
    students.sort((student1, student2) -> {
      if (student2.getGpa() - student1.getGpa() > 0)
        return 1;
      else if(student2.getGpa() - student1.getGpa() < 0)
        return -1;
      else 
        return student1.getName().compareTo(student2.getName()); // * CompareTo is a String method
    });
    // for (Student student : students) {
    //   System.out.println(student);  
    // }

    // * Comparator can be even given in Collections.sort()
    // Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName); // * Don't write getGpa() just the function name no function call
    // Collections.sort(students, comparator);

    // ^ Correct ways to convert int[] → ArrayList<Integer> 
    // * Recommended (Java 8+) using streams
    // int[] arr = {1, 8, 10, 4, 0, -1, 7};
    // ArrayList<Integer> arrList = Arrays.stream(arr)
    //                                   .boxed()
    //                                   .collect(Collectors.toCollection(ArrayList::new));

    // * Using loop (simplest & fastest)
    // int[] arr = {1, 8, 10, 4, 0, -1, 7};
    // ArrayList<Integer> arrList = new ArrayList<>();
    // for (int x : arr) {
    //     arrList.add(x);
    // }

    // * If array was Integer[] instead
    // Integer[] arr = {1, 8, 10, 4, 0, -1, 7};
    // ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arr));

    // ^ toArray() - converts a Collection → Array
    // * Object Method
    // Integer[] arr = arrList.toArray(new Integer[0]);

    // * Using Streams
    // int[] arr = arrList.stream()
    //                .mapToInt(Integer::intValue)
    //                .toArray();

    // ^ Primitive arrays (int[]) do NOT work with Arrays.asList() the way we expect.

    // * Gives ArrayList with 10 elements as 0s
    List<Integer> arrayList = new ArrayList<>(Collections.nCopies(10, Integer.valueOf(0)));
    // printArrayList(arrayList);    // * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    // * replaces those 10 elements with value 6
    Collections.fill(arrayList, Integer.valueOf(6));
    // printArrayList(arrayList);    // * [6, 6, 6, 6, 6, 6, 6, 6, 6, 6]
  }

  private static <T> void printArrayList(List<T> arrayList) {
    System.out.println(arrayList);
  }
};