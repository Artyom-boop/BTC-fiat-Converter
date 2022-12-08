package converter.BTCfiatConverter.model;

import org.springframework.stereotype.Component;

@Component
public class ExchangeRates {
    private Integer btcToRub;
    private Integer btcToUsd;

    public Integer getBtcToRub() {
        return btcToRub;
    }

    public void setBtcToRub(Integer btcToRub) {
        this.btcToRub = btcToRub;
    }

    public Integer getBtcToUsd() {
        return btcToUsd;
    }

    public void setBtcToUsd(Integer btcToUsd) {
        this.btcToUsd = btcToUsd;
    }
}
