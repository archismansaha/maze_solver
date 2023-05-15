import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Maze_Solver  extends JFrame {
    private int[][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };  // 1= obstacle, 0 = points through which we can go, 9 = destination point

    public ArrayList<Integer> path = new ArrayList<>();

    // constructor
    public Maze_Solver() {
        setTitle("Maze Solver");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dfs.searchPath(maze,1,1,path);
    }

    @Override
    public void paint(Graphics g) {
        g.translate(150,50);

        for(int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1: color = Color.BLACK;break; // obstacles are black
                    case 9: color = Color.BLUE;break; // destination is blue
                    default: color = Color.PINK;break; // path is pink
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0; i<path.size(); i+=2) {
            int row = path.get(i);
            int col = path.get(i+1);

            g.setColor(Color.GREEN); // solution path is green circled cells
            g.fillRect(30*col,30*row,20,20);
        }
    }



    public static void main(String[] args) {
        Maze_Solver view = new Maze_Solver();
        view.setVisible(true);
    }
}
