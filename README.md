# gradlePluginDevelopment

This is a plugin exercise done while watching Pluralsight's Play by Play Customizing Gradle with Plugins

What is the purpose? 
Learn how to write custom gradle plugins, specially for Android

What does this plugin do?
It gets the weather from different cities, and copies them to json files named after each city provided.

How does it access the weather for each city?
Through https://openweathermap.org/api. The plugin requires a path to a json file with a developer's secret key, like this:

{
    "id":"a123445678910"
}

There is going to be a WIKI describing the development process by each git branch.
