package info.juanmendez.gradle.plugin.weather

import org.gradle.api.tasks.TaskAction
import org.gradle.api.DefaultTask


import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.JSON

class WeatherTask extends DefaultTask{
	
	def http
	def cities
	def developer
	
	WeatherTask(){
		this.http = new HTTPBuilder( 'http://api.openweathermap.org' )
	}
	
	@TaskAction
	def printCitiesWeather(){
		
		println "cities $developer wants to know about their weather"
		
		/*
		 * no longer code from member cities
		 * cities.each{ city->
			readWeather( city.name, city.countryCode)
		}*/
		
		project.weather.cities.each { city ->
			readWeather( city.name, city.countryCode)
		  }
	}
	
	
	def readWeather( city, countryCode ){
		
		http.request( GET, JSON ) {
						  uri.path = '/data/2.5/weather'
						  uri.query = [ APPID:project.weather_id, q: "$city,$countryCode", units:"Imperial" ]
						
						  response.success = { resp, json ->
							 println json
						  }
						}
						
						http.handler.'404' = { resp ->
							println "Access Issue $resp"
						  }
	}
}