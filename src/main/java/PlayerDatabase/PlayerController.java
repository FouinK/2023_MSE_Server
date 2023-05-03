package PlayerDatabase;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PlayerController {
	
	private final PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
	
	// winner 객체, looser 객체 따로따로 요청을 받아서 
	// playerService에서 winner는 win+1, looser는 lose+1 해줄거임

//   RequestBody

//	{
//		  "playerId" : "",
//		  "wins" : true or false
//	}

	
	@GetMapping("/database/player/...")
	// 
	
    @PostMapping("/database/player/...")
    // playerService.crud(playerId) 를 사용하는 로직
	
	@PutMapping()
	
	@DeleteMapping()
}