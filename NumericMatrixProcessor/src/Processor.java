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

    static void transposeMatrixPrompts() {

        System.out.println("\n1. Main diagonal\n2. Side diagonal\n3. Vertical line\n4. Horizontal line");
        System.out.print("Your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        
        switch (choice) {
            case 1:
                transposeMainDiagonal();
                break;
            case 2:
                transposeSideDiagonal();
                break;
            case 3:
                transposeVertLine();
                break;
            case 4:
                transposeHorizLine();
                break;
        }
    }

    private static void transposeHorizLine() {

        System.out.print("Enter matrix size: ");
        String[] firstMatrixInput = scanner.nextLine().split(" ");
        int matrixRow = Integer.parseInt(firstMatrixInput[0]);
        int matrixCol = Integer.parseInt(firstMatrixInput[1]);
        double[][] matrix = new double[matrixRow][matrixCol];

        System.out.println("Enter matrix:");
        createDoubleMatrix(matrix);

        double[][] horizontalLine = new double[matrixRow][matrixCol];

        System.out.println("The result is:");
        for (int row = 0; row < horizontalLine.length; row++) {
            for (int col = 0; col < horizontalLine[row].length; col++) {
                horizontalLine[row][col] = matrix[matrixRow - 1 - row][col];
                System.out.print(horizontalLine[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void transposeVertLine() {

        System.out.print("Enter matrix size: ");
        String[] firstMatrixInput = scanner.nextLine().split(" ");
        int matrixRow = Integer.parseInt(firstMatrixInput[0]);
        int matrixCol = Integer.parseInt(firstMatrixInput[1]);
        double[][] matrix = new double[matrixRow][matrixCol];

        System.out.println("Enter matrix:");
        createDoubleMatrix(matrix);

        double[][] verticalLine = new double[matrixRow][matrixCol];

        System.out.println("The result is:");
        for (int row = 0; row < verticalLine.length; row++) {
            for (int col = 0; col < verticalLine[row].length; col++) {
                verticalLine[row][col] = matrix[row][matrixCol - 1 - col];
                System.out.print(verticalLine[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void transposeSideDiagonal() {

        System.out.print("Enter matrix size: ");
        String[] firstMatrixInput = scanner.nextLine().split(" ");
        int matrixRow = Integer.parseInt(firstMatrixInput[0]);
        int matrixCol = Integer.parseInt(firstMatrixInput[1]);
        double[][] matrix = new double[matrixRow][matrixCol];

        System.out.println("Enter matrix:");
        createDoubleMatrix(matrix);

        double[][] sideDiagonal = new double[matrixRow][matrixCol];

        System.out.println("The result is:");
        for (int row = 0; row < sideDiagonal.length; row++) {
            for (int col = 0; col < sideDiagonal[row].length; col++) {
                sideDiagonal[row][col] = matrix[matrixCol - 1 - col][matrixRow - 1 - row];
                System.out.print(sideDiagonal[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void transposeMainDiagonal() {

        System.out.print("Enter matrix size: ");
        String[] firstMatrixInput = scanner.nextLine().split(" ");
        int matrixRow = Integer.parseInt(firstMatrixInput[0]);
        int matrixCol = Integer.parseInt(firstMatrixInput[1]);
        double[][] matrix = new double[matrixRow][matrixCol];

        System.out.println("Enter matrix:");
        createDoubleMatrix(matrix);

        double[][] mainDiagonal = new double[matrixRow][matrixCol];

        System.out.println("The result is:");
        for (int row = 0; row < mainDiagonal.length; row++) {
            for (int col = 0; col < mainDiagonal[row].length; col++) {
                mainDiagonal[row][col] = matrix[col][row];
                System.out.print(mainDiagonal[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void matrixDeterminant() {
        System.out.print("Enter matrix size: ");
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        double[][] matrix = new double[row][col];
        System.out.println("Enter matrix:");

        createDoubleMatrix(matrix);

        System.out.println("The result is:");
        System.out.println(calculateDeterminant(matrix));

    }

    private static double calculateDeterminant(double[][] matrix) {
        double answer = 0;
        double s;

        if (matrix.length == 1) {
            return matrix[0][0];
        }

        for (int x = 0; x < matrix.length; x++) {
            double[][] small = new double[matrix.length - 1][matrix.length - 1];
            for (int row = 1; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (col < x) {
                        small[row - 1][col] = matrix[row][col];
                    } else if (col > x) {
                        small[row - 1][col - 1] = matrix[row][col];
                    }
                }
            }
            if (x % 2 == 0) {
                s = 1;
            } else {
                s = -1;
            }
            answer += s * matrix[0][x] * (calculateDeterminant(small));
        }
        return answer;
    }

    private static void inverseMatrix() {

        System.out.print("Enter matrix size: ");
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        double[][] matrix = new double[row][col];
        System.out.println("Enter matrix:");

        createDoubleMatrix(matrix);

        System.out.println("The result is:");
        if (calculateDeterminant(matrix) == 0) {
            System.out.println("This matrix doesn't have an inverse.");
        } else {
            for (int x = 0; x < calculateInverse(matrix).length; x++) {
                for (int y = 0; y < calculateInverse(matrix)[x].length; y++) {
                    System.out.print(calculateInverse(matrix)[x][y] + " ");
                }
                System.out.println();
            }
        }
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    private static double[][] calculateInverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * calculateDeterminant((minor(matrix, i, j)));

        double det = 1.0 / calculateDeterminant(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
    }

    static void program() {
        while (true) {
            System.out.println("1. Add matrices\n2. Multiply matrix by a constant\n3. Multiply matrices" +
                    "\n4. Transpose matrix\n5. Calculate a determinant\n6. Inverse matrix\n0. Exit");
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
                case 4:
                    transposeMatrixPrompts();
                    System.out.println();
                    break;
                case 5:
                    matrixDeterminant();
                    System.out.println();
                    break;
                case 6:
                    inverseMatrix();
                    System.out.println();
                    break;
            }
        }
    }

    static void start() {
        program();
    }
}


