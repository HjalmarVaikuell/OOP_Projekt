import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuudegaTeenitu {
    public static void main(String[] args) throws IOException {

        KirjutaPalke("palgid.txt");
        //LoePalke("palgid.txt");

        Kask kask = new Kask(0.405,2,20,"Harilik kask");
        kask.arvutaHind();

        Mänd mänd = new Mänd(0.517,2,41,"Harilik mänd");
        mänd.arvutaHind();

        Kuusk kuusk = new Kuusk(0.354,2,51,"Harilik kuusk");
        kuusk.arvutaHind();

        MänniPeenpalk männiPeenpalk = new MänniPeenpalk(0.214,2,51,"Harilik mänd");
        männiPeenpalk.arvutaHind();
        System.out.println();
        männiPeenpalk.puuliik(); //dünaamiline seostamine, võtab klassist Mänd kirjeldatud meetodi.

        Puu puu2 = mänd; //toimib kuna Mänd on Puu alamklass
        Object obj = mänd; //toimib kuna Mänd on Object alamklass
        List<Puu> puud = new ArrayList<>();
        puud.add(mänd);
        puud.add(kask);
        puud.add(männiPeenpalk);
        puud.add(kuusk);
        //puud.add(obj); ei toimi kuna iga Object ei pruugi olla puu
        for (Puu puu : puud){
            System.out.println(puu);
        }
    }

    static List<Puu> LoePalke(String failinimi) throws FileNotFoundException {

        File file = new File(failinimi);
        List<Puu> puud = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        boolean kontroll = true;
        String rida;

        while (kontroll) {
            String esimeneRida = scanner.nextLine();
            if (esimeneRida.contains("---")) {
                String algKuupäev = esimeneRida.split(" ")[1];
                kontroll = false;
            }
        }

        while (scanner.hasNextLine()) {

            rida = scanner.nextLine();
            if (rida.contains("---")) {
                String lõppKuupäev = rida.split(" ")[1];
                rida = scanner.nextLine();
            }
            String[] palk = rida.split(" - ");

            if (palk.length > 3) {

            } else {

            }
        }
        return null;
    }

    static void KirjutaPalke(String failinimi) throws IOException {

        //Allikas: https://www.baeldung.com/java-append-to-file
        FileWriter fileWriter = new FileWriter(failinimi, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Scanner scanner = new Scanner(System.in);
        boolean jätka = true;
        String aktiivneLiik = null;
        String liikLower;
        boolean kontroll;

        //Allikas: https://mkyong.com/java/how-to-get-current-timestamps-in-java/
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String[] liigid = new String[] {"mänd", "kuusk", "kask"};

        System.out.println("Sisesta palk vastavalt:\n1. Liik - enter kui on sama, mis eelmise puhul\n2. Diameeter\n3. Pikkus\n4. Peenpalk - enter, kui pole peenpalk. Muul juhul muu.");

        bufferedWriter.write("\n--------------------------------------- " + dtf.format(now));
        bufferedWriter.newLine();

        while (jätka) {
            System.out.println("\nLiik: ");
            String liik = scanner.nextLine();
            System.out.println(liik);
            if (liik.equals("") && aktiivneLiik != null) {
                liik = aktiivneLiik;
            } else {
                kontroll = true;
                while (kontroll) {
                    liikLower = liik.toLowerCase();
                    for (int i = 0; i < 3; i++) {
                        if (!liikLower.contains(liigid[i])) {}
                        else {
                            aktiivneLiik = liik;
                            kontroll = false;
                            break;
                        }
                    }
                    if (kontroll == true) {
                        System.out.println("Sellist liiki ei saa andmebaasi lisada. Palun sisestage uuesti: ");
                        liik = scanner.nextLine();
                    }
                }
            }

            System.out.println("Diameeter: ");
            String diameeter = scanner.nextLine();
            kontroll = true;
            while (kontroll) {
                try {
                    Double.parseDouble(diameeter);
                    kontroll = false;
                } catch (Exception NumberFormatException) {
                    System.out.println("Palun sisestage number: ");
                    diameeter = scanner.nextLine();
                }
            }

            System.out.println("Pikkus: ");
            String pikkus = scanner.nextLine();
            kontroll = true;
            while (kontroll) {
                try {
                    Double.parseDouble(pikkus);
                    kontroll = false;
                } catch (Exception NumberFormatException) {
                    System.out.println("Palun sisestage number: ");
                    pikkus = scanner.nextLine();
                }
            }

            System.out.println("Peenpalk: ");
            String peenpalk = scanner.nextLine();

            if (peenpalk.equals("")) {
                bufferedWriter.write(liik + " - " + diameeter + " - " + pikkus);
                System.out.println("Lisatud: " + liik + " - " + diameeter + " - " + pikkus);
            }
            else {
                peenpalk = "1";
                bufferedWriter.write(liik + " - " + diameeter + " - " + pikkus + " - " + peenpalk);
                System.out.println("Lisatud: " + liik + " - " + diameeter + " - " + pikkus + " - " + peenpalk);
            }
            bufferedWriter.newLine();

            System.out.println("Kas soovite jätkata?\nJah = 'Enter'\nEi = Muu");
            if (!scanner.nextLine().equals("")) {jätka = false; bufferedWriter.close();}
        }
    }
}