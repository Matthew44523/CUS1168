// Matthew Frankowski
// Assignment 10 Question 1
// CUS 1168

public class Assignment10Part1 {
    private int[][] data;
    private int rows;
    private int cols;

    // Constructor to create a matrix with specified dimensions
    public Assignment10Part1(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    // Constructor to create a matrix from a given 2D array
    public Assignment10Part1(int[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    // Getter method to retrieve the number of rows in the matrix
    public int getRows() {
        return rows;
    }

    // Getter method to retrieve the number of columns in the matrix
    public int getCols() {
        return cols;
    }

    // Getter method to retrieve an element at specified row and column
    public int getElement(int i, int j) {
        return data[i][j];
    }

    // Setter method to set an element at specified row and column
    public void setElement(int i, int j, int value) {
        data[i][j] = value;
    }

    // Method to perform matrix addition
    public Assignment10Part1 add(Assignment10Part1 other) {
        // Check if matrices have the same dimensions for addition
        if (this.rows != other.getRows() || this.cols != other.getCols()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        // Create a new matrix to store the result
        Assignment10Part1 result = new Assignment10Part1(rows, cols);
        // Iterate through each element and perform addition
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, this.getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }

    // Method to perform matrix subtraction
    public Assignment10Part1 subtract(Assignment10Part1 other) {
        // Check if matrices have the same dimensions for subtraction
        if (this.rows != other.getRows() || this.cols != other.getCols()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }

        // Create a new matrix to store the result
        Assignment10Part1 result = new Assignment10Part1(rows, cols);
        // Iterate through each element and perform subtraction
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, this.getElement(i, j) - other.getElement(i, j));
            }
        }
        return result;
    }

    // Method to perform matrix multiplication
    public Assignment10Part1 multiply(Assignment10Part1 other) {
        // Check if matrices can be multiplied
        if (this.cols != other.getRows()) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication.");
        }

        // Create a new matrix to store the result
        Assignment10Part1 result = new Assignment10Part1(this.rows, other.getCols());
        // Iterate through each element and perform multiplication
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.getCols(); j++) {
                int sum = 0;
                // Calculate the dot product of the corresponding row and column
                for (int k = 0; k < this.cols; k++) {
                    sum += this.getElement(i, k) * other.getElement(k, j);
                }
                // Set the result in the new matrix
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    // Method to represent the matrix as a string
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                builder.append(data[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example matrices
        int[][] data1 = {{31, 22}, {42, 1}};
        int[][] data2 = {{18, 61}, {90, 23}};

        // Create matrices from the example data
        Assignment10Part1 matrix1 = new Assignment10Part1(data1);
        Assignment10Part1 matrix2 = new Assignment10Part1(data2);

        // Perform operations and display results
        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        System.out.println("Matrix 1 + Matrix 2:");
        System.out.println(matrix1.add(matrix2));

        System.out.println("Matrix 1 - Matrix 2:");
        System.out.println(matrix1.subtract(matrix2));

        System.out.println("Matrix 1 * Matrix 2:");
        System.out.println(matrix1.multiply(matrix2));
    }
}
