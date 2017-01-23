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
		
		println "cities $project.weather.developer wants to know about their weather"
		
		project.file("$project.weather.cities_dir").deleteDir();
		project.weather.cities.each { city ->
			readWeather( city )
		  }
	}
	
	
	def readWeather( City city ){
		
		project.file("$project.weather.cities_dir").mkdirs();
		http.request( GET, JSON ) {
						  uri.path = '/data/2.5/weather'
						  uri.query = [ APPID:project.weather.map_id, q: "$city.name,$city.countryCode", units:"Imperial" ]
						
						  response.success = { resp, json ->
							 city.json = json
							 
							 
							 project.file("$project.weather.cities_dir/$city.file" ).withWriter { writer ->
								 writer.println city.json
							   }
						  }
						}
						
						http.handler.'404' = { resp ->
							println "Access Issue $resp"
						  }
	}
}