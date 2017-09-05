# Gradle Plugin Development

This is a plugin exercise done inspired from watching [Pluralsight's Play by Play Customizing Gradle with Plugins](https://www.pluralsight.com/courses/play-by-play-customizing-gradle-with-plugins) made by [Tim Berglund](https://twitter.com/tlberglund)

What is the purpose? 
Learn how to write custom gradle plugins, specially for Android

What does this plugin do?
It gets the weather from different cities, and copies them to json files named after each city provided.

How does it access the weather for each city?
it access it through [openweathermap](https://openweathermap.org/api). The plugin requires a path to a json file with a developer's secret key, like this:

{
    "id":"a123445678910"
}

[You can go to this link and get your key](https://openweathermap.org/appid)

[I included a wiki explaining each branch](https://github.com/juanmendez/gradlePluginDevelopment/wiki).
