package baseball.service;

import baseball.vo.Result;
import baseball.vo.Computer;
import baseball.vo.Player;

import java.util.List;

public class GameService {
    private final Computer computer = Computer.getInstance();
    private final Player player = Player.getInstance();
    private List<Integer> computerNumbers;

    private GameService() { }
    private static final GameService instance = new GameService();
    public static GameService getInstance() {
        return instance;
    }

    public void refreshComputerNumbers() {
        computerNumbers = computer.generateGameNumberList();
    }

    // TODO computerNumbers가 초기화되지 않았을 때 이 메소드를 사용하지 못하게 하기
    public Result guessNumbers(String guessingNumbers) throws IllegalArgumentException {
        List<Integer> playerNumbers = player.generateGameNumberList(guessingNumbers);
        return new Result(computerNumbers, playerNumbers);
    }
}
