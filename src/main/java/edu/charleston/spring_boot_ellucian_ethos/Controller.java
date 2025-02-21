package edu.charleston.spring_boot_ellucian_ethos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ellucian.ethos.integration.client.EthosClientBuilder;
import com.ellucian.ethos.integration.client.EthosResponse;
import com.ellucian.ethos.integration.client.proxy.EthosProxyClient;

@RestController
public class Controller {

	@Value("${ethos.api.key}")
	private String ethosApiKey;

	@GetMapping(value = "/test", produces = "application/json")
	public String test() {
		return "{\"apiKey\": \"" + ethosApiKey + "\"}";
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping(value = "/courses", produces = "application/json")
	public String courses() { 
		// Create Proxy Client
		// read apiKey from environment variable ETHOS_API_KEY
		String apiKey = System.getenv("ETHOS_API_KEY");
		if (apiKey == null) {
			System.out.println("ETHOS_API_KEY is not set");
			return "{\"error\": \"Cannot authenticate against ethos\"}";
		}
		EthosProxyClient<String> ethosProxyClient = new EthosClientBuilder(apiKey).buildEthosProxyClient();
		try {
			EthosResponse<String> response = ethosProxyClient.get("courses");
			return response.getContent();
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"error\": \"" + e.getMessage() + "\"}";
		}  
	}
}  
