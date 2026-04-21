import java.util.*;

class Fan {

    int Speed;

    void FanLogic(int FanSpeed) {
        System.out.println("Fan on ");
        Speed = FanSpeed;
    }

   void FanSpeedLOgic(String speedLevl) {
        String[] FanLevel = { "1", "2", "3" };
        if (speedLevl.equalsIgnoreCase("on")) {
            System.out.println("Enter the Speed of the Fan");
            for (int i = 0; i <= 2; i++) {
                System.out.print(FanLevel[i] + " ");
            }
        } else if (speedLevl.equalsIgnoreCase("off")) {
                FanOff();
            } else {
                System.out.println("Worng input ");
            }
     }
    void FanOff() {
        System.out.println("Fan off");
    }
}

class Ligth {
    void LigthLogic(String userL) {
        if (userL.equalsIgnoreCase("on")) {
            LightON();
        } else if (userL.equalsIgnoreCase("off")) {
            LigthOFF();
        } else {
            System.out.println("worng input");
        }
    }

    void LightON() {
        System.out.println("Light on");
    }

    void LigthOFF() {
        System.out.println("LIght off");
    }
}

class AC {

    void ACLogic(String user) {
        Scanner input = new Scanner(System.in);
        if (user.equalsIgnoreCase("on")) {
            System.out.println("Enter temp");
            int temp = input.nextInt();
            if (temp < 15) {
                System.out.println("Enter the valid temp! temp should be between 15-30");
            } else if(temp >= 15) {
                System.out.println("AC on");
            } else {
                System.out.println("Enter the valid input");
            }
        } else if (user.equalsIgnoreCase("off")) {
            System.out.println("AC off");
        } else {
            System.out.println("Enter the valid input");
        }
    }
    void ACon() {
        System.out.println("AC on");
    }

    void ACoff() {
        System.out.println("AC off");
    }
}

public class SmartHome {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] device = { "Light", "Fan", "AC" };
        System.out.println("Enter the device name");
        for (int i = 0; i <= 2; i++) {
            System.out.print(device[i]+ " ");
        }
        String UserChoice = input.nextLine();
        if (UserChoice.equalsIgnoreCase("fan")) {
            Fan FanL = new Fan();
            System.out.println("Fan: on - off");
            String user = input.nextLine();
            FanL.FanSpeedLOgic(user);
            int speed = input.nextInt();
            FanL.FanLogic(speed);
        } else if (UserChoice.equalsIgnoreCase("light")) {
            Ligth ligth = new Ligth();
            System.out.println("Light : on - off");
            String user = input.nextLine();
            ligth.LigthLogic(user);
        } else if (UserChoice.equalsIgnoreCase("ac")) {
            System.out.println("AC : on - off");
            AC A = new AC();
            String user = input.nextLine();
            A.ACLogic(user);
        }

    }
}