package info.juanmendez.gradle.plugin.weather
import groovy.json.JsonSlurper
import org.gradle.api.tasks.TaskAction
import org.gradle.api.DefaultTask


class CredentialsTask extends DefaultTask{
	
	@TaskAction
	def getCredentialsId(){
		
		File readMe = project.file( project.weather.map_json );
		String contents = readMe.getText("UTF-8")
		
		def slurper = new JsonSlurper()
		def credentials = slurper.parseText( contents )
		project.weather.map_id = credentials.id;
	}
}