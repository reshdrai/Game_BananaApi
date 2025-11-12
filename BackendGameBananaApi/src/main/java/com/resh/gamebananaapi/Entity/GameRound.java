package com.resh.gamebananaapi.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;




import jakarta.persistence.*;

@Entity
public class GameRound {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String prompt;     // solution
    private String imageUrl;
    private String userGuess;
    private int roundScore;

    @ManyToOne
    private User user;

    public GameRound() {}

    public GameRound(String prompt, String imageUrl, User user) {
        this.prompt = prompt;
        this.imageUrl = imageUrl;
        this.user = user;
    }

    public String getId() { return id; }
    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getUserGuess() { return userGuess; }
    public void setUserGuess(String userGuess) { this.userGuess = userGuess; }
    public int getRoundScore() { return roundScore; }
    public void setRoundScore(int roundScore) { this.roundScore = roundScore; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}


