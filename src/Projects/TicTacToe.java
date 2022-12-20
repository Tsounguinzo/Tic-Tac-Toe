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

public class TicTacToe {
    public static void main(String[] args){
        Play game = new Play();
        introduction();
        game.match();
    }


    public static void introduction() {
        System.out.println("\u001B[36m" + "WELCOME TO THE TIC TAC TOE GAME!" + "\u001B[0m");

    }
}


