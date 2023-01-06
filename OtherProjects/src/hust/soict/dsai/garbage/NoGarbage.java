package hust.soict.dsai.garbage;
import java.io.File;
import java.util.*;

public class NoGarbage {
    public static void main(String[] args) throws Exception {
        File file = new File("garbage.txt");
        Scanner sc = new Scanner(file);

        long start = System.currentTimeMillis();
        String s = "";
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine())
            sb.append(sc.nextLine());
        s = sb.toString();
        System.out.println(s);
        System.out.println(System.currentTimeMillis() - start);
        sc.close();
    }
}