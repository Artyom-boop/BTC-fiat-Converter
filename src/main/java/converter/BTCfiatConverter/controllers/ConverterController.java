package converter.BTCfiatConverter.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import converter.BTCfiatConverter.model.ExchangeRates;
import converter.BTCfiatConverter.services.ConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    private final ConverterService converterService;

    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/exchange-rates")
    public ExchangeRates exchangeRates() throws JsonProcessingException {
        return converterService.getExchangeRates();
    }

    @GetMapping("/btc-rub")
    public String btcToRub(@RequestParam String value) throws JsonProcessingException {
        return converterService.btcToRub(Double.parseDouble(value)).toString();
    }

    @GetMapping("/btc-usd")
    public String btcToUsd(@RequestParam String value) throws JsonProcessingException {
        return converterService.btcToUsd(Double.parseDouble(value)).toString();
    }

    @GetMapping("/btc-eur")
    public String btcToEur(@RequestParam String value) throws JsonProcessingException {
        return converterService.btcToEur(Double.parseDouble(value)).toString();
    }

    @GetMapping("/btc-cny")
    public String btcToCny(@RequestParam String value) throws JsonProcessingException {
        return converterService.btcToCny(Double.parseDouble(value)).toString();
    }
}
