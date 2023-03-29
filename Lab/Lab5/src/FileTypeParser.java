import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileTypeParser {

    public static void main(String[] args) throws IOException {
        System.out.print("java FileTypeParser ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        FileInputStream r = new FileInputStream("F:/CS209/Lab5/" + n);
        String str1 = "Filename: " + n;
        byte[] c = new byte[4];
        r.read(c);
        String compare = String.format("%02x%02x%02x%02x",c[0],c[1],c[2],c[3]);
        String str2 = String.format("File Header(Hex): [%02x, %02x, %02x, %02x]",c[0],c[1],c[2],c[3]);
        String str3 = "File Type: ";
        if (compare.equals("89504e47")){
            str3 = str3 + "png";
            print(str1,str2,str3);
        }else if (compare.equals("504b0304")){
            str3 = str3 + "zip or jar";
            print(str1,str2,str3);
        }else if (compare.equals("cafebabe")){
            str3 = str3 + "class";
            print(str1,str2,str3);
        }
    }

    public static void print(String s1, String s2, String s3){
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
