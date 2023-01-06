```main:```
![badge](https://github.com/Artyom-boop/BTC-fiat-Converter/actions/workflows/test.yml/badge.svg?branch=main)
```develop:```
![badge](https://github.com/Artyom-boop/BTC-fiat-Converter/actions/workflows/test.yml/badge.svg?branch=develop)
# BTC-fiat-Converter

Ёто Rest API приложение дл€ конвертаций BTC в различные фиатные валюты.

## Install
### Docker

    docker build -t btc-fiat-converter .   
    docker run -ti --rm -p 8080:8084 btc-fiat-converter

## REST API

### ѕолучить курс всех валют

#### Request

`GET /exchange-rates`

#### Response

    {"btcToRub":1074439,"btcToUsd":17133,"btcToEur":16244,"btcToCny":121853}

#### Request

`GET /btc-rub?value=0.5`

#### Response

    537054.0

#### Request

`GET /btc-usd?value=0.5`

#### Response

    8567.0

#### Request

`GET /btc-eur?value=0.5`

#### Response

    8122.5

#### Request

`GET /btc-cny?value=0.5`

#### Response

    60914.0