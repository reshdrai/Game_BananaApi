package com.resh.gamebananaapi.Listener;

import com.resh.gamebananaapi.Entity.User;
import com.resh.gamebananaapi.Service.RoundCompletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;



@Component
public class RoundCompletedListener {
    @EventListener
    public void handleRoundCompleted(RoundCompletedEvent event) {
        User user = event.getRound().getUser();
        user.setTotalScore(user.getTotalScore() + event.getRound().getRoundScore());
        System.out.println("Round completed for user: " + user.getUsername());
    }
}
