package info.juanmendez.gradle.plugin.weather
import org.gradle.api.Plugin
import org.gradle.api.Project

class WeatherPlugin implements Plugin<Project>{
	
	void apply( Project project ){
		
		
		//we can include apply "plugin: 'pluginName'" like this
		//project.plugins.apply( 'pluginName' )
		
		project.tasks.create( "credentials", CredentialsTask )
		
		project.tasks.create('weather', WeatherTask).configure{
			dependsOn<<[ "credentials"]
		}
		
		def cities = project.container(City){ name->
			new City(name)
		}
		
		project.configure( project ){
			extensions.create( "weather", CityExtension, cities )
		}
		
		//accessing another plugin
		//project.task.getByName('pluginName').configure{}
	}
}