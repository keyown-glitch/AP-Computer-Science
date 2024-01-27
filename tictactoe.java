import java.util.Random;
import java.util.Scanner;

class Main {
    
    public static void main(String[] args)
    {
        Computer myComf = new Computer("keyown", "X");
        Player mePlay = new Player("me", "O");
        Board myBoard = new Board();
        System.out.println("ztarrt");
        myBoard.displayBoard();
        boolean canAim = false;
        while (canAim != true)
        {
            int[] moveCoords = myComf.makeMove();
            int[] moveOCoords = mePlay.makeMove();
            boolean validOMove = myBoard.addMove(moveCoords[0], moveCoords[1], "X");
            while (validOMove != true) {
                validOMove = myBoard.addMove(moveCoords[0], moveCoords[1], "X");
                moveCoords = myComf.makeMove();
            }
            System.out.println(" ");
            myBoard.displayBoard();
            canAim = myBoard.checkWin();
            if (canAim) {
                break;
            }
            
            boolean cantAim = myBoard.checkDraw();
            if (cantAim) {
                System.out.println("DRAW");
                break;
            }
            boolean validMove = myBoard.addMove(moveOCoords[0], moveOCoords[1], "O");
            while (validMove != true) {
                moveOCoords = mePlay.makeMove();
                validMove = myBoard.addMove(moveOCoords[0], moveOCoords[1], "O");
            }

            System.out.println(" ");
            myBoard.displayBoard();
            canAim = myBoard.checkWin();
            
        }
        
        
        }
    
}
class Board
{
    public String[][] board = new String[3][3];
    
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = "-";
            }
        }
    }
    
    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.board[i][j] + " ");
            }   
            System.out.println();
        }
    }
    
    public boolean addMove(int x, int y, String marker) {
        if (board[x][y].equals("-")) {
            board[x][y] = marker;
            return true;
        }
        else {
            return false;
        }
        
    }
    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("-")) {
                System.out.println("WIN");
                return true;
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals("-")) {
                System.out.println("WIN");
                return true;

            }
        }
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("-")) {
            System.out.println("WIN");
            return true;

        }
        if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]) && !board[2][0].equals("-")) {
            System.out.println("WIN");
            return true;

        }
    
        return false; // No winning condition found
    }
    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].equals("-")) {
                        return false;
                }
            }
    }
    return true;
    }
}

class Player
{
    String name, marker;
    public Player(String name, String marker) {
        this.name = name;
        this.marker = marker;
        }
    
    
    // returns an array containing move coordinates in [x, y]
    public int[] makeMove() {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String input1 = scan1.nextLine();
        String input2 = scan2.nextLine();
        int x = Integer.parseInt(input1);
        int y = Integer.parseInt(input2);
        int[] moveArray = new int[2];
        moveArray[0] = x;
        moveArray[1] = y;
        return moveArray;
        }
}

class Computer
{
    
    String name, marker; 
    Random random = new Random();
    
    
    // initializes computer player with name and marker
    public Computer(String name, String marker) {
        this.name = name;
        this.marker = marker;
        }
    
    
    // returns an array containing move coordinates in [x, y]
    public int[] makeMove() {
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        int[] moveArray = new int[2];
        moveArray[0] = x;
        moveArray[1] = y;
        return moveArray;
    }
}
