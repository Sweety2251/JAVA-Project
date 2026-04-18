import java.util.*;
import java.lang.Math;

class calculator {

    public int add(int a, int b) {
        return a + b;
    }

     public int sub(int a, int b) {
        return a - b;
    }

     public int mul(int a, int b) {
        return a * b;
    }

     public int mod(int a, int b) {
        return a % b;
    }

     public double pow(int a, int b) {
        return Math.pow(a, b);
    }
}


class Commandprocessor {
    calculator calc = new calculator();

    public void process(String input) {
        try{
            String[] part = input.trim().split(" ");

            if(part.length != 3){
                System.out.println("Invalid format! use: Command num1 num2");
                return;
            }

            String command = part[0].toUpperCase();
            int a = Integer.parseInt(part[1]);
            int b = Integer.parseInt(part[2]);

            switch (command) {
                case "ADD":
                    System.out.println("Result :" + calc.add(a,b));
                    break;

                    case "SUB":
                    System.out.println("Result :" + calc.sub(a,b));
                    break;

                    case "MUL":
                    System.out.println("Result :" + calc.mul(a,b));
                    break;

                    case "MOD":
                    System.out.println("Result :" + calc.mul(a,b));
                    break;

                    case "POW":
                    System.out.println("Result :" + calc.pow(a,b));
                    break;
            
                default:
                    System.out.println("you enter the worng command");
                    break;
            }
        }
        catch(NumberFormatException e){
            System.out.println("Invalid number! please enter the integer number");
        }
    }
}

public class Cal {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Commandprocessor Cmd = new Commandprocessor();
      System.out.println("=== Command Based Calculator");
      System.out.println("Commands: ADD, SUB,MUL,MOD,POW");
      System.out.println("type 'Exist' to stop");

      while (true) {
          System.out.println("enter Command");
          String input = sc.nextLine();

          if (input.equalsIgnoreCase("Exist")) {
              System.out.println("Existing....");
              break;
          }

          Cmd.process(input);
      }
      sc.close();
  }
}