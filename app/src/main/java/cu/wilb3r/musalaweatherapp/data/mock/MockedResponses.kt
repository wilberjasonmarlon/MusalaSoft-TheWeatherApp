package cu.wilb3r.musalaweatherapp.data.mock

import com.google.gson.Gson
import cu.wilb3r.musalaweatherapp.data.models.onecall.OneCallResponse
import cu.wilb3r.musalaweatherapp.data.models.reverse.ReverseResponse
import retrofit2.Response

const val onecallRaw = """{
    "lat": 22.4175,
    "lon": -83.6981,
    "timezone": "America/Havana",
    "timezone_offset": -14400,
    "current": {
        "dt": 1658265974,
        "sunrise": 1658228455,
        "sunset": 1658276453,
        "temp": 306,
        "feels_like": 307.83,
        "pressure": 1016,
        "humidity": 45,
        "dew_point": 292.5,
        "uvi": 4.51,
        "clouds": 54,
        "visibility": 10000,
        "wind_speed": 4.47,
        "wind_deg": 99,
        "wind_gust": 5.16,
        "weather": [
            {
                "id": 803,
                "main": "Clouds",
                "description": "broken clouds",
                "icon": "04d"
            }
        ]
    },
    "minutely": [
        {
            "dt": 1658266020,
            "precipitation": 0
        },
        {
            "dt": 1658266080,
            "precipitation": 0
        },
        {
            "dt": 1658266140,
            "precipitation": 0
        },
        {
            "dt": 1658266200,
            "precipitation": 0
        },
        {
            "dt": 1658266260,
            "precipitation": 0
        },
        {
            "dt": 1658266320,
            "precipitation": 0
        },
        {
            "dt": 1658266380,
            "precipitation": 0
        },
        {
            "dt": 1658266440,
            "precipitation": 0
        },
        {
            "dt": 1658266500,
            "precipitation": 0
        },
        {
            "dt": 1658266560,
            "precipitation": 0
        },
        {
            "dt": 1658266620,
            "precipitation": 0
        },
        {
            "dt": 1658266680,
            "precipitation": 0
        },
        {
            "dt": 1658266740,
            "precipitation": 0
        },
        {
            "dt": 1658266800,
            "precipitation": 0
        },
        {
            "dt": 1658266860,
            "precipitation": 0
        },
        {
            "dt": 1658266920,
            "precipitation": 0
        },
        {
            "dt": 1658266980,
            "precipitation": 0
        },
        {
            "dt": 1658267040,
            "precipitation": 0
        },
        {
            "dt": 1658267100,
            "precipitation": 0
        },
        {
            "dt": 1658267160,
            "precipitation": 0
        },
        {
            "dt": 1658267220,
            "precipitation": 0
        },
        {
            "dt": 1658267280,
            "precipitation": 0
        },
        {
            "dt": 1658267340,
            "precipitation": 0
        },
        {
            "dt": 1658267400,
            "precipitation": 0
        },
        {
            "dt": 1658267460,
            "precipitation": 0
        },
        {
            "dt": 1658267520,
            "precipitation": 0
        },
        {
            "dt": 1658267580,
            "precipitation": 0
        },
        {
            "dt": 1658267640,
            "precipitation": 0
        },
        {
            "dt": 1658267700,
            "precipitation": 0
        },
        {
            "dt": 1658267760,
            "precipitation": 0
        },
        {
            "dt": 1658267820,
            "precipitation": 0
        },
        {
            "dt": 1658267880,
            "precipitation": 0
        },
        {
            "dt": 1658267940,
            "precipitation": 0
        },
        {
            "dt": 1658268000,
            "precipitation": 0
        },
        {
            "dt": 1658268060,
            "precipitation": 0
        },
        {
            "dt": 1658268120,
            "precipitation": 0
        },
        {
            "dt": 1658268180,
            "precipitation": 0
        },
        {
            "dt": 1658268240,
            "precipitation": 0
        },
        {
            "dt": 1658268300,
            "precipitation": 0
        },
        {
            "dt": 1658268360,
            "precipitation": 0
        },
        {
            "dt": 1658268420,
            "precipitation": 0
        },
        {
            "dt": 1658268480,
            "precipitation": 0
        },
        {
            "dt": 1658268540,
            "precipitation": 0
        },
        {
            "dt": 1658268600,
            "precipitation": 0
        },
        {
            "dt": 1658268660,
            "precipitation": 0
        },
        {
            "dt": 1658268720,
            "precipitation": 0
        },
        {
            "dt": 1658268780,
            "precipitation": 0
        },
        {
            "dt": 1658268840,
            "precipitation": 0
        },
        {
            "dt": 1658268900,
            "precipitation": 0
        },
        {
            "dt": 1658268960,
            "precipitation": 0
        },
        {
            "dt": 1658269020,
            "precipitation": 0
        },
        {
            "dt": 1658269080,
            "precipitation": 0
        },
        {
            "dt": 1658269140,
            "precipitation": 0
        },
        {
            "dt": 1658269200,
            "precipitation": 0
        },
        {
            "dt": 1658269260,
            "precipitation": 0
        },
        {
            "dt": 1658269320,
            "precipitation": 0
        },
        {
            "dt": 1658269380,
            "precipitation": 0
        },
        {
            "dt": 1658269440,
            "precipitation": 0
        },
        {
            "dt": 1658269500,
            "precipitation": 0
        },
        {
            "dt": 1658269560,
            "precipitation": 0
        },
        {
            "dt": 1658269620,
            "precipitation": 0
        }
    ],
    "hourly": [
        {
            "dt": 1658264400,
            "temp": 306,
            "feels_like": 307.83,
            "pressure": 1016,
            "humidity": 45,
            "dew_point": 292.5,
            "uvi": 4.51,
            "clouds": 54,
            "visibility": 10000,
            "wind_speed": 4.47,
            "wind_deg": 99,
            "wind_gust": 5.16,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0
        },
        {
            "dt": 1658268000,
            "temp": 305.89,
            "feels_like": 307.88,
            "pressure": 1016,
            "humidity": 46,
            "dew_point": 292.75,
            "uvi": 2.05,
            "clouds": 52,
            "visibility": 10000,
            "wind_speed": 3.67,
            "wind_deg": 98,
            "wind_gust": 4.66,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0
        },
        {
            "dt": 1658271600,
            "temp": 305.44,
            "feels_like": 307.8,
            "pressure": 1016,
            "humidity": 49,
            "dew_point": 293.37,
            "uvi": 0.58,
            "clouds": 46,
            "visibility": 10000,
            "wind_speed": 2.08,
            "wind_deg": 85,
            "wind_gust": 3.56,
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "pop": 0
        },
        {
            "dt": 1658275200,
            "temp": 303.46,
            "feels_like": 306.37,
            "pressure": 1016,
            "humidity": 59,
            "dew_point": 294.55,
            "uvi": 0,
            "clouds": 38,
            "visibility": 10000,
            "wind_speed": 1.2,
            "wind_deg": 41,
            "wind_gust": 2.14,
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "pop": 0
        },
        {
            "dt": 1658278800,
            "temp": 301.05,
            "feels_like": 303.62,
            "pressure": 1016,
            "humidity": 70,
            "dew_point": 295.07,
            "uvi": 0,
            "clouds": 12,
            "visibility": 10000,
            "wind_speed": 1.88,
            "wind_deg": 49,
            "wind_gust": 2.92,
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02n"
                }
            ],
            "pop": 0.01
        },
        {
            "dt": 1658282400,
            "temp": 299.27,
            "feels_like": 299.27,
            "pressure": 1017,
            "humidity": 81,
            "dew_point": 295.47,
            "uvi": 0,
            "clouds": 1,
            "visibility": 10000,
            "wind_speed": 2.78,
            "wind_deg": 71,
            "wind_gust": 4.94,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.03
        },
        {
            "dt": 1658286000,
            "temp": 298.71,
            "feels_like": 299.54,
            "pressure": 1017,
            "humidity": 85,
            "dew_point": 295.77,
            "uvi": 0,
            "clouds": 2,
            "visibility": 10000,
            "wind_speed": 2.83,
            "wind_deg": 71,
            "wind_gust": 6.65,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.07
        },
        {
            "dt": 1658289600,
            "temp": 297.98,
            "feels_like": 298.84,
            "pressure": 1017,
            "humidity": 89,
            "dew_point": 295.85,
            "uvi": 0,
            "clouds": 1,
            "visibility": 10000,
            "wind_speed": 2.65,
            "wind_deg": 65,
            "wind_gust": 5.41,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.05
        },
        {
            "dt": 1658293200,
            "temp": 297.5,
            "feels_like": 298.37,
            "pressure": 1016,
            "humidity": 91,
            "dew_point": 295.77,
            "uvi": 0,
            "clouds": 1,
            "visibility": 10000,
            "wind_speed": 2.43,
            "wind_deg": 49,
            "wind_gust": 5.34,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.04
        },
        {
            "dt": 1658296800,
            "temp": 297.28,
            "feels_like": 298.18,
            "pressure": 1016,
            "humidity": 93,
            "dew_point": 295.86,
            "uvi": 0,
            "clouds": 1,
            "visibility": 10000,
            "wind_speed": 2.63,
            "wind_deg": 47,
            "wind_gust": 5.6,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.07
        },
        {
            "dt": 1658300400,
            "temp": 297.12,
            "feels_like": 298.03,
            "pressure": 1015,
            "humidity": 94,
            "dew_point": 295.95,
            "uvi": 0,
            "clouds": 2,
            "visibility": 10000,
            "wind_speed": 2.71,
            "wind_deg": 57,
            "wind_gust": 6.29,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.12
        },
        {
            "dt": 1658304000,
            "temp": 297.13,
            "feels_like": 298.06,
            "pressure": 1015,
            "humidity": 95,
            "dew_point": 296.03,
            "uvi": 0,
            "clouds": 6,
            "visibility": 10000,
            "wind_speed": 2.4,
            "wind_deg": 60,
            "wind_gust": 5.09,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.11
        },
        {
            "dt": 1658307600,
            "temp": 297.11,
            "feels_like": 298.04,
            "pressure": 1015,
            "humidity": 95,
            "dew_point": 296.07,
            "uvi": 0,
            "clouds": 8,
            "visibility": 10000,
            "wind_speed": 2.65,
            "wind_deg": 57,
            "wind_gust": 6.26,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.11
        },
        {
            "dt": 1658311200,
            "temp": 296.95,
            "feels_like": 297.87,
            "pressure": 1015,
            "humidity": 95,
            "dew_point": 295.88,
            "uvi": 0,
            "clouds": 9,
            "visibility": 10000,
            "wind_speed": 2.73,
            "wind_deg": 50,
            "wind_gust": 5.73,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.16
        },
        {
            "dt": 1658314800,
            "temp": 296.72,
            "feels_like": 297.61,
            "pressure": 1016,
            "humidity": 95,
            "dew_point": 295.66,
            "uvi": 0,
            "clouds": 16,
            "visibility": 10000,
            "wind_speed": 2.9,
            "wind_deg": 50,
            "wind_gust": 6.18,
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02n"
                }
            ],
            "pop": 0.14
        },
        {
            "dt": 1658318400,
            "temp": 297.75,
            "feels_like": 298.64,
            "pressure": 1016,
            "humidity": 91,
            "dew_point": 295.87,
            "uvi": 0.4,
            "clouds": 29,
            "visibility": 10000,
            "wind_speed": 2.97,
            "wind_deg": 48,
            "wind_gust": 7.5,
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "pop": 0.19
        },
        {
            "dt": 1658322000,
            "temp": 299.69,
            "feels_like": 299.69,
            "pressure": 1016,
            "humidity": 81,
            "dew_point": 296.08,
            "uvi": 1.61,
            "clouds": 100,
            "visibility": 10000,
            "wind_speed": 4.14,
            "wind_deg": 67,
            "wind_gust": 7.44,
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.24
        },
        {
            "dt": 1658325600,
            "temp": 301.62,
            "feels_like": 305.07,
            "pressure": 1017,
            "humidity": 72,
            "dew_point": 296.02,
            "uvi": 3.87,
            "clouds": 77,
            "visibility": 10000,
            "wind_speed": 4.98,
            "wind_deg": 81,
            "wind_gust": 6.4,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.28
        },
        {
            "dt": 1658329200,
            "temp": 303.28,
            "feels_like": 307.09,
            "pressure": 1017,
            "humidity": 64,
            "dew_point": 295.67,
            "uvi": 6.85,
            "clouds": 69,
            "visibility": 10000,
            "wind_speed": 4.79,
            "wind_deg": 93,
            "wind_gust": 5.52,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.28
        },
        {
            "dt": 1658332800,
            "temp": 304.56,
            "feels_like": 308.35,
            "pressure": 1016,
            "humidity": 58,
            "dew_point": 295.34,
            "uvi": 9.54,
            "clouds": 60,
            "visibility": 10000,
            "wind_speed": 4.6,
            "wind_deg": 100,
            "wind_gust": 5.23,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.24
        },
        {
            "dt": 1658336400,
            "temp": 304.97,
            "feels_like": 308.69,
            "pressure": 1016,
            "humidity": 56,
            "dew_point": 295.09,
            "uvi": 11.31,
            "clouds": 67,
            "visibility": 10000,
            "wind_speed": 4.75,
            "wind_deg": 106,
            "wind_gust": 5.21,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "pop": 0.35,
            "rain": {
                "1h": 0.24
            }
        },
        {
            "dt": 1658340000,
            "temp": 305.37,
            "feels_like": 308.7,
            "pressure": 1015,
            "humidity": 53,
            "dew_point": 294.5,
            "uvi": 11.49,
            "clouds": 68,
            "visibility": 10000,
            "wind_speed": 4.45,
            "wind_deg": 112,
            "wind_gust": 4.94,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "pop": 0.43,
            "rain": {
                "1h": 0.28
            }
        },
        {
            "dt": 1658343600,
            "temp": 306.14,
            "feels_like": 309.14,
            "pressure": 1015,
            "humidity": 49,
            "dew_point": 293.91,
            "uvi": 9.27,
            "clouds": 49,
            "visibility": 10000,
            "wind_speed": 4.6,
            "wind_deg": 112,
            "wind_gust": 4.88,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "pop": 0.4,
            "rain": {
                "1h": 0.13
            }
        },
        {
            "dt": 1658347200,
            "temp": 305.85,
            "feels_like": 308.84,
            "pressure": 1014,
            "humidity": 50,
            "dew_point": 293.79,
            "uvi": 6.8,
            "clouds": 66,
            "visibility": 10000,
            "wind_speed": 4.78,
            "wind_deg": 112,
            "wind_gust": 4.91,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.56
        },
        {
            "dt": 1658350800,
            "temp": 305.55,
            "feels_like": 308.26,
            "pressure": 1014,
            "humidity": 50,
            "dew_point": 293.58,
            "uvi": 4.05,
            "clouds": 61,
            "visibility": 10000,
            "wind_speed": 4.57,
            "wind_deg": 112,
            "wind_gust": 4.72,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.65
        },
        {
            "dt": 1658354400,
            "temp": 304.7,
            "feels_like": 307.16,
            "pressure": 1014,
            "humidity": 52,
            "dew_point": 293.57,
            "uvi": 1.34,
            "clouds": 55,
            "visibility": 10000,
            "wind_speed": 4.38,
            "wind_deg": 113,
            "wind_gust": 4.77,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.68
        },
        {
            "dt": 1658358000,
            "temp": 303.69,
            "feels_like": 306.6,
            "pressure": 1014,
            "humidity": 58,
            "dew_point": 294.32,
            "uvi": 0.38,
            "clouds": 47,
            "visibility": 10000,
            "wind_speed": 3.47,
            "wind_deg": 122,
            "wind_gust": 4.56,
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "pop": 0.71
        },
        {
            "dt": 1658361600,
            "temp": 301.09,
            "feels_like": 303.7,
            "pressure": 1014,
            "humidity": 70,
            "dew_point": 294.88,
            "uvi": 0,
            "clouds": 41,
            "visibility": 10000,
            "wind_speed": 2.34,
            "wind_deg": 127,
            "wind_gust": 3.18,
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "pop": 0.75
        },
        {
            "dt": 1658365200,
            "temp": 299.44,
            "feels_like": 299.44,
            "pressure": 1015,
            "humidity": 75,
            "dew_point": 294.48,
            "uvi": 0,
            "clouds": 7,
            "visibility": 10000,
            "wind_speed": 2.11,
            "wind_deg": 111,
            "wind_gust": 2.56,
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "pop": 0.44
        },
        {
            "dt": 1658368800,
            "temp": 298.79,
            "feels_like": 299.45,
            "pressure": 1015,
            "humidity": 78,
            "dew_point": 294.57,
            "uvi": 0,
            "clouds": 19,
            "visibility": 10000,
            "wind_speed": 1.87,
            "wind_deg": 87,
            "wind_gust": 2.32,
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02n"
                }
            ],
            "pop": 0.56
        },
        {
            "dt": 1658372400,
            "temp": 298.51,
            "feels_like": 299.19,
            "pressure": 1015,
            "humidity": 80,
            "dew_point": 294.6,
            "uvi": 0,
            "clouds": 38,
            "visibility": 10000,
            "wind_speed": 1.68,
            "wind_deg": 67,
            "wind_gust": 2.12,
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "pop": 0.6
        },
        {
            "dt": 1658376000,
            "temp": 298.27,
            "feels_like": 298.95,
            "pressure": 1015,
            "humidity": 81,
            "dew_point": 294.62,
            "uvi": 0,
            "clouds": 49,
            "visibility": 10000,
            "wind_speed": 1.73,
            "wind_deg": 69,
            "wind_gust": 2.19,
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "pop": 0.54
        },
        {
            "dt": 1658379600,
            "temp": 297.93,
            "feels_like": 298.66,
            "pressure": 1015,
            "humidity": 84,
            "dew_point": 294.74,
            "uvi": 0,
            "clouds": 54,
            "visibility": 10000,
            "wind_speed": 1.78,
            "wind_deg": 72,
            "wind_gust": 2.47,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04n"
                }
            ],
            "pop": 0.52
        },
        {
            "dt": 1658383200,
            "temp": 297.53,
            "feels_like": 298.27,
            "pressure": 1015,
            "humidity": 86,
            "dew_point": 294.93,
            "uvi": 0,
            "clouds": 60,
            "visibility": 10000,
            "wind_speed": 1.87,
            "wind_deg": 67,
            "wind_gust": 2.47,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04n"
                }
            ],
            "pop": 0.52
        },
        {
            "dt": 1658386800,
            "temp": 297.23,
            "feels_like": 298.02,
            "pressure": 1014,
            "humidity": 89,
            "dew_point": 295.12,
            "uvi": 0,
            "clouds": 100,
            "visibility": 10000,
            "wind_speed": 1.84,
            "wind_deg": 61,
            "wind_gust": 2.31,
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "pop": 0.21
        },
        {
            "dt": 1658390400,
            "temp": 297.04,
            "feels_like": 297.83,
            "pressure": 1014,
            "humidity": 90,
            "dew_point": 295.23,
            "uvi": 0,
            "clouds": 100,
            "visibility": 10000,
            "wind_speed": 1.92,
            "wind_deg": 61,
            "wind_gust": 2.67,
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "pop": 0.34
        },
        {
            "dt": 1658394000,
            "temp": 296.97,
            "feels_like": 297.78,
            "pressure": 1014,
            "humidity": 91,
            "dew_point": 295.29,
            "uvi": 0,
            "clouds": 99,
            "visibility": 10000,
            "wind_speed": 2.13,
            "wind_deg": 67,
            "wind_gust": 3.15,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10n"
                }
            ],
            "pop": 0.4,
            "rain": {
                "1h": 0.13
            }
        },
        {
            "dt": 1658397600,
            "temp": 296.87,
            "feels_like": 297.73,
            "pressure": 1014,
            "humidity": 93,
            "dew_point": 295.38,
            "uvi": 0,
            "clouds": 99,
            "visibility": 10000,
            "wind_speed": 2.23,
            "wind_deg": 70,
            "wind_gust": 3.62,
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "pop": 0.34
        },
        {
            "dt": 1658401200,
            "temp": 296.65,
            "feels_like": 297.51,
            "pressure": 1014,
            "humidity": 94,
            "dew_point": 295.44,
            "uvi": 0,
            "clouds": 97,
            "visibility": 10000,
            "wind_speed": 2.19,
            "wind_deg": 65,
            "wind_gust": 3.73,
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "pop": 0.3
        },
        {
            "dt": 1658404800,
            "temp": 297.93,
            "feels_like": 298.79,
            "pressure": 1015,
            "humidity": 89,
            "dew_point": 295.86,
            "uvi": 0.41,
            "clouds": 95,
            "visibility": 10000,
            "wind_speed": 2.11,
            "wind_deg": 71,
            "wind_gust": 6.64,
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.26
        },
        {
            "dt": 1658408400,
            "temp": 300.16,
            "feels_like": 302.91,
            "pressure": 1015,
            "humidity": 80,
            "dew_point": 296.2,
            "uvi": 1.64,
            "clouds": 70,
            "visibility": 10000,
            "wind_speed": 3.71,
            "wind_deg": 85,
            "wind_gust": 6.86,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0
        },
        {
            "dt": 1658412000,
            "temp": 301.82,
            "feels_like": 305.51,
            "pressure": 1016,
            "humidity": 72,
            "dew_point": 296.08,
            "uvi": 3.95,
            "clouds": 73,
            "visibility": 10000,
            "wind_speed": 4.37,
            "wind_deg": 95,
            "wind_gust": 5.56,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0
        },
        {
            "dt": 1658415600,
            "temp": 303.3,
            "feels_like": 307.36,
            "pressure": 1016,
            "humidity": 65,
            "dew_point": 295.83,
            "uvi": 6.99,
            "clouds": 73,
            "visibility": 10000,
            "wind_speed": 3.94,
            "wind_deg": 107,
            "wind_gust": 4.82,
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "pop": 0.04
        },
        {
            "dt": 1658419200,
            "temp": 303.89,
            "feels_like": 308.18,
            "pressure": 1016,
            "humidity": 63,
            "dew_point": 295.82,
            "uvi": 9.32,
            "clouds": 70,
            "visibility": 10000,
            "wind_speed": 4.07,
            "wind_deg": 117,
            "wind_gust": 4.5,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "pop": 0.31,
            "rain": {
                "1h": 0.79
            }
        },
        {
            "dt": 1658422800,
            "temp": 303.6,
            "feels_like": 308.03,
            "pressure": 1016,
            "humidity": 65,
            "dew_point": 296.1,
            "uvi": 11.06,
            "clouds": 75,
            "visibility": 10000,
            "wind_speed": 4.32,
            "wind_deg": 124,
            "wind_gust": 4.6,
            "weather": [
                {
                    "id": 501,
                    "main": "Rain",
                    "description": "moderate rain",
                    "icon": "10d"
                }
            ],
            "pop": 0.47,
            "rain": {
                "1h": 1.5
            }
        },
        {
            "dt": 1658426400,
            "temp": 303.29,
            "feels_like": 307.57,
            "pressure": 1016,
            "humidity": 66,
            "dew_point": 296.05,
            "uvi": 11.24,
            "clouds": 79,
            "visibility": 10000,
            "wind_speed": 4.01,
            "wind_deg": 119,
            "wind_gust": 4.65,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "pop": 0.59,
            "rain": {
                "1h": 0.94
            }
        },
        {
            "dt": 1658430000,
            "temp": 303.47,
            "feels_like": 307.5,
            "pressure": 1015,
            "humidity": 64,
            "dew_point": 295.63,
            "uvi": 7.57,
            "clouds": 100,
            "visibility": 10000,
            "wind_speed": 3.83,
            "wind_deg": 124,
            "wind_gust": 4.76,
            "weather": [
                {
                    "id": 501,
                    "main": "Rain",
                    "description": "moderate rain",
                    "icon": "10d"
                }
            ],
            "pop": 0.72,
            "rain": {
                "1h": 1.08
            }
        },
        {
            "dt": 1658433600,
            "temp": 304.2,
            "feels_like": 308.1,
            "pressure": 1015,
            "humidity": 60,
            "dew_point": 295.3,
            "uvi": 5.55,
            "clouds": 100,
            "visibility": 10000,
            "wind_speed": 3.39,
            "wind_deg": 123,
            "wind_gust": 4.38,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "pop": 0.73,
            "rain": {
                "1h": 0.32
            }
        }
    ],
    "daily": [
        {
            "dt": 1658250000,
            "sunrise": 1658228455,
            "sunset": 1658276453,
            "moonrise": 1658204760,
            "moonset": 1658249700,
            "moon_phase": 0.72,
            "temp": {
                "day": 305.56,
                "min": 296.58,
                "max": 306.12,
                "night": 298.71,
                "eve": 305.44,
                "morn": 296.58
            },
            "feels_like": {
                "day": 308.03,
                "night": 299.54,
                "eve": 307.8,
                "morn": 297.43
            },
            "pressure": 1018,
            "humidity": 49,
            "dew_point": 293.47,
            "wind_speed": 5.03,
            "wind_deg": 109,
            "wind_gust": 6.65,
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02d"
                }
            ],
            "clouds": 21,
            "pop": 0.11,
            "uvi": 11.86
        },
        {
            "dt": 1658336400,
            "sunrise": 1658314880,
            "sunset": 1658362835,
            "moonrise": 1658293260,
            "moonset": 1658339400,
            "moon_phase": 0.75,
            "temp": {
                "day": 304.97,
                "min": 296.72,
                "max": 306.14,
                "night": 298.51,
                "eve": 303.69,
                "morn": 296.72
            },
            "feels_like": {
                "day": 308.69,
                "night": 299.19,
                "eve": 306.6,
                "morn": 297.61
            },
            "pressure": 1016,
            "humidity": 56,
            "dew_point": 295.09,
            "wind_speed": 4.98,
            "wind_deg": 81,
            "wind_gust": 7.5,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": 67,
            "pop": 0.75,
            "rain": 0.65,
            "uvi": 11.49
        },
        {
            "dt": 1658422800,
            "sunrise": 1658401306,
            "sunset": 1658449216,
            "moonrise": 1658381700,
            "moonset": 1658428980,
            "moon_phase": 0.78,
            "temp": {
                "day": 303.6,
                "min": 296.65,
                "max": 304.2,
                "night": 298.15,
                "eve": 301.67,
                "morn": 296.65
            },
            "feels_like": {
                "day": 308.03,
                "night": 298.87,
                "eve": 305.18,
                "morn": 297.51
            },
            "pressure": 1016,
            "humidity": 65,
            "dew_point": 296.1,
            "wind_speed": 4.37,
            "wind_deg": 95,
            "wind_gust": 6.86,
            "weather": [
                {
                    "id": 501,
                    "main": "Rain",
                    "description": "moderate rain",
                    "icon": "10d"
                }
            ],
            "clouds": 75,
            "pop": 0.77,
            "rain": 4.96,
            "uvi": 11.24
        },
        {
            "dt": 1658509200,
            "sunrise": 1658487732,
            "sunset": 1658535596,
            "moonrise": 1658470200,
            "moonset": 1658518620,
            "moon_phase": 0.82,
            "temp": {
                "day": 306.63,
                "min": 297.05,
                "max": 306.63,
                "night": 298.71,
                "eve": 301.41,
                "morn": 297.05
            },
            "feels_like": {
                "day": 310.74,
                "night": 299.44,
                "eve": 304.93,
                "morn": 297.79
            },
            "pressure": 1016,
            "humidity": 51,
            "dew_point": 294.9,
            "wind_speed": 3.27,
            "wind_deg": 112,
            "wind_gust": 3.95,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": 66,
            "pop": 0.65,
            "rain": 1.99,
            "uvi": 11.94
        },
        {
            "dt": 1658595600,
            "sunrise": 1658574157,
            "sunset": 1658621975,
            "moonrise": 1658558880,
            "moonset": 1658608200,
            "moon_phase": 0.85,
            "temp": {
                "day": 304.71,
                "min": 297.33,
                "max": 304.71,
                "night": 298.09,
                "eve": 300.36,
                "morn": 298.16
            },
            "feels_like": {
                "day": 309.5,
                "night": 298.96,
                "eve": 303.26,
                "morn": 299.09
            },
            "pressure": 1017,
            "humidity": 61,
            "dew_point": 296.03,
            "wind_speed": 5.54,
            "wind_deg": 112,
            "wind_gust": 6.35,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": 47,
            "pop": 1,
            "rain": 7.56,
            "uvi": 11.22
        },
        {
            "dt": 1658682000,
            "sunrise": 1658660583,
            "sunset": 1658708353,
            "moonrise": 1658647800,
            "moonset": 1658697900,
            "moon_phase": 0.88,
            "temp": {
                "day": 305.86,
                "min": 296.39,
                "max": 305.86,
                "night": 298.09,
                "eve": 301.47,
                "morn": 297.4
            },
            "feels_like": {
                "day": 309.14,
                "night": 298.94,
                "eve": 304.6,
                "morn": 298.23
            },
            "pressure": 1016,
            "humidity": 51,
            "dew_point": 294.45,
            "wind_speed": 5.88,
            "wind_deg": 103,
            "wind_gust": 6.2,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": 78,
            "pop": 0.83,
            "rain": 0.83,
            "uvi": 0.4
        },
        {
            "dt": 1658768400,
            "sunrise": 1658747009,
            "sunset": 1658794730,
            "moonrise": 1658736900,
            "moonset": 1658787420,
            "moon_phase": 0.91,
            "temp": {
                "day": 305.64,
                "min": 296.98,
                "max": 305.64,
                "night": 298.44,
                "eve": 300.66,
                "morn": 297.51
            },
            "feels_like": {
                "day": 308.7,
                "night": 299.14,
                "eve": 302.9,
                "morn": 298.4
            },
            "pressure": 1015,
            "humidity": 51,
            "dew_point": 293.97,
            "wind_speed": 5.65,
            "wind_deg": 104,
            "wind_gust": 8.79,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": 66,
            "pop": 0.63,
            "rain": 2.99,
            "uvi": 1
        },
        {
            "dt": 1658854800,
            "sunrise": 1658833435,
            "sunset": 1658881106,
            "moonrise": 1658826240,
            "moonset": 1658876880,
            "moon_phase": 0.94,
            "temp": {
                "day": 305.56,
                "min": 297.25,
                "max": 305.56,
                "night": 298.61,
                "eve": 300.99,
                "morn": 298.15
            },
            "feels_like": {
                "day": 309.66,
                "night": 299.33,
                "eve": 303.76,
                "morn": 299
            },
            "pressure": 1016,
            "humidity": 55,
            "dew_point": 295.22,
            "wind_speed": 4.56,
            "wind_deg": 109,
            "wind_gust": 6.07,
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": 87,
            "pop": 0.84,
            "rain": 1.78,
            "uvi": 1
        }
    ]
}"""

const val reverseRaw = """[
    {
        "name": "Pinar del Rio",
        "local_names": {
            "hu": "Pinar del Río",
            "ru": "Пинар-дель-Рио",
            "en": "Pinar del Rio",
            "es": "Pinar del Río"
        },
        "lat": 22.4167422,
        "lon": -83.7002582,
        "country": "CU",
        "state": "Pinar del Rio"
    }
]"""

val onecallResponse = Response.success(
    200, Gson().fromJson(onecallRaw, OneCallResponse::class.java)
)

val reverseResponse = Response.success(
    200, Gson().fromJson(reverseRaw, ReverseResponse::class.java)
)


