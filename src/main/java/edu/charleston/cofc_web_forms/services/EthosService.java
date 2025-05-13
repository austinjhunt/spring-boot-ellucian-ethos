package edu.charleston.cofc_web_forms.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ellucian.ethos.integration.client.EthosClientBuilder;
import com.ellucian.ethos.integration.client.proxy.EthosProxyClient;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class EthosService {
    @Value("${ethos.api.key}")
    private String ethosApiKey;

    private EthosProxyClient<String> ethosProxyClient;

    @SuppressWarnings("unchecked")
    public EthosService() {
        String ethosApiKey = System.getenv("ETHOS_API_KEY");
        if (ethosApiKey == null) {
            throw new IllegalArgumentException("ETHOS_API_KEY environment variable is not set");
        }
        this.ethosProxyClient = new EthosClientBuilder(ethosApiKey).buildEthosProxyClient();
    }

    public JsonNode getResource(String resourceName) throws Exception {
        try {
            JsonNode response = ethosProxyClient.getAsJsonNode(resourceName);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch courses from Ethos API", e);
        }
    }

}
