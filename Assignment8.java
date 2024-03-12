/*
 *Matthew Frankowski
 * CUS1168
 *Assignment 8
 * */
public class Assignment8 {

    public static void main(String[] args) {

        /*Initialize Variables*/
        int k = 5, j = 3;

        switch (k) {
            case 1, 2 -> j = 2 * k - 1; // If k is 1 or 2, calculate 2k - 1
            case 3, 5 -> j = 3 * k + 1; //If k is 3 or 5, calculate 3k + 1
            case 4 -> j = 4 * k - 1; //If k is 4, calculate 4k - 1
            case 6, 7, 8 -> j = k - 2; //If k is 6, 7, or 8, calculate k - 2
        }

        /*Print J after going through the switch case*/
        System.out.println(j);

    }

}

