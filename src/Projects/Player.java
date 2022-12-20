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
         * The {@code Player} class represents the corresponding real world Player,
         * it manages all the actions the player can do.
         * All players are implemented as instances of this class.
         */
public class Player {
            /**
             * PlayerName : Used to personalise players name.
             * position : used to choose a position on the grid.
             * XorO : represents the mark made by a player.
             */
    private String playerName;
    private int position;
    private String XorO;

            /**
             * To create a new player with a randomly assign initial position.
             * @param playerName the name parsed in by to user to identify his player.
             * @param XorO the mark used by the user
             * The first player shall be assigned the mark X by default during the implementation of
             * this constructor.
             */
    public  Player (String playerName, String XorO){
     this.position = (int)(Math.random()*9+1); // random number between 1 and 9
     this.playerName = playerName;
     this.XorO = XorO;
    }

            /**
             * To create a new player with an initial position of his choice.
             * @param playerName the name parsed in by to user to identify his player.
             * @param XorO the mark used by the user
             * The first player shall be assigned the mark X by default during the implementation of
             * this constructor.
             * @param position initial position chosen by the user.
             *  The position is validated using {@code setPosition()} method.
             */
    public Player (int position,String playerName,String XorO){
        setPosition(position);
        this.playerName = playerName;
        this.XorO = XorO;
    }

            /**
             * @return the current position chosen the user.
             */
    public int getPosition(){return this.position;}

            /**
             * @return the name of assign to the object.
             */
    public String getPlayerName() {return this.playerName;}

            /**
             * @return the character assign to the user.
             */
    public String getXorO() {return this.XorO;}


            /**
             * used to assign a value to the position of the player.
             * Note: this method check if the user input is the range 1 - 9 inclusive
             * and if it is not in that range it assign the value -1.
             * @param position the position chosen by the user from the grid.
             */
   public void setPosition(int position){this.position = (position >= 1 && position <= 9)? position : -1;}

            /**
             * @param playerName sets the name of Player to the parsed in argument.
             */
    public void setPlayerName(String playerName) {this.playerName = playerName;}

            /**
             * @param xorO Sets the user with a mark.
             */
    public void setXorO(String xorO) {this.XorO = xorO;}

} // end of Player class.