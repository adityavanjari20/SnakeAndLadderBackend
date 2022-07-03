package com.fungames.SnakeAndLadder.play;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoardServicer {


    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String, Integer> playersCurrentPosition;
    int boardSize;


    public GameBoardServicer(Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders, Map<String, Integer> playersCurrentPosition, int boardSize) {

        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

    public Map<String, Integer> startGame(int rollValue) {
        while (nextTurn.size() >= 4) {

            int[] nextPosition = new int[1];
            Player player = nextTurn.poll();
            int currentPosition = playersCurrentPosition.get(player.getPlayerName());
            int diceValue = rollValue;
            int nextCell = currentPosition + diceValue;
            // Overshoot the 100 square player must move back to of number of square
            // that are still left on dice
            if (nextCell > boardSize) {
                nextPosition[0] = currentPosition - (nextCell - boardSize);
                // check for the Snake and Ladder for the current postion
                return checkSnakeAndLadder(nextPosition[0], player);
                // if this condition satisfy then the player is winner
            } else if (nextCell == boardSize) {

                playersCurrentPosition.put(player.getPlayerName(), nextCell);
                return playersCurrentPosition;
            } else {
                // check for the Snake and Ladder for the current postion
                return checkSnakeAndLadder(nextCell, player);

            }

        }
        return null;
    }


    public Map<String, Integer> checkSnakeAndLadder(int nextCell, Player player) {

        int[] nextPosition = new int[1];
        boolean[] b = new boolean[1];
        nextPosition[0] = nextCell;
        snakes.forEach(v -> {
            if (v.startPoint == nextCell) {
                nextPosition[0] = v.endPoint;
            }
        });
        if (nextPosition[0] != nextCell)
            System.out.println(player.getPlayerName() + " Bitten by Snake present at: " + nextCell);
        ladders.forEach(v -> {
            if (v.startPoint == nextCell) {
                nextPosition[0] = v.endPoint;
                b[0] = true;
            }
        });
        if (nextPosition[0] != nextCell && b[0])
            System.out.println(player.getPlayerName() + " Got ladder present at: " + nextCell);
        if (nextPosition[0] == boardSize) {
            //Winner and updating the player position
            playersCurrentPosition.put(player.getPlayerName(), nextPosition[0]);
            return playersCurrentPosition;
        } else {
            //updating player position
            playersCurrentPosition.put(player.getPlayerName(), nextPosition[0]);
            //add the player back to queue
            nextTurn.offer(player);


            return playersCurrentPosition;

        }
    }
}
