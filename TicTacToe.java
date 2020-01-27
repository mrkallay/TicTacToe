import java.util.Scanner;

public class TicTacToe
{

    private char[][] board = new char[3][3];

    //current turn flips between 1 and -1 (1 is x or p1)
    private int currentTurn = 1;

    private boolean didQuit = false;

    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);
        TicTacToe ttt = new TicTacToe();
        ttt.initBoard();
        ttt.displayBoard();

        //TODO: implement ability to quit
        while (!ttt.didQuit)
        {
            //move must be entered in row col
            //for example: 1 1 would be the center space
            System.out.println(ttt.getMark() + ", choose your location (row column):");
            String currentMove = keyboard.nextLine();

            ttt.processMove(currentMove);
            ttt.checkBoard();
            ttt.displayBoard();
        }
    }

    public char getMark()
    {
        return currentTurn == 1 ? 'X' : 'O';
    }

    public void processMove(String move)
    {
        if (move.length() != 3)
        {
            System.out.println("INVALID MOVE...");
            return;
        }
        int row = Integer.parseInt(String.valueOf(move.charAt(0)));
        int col = Integer.parseInt(String.valueOf(move.charAt(2)));

        if(row > 2 || col > 2)
        {
            System.out.println("INVALID MOVE...");
            return;
        }

        if (board[row][col] == ' ')
        {
            char mark = getMark();

            board[row][col] = mark;

            //flip currentTurn
            currentTurn *= -1;
        }
        else
        {
            //invalid move, space taken
            System.out.println("**********SPACE TAKEN*********");
        }
    }

    //TODO: this method should check to see if there is a win or draw
    //      if either case is true display a message to the user and end game
   public void checkBoard()
    {
        checkRow();
        checkColumn();
        checkDiagonalLeftToRight();
        checkDiagonalRightToLeft();
        
    }

    public void checkRow()
    {
        for ( int r=0; r<3; r++ )
        {
                if(board[r][0] != ' ' && board[r][0] == board[r][1] && board[r][0] == board[r][2])
                {
                    System.out.println("You Win");
                }
            }
        }

    public void checkColumn()
    {
        for ( int c=0; c<3; c++ )
        {
            if(board[0][c] != ' ' && board[0][c] == board[1][c] && board[0][c] == board[2][c])
            {
                System.out.println("You Win");
            }
        }
    }
    public void checkDiagonalLeftToRight()
    {
        for ( int r=0; r<3; r++ )
        {
            if(board[r][0] != ' ' && board[r][0] == board[1][1] && board[r][0] == board[2][2])
            {
                System.out.println("You Win");
            }
        }
    }

    public void checkDiagonalRightToLeft()
    {
        for ( int c=0; c<3; c++ )
        {
            if(board[0][c] != ' ' && board[0][c] == board[1][1] && board[0][c] == board[2][0])
            {
                System.out.println("You Win");
            }
        }
    }


    public void initBoard()
    {
        // fills up the board with blanks
        for ( int r=0; r<3; r++ )
            for ( int c=0; c<3; c++ )
                board[r][c] = ' ';
    }


    public  void displayBoard()
    {
        for ( int r=0; r<3; r++ )
        {
            System.out.print("\t"+r+" ");
            for ( int c=0; c<3; c++ )
            {
                System.out.print( board[r][c] + " " );
            }
            System.out.println();
        }
        System.out.println("\t  0 1 2 ");
    }
}
