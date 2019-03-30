import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;

public class Main {

    private static Object Integer;

    static  void printArray(int[]arr)
    {
        for (int r = 0;r<4;r++)
        {
            for(int c = 0; c < 4; c++)
            {
                System.out.print(arr[r*4+c]);
                System.out.print(" ");
                System.out.print(" ");
                if (arr[r*4+c]<10)
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int player = 1;
        int moves = 0;
        int counter = 0;
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        List<Integer> remain = new ArrayList<Integer>();
        List<Integer> minus = new ArrayList<Integer>();
        while (true)
        {
            moves++;
            printArray(arr);
            boolean flag1 = true;
            boolean flag2 = false;
            boolean flag3 = false;

            // Print Player Turn
            System.out.print("Plyer "+player+" Move : ");

            // Get Input From User
            Scanner myObj = new Scanner(System.in);
            int input1,input2;
            input1 = myObj.nextInt();
            input2 = myObj.nextInt();


            // Check The Validation of The input.
            while ((input1 < 1 || input1 > 16)||(input2 < 1 || input2 > 16))
            {
                System.out.println("Invalid Input!!!!!\nPlease Enter The Two Numbers Again");
                input1 = myObj.nextInt();
                input2 = myObj.nextInt();
            }

            // Check if the two input can be selected.
            int result;
            while (flag1) {
                result = Math.abs(input1 - input2);
                if (result == 4 || result == 1) {
                    while ((arr[input1 - 1] == 0 || arr[input2 - 1] == 0)) {
                        System.out.println("The Other Player Chose it Already\nPlease Enter The Two Numbers Again");
                        while (true)
                        {
                            input1 = myObj.nextInt();
                            input2 = myObj.nextInt();
                            result = Math.abs(input1 - input2);
                            if ((result == 4 || result == 1))
                            {
                                break;
                            }
                        }

                        if ((arr[input1 - 1] != 0 && arr[input2 - 1] != 0)) {
                            break;
                        }

                    }
                    arr[input1-1] = 0;
                    arr[input2-1] = 0;
                    counter+=2;
                    flag1 = false;

                }
                else {
                    System.out.println("Not Adjacent Numbers\nPlease Enter The Two Numbers Again");
                    input1 = myObj.nextInt();
                    input2 = myObj.nextInt();
                }
            }
            System.out.println(counter);
            if (16 - counter == 4)
            {
                for (int i=0;i<16;i++)
                {
                    if (arr[i]!=0)
                    {
                        remain.add(arr[i]);
                    }
                }
                for (int i = 0; i<4;i++)
                {
                    for (int j = i; j<4;j++)
                    {
                        int tmp = 0;
                        tmp = Math.abs(remain.get(i)-remain.get(j));
                        minus.add(tmp);
                    }
                }
                int x = 0;
                for (int i = 0;i<6;i++)
                {

                    if (minus.get(i) != 4 && minus.get(i) != 1)
                    {
                        x++;
                    }
                }
                if (x == 6)
                {
                    flag3 = true;
                }

            }
            else if (16 - counter == 2)
            {
                for (int i=0;i<16;i++)
                {
                    if (arr[i]!=0)
                    {
                        remain.add(arr[i]);
                    }
                }
                for (int i = 0; i<2;i++)
                {
                    for (int j = i; j<2;j++)
                    {
                        int tmp = 0;
                        tmp = Math.abs(remain.get(i)-remain.get(j));
                        minus.add(tmp);
                    }
                }
                int x = 0;
                for (int i = 0;i<1;i++)
                {

                    if (minus.get(i) != 4 && minus.get(i) != 1)
                    {
                        x++;
                    }
                }
                if (x == 1)
                {
                    flag3 = true;
                }
            }

            if (moves == 8)
            {
                System.out.println("Player " + player + " is The Winner");
                break;
            }
            if (flag3 == true)
            {
                System.out.println("Player " + player + " is The Winner");
                break;
            }
            if (player == 1)
            {
                player = 2;
            }
            else {
                player = 1;
            }

        }

    }


}

