plugins{
	java
	id("texteditor-conventions")
}
dependencies{
	implementation(project(":api"))
}

tasks.withType<Jar> {
    manifest {
        attributes("TextEditor-Plugin-Main-Class" to "edu.curtin.texteditor.DatePlugin")
    }
}
