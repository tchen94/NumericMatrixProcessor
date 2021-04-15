import java.util.Scanner;

public class Processor {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void createDoubleMatrix(double[][] x) {
        for (int row = 0; row < x.length; row++) {
            String[] rowNum = scanner.nextLine().split(" ");
            for (int col = 0; col < x[row].length; col++) {
                x[row][col] = Double.parseDouble(rowNum[col]);
            }
        }
    }

    static void matrixAddition() {

        System.out.print("Enter size of first matrix: ");
        String[] firstMatrixInput = scanner.nextLine().split(" ");
        int firstMatrixRow = Integer.parseInt(firstMatrixInput[0]);
        int firstMatrixCol = Integer.parseInt(firstMatrixInput[1]);
        double[][] firstMatrix = new double[firstMatrixRow][firstMatrixCol];

        System.out.println("Enter first matrix:");
        createDoubleMatrix(firstMatrix);

        System.out.print("Enter size of second matrix: ");
        String[] secondMatrixInput = scanner.nextLine().split(" ");
        int secondMatrixRow = Integer.parseInt(secondMatrixInput[0]);
        int secondMatrixCol = Integer.parseInt(secondMatrixInput[1]);
        double[][] secondMatrix = new double[secondMatrixRow][secondMatrixCol];

        System.out.println("Enter second matrix:");
        createDoubleMatrix(secondMatrix);

        double[][] answer = new double[firstMatrixRow][firstMatrixCol]; // The dimensions have to be equal

        if (firstMatrixRow != secondMatrixRow && firstMatrixCol != secondMatrixCol) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println("The result is:");
            for (int row = 0; row < answer.length; row++) {
                for (int col = 0; col < answer[row].length; col++) {
                    answer[row][col] = firstMatrix[row][col] + secondMatrix[row][col];
                    System.out.print(answer[row][col] + " ");
                }
                System.out.println();
            }
        }
    }

    static void matrixConstantMultiplication() {

        System.out.print("Enter size of matrix:");
        String[] input = scanner.nextLine().split(" ");
        int matrixRow = Integer.parseInt(input[0]);
        int matrixCol = Integer.parseInt(input[1]);
        double[][] someMatrix = new double[matrixRow][matrixCol];

        System.out.println("Enter matrix: ");
        createDoubleMatrix(someMatrix);

        System.out.print("Enter constant: ");
        double multiple = Double.parseDouble(scanner.nextLine());
        double[][] answer = new double[matrixRow][matrixCol];

        System.out.println("The result is:");
        for (int row = 0; row < answer.length; row++) {
            for (int col = 0; col < answer[row].length; col++) {
                answer[row][col] = multiple * someMatrix[row][col];
                System.out.print(answer[row][col] + " ");
            }
            System.out.println();
        }
    }

    static void matrixToMatrixMultiplication() {

        System.out.print("Enter size of first matrix: ");
        String[] firstMatrixInput = scanner.nextLine().split(" ");
        int firstMatrixRow = Integer.parseInt(firstMatrixInput[0]);
        int firstMatrixCol = Integer.parseInt(firstMatrixInput[1]);
        double[][] firstMatrix = new double[firstMatrixRow][firstMatrixCol];

        System.out.println("Enter first matrix:");
        createDoubleMatrix(firstMatrix);

        System.out.print("Enter size of second matrix: ");
        String[] secondMatrixInput = scanner.nextLine().split(" ");
        int secondMatrixRow = Integer.parseInt(secondMatrixInput[0]);
        int secondMatrixCol = Integer.parseInt(secondMatrixInput[1]);
        double[][] secondMatrix = new double[secondMatrixRow][secondMatrixCol];

        System.out.println("Enter second matrix:");
        createDoubleMatrix(secondMatrix);

        double[][] product;
        System.out.println("The result is:");

        if (firstMatrixCol == secondMatrixRow) {

            product = new double[firstMatrixRow][secondMatrixCol];

            for (int x = 0; x < firstMatrixRow; x++) {
                for (int y = 0; y < secondMatrixCol; y++) {
                    product[x][y] = 0;
                    for (int z = 0; z < firstMatrixCol; z++) {
                        product[x][y] += firstMatrix[x][z] * secondMatrix[z][y];
                    }
                    System.out.print(product[x][y] + " ");
                }
                System.out.println();
            }
        } else {

            product = new double[firstMatrixRow][firstMatrixCol];

            for (int x = 0; x < product.length; x++) {
                for (int y = 0; y < product[x].length; y++) {
                    product[x][y] = 0;
                    for (int z = 0; z < product.length; z++) {
                        product[x][y] += firstMatrix[x][z] * secondMatrix[z][y];
                    }
                    System.out.print(product[x][y] + " ");
                }
                System.out.println();
            }
        }
    }

    static void program() {
        while (true) {
            System.out.println("1. Add matrices\n2. Multiply matrix by a constant\n3. Multiply matrices\n0. Exit");
            System.out.print("Your choice: ");
            int input = Integer.parseInt(scanner.nextLine());

            if (input == 0) {
                break;
            }

            switch (input) {
                case 1:
                    matrixAddition();
                    System.out.println();
                    break;
                case 2:
                    matrixConstantMultiplication();
                    System.out.println();
                    break;
                case 3:
                    matrixToMatrixMultiplication();
                    System.out.println();
                    break;
            }
        }
    }

    static void start() {
        program();
    }
}


