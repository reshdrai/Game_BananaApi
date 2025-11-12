package com.resh.gamebananaapi.Repository;

import com.resh.gamebananaapi.Entity.GameRound;
import com.resh.gamebananaapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GameRoundRepository extends JpaRepository<GameRound, String> {
    GameRound findTopByUserOrderByIdDesc(User user);
}
