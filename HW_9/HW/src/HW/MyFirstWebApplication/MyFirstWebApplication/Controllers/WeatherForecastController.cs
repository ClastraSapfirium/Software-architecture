using Microsoft.AspNetCore.Mvc;
using MyFirstWebApplication.Models;

namespace MyFirstWebApplication.Controllers
{

    /// <summary>
    /// Контроллер позволяет обрабатывать входящие запросы для фиксации погодных условий
    /// </summary>
    [Route("weather")]
    [ApiController]
    public class WeatherForecastController : ControllerBase
    {

        private WeatherForecastModel _weatherForecastModel;

        public WeatherForecastController(WeatherForecastModel weatherForecastModel) 
        { 
            _weatherForecastModel= weatherForecastModel;
        }


        /// <summary>
        /// Добавление информации по погоде
        /// </summary>
        /// <returns></returns>
        [HttpPost("add")]
        public IActionResult Add(DateTime date, int temperatureC)
        {
            _weatherForecastModel.Add(date, temperatureC);
            return Ok(); // http 200
        }

        /// <summary>
        /// Обновление информации по погоде
        /// </summary>
        /// <returns></returns>
        [HttpPut("update")]
        public IActionResult Update(DateTime date, int temperatureC)
        {
            _weatherForecastModel.Update(date, temperatureC);
            return Ok(); // http 200
        }

        /// <summary>
        /// Удаление информации по погоде
        /// </summary>
        /// <returns></returns>
        [HttpDelete("delete")]
        public IActionResult Delete(DateTime date)
        {
            _weatherForecastModel.Delete(date);
            return Ok(); // http 200
        }

        /// <summary>
        /// Получение информации по погоде за период
        /// </summary>
        /// <returns></returns>
        [HttpGet("get")]
        public ActionResult<List<WeatherForecast>> Get(DateTime dateFrom, DateTime dateTo)
        {
            List<WeatherForecast> list = _weatherForecastModel.Get(dateFrom, dateTo);

            return Ok(list); // http 200
        }

    }
}
