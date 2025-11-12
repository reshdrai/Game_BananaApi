package com.resh.gamebananaapi.Controller;

import com.resh.gamebananaapi.Entity.GameRound;
import com.resh.gamebananaapi.Entity.User;
import com.resh.gamebananaapi.Repository.GameRoundRepository;
import com.resh.gamebananaapi.Repository.UserRepository;
import com.resh.gamebananaapi.Service.BananaService;
import com.resh.gamebananaapi.Service.GameService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;



@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired private BananaService bananaService;
    @Autowired private GameService gameService;
    @Autowired private UserRepository userRepository;
    @Autowired private GameRoundRepository gameRoundRepository;

    // Start a new game round
    @GetMapping("/start/{username}")
    public GameRound startGame(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) user = userRepository.save(new User(username));

        Map<String, Object> puzzle = bananaService.getBananaPuzzle();

        String imageUrl = (String)puzzle.get("question");
        String solution = puzzle.get("solution").toString();

        return gameService.startRound(user, imageUrl, solution);
    }

    // Submit a guess for a round
    @PostMapping("/guess")
    public GameRound submitGuess(
            @RequestParam String username,
            @RequestParam String roundId,
            @RequestParam String guess
    ) {
        User user = userRepository.findByUsername(username);
        GameRound round = gameRoundRepository.findById(roundId)
                .orElseThrow(() -> new RuntimeException("Round not found"));

        return gameService.submitGuess(round, guess);
    }
}
