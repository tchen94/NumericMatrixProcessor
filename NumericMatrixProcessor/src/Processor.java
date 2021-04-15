import java.util.Scanner;

public class Processor {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void matrixAddition() {
        Scanner scanner = new Scanner(System.in);
        String[] inputA = scanner.nextLine().split(" ");
        int aRow = Integer.parseInt(inputA[0]);
        int aCol = Integer.parseInt(inputA[1]);
        int[][] a = new int[aRow][aCol];

        for (int row = 0; row < a.length; row++) {
            String[] rowNum = scanner.nextLine().split(" ");
            for (int col = 0; col < a[row].length; col++) {
                a[row][col] = Integer.parseInt(rowNum[col]);
            }
        }

        String[] inputB = scanner.nextLine().split(" ");
        int bRow = Integer.parseInt(inputB[0]);
        int bCol = Integer.parseInt(inputB[1]);
        int[][] b = new int[bRow][bCol];

        for (int row = 0; row < b.length; row++) {
            String[] rowNum = scanner.nextLine().split(" ");
            for (int col = 0; col < b[row].length; col++) {
                b[row][col] = Integer.parseInt(rowNum[col]);
            }
        }

        int[][] c = new int[aRow][aCol];

        if (aRow != bRow && aCol != bCol) {
            System.out.println("ERROR");
        } else {
            for (int row = 0; row < c.length; row++) {
                for (int col = 0; col < c[row].length; col++) {
                    c[row][col] = a[row][col] + b[row][col];
                    System.out.print(c[row][col] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void matrixMultiplication() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int[][] a = new int[x][y];

        for (int row = 0; row < a.length; row++) {
            String[] rowNum = scanner.nextLine().split(" ");
            for (int col = 0; col < a[row].length; col++) {
                a[row][col] = Integer.parseInt(rowNum[col]);
            }
        }

        int multiple = Integer.parseInt(scanner.nextLine());
        int[][] b = new int[x][y];

        for (int row = 0; row < b.length; row++) {
            for (int col = 0; col < b[row].length; col++) {
                b[row][col] = multiple * a[row][col];
                System.out.print(b[row][col] + " ");
            }
            System.out.println();
        }
    }

    static void start() {
        program();
    }
}


