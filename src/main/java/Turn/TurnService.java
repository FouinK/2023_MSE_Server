package Turn;

import org.springframework.stereotype.Service;

@Service
public class TurnService {
	
    private Player currentPlayer;
    private Coordinate previousCoordinate;
    private final Player player1 = new Player("1", "Player 1", true);
    private final Player player2 = new Player("2", "Player 2", false);
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Coordinate getPreviousCoordinate() {
        return previousCoordinate;
    }
    
    public void setCoordinate(Coordinate coordinate) {
        if (currentPlayer == null) {
            currentPlayer = player1;
        } else {
            currentPlayer = currentPlayer == player1 ? player2 : player1;
        }
        previousCoordinate = coordinate;
        currentPlayer.setMyTurn(true);
    }
    
    public Player getPlayerById(String playerId) {
        if (player1.getId().equals(playerId)) {
            return player1;
        } else if (player2.getId().equals(playerId)) {
            return player2;
        } else {
            throw new RuntimeException("Invalid player ID");
        }
    }
    
    public void endTurn(String playerId) {
        if (player1.getId().equals(playerId)) {
            player1.setMyTurn(false);
        } else if (player2.getId().equals(playerId)) {
            player2.setMyTurn(false);
        } else {
            throw new RuntimeException("Invalid player ID");
        }
    }
	
}
