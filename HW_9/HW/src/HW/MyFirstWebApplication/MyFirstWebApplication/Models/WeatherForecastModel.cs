namespace MyFirstWebApplication.Models
{

    /// <summary>
    /// Объект на базе класса WeatherForecastModel хранит список показаний температуры
    /// </summary>
    public class WeatherForecastModel
    {
        // Коллекция для хранения показаний температуры
        private List<WeatherForecast> _list;

        public WeatherForecastModel()
        {
            // Инициализирую коллекцию для хранения показателей температуры
            _list = new List<WeatherForecast>();
        }

        /// <summary>
        /// Добавить новый показатель температуры
        /// </summary>
        /// <param name="date">Дата фиксации показателя температуры</param>
        /// <param name="temperatureC">Показатель температуры</param>
        public void Add(DateTime date, int temperatureC)
        {
            WeatherForecast weatherForecast = new WeatherForecast(date, temperatureC);
            _list.Add(weatherForecast);
        }

        /// <summary>
        /// Получить показатели температуры за временной период
        /// </summary>
        /// <param name="dateFrom">Начальная дата</param>
        /// <param name="dateTo">Конечная дата</param>
        /// <returns>Коллекция показателей температуры</returns>
        public List<WeatherForecast> Get(DateTime dateFrom, DateTime dateTo)
        {
            List<WeatherForecast> listByDate = new List<WeatherForecast>();
            foreach(WeatherForecast weather in _list)
            {
                if (weather.Date >= dateFrom && weather.Date <= dateTo)
                {
                    listByDate.Add(weather);
                }
            }
            return listByDate;
        }

        /// <summary>
        /// Обновить показатель температуры
        /// </summary>
        /// <param name="date"></param>
        /// <param name="temperatureC"></param>
        public void Update(DateTime date, int temperatureC)
        {
            foreach(WeatherForecast weather in _list)
            {
                if (weather.Date == date)
                {
                    weather.TemperatureC = temperatureC;
                    break;
                }
            }
        }

        /// <summary>
        /// Удалить показатель температуры по дате?
        /// </summary>
        /// <param name="date"></param>
        public void Delete(DateTime date /*,int temperatureC*/)
        {
            foreach(WeatherForecast weather in _list)
            {
                if (weather.Date == date)
                {
                    /*,_list.Remove(temperatureC);*/
                    _list.Remove(weather);
                    break;
                }
            }
        }


    }
}
