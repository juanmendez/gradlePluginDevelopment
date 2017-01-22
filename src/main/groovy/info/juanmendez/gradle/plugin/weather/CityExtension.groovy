package info.juanmendez.gradle.plugin.weather
import org.gradle.api.NamedDomainObjectContainer

class CityExtension{
	final NamedDomainObjectContainer<City> cities
	
	CityExtension( NamedDomainObjectContainer<City> cities ){
		this.cities = cities;
	}
	
	def cities( Closure closure ){
		cities.configure( closure )
	}
}