import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class practice6_2 {

  public static void main(String[] args) throws IOException {
    String url = "F:\\CS209\\Lab6\\rt.jar";
    File file = new File(url);
    JarFile jarFile = new JarFile(file);
    Enumeration<JarEntry> entries = jarFile.entries();
    StringBuffer stringBuffer = new StringBuffer();
    int count = 0;
    while (entries.hasMoreElements()){
      JarEntry entry = entries.nextElement();
      if ((entry.getName().startsWith("java/io") || entry.getName().startsWith("java/nio")) && entry.getName().endsWith(".class")){
        stringBuffer.append(entry.getName());
        stringBuffer.append("\n");
        count++;
      }
    }
    System.out.println("# of .class files in java.io/java.nio: " + count);
    System.out.println(stringBuffer);
  }

}
