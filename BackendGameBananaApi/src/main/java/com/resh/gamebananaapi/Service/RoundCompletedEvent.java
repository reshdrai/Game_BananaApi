package com.resh.gamebananaapi.Service;

import com.resh.gamebananaapi.Entity.GameRound;
import org.springframework.context.ApplicationEvent;

public class RoundCompletedEvent extends ApplicationEvent {
    private final GameRound round;


    public RoundCompletedEvent(Object source, GameRound round) {
        super(source);
        this.round = round;
    }


    public GameRound getRound() { return round; }
}
