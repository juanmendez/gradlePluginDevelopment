package info.juanmendez.gradle.plugin.weather
import org.gradle.api.NamedDomainObjectContainer

class CityExtension{
	String developer
	String map_json
	String map_id
	String cities_dir
	
	final NamedDomainObjectContainer<City> cities
	
	CityExtension( NamedDomainObjectContainer<City> cities ){
		this.cities = cities;
	}
	
	def cities( Closure closure ){
		cities.configure( closure )
	}
}