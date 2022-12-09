package converter.BTCfiatConverter.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import converter.BTCfiatConverter.model.ExchangeRates;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConverterService {
    private final ExchangeRates exchangeRates;

    public ConverterService(ExchangeRates exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public ExchangeRates getExchangeRates() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.blockchain.com/ru/ticker";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(restTemplate.getForObject(url, String.class));
        exchangeRates.setBtcToRub(root.at("/RUB/last").asInt());
        exchangeRates.setBtcToUsd(root.at("/USD/last").asInt());
        exchangeRates.setBtcToEur(root.at("/EUR/last").asInt());
        return exchangeRates;
    }

    public Double btcToRub(Double value) throws JsonProcessingException {
        getExchangeRates();
        return value * exchangeRates.getBtcToRub();
    }

    public Double btcToUsd(Double value) throws JsonProcessingException {
        getExchangeRates();
        return value * exchangeRates.getBtcToUsd();
    }

    public Double btcToEur(Double value) throws JsonProcessingException {
        getExchangeRates();
        return value * exchangeRates.getBtcToEur();
    }
}
