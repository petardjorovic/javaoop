import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            FileInputStream fis = new FileInputStream("./ulaz.dat");
            Scanner s = new Scanner(fis);

        String name = s.next();
        int dan = s.nextInt();
        int mesec = s.nextInt();
        int godina = s.nextInt();

        s.close();
        fis.close();

        String ispis = String.format("-%20s%10d%10d%10d", name,dan,mesec,godina);
        String ispis2 = String.format("-%30s%-10d%-10d%-10d", name,dan,mesec,godina);
        // System.out.println("Vas ime je: " + name + " i vi ste rodjeni " + dan + "." + mesec + "." + godina);
        System.out.println(ispis);
        System.out.println(ispis2);
        } catch (FileNotFoundException e) {
            System.out.println("Nije pronadjen takav fajl");
        }
    }
}
