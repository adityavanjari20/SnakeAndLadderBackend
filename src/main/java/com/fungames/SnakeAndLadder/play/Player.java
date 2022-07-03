package com.fungames.SnakeAndLadder.play;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode

public class Player {
    private String playerName;
    private int id;

    public Player(String playerName, int id) {
        this.playerName = playerName;
        this.id = id;
    }
}

