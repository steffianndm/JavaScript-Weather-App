let weatherApp = new Vue({
  el: '#app',
  data: {
    apiKey: '1d49b29e91edece24fe21c6dc30ac5bb',
    currentTemp: '',
    minTemp: '',
    maxTemp:'',
    sunrise: '',
    sunset: '',
    pressure: '',
    humidity: '',
    rain: '',
    snow:'',
    wind: '',
    overcast: '', 
    icon: '',
    location: ''
  },
  methods: {
    getWeather() {
      let url = "https://api.openweathermap.org/data/2.5/weather?q="+this.location+"&units=imperial&APPID="+this.apiKey;
      axios
        .get(url)
        .then(response => {
          this.currentTemp = response.data.main.temp;
          this.minTemp = response.data.main.temp_min;
          this.maxTemp = response.data.main.temp_max;
          this.pressure = response.data.main.pressure;
          this.humidity = response.data.main.humidity;
          this.wind = response.data.wind.speed + 'm/s';
          this.description = response.data.weather[0].description;
      })
      .catch(error => {
        console.log(error);
      });
    },
  },
  updated() {
    this.getWeather();
  },
});
