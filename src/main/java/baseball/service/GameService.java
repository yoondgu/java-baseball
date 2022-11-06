package baseball.service;

import baseball.vo.Computer;
import baseball.vo.Player;

import java.util.List;

public class GameService {
    private GameService() {
        refreshComputerNumbers();
    }
    private static final GameService instance = new GameService();
    public static GameService getInstance() {
        return instance;
    }

    private final Computer computer = Computer.getInstance();
    private final Player player = Player.getInstance();
    private List<Integer> computerNumbers;

    public void refreshComputerNumbers() {
        computerNumbers = computer.generateNumberList();
    }

    public boolean guessNumbers(String guessingNumbers) {
        List<Integer> playerNumbers = player.generateNumberList(guessingNumbers);
        // TODO 두 수가 맞는지 확인하기
        return true;
    }
}
