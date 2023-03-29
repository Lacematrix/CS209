import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class practice6 {

  public static void main(String[] args) throws IOException {
    String url = "F:\\CS209\\Lab6\\src.zip";
    InputStream stream = new FileInputStream(url);
    ZipInputStream zipInputStream = new ZipInputStream(stream);
    ZipEntry zipEntry;
    StringBuffer stringBuffer = new StringBuffer();
    int count = 0;
    while ((zipEntry = zipInputStream.getNextEntry()) != null){
      if (zipEntry.getName().startsWith("java/io") || zipEntry.getName().startsWith("java/nio")){
        stringBuffer.append(zipEntry.getName());
        stringBuffer.append("\n");
        count++;
      }
    }
    System.out.println("# of .java files in java.io/java.nio: " + count);
    System.out.println(stringBuffer);
  }

}
