import java.util.Scanner;

/**
 * MonsterMaze Program - HW06
 *
 * This program is a game called MonsterMaze, in which the player chooses
 * an input between WASD that controls their player on a grid, with the
 * goal of ending the program by reaching the goal. Another way to end the
 * program is by colliding with a monster on the board. The grid size,
 * player, and grid starting locations are all customizable. The number of
 * monsters and each of their respective starting locations are also
 * customizable.
 *
 * @author Andres Maldonado, Lab Section L18
 *
 * @version February 25, 2026
 *
 */

public class MonsterMaze {

    // Constants for Prompts
    public static final String WELCOME_MESSAGE = "Welcome to Monster Maze!";
    public static final String INPUT_SIZE = "Enter grid rows and columns:";
    public static final String INPUT_START = "Enter player start row and column:";
    public static final String INPUT_GOAL = "Enter goal row and column:";
    public static final String INPUT_MONSTERS = "Enter number of monsters and their locations (row col):";
    public static final String MOVE = "Enter move (W/A/S/D):";
    public static final String INVALID_MOVE = "Invalid move! You hit a wall, but the monsters keep moving...";
    public static final String GAME_OVER = "A monster caught you! Game Over.";
    public static final String REACH_GOAL = "Congratulations! You reached the goal!";
    public static final String THANKS = "Thank you for playing!";

    static public void print(String arg) {
        System.out.println(arg);
    }

    static public int coordsParser(String input, int yz) {
        String[] coordsArray = input.split(",");
        int[] coordsArrayInts = new int[2];

        for (int i = 0; i < coordsArray.length; i++) {
            coordsArrayInts[i] = Integer.parseInt(coordsArray[i]);
        }
        int coord = coordsArrayInts[yz];

        return coord;
    }

    static void main(String[] args) {
        //initialization
        Scanner scan = new Scanner(System.in);
        String input;
        print(WELCOME_MESSAGE);

        print(INPUT_SIZE);
        input = scan.nextLine();
        Gameboard board = new Gameboard(coordsParser(input, 0), coordsParser(input, 1));

        print(INPUT_START);
        input = scan.nextLine();
        Entity player = new Entity(coordsParser(input, 0), coordsParser(input, 1));

        print(INPUT_GOAL);
        input = scan.nextLine();
        Entity goal = new Entity(coordsParser(input, 0), coordsParser(input, 1));

        print(INPUT_MONSTERS);
        int numMonsters = scan.nextInt();
        scan.nextLine();
        Entity[] monsters = new Entity[numMonsters];

        for (int i = 0; i < numMonsters; i++) {
            input = scan.nextLine();
            monsters[i] = new Entity(coordsParser(input, 0), coordsParser(input, 1));
        }

        boolean gameDone = false;
        while (!gameDone) {
            print(MOVE);
            input = (scan.nextLine()).toUpperCase();

            switch (input) {
                case "W":
                    player.moveUp(board);
                    break;
                case "S":
                    player.moveDown(board);
                    break;
                case "D":
                    player.moveRight(board);
                    break;
                case "A":
                    player.moveLeft(board);
                    break;
            }

            for (Entity monster : monsters) {
                monster.monsterMoveUp(board);
                if (monster.outOfBounds(board)) {
                    monster.setYPos(monster.getYPos() + board.getYSize());
                }
            }

            //tester code
            //System.out.printf("Player Loc is: [%d, %d]\n", player.getYPos(), player.getXPos());
            //System.out.printf("Goal Loc is: [%d, %d]\n\n", goal.getYPos(), goal.getXPos());
            //for (int i = 0; i < monsters.length; i++) {
            //    System.out.printf("Monster %d Loc is: [%d, %d]\n",
            //            i + 1, monsters[i].getXPos(), monsters[i].getYPos());

            //check monster collision
            for (Entity monster : monsters) {
                if ((player.getXPos() == monster.getXPos()) &&
                        player.getYPos() == monster.getYPos()) {
                    print(GAME_OVER);
                    gameDone = true;
                }
            }

            //check goal collision
            if ((player.getXPos() == goal.getXPos()) &&
                    player.getYPos() == goal.getYPos()) {
                print(REACH_GOAL);
                gameDone = true;
            }
        }

        print(THANKS);
    }


    static class Gameboard {
        private int xSize;
        private int ySize;

        // construct gameboard
        public Gameboard(int ySize, int xSize) {
            this.xSize = xSize;
            this.ySize = ySize;
        }

        // get gameboard stuffs
        public int getXSize() {return xSize;}
        public int getYSize() {return ySize;}
    }

    static class Entity {
        private int xPos;
        private int yPos;

        // construct entity
        public Entity(int yPos, int xPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        // initialize position function
        public void setPos(int yPos, int xPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        public void setYPos(int yPos) {
            this.yPos = yPos;
        }
        public void setXPos(int xPos) {
            this.xPos = xPos;
        }

        // get positions
        public int getXPos() { return xPos; }
        public int getYPos() { return yPos; }

        // movement functions
        public void moveDown(Gameboard board) {
            this.yPos++;
            if (outOfBounds(board)) {
                this.yPos--;
                print(INVALID_MOVE);
            }
        }
        public void moveUp(Gameboard board) {
            this.yPos--;
            if (outOfBounds(board)) {
                this.yPos++;
                print(INVALID_MOVE);
            }
        }
        public void moveRight(Gameboard board) {
            this.xPos++;
            if (outOfBounds(board)) {
                this.xPos--;
                print(INVALID_MOVE);
            }
        }
        public void moveLeft(Gameboard board) {
            this.xPos--;
            if (outOfBounds(board)) {
                this.xPos++;
                print(INVALID_MOVE);
            }
        }

        //monster movement
        public void monsterMoveUp(Gameboard board) {
            this.yPos--;
            if (outOfBounds(board)) {
                this.yPos += board.getYSize() + 1;
            }
        }

        // check if out of bounds
        public boolean outOfBounds(Gameboard board) {
            return (this.yPos < 0) || (this.yPos > board.getYSize()) ||
                    (this.xPos < 0) || (this.xPos > board.getXSize());
        }
    }




}

