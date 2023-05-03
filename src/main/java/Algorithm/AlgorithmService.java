package Algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.stereotype.Service;

@Service
public class AlgorithmService {
	public boolean isValidObstacle(List<Map<String, Integer>> obstacleCoord, List<Map<String, Integer>> playerCoord) {
        // For player1
        _initialize();

        Map<String, Integer> obstacle_F = obstacleCoord.get(0);
        Map<String, Integer> obstacle_S = obstacleCoord.get(1);

        Map<String, Integer> player1 = playerCoord.get(0);
        Map<String, Integer> player2 = playerCoord.get(1);

        visited[obstacle_F.get("X")][obstacle_F.get("Y")] = BLOCKED;
        visited[obstacle_S.get("X")][obstacle_S.get("Y")] = BLOCKED;

        boolean flag1 = false;
        Queue<Map<String, Integer>> Q1 = new LinkedList<>();
        Q1.offer(player1);

        while (!Q1.isEmpty()) {
            Map<String, Integer> cur = Q1.poll();
            for (int direction = 0; direction < 4; direction++) {
                int nx = dx[direction] + cur.get("X");
                int ny = dy[direction] + cur.get("Y");

                if (nx < 0 || nx >= BORD_SIZE || ny < 0 || ny >= BORD_SIZE) continue;
                if (board[nx][ny] == BLOCKED || visited[nx][ny] == VISITED) continue;
                if (ny == (BORD_SIZE - 1)) {
                    flag1 = true;
                    break;
                }

                visited[nx][ny] = VISITED;
                Q1.offer(Map.of("X", nx, "Y", ny));
            }
            if (flag1) break;
        }

        _initialize();

        obstacle_F = obstacleCoord.get(0);
        obstacle_S = obstacleCoord.get(1);

        visited[obstacle_F.get("X")][obstacle_F.get("Y")] = BLOCKED;
        visited[obstacle_S.get("X")][obstacle_S.get("Y")] = BLOCKED;

        boolean flag2 = false;
        Queue<Map<String, Integer>> Q2 = new LinkedList<>();
        Q2.offer(player2);

        while (!Q2.isEmpty()) {
            Map<String, Integer> cur = Q2.poll();
            for (int direction = 0; direction < 4; direction++) {
                int nx = dx[direction] + cur.get("X");
                int ny = dy[direction] + cur.get("Y");

                if (nx < 0 || nx >= BORD_SIZE || ny < 0 || ny >= BORD_SIZE) continue;
                if (board[nx][ny] == BLOCKED || visited[nx][ny] == VISITED) continue;
                if (ny == 0) {
                    flag2 = true;
                    break;
                }

                visited[nx][ny] = VISITED;
                Q2.offer(Map.of("X", nx, "Y", ny));
            }
            if (flag2) break;
        }

        if (flag1 && flag2) {
            return true;
        } else {
            return false;
        }
        
        void _initialize() {
            //init visited
            for (int i = 0; i < BORD_SIZE; i++) {
                for (int j = 0; j < BORD_SIZE; j++) {
                    visited[i][j] = 0;
                }
            }

            //copy visited -> board
            for (int i = 0; i < BORD_SIZE; i++) {
                for (int j = 0; j < BORD_SIZE; j++) {
                    visited[i][j] = board[i][j];
                }
            }
        }
}
