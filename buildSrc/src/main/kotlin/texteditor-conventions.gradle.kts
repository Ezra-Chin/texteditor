plugins{
	pmd
}

repositories{
	mavenCentral()
}

pmd{
	toolVersion = "7.26.0"	
	ruleSetFiles = files(rootProject.file("saed-pmd-rules.xml"))
	ruleSets = listOf()
	isConsoleOutput = true 
}

