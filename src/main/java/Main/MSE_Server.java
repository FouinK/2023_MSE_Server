package Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) // db사용 안하겠다는 뜻. db구축 후에 삭제
public class MSE_Server {

	public static void main(String[] args) {
		SpringApplication.run(MSE_Server.class, args);
	}

}
