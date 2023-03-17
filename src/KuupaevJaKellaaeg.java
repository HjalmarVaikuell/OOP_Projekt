import java.util.ArrayList;
import java.util.List;

public class KuupaevJaKellaaeg {

    String kuupaevKellaaegKoos;

    public KuupaevJaKellaaeg(String kuupaevKellaaegKoos) {
        this.kuupaevKellaaegKoos = kuupaevKellaaegKoos;
    }

    public List<Integer> saaKuupaevad(){
        String[] arvud = kuupaevKellaaegKoos.split(";");
        List<Integer> kuupaevKellaaeg = new ArrayList<>();
        int aasta = Integer.parseInt(arvud[0]);
        int kuu = Integer.parseInt(arvud[1]);
        int kuupaev = Integer.parseInt(arvud[2]);
        int tund = Integer.parseInt(arvud[3]);
        int minutid = Integer.parseInt(arvud[4]);
        kuupaevKellaaeg.add(aasta);
        kuupaevKellaaeg.add(kuu);
        kuupaevKellaaeg.add(kuupaev);
        kuupaevKellaaeg.add(tund);
        kuupaevKellaaeg.add(minutid);
        return kuupaevKellaaeg;

    }


}
