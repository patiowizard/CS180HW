import java.util.Scanner;

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

    static public int[] coordsParser(String input) {
        String[] coordsArray = input.split(",");
        for (String coord, coordsArray) {
            int[] coordsArrayInts = Integer.parseInt(coord);
        }
    }

    static void main(String[] args) {
        //initialization
        Scanner scan = new Scanner(System.in);
        String input;
        print(WELCOME_MESSAGE);

        print(INPUT_SIZE);
        Gameboard board = new Gameboard(10, 10);




        Entity[] monsters = new Entity[2];
        monsters[0] = new Entity(1, 3);
        monsters[1] = new Entity(1, 5);

        Entity player = new Entity(5, 3);
        Entity goal = new Entity(3, 2);

        boolean winState = false;
        while (!winState) {
            input = (scan.nextLine()).toUpperCase();
            switch (input) {
                case "W":
                    player.moveUp(board);
                    break;
                case "S" :
                    player.moveDown(board);
                    break;
                case "D" :
                    player.moveRight(board);
                    break;
                case "A" :
                    player.moveLeft(board);
                    break;
            }

            for (Entity monster : monsters) {
                monster.monsterMoveDown(board);
                if (monster.outOfBounds(board)) {
                    monster.setYPos(monster.getYPos() + board.getYSize());
                }
            }


            System.out.printf("Player Loc is: [%d, %d]\n", player.getXPos(), player.getYPos());
            System.out.printf("Goal Loc is: [%d, %d]\n\n", goal.getXPos(), goal.getYPos());

            for (int i = 0; i < monsters.length; i++) {
                System.out.printf("Monster %d Loc is: [%d, %d]\n",
                        i + 1, monsters[i].getXPos(), monsters[i].getYPos());
            }

            if ((player.getXPos() == goal.getXPos()) &&
                    player.getYPos() == goal.getYPos()) {
                print("User is winning!");
            } else {
                print("User is losing lol!");
            }

            if (input.equalsIgnoreCase("stop")) {
                winState = true;
            }
        }







    }

    static class Gameboard {
        private int xSize;
        private int ySize;

        // construct gameboard
        public Gameboard(int xSize, int ySize) {
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
        public Entity(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        // initialize position function
        public void setPos(int xPos, int yPos) {
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
        public void moveUp(Gameboard board) {
            this.yPos++;
            if (outOfBounds(board)) {
                this.yPos--;
                print(INVALID_MOVE);
            }
        }
        public void moveDown(Gameboard board) {
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
        public void monsterMoveDown(Gameboard board) {
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

