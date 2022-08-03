package service;

import entity.Score;

import java.util.List;

public interface ScoreService {

    void addScore(Score score);

    List<Score> getBestScores(String game);

    void reset();
}
