package converter.BTCfiatConverter.model;

import org.springframework.stereotype.Component;

@Component
public class ExchangeRates {
    private Integer btcToRub;
    private Integer btcToUsd;
    private Integer btcToEur;
    private Integer btcToCny;

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

    public Integer getBtcToEur() {
        return btcToEur;
    }

    public void setBtcToEur(Integer btcToEur) {
        this.btcToEur = btcToEur;
    }

    public Integer getBtcToCny() {
        return btcToCny;
    }

    public void setBtcToCny(Integer btcToCny) {
        this.btcToCny = btcToCny;
    }
}
