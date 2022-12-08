package converter.BTCfiatConverter.model;

import org.springframework.stereotype.Component;

@Component
public class ExchangeRates {
    private Integer btcToRub;

    public Integer getBtcToRub() {
        return btcToRub;
    }

    public void setBtcToRub(Integer btcToRub) {
        this.btcToRub = btcToRub;
    }
}
