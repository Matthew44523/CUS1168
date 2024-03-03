/*
 *Matthew Frankowski
 * CUS1168
 *Assignment 7
 * */
public class Assignment7 {

    public static void main(String[] args) {

        double j = 1, k = (j + 13.0) / 27.0, i; /*Initialize variables: j, k*/

        while (k <= 10.0){ /*Loop while k is less than or equal to 10.0*/

            k = k + 1.2; /*Increment k by 1.2 in each iteration of the loop*/
            i = 3.0 * k - 1.0; /*Calculate the value of j based on the current value of k*/

            System.out.println("k: " + k + ", i: " + i); /*Print the values of k and i in each iteration of the loop*/
        }

    }

}
