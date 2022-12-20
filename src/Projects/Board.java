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

        /**
         * The {@code Board} class represents the corresponding real world grid.
         * All boards used in this game are derived from this class.
         */

        public class Board {

            /**
             * occupied parameter: help to track which spaces (number) is already occupied.
             * The board is a hardcoded <i>two-dimensional array</i>.
             * Note: The board is hardcoded because its dimensions will never change.
             */
    private String occupied=" ";
    String[][] board = new String[][]{
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}};

            /**
             * Used to initialise a newly created {@code Board} Object which the above hardcoded values.
             */
    public Board() {}

            /**
             * This method is used to mark the position played by the user with either X or O,
             * it also keeps track of the position played by the user via <b>String concatenation</b>.
             * @param position represents the position played by the user from one of the nine spaces in the grid.
             * @param XorO It represents mark placed by the user.
             */

    public void setBoard(int position, String XorO){
    for(int i = 0; i<board.length; i++){
        for (int j = 0; j<board[i].length; j++){
            if(board[i][j].equals("" + position)) {
                this.occupied += this.board[i][j];
                this.board[i][j] = XorO;
                }
            }
        }
    }

            /**
             * To get the String representation of positions already occupied in the grids.
             * @return the number already occupied in the grid as a concatenated string.
             */
    public String getOccupied() {return occupied;}

            /**
             * used to print the game grid row-by-row
             */
    public void printBoard() {
        for (String[] strings : board) {
            for (String print : strings)
                System.out.print(print + "\t");
            System.out.println();
        }
    }

            /**
             * Indicates whether a player got the winning arrangement.
             * @return {@code true} if a player succeeds in placing three of their marks
             * in a horizontal, vertical, or diagonal row; {@code false} otherwise.
             */
    public boolean isGameOver()
    {
        if      ((board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) || (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]))) return true;
        else if ((board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) || (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]))) return true;
        else if ((board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) || (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]))) return true;
        else return (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) || (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]));
    }

            /**
             * A method used to avoid choosing a same position twice; thus, avoiding overlapping.
             * @param num the position the player wishes to play.
             * @return {@code true} if the position has not been played yet; {@code false} otherwise.
             * <pre>
             *     Note: the statement {@code (char) (num + '0')} is used to convert an Integer
             *     into it's corresponding character representation in the <b>ASCII table</b>.
             * </pre>
             */
    public boolean isNumberOccupied(int num){
        boolean isOccupied = false;
        for(int i =0; i<occupied.length() ; i++){
            if (occupied.charAt(i) == (char) (num + '0')) {
                isOccupied = true;
                break;
            }
        }
        return isOccupied;
    }

            /**
             * This method is used to check if the board is full.
             * @return {@code true} if the grid is full; {@code false} otherwise.
             */
    public boolean isBoardFull(){
        boolean result = true;
        int[] test ={1,2,3,4,5,6,7,8,9};
        for (String[] strings: this.board){
            for (String str : strings){
                for (int value : test){
                    if (str.equals("" + value)) {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;
    }

} // end of Board class.


