//package Algorithm;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AlgorithmController {
//	
//	private final AlgorithmService algorithmService;
//	
//	public AlgorithmController(AlgorithmService algorithmService) {
//        this.algorithmService = algorithmService;
//    }
//    @PostMapping("/api/isValidObstacle")
//    public boolean isValidObstacle(@RequestBody Map<String, List<Map<String, Integer>>> requestBody) {
//        List<Map<String, Integer>> obstacleCoord = requestBody.get("obstacleCoord");
//        List<Map<String, Integer>> playerCoord = requestBody.get("playerCoord");
//        
//        // isValidObstacle 알고리즘을 실행하는 코드
//        boolean result = algorithmService.isValidObstacle(obstacleCoord, playerCoord);
//        
//        return result;
//    }
//}
