package com.resh.gamebananaapi.Service;

import com.resh.gamebananaapi.Entity.GameRound;
import com.resh.gamebananaapi.Entity.User;
import com.resh.gamebananaapi.Repository.GameRoundRepository;
import com.resh.gamebananaapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Service
public class GameService {

    @Autowired private GameRoundRepository gameRoundRepository;

    // Start a new round
    public GameRound startRound(User user, String imageUrl, String solution) {
        GameRound round = new GameRound();
        round.setUser(user);
        round.setImageUrl(imageUrl);
        round.setPrompt(solution);
        round.setRoundScore(0);
        round.setUserGuess(null);

        return gameRoundRepository.save(round);
    }

    // Submit a guess
    public GameRound submitGuess(GameRound round, String guess) {
        round.setUserGuess(guess);
        int score = guess.equalsIgnoreCase(round.getPrompt()) ? 10 : 0;
        round.setRoundScore(score);

        return gameRoundRepository.save(round);
    }
}

