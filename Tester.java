import java.util.*;
import java.io.*;
public class Tester {
  public static void main(String[] args) {
    try {
      Maze maze1 = new Maze("data3.dat");
      maze1.setAnimate(true);
      System.out.println(maze1.solve());
      System.out.println(maze1);
      // Maze maze2 = new Maze("data2.dat");
      // System.out.println(maze2);
      // Maze maze3 = new Maze("data3.dat");
      // System.out.println(maze3);
    } catch(FileNotFoundException e) {
      System.out.println("the file is not found");
    }
    // char[][] maze;
    // int rows = 0;
    // int cols = 0;
    // File file = new File("data1.dat");
    // Scanner inf = new Scanner(file);
    // cols = inf.nextLine().length();
    // while (inf.hasNextLine()) {
    //   rows++;
    // }
    // char[][] maze = char[rows][cols];
    // while (inf.hasNextLine()) {
    //   String line = inf.nextLine();
    //   for (int c = 0; c < line.length(); c++) {
    //     if (line.charAt(c) == '\n') {
    //       System.out.print('\n');
    //       r++;
    //     } else {
    //       maze[r][c] = line.charAt(c);
    //       System.out.print(maze[r][c]);
    //     }
    //   }
    // }
  }
}
