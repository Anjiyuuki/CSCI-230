// Angie Bui, Buia@g.cofc.edu
// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
// Status: 100% complete 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Class Node
class Node {
    String word;
    String speechPart;
    Node next;

    // Constructor
    public Node(String word, String speechPart) {
        this.word = word;
        this.speechPart = speechPart;
    }
}

// Class linkedList
class LinkedList {
    //head node of linked list
    Node head;

    // LinkedList constructor which adds a node
    public LinkedList(String word, String speechPart) {
        this.insert(word, speechPart);
    }

    // insert a node to a linked list
    public void insert(String word, String speechPart) {
        Node newNode = new Node(word, speechPart);
        // If linkedlist is empty then create a new node
        if (this.head == null) {
            head = newNode;
            return;
        }

        Node curNode = head;
        // Loop till the last node
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        // insert new node after last node
        curNode.next = newNode;
    }

    // display the linked list
    public void display() {
        if (head != null) {
            Node curNode = head;
            while (curNode.next != null) {
                System.out.println(curNode.word + "  " + curNode.speechPart);
                curNode = curNode.next;
            }
            System.out.println(curNode.word + "  " + curNode.speechPart);
        }
    }
}

// Class Hashtable
class HashTable {
    int collisions = 0;
    int totalEntries = 0;
    int[] perCollisions;
    LinkedList[] hashtable;
    static int size = 24593;

    // Constructor
    HashTable() {
        // create arrays of size 24593
        hashtable = new LinkedList[size];
        perCollisions = new int[size];
    }

    // hash function for getting hash value from string
    public int hashFunction(String key) {
        int num = 0;
        for (int i = 0; i < key.length(); i++) {
            num += (int) key.charAt(i) * i;
        }
        return num % 24593;
    }

    // find the key from the hash table
    public void find(String key) {
        // get hash value
        int hash = hashFunction(key);
        int count = 1;
        // if no key linked list found at particular hash
        if (hashtable[hash] == null) {
            System.out.println(key + " not found!");
        } else {
            LinkedList linkedList = hashtable[hash];
            Node ptr = linkedList.head;
            // iterate through the found linkedlist
            while (ptr.next != null) {
                // if key found prints the details
                if (ptr.word.equals(key)) {
                    System.out.println("Parts of Speech: " + ptr.speechPart);
                    System.out.println("Number of Collisions: " + count);
                }
                ptr = ptr.next;
                count++;
            }
        }
        totalEntries++;
    }

    // insert key into hash table
    public void put(String word, String speechPart) {
        int hash = hashFunction(word);
        // if no linedlist found
        if (hashtable[hash] == null) {
            // then create one
            hashtable[hash] = new LinkedList(word, speechPart);
        } else {
            // insert into linked list
            hashtable[hash].insert(word, speechPart);
            perCollisions[hash]++;
            collisions++;
        }
        totalEntries++;
    }

    // calculate and return avg number of collisions
    public float getAvgCollisions() {
        return (float) collisions / (float) totalEntries;
    }

    // print the highest collision index
    public void highestCollision() {
        int index = 0;
        int max = perCollisions[0];
        // find max collision index
        for (int i = 1; i < perCollisions.length; i++)
            if (perCollisions[i] > max) {
                max = perCollisions[i];
                index = i;
            }

        // display max collision index and entries
        System.out.println("\nMaximum Collision Lexicals");
        System.out.println("Max Collision Lexical Index: " + index);
        System.out.println("Colliding Words Count: " + max);
        hashtable[index].display();
    }
}

// class Main
public class Main {
    public static void main(String[] args) {
        // create an object of hashtable
        HashTable hashTable = new HashTable();
        Scanner sc = new Scanner(System.in);
        String word = "";
        try {
            // read file
            File myObj = new File("LEXICON.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String str = myReader.nextLine();
                // split each entry to 2 values
                String[] tokens = str.split(" ", 2);
                // insert into hashTable
                hashTable.put(tokens[0], tokens[1]);
            }
            myReader.close();
            System.out.println("Total Lexical Entries: " + hashTable.totalEntries);
            System.out.println("Total Collision: " + hashTable.collisions);
            System.out.println("Average Number of Collision Per Lexical Entry: " + hashTable.getAvgCollisions());
            hashTable.highestCollision();

            while (word != "QUIT" || word != "quit") {
                // ask user for word
                System.out.print("\nEnter a word(QUIT for quitting): ");
                word = sc.nextLine();
                hashTable.find(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}