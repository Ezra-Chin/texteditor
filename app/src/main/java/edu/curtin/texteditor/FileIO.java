package edu.curtin.texteditor;
import java.nio.charset.Charset;
import java.io.*;


public class FileIO 
{
    public void save(File file, String text, String encoding  )throws IOException
    {
        try(PrintWriter writer = new PrintWriter(file, Charset.forName(encoding))){
            writer.print(text);
        }
    }

    public String load(File file, String encoding) throws IOException
    {
        StringBuilder text = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file, Charset.forName(encoding)))){
            String line;
            while((line = br.readLine()) != null){
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }

}