        /*
         * Copyright (c) 2022 Beaudelaire Tsoungui Nzodoumkouo. All rights reserved.
         * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
         *
         * This code is free software; you can redistribute it and/or modify it
         * under My consent.
         *
         * This code is shared on GitHub in the hope that it will be useful, but WITHOUT
         * ANY WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE.
         *
         * Please contact Me at +1 438 509 3906
         * or LinkedIn: https://www.linkedin.com/in/beaudelaire-tsoungui-nzodoumkouo-809744231
         * if you need additional information or have any questions.
         */

package Projects;

import java.util.InputMismatchException;
import java.util.Scanner;

        /**
         * The {@code Play} class is used to play the game while implementing the
         * methods from the {@code Board} and {@code Player} class.
         */
        public class Play {

            //Instantiating two scanner objects, one for String input and the other integers inputs.
            private Scanner stringInput = new Scanner(System.in);
            private static Scanner intInput = new Scanner(System.in);

   // ANSI escape code used to control the text color in our game.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    String X = ANSI_BLUE + "X" + ANSI_RESET, O = ANSI_YELLOW + "O" + ANSI_RESET;

    // This method is used to lunch the main screen of the game.
    public void match() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n\tType 1 to Enter your names");
                System.out.println("\tType 2 to Exit the game");
                System.out.print(ANSI_PURPLE + "\nchoice: " + ANSI_RESET);
                
                int choice = intInput.nextInt();
                
                switch (choice) {
                    case 1 -> { gamePreliminaries(); end = true; }
                    case 2 -> {System.out.println(ANSI_CYAN + "\nBYE BYE ^^" + ANSI_RESET);end = true;}
                    default -> System.out.println(ANSI_RED+"\nInvalid Choice!!\n"+ANSI_RESET);
                }

            }catch (InputMismatchException e){
                System.out.println(ANSI_RED+"\nInvalid Choice!!\n"+ANSI_RESET);
                intInput.next();
            }
        }
    }

    private void gamePreliminaries() {
        System.out.print("\n Enter the name of the first player: ");

        String player1 = ANSI_BLUE + stringInput.nextLine() + ANSI_RESET;

        System.out.print("\n Enter the name of the second player: ");

        String player2 = ANSI_YELLOW + stringInput.nextLine() + ANSI_RESET;

        System.out.println("\n WE HAVE " + player1 +" VS " + player2 + "!!\n");

        Player first, second;
        int x, y;

        boolean end = false;
        while (!end) {
            try {
                System.out.println(ANSI_CYAN + "\t\t\t How do you want to start\n" + ANSI_RESET);
                System.out.println("\tType 1 to get random initial positions in the game");
                System.out.println("\tType 2 to chose your initial positions in the game");
                System.out.print(ANSI_PURPLE + "\nchoice: " + ANSI_RESET);

                int choice = intInput.nextInt();

                switch (choice) {
                    case 1 -> {
                         first = new Player(player1, X);  second = new Player(player2, O);
                         while (first.getPosition() == second.getPosition())second.setPosition((int)(Math.random()*9+1));

                        System.out.println("\t"+player1 + " You have been assign the piece \""+X+"\" and "
                                +" Your initial position is " +ANSI_BLUE+ first.getPosition()+ ANSI_RESET);

                        System.out.println("\t"+player2 + " You have been assign the piece \""+O+"\" and "
                                            +" Your initial position is " +ANSI_YELLOW+ second.getPosition()+ ANSI_RESET);

                        System.out.println(ANSI_CYAN + "\nYou can start now!\n" + ANSI_RESET);

                        play(first,second);
                        end = true;
                    }
                    case 2 -> {
                        Board board = new Board();
                        System.out.println();
                        board.printBoard();

                        do{
                            System.out.print("\n" + player1 + " Which position do you Chose from the board above: ");
                             x = intInput.nextInt();
                        }while ((x < 1 || x > 9));

                        do{
                            System.out.print("\n"+player2 + " Which position do you Chose from the board above: ");
                             y = intInput.nextInt();
                        }while ((y < 1 || y > 9));

                         first = new Player(x,player1,X);
                         second = new Player(y,player2, O);

                        System.out.println("\n\t"+player1 + " You have been assign the piece \""+X+"\" and " + "Your initial position is " + first.getPosition());
                        System.out.println("\t"+player2 + " You have been assign the piece \""+O+"\" and " +" Your initial position is " + second.getPosition());
                        System.out.println(ANSI_CYAN + "\nYou can start now!\n" + ANSI_RESET);
                        play(first,second);
                        end = true;
                    }
                    default -> System.out.println(ANSI_RED+"\nInvalid Choice!!\n"+ANSI_RESET);
                }

            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"\nInvalid Choice!!\n"+ANSI_RESET);
                intInput.next();
            }
        }
    }

    private void play(Player one, Player two) {
        Board board = new Board();
        board.setBoard(one.getPosition(),one.getXorO());
        board.setBoard(two.getPosition(), two.getXorO());
        board.printBoard();
        String winner;

        while (true){
            try {

                do{
                    System.out.print("\n" + one.getPlayerName() + " Enter your next move -> " );
                    int x = intInput.nextInt();
                    one.setPosition(alreadyOccupied(x, board));
                }while (one.getPosition() == -1);

                board.setBoard(one.getPosition(),one.getXorO());
                board.printBoard();
                winner = one.getPlayerName();
                if(board.isGameOver() || board.isBoardFull()) break;

                do{
                    System.out.print("\n" + two.getPlayerName() + " Enter your next move -> " );
                    int y = intInput.nextInt();
                    two.setPosition(alreadyOccupied(y, board));
                }while (two.getPosition() == -1);

                board.setBoard(two.getPosition(), two.getXorO());
                winner = two.getPlayerName();
                if(board.isGameOver() || board.isBoardFull()) break;
                board.printBoard();

            }catch (InputMismatchException e){
                System.out.println(ANSI_RED+"\nInvalid Choice!!\n"+ANSI_RESET);
                intInput.next();
            }
        }

        System.out.println( ANSI_CYAN + "\nResults loading................\n" + ANSI_RESET);
        System.out.println((board.isGameOver())?  "Congrats " + winner + " You Won!!!\n" : ANSI_RED + " you both lose\n" + ANSI_RESET);
        board.printBoard();
        restart();
    }

    private void restart() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n\tType 1 to restart");
                System.out.println("\tType 2 to Exit the game");
                System.out.print(ANSI_PURPLE + "\nchoice: " + ANSI_RESET);

                int choice = intInput.nextInt();

                switch (choice) {
                    case 1 -> match();
                    case 2 -> {System.out.println(ANSI_CYAN + "\nBYE BYE ^^" + ANSI_RESET);end = true;}
                    default -> System.out.println(ANSI_RED+"\nInvalid Choice!!\n"+ANSI_RESET);
                }

            }catch (InputMismatchException e){
                System.out.print(ANSI_RED+"\nInvalid Choice!!\n"+ANSI_RESET);
                intInput.next();
            }
    }
    }

    private static int alreadyOccupied(int num, Board board){
        while (board.isNumberOccupied(num)){
            System.out.println(ANSI_RED + "\nThe Number is already occupied try again!" + ANSI_RESET);
            System.out.print( " Enter your next move -> " );
            num = intInput.nextInt();
            System.out.println();
        }
        return num;
    }
}