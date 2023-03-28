import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuudegaTeenitu {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String sisestus;
        boolean kontroll = true;

        while (kontroll) {
            System.out.println("Mida soovid teha?\n1 - lisada palke\n2 - väljastada palkide andmed\n3 - väljastada liikide tihumeetrid ja teenitava hinna\nEnter - lõpeta");
            sisestus = scanner.nextLine();
            if (sisestus.equals("")) {
                kontroll = false;
                System.out.println("\nVäljun");
                System.out.println();
            }
            else if (sisestus.equals("1")) {
                System.out.println();
                KirjutaPalke("palgid.txt");
                System.out.println();
            }
            else if (sisestus.equals("2")) {
                System.out.println();
                väljastaPuud(LoePalke("palgid.txt"));
                System.out.println();
            }
            else if (sisestus.equals("3")) {
                System.out.println();
                Loetihumeetrid(LoePalke("palgid.txt"));
                System.out.println();
            }
        }
    }

    static void Loetihumeetrid(List<Puu> puud){ //loeb listist isendid ja sorteerib vastavalt klassile isendi
        double männitm = 0;                     //ning arvutab siis kõigi samast liigist puude tihumeetri
        double männiHind = 0;                   // ja siis sellele vastava hinna
        double kasetm = 0;
        double kaseHind = 0;
        double kuusetm = 0;
        double kuuseHind = 0;
        double haavatm = 0;
        double haavaHind = 0;
        for (Puu puu : puud) {
            if (puu instanceof Mänd){
                double saadudtm = puu.arvutaTihumeeter();
                männiHind += ((Mänd) puu).arvutaHind();
                männitm += saadudtm;
            }
            if (puu instanceof Kask){
                double saadudtm = puu.arvutaTihumeeter();
                kaseHind += ((Kask) puu).arvutaHind();
                kasetm += saadudtm;
            }
            if (puu instanceof Kuusk){
                double saadudtm = puu.arvutaTihumeeter();
                kuuseHind += ((Kuusk) puu).arvutaHind();
                kuusetm += saadudtm;
            }
            if (puu instanceof Haab){
                double saadudtm = puu.arvutaTihumeeter();
                haavaHind += ((Haab) puu).arvutaHind();
                haavatm += saadudtm;
            }
        }
        System.out.println("Kuuskede tihumeetrid kokku " + kuusetm); //väljastab kogu info
        System.out.println("Kuusepuude pealt saadud raha " + kuuseHind);
        System.out.println("Mändide tihumeetrid kokku " + männitm);
        System.out.println("Männipuude pealt saadud raha " + männiHind);
        System.out.println("Kaskede tihumeetrid kokku " + kasetm);
        System.out.println("Kasepuude pealt saadud raha " + kaseHind);
        System.out.println("Haabade tihumeetrid kokku " + haavatm);
        System.out.println("Haavapuude pealt saadud raha " + haavaHind);
    }

    static void väljastaPuud(List<Puu> puud) {
        for (Puu puu : puud) {
            System.out.println(puu);
        }
    }

    static List<Puu> LoePalke(String failinimi) throws FileNotFoundException {

        File file = new File(failinimi);
        List<Puu> puud = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        boolean kontroll = true;//Näitamaks, kas esimene andmetega rida leiti üles
        String rida;//Vaadeldav rida
        String algKuupäev = null;//Esimese sissekande kuupäev
        String lõppKuupäev = null;//Viimase sissekande kuupäev

        String[] liigid = new String[] {"mänd", "kuusk", "kask", "haab"};//Kontrolliks sobivad puuliigid

        while (kontroll) {
            String esimeneRida = scanner.nextLine();
            if (esimeneRida.contains("---")) {
                algKuupäev = esimeneRida.split(" ")[1];
                kontroll = false;
            }
        }

        while (scanner.hasNextLine()) {

            rida = scanner.nextLine();

            if (rida.equals("\n")) rida = scanner.nextLine();

            if (rida.contains("---")) {
                lõppKuupäev = rida.split(" ")[1];
                rida = scanner.nextLine();
            }
            String[] palk = rida.split(" - ");

            for (String liik : liigid) {
                if (palk[0].toLowerCase().contains(liik)) {
                    if (liik.equals("kuusk")) puud.add(new Kuusk(Double.parseDouble(palk[1]), Double.parseDouble(palk[2]), 1,palk[0]));
                    else if (liik.equals("mänd")) puud.add(new Mänd(Double.parseDouble(palk[1]), Double.parseDouble(palk[2]), 1,palk[0]));
                    else if (liik.equals("kask")) puud.add(new Kask(Double.parseDouble(palk[1]), Double.parseDouble(palk[2]), 1,palk[0]));
                    else if (liik.equals("haab")) puud.add(new Haab(Double.parseDouble(palk[1]), Double.parseDouble(palk[2]), 1,palk[0]));
                }
            }
        }
        System.out.println("Lugesin puude andmed alates " + algKuupäev + " kuni " + lõppKuupäev + ".");
        return puud;
    }

    static void KirjutaPalke(String failinimi) throws IOException {

        //Allikas: https://www.baeldung.com/java-append-to-file
        FileWriter fileWriter = new FileWriter(failinimi, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Scanner scanner = new Scanner(System.in);
        boolean jätka = true;//Kontrollimaks, kas kirjutamise tsüklit tahetakse korrata
        String aktiivneNimi = null;//Jätab viimase sisestatud puu nimetuse meelde
        String liikLower;//Salvestab puu nimetuse väiketähtedega
        boolean kontroll;//Kotrollimaks, kas nimetuse tsüklit on vaja korrata

        //Allikas: https://mkyong.com/java/how-to-get-current-timestamps-in-java/
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String[] liigid = new String[] {"mänd", "kuusk", "kask", "haab"};//Kontrolliks liikide nimed, millega programm töötab

        System.out.println("Sisesta palk vastavalt:\n1. Liik - enter kui on sama, mis eelmise puhul\n2. Diameeter\n3. Pikkus");//Õpetus/meeldetuletus

        bufferedWriter.write("\n--------------------------------------- " + dtf.format(now));//Lisab kuupäeva ja kellaaja, millal palgid lisatud on faili
        bufferedWriter.newLine();

        while (jätka) {
            System.out.println("\nLiik: ");
            String liik = scanner.nextLine();
            if (liik.equals("") && aktiivneNimi != null) {
                liik = aktiivneNimi;
            }//Kui midagi ei sisestatud ning tsüklit ei tehta esimest korda, siis salvestab uue nime
            else {
                kontroll = true;
                while (kontroll) {
                    liikLower = liik.toLowerCase();
                    for (int i = 0; i < 4; i++) {
                        if (!liikLower.contains(liigid[i])) {}//Kui puu nimetus ei sisalda vajalike liikide nimesid, siis ei tee pidagi
                        else {
                            aktiivneNimi = liik;
                            kontroll = false;
                            break;
                        }//Kui puu nimetus sisaldab sobiva nimetusega liigi, siis salvestab selle ja laseb tsüklil lõppeda
                    }
                    if (kontroll == true) {
                        System.out.println("Sellise nimetusega puud ei saa andmebaasi lisada. Palun sisestage uuesti: ");
                        liik = scanner.nextLine();
                    }//Küsib nimetuse uuesti sisestamist
                }//Kontrollib nimetuse sobivust ning vajadusel küsib uuesti sisestamist
            }//Kui puu nimetus sisestatakse, siis kontrollitakse sobivust

            System.out.println("Diameeter: ");
            String diameeter = scanner.nextLine();
            kontroll = true;
            while (kontroll) {
                try {
                    Double.parseDouble(diameeter);
                    kontroll = false;
                }//Kontrollib, kas sisestati arv, mida saab double formaati panna
                catch (Exception NumberFormatException) {
                    System.out.println("Palun sisestage number: ");
                    diameeter = scanner.nextLine();
                }//Kui ei saa double formaati panna sisestatut, siis küsib uuesti sisestust
            }//Kontrollib diameetri sisestust

            System.out.println("Pikkus: ");
            String pikkus = scanner.nextLine();
            kontroll = true;
            while (kontroll) {
                try {
                    Double.parseDouble(pikkus);
                    kontroll = false;
                }//Kontrollib, kas sisestati arv, mida saab double formaati panna
                catch (Exception NumberFormatException) {
                    System.out.println("Palun sisestage number: ");
                    pikkus = scanner.nextLine();
                }//Kui ei saa double formaati panna sisestatut, siis küsib uuesti sisestust
            }//Kontrollib pikkuse sisestust

            bufferedWriter.write(liik + " - " + diameeter + " - " + pikkus);//Kirjutab andmed kindlas formaadis faili
            bufferedWriter.newLine();

            System.out.println("Kas soovite jätkata?\nJah = 'Enter'\nEi = Muu");
            if (!scanner.nextLine().equals("")) {
                jätka = false;
                bufferedWriter.close();//Salvestab faili uute kirjutustega
            }//Kontrollib, kas vajutati lihtsalt Enter või sisestati midagi
        }//Tsükliga saab lisada palkide andmeid faili seni, kuni soovitakse
    }
}