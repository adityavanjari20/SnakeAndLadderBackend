package com.fungames.SnakeAndLadder.play;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j

@RestController
@RequestMapping("home/")
@AllArgsConstructor
public class PlayController {

    private RestartEndpoint restartEndpoint;
    private GameBoardServicer gameBoardServicer;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("play")
    public Map<String, Integer> home(@RequestParam int rollValue) {

        log.info("dice roll value = " + rollValue);
        Map<String, Integer> data = gameBoardServicer.startGame(rollValue);

        return data;

    }

    @PostMapping("restart")
    public void restart(String name) {
        restartEndpoint.restart();
    }
}
