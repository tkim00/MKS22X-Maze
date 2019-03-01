import java.util.*;
import java.io.*;
public class Tester {
  public static void main(String[] args) {
    // try {
    //   Maze maze1 = new Maze("data1.dat");
    // } catch(Exception FileNotFoundException) {
    //   System.out.println("something went wrong");
    // }
    //char[][] maze;
    int rows = 0;
    int cols = 0;
    File file = new File("data1.dat");
    Scanner inf = new Scanner(file);
    cols = inf.nextLine().length();
    while (inf.hasNextLine()) {
      rows++;
    }
    char[][] maze = char[rows][cols];
    while (inf.hasNextLine()) {
      String line = inf.nextLine();
      for (int c = 0; c < line.length(); c++) {
        if (line.charAt(c) == '\n') {
          System.out.print('\n');
          r++;
        } else {
          maze[r][c] = line.charAt(c);
          System.out.print(maze[r][c]);
        }
      }
    }
  }
}
