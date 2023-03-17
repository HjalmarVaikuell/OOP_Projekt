import java.util.ArrayList;
import java.util.List;

public class PuudegaTeenitu {
    public static void main(String[] args) {

        Kask kask = new Kask(0.405,2,20,"Harilik kask");
        kask.arvutaHind();

        Mänd mänd = new Mänd(0.517,2,41,"Harilik mänd");
        mänd.arvutaHind();

        Kuusk kuusk = new Kuusk(0.354,2,51,"Harilik kuusk");
        kuusk.arvutaHind();

        MänniPeenpalk männiPeenpalk = new MänniPeenpalk(0.214,2,51,"Harilik mänd", 41);
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
}
