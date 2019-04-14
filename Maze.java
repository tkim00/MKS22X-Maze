import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
        animate = false;
        int rows = 1;
        int cols = 0;
        File file = new File(filename);
        Scanner inf = new Scanner(file);
        cols = inf.nextLine().length();
        while (inf.hasNextLine()) {
          rows++;
          inf.nextLine();
        }
        maze = new char[rows][cols];
        int r = 0;
        inf = new Scanner(file);
        while (inf.hasNextLine()) {
          String line = inf.nextLine();
          //System.out.println(line.length());
          for (int c = 0; c < line.length(); c++) {
            maze[r][c] = line.charAt(c);
            //System.out.print(maze[r][c]);
          }
          //System.out.println(r);
          r++;
        }
    }


    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }

    public String toString() {
      String str = "";
      for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[i].length; j++) {
          str += maze[i][j];
        }
        str += "\n";
      }
      return str;
    }

    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
      int r = 0;
      int c = 0;
      for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length; j++) {
          if (maze[i][j] == 'S') {
            r = i;
            c = j;
            maze[i][j] = ' ';
            break;
          }
        }
      }
      return solve(r, c, 0);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int counter){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(100);
        }

        //COMPLETE SOLVE
        if (maze[row][col] == 'E') {
          return counter;
        }
        // if (maze[row][col] == '#' || maze[row][col] == '.' || maze[row][col] == '@') {
        //   return -1;
        // }
        maze[row][col] = '@';
        if (maze[row+1][col] == ' ') {
          solve(row+1, col, counter+1);
        }
        else if (maze[row-1][col] == ' ') {
          solve(row-1, col, counter+1);
        }
        else if (maze[row][col+1] == ' ') {
          solve(row, col+1, counter+1);
        }
        else if (maze[row][col-1] == ' ') {
          solve(row, col-1, counter+1);
        }
        maze[row][col] = '.';
        // if (maze[row][col] == ' ') {
        //   maze[row][col] = '@';
        //   solve(row+1, col, counter+1);
        //   solve(row-1, col, counter+1);
        //   solve(row, col+1, counter+1);
        //   solve(row, col-1, counter+1);
        //   maze[row][col] = '.';
        // }

        return -1; //so it compiles
    }


}
