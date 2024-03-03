/*
 *Matthew Frankowski
 * CUS1168
 *Assignment 7
 * */
public class Assignment7 {

    public static void main(String[] args) {

        double j = 1, k = (j + 13.0) / 27.0;

        while (k <= 10.0){

            k = k + 1.2;
            j = 3.0 * k - 1.0;

            System.out.println("k: " + k + ", j: " + j);
        }

    }

}
