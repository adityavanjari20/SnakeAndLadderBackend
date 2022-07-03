package com.fungames.SnakeAndLadder.play;

import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class config {
    @Bean
    GameBoardServicer gameSetup() {

        Player p1 = new Player("Joy", 1);
        Player p2 = new Player("Mave", 2);
        Player p3 = new Player("Aditya", 3);
        Player p4 = new Player("Rahul", 4);
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
        allPlayers.offer(p3);
        allPlayers.offer(p4);

        Jumper snake1 = new Jumper(16, 6);
        Jumper snake2 = new Jumper(46, 25);
        Jumper snake3 = new Jumper(49, 11);
        Jumper snake4 = new Jumper(62, 19);
        Jumper snake5 = new Jumper(64, 60);
        Jumper snake6 = new Jumper(74, 53);
        Jumper snake7 = new Jumper(89, 68);
        Jumper snake8 = new Jumper(92, 88);
        Jumper snake9 = new Jumper(95, 75);
        Jumper snake10 = new Jumper(99, 80);

        List<Jumper> snakes = new ArrayList<>();

        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);
        snakes.add(snake4);
        snakes.add(snake5);
        snakes.add(snake6);
        snakes.add(snake7);
        snakes.add(snake8);
        snakes.add(snake9);
        snakes.add(snake10);

        Jumper ladder1 = new Jumper(2, 38);
        Jumper ladder2 = new Jumper(7, 14);
        Jumper ladder3 = new Jumper(8, 31);
        Jumper ladder4 = new Jumper(15, 26);
        Jumper ladder5 = new Jumper(21, 42);
        Jumper ladder6 = new Jumper(28, 84);
        Jumper ladder7 = new Jumper(36, 44);
        Jumper ladder8 = new Jumper(51, 67);
        Jumper ladder9 = new Jumper(71, 91);
        Jumper ladder10 = new Jumper(78, 98);
        Jumper ladder11 = new Jumper(87, 94);

        List<Jumper> ladders = new ArrayList<>();

        ladders.add(ladder1);
        ladders.add(ladder2);
        ladders.add(ladder3);
        ladders.add(ladder4);
        ladders.add(ladder5);
        ladders.add(ladder6);
        ladders.add(ladder7);
        ladders.add(ladder8);
        ladders.add(ladder9);
        ladders.add(ladder10);
        ladders.add(ladder11);


        Map<String, Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put("Joy", 1);
        playersCurrentPosition.put("Mave", 1);
        playersCurrentPosition.put("Aditya", 1);
        playersCurrentPosition.put("Rahul", 1);

        GameBoardServicer gameBoardServicer = new GameBoardServicer(allPlayers, snakes, ladders, playersCurrentPosition, 100);

        return gameBoardServicer;
    }

    @Bean
    RestartEndpoint restart() {
        return new RestartEndpoint();
    }
}
