// Angie Bui, Buia@g.cofc.edu
// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
// Status: The code takes in int length of each side one at a time then
// runs after -1 is entered at the end when no more prompt is asked. 
// Technically program is correct but doesn't take in String input. 

import java.util.*;
public class triangle
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double AB, BC, BC2, AC2, AC3, AB3, BC4, AC4;
        int end;
       
        do{ // ends program and calculate answer when -1 is entered at the end
            //gets all input for the sides
            System.out.println("Input side AB");
            AB = input.nextDouble();
            System.out.println("Input side BC");
            BC = input.nextDouble();
            
            System.out.println("Input side BC");
            BC2 = input.nextDouble();
            System.out.println("Input side AC");
            AC2 = input.nextDouble();
            
            System.out.println("Input side AC");
            AC3 = input.nextDouble();
            System.out.println("Input side AB");
            AB3 = input.nextDouble();
            
            System.out.println("Input side BC");
            BC4 = input.nextDouble();
            System.out.println("Input side AC");
            AC4 = input.nextDouble();
            
	//  user enter -1, then methods are called and print answer
            end = input.nextInt();
            abbc(AB, BC);
            bcac(BC2, AC2);
            acab(AC3, AB3);
            bcac2(BC4, AC4);
            
        }while (end != -1); //end the program when -1 is entered
    
    }
// Triangle math stuff 

    public static void abbc(double ab, double  bc){
        double  hypotenuse = Math.sqrt((ab*ab)+(bc*bc));
        double  area = (ab*bc)/2;
        System.out.println("AC: "+ ((int) hypotenuse)+ " Area: " + ((int) area));
    }
    public static void bcac(double  bc, double  ac){
        double  base = Math.sqrt(Math.abs((bc*bc)-(ac*ac)));
        double  area = (base * bc)/2;
        System.out.println("AB: "+ ((int)base) + " Area: " + ((int)area));
    }
    public static void acab( double  ac, double  ab){
        double height = Math.sqrt(Math.abs((ac*ac)-(ab*ab)));
        double area = (ab * height)/2;
        System.out.println("BC: "+ ((int)height) + " Area: " + ((int)area));
    }
    public static void bcac2(double  bc, double  ac){
        double  base = Math.sqrt(Math.abs((bc*bc)-(ac*ac)));
        double  area = (base * bc)/2;
        System.out.println("AB: "+ ((int)base) + " Area: " + ((int)area));
    }
}
