plugins{
	java
	id("texteditor-conventions")
}

tasks.withType<Jar> {
	manifest {
        attributes("TextEditor-Plugin-Main-Class" to "edu.curtin.texteditor.FindPlugin")
    }
}