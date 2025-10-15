
/******************************************
 *  @Author : Tenzing Lobden
 *  @Created On : Feb 25 2025
 *  @File : Simulator.java
 *  @Description: Simulator for a Doubly Linked List.
 *                Reads commands from a CSV file and performs operations on the linked list.
 ****************************************** */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;

public class Simulator {

    /**
     * main program.
     */
    public static void main(String[] args) throws FileNotFoundException {

        // create linked list
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();

        // read the file
        Scanner scanner = new Scanner(new File("commands.csv"));

        // if there is next line then process it
        while (scanner.hasNextLine()) {

            // get the line in the file
            String line = scanner.nextLine();

            // split it up into array with the ',' being delimiter
            String[] words = line.split(",");

            // local variable to hold the position = (words[1])
            int position, data;
            boolean answer;

            switch (words[0]) {
                case "create":
                    // clear the linked list and start as a new linked list
                    linkedList.clear();
                    break;
                case "insert":
                    // parse into Integer
                    position = Integer.parseInt(words[1]);
                    data = Integer.parseInt(words[2]);

                    // call insert method passing in local variables above
                    answer = linkedList.insert(position, data);

                    if (!answer) {
                        System.out.println("Can't insert");
                    } else {
                        System.out.printf("Inserted (%d) at position (%d)%n", data, position);
                    }

                    break;
                case ("remove"):
                    // parse into Integer
                    position = Integer.parseInt(words[1]);

                    // call remove method passing in position
                    linkedList.remove(position);

                    System.out.printf("Removed DoubleNode at position (%d)%n", position);
                    break;
                case ("get"):
                    // parse into Integer
                    position = Integer.parseInt(words[1]);
                    try {
                        // call getEntry method which retrieves the data at the position
                        data = linkedList.getEntry(position);
                        System.out.println("Item at position " + position + ": " + data);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid position: " + position);
                    }
                    break;
                case ("print"):
                    // print in a natural order if argument is 0
                    if (words[1].equals("0")) {
                        System.out.println(linkedList);
                    }
                    // print after sorting if argument is 1
                    else if (words[1].equals("1")){

                        // sort the linked list using custom comparator
                        linkedList.sort(new Comparator<DoubleNode<Integer>>() {
                            // compares two DoubleNode objects by comparing the integer values they store using natural sorting ordering (compareTo)
                            @Override
                            public int compare(DoubleNode<Integer> o1, DoubleNode<Integer> o2) {
                                return o1.getItem().compareTo(o2.getItem());
                            }
                        });

                        System.out.println(linkedList);
                    }
                    break;

                default:

                    System.out.println("Unknown Command");
            }
        }
    }
}
