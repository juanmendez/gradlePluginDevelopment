package info.juanmendez.gradle.plugin.weather
import groovy.json.JsonSlurper
import org.gradle.api.Plugin
import org.gradle.api.Project

class WeatherPlugin implements Plugin<Project>{
	
	void apply( Project project ){
		//we can include apply "plugin: 'pluginName'" like this
		//project.plugins.apply( 'pluginName' )
		
		project.tasks.create( "credentials" ).configure{
			
			File readMe = project.file( "$project.map_json" );
			String contents = readMe.getText("UTF-8")
			
			def slurper = new JsonSlurper()
			def credentials = slurper.parseText( contents )
			project.weather_id = credentials.id;
			
		}
		
		project.tasks.create('weather', WeatherTask).configure{
			dependsOn<<["credentials"]
			
			developer = "Juan Mendez"
		}
		
		def cities = project.container(City){ name->
			new City(name)
		}
		
		project.configure( project ){
			println "cities " + cities + "/cities";
			extensions.create( "weather", CityExtension, cities )
		}
		
		//accessing another plugin
		//project.task.getByName('pluginName').configure{}
	}
}
