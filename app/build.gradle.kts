plugins{
	application 
	antlr
	id("texteditor-conventions")
	id("org.openjfx.javafxplugin") version "0.1.0"
}

dependencies {
	implementation(project(":api"))
	antlr("org.antlr:antlr4:4.13.2")
}

javafx{
	version = "21"
	modules("javafx.controls")
}

application{
	mainClass = "edu.curtin.texteditor.App"
}

