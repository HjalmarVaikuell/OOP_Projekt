import java.util.ArrayList;
import java.util.List;

public class Puu {
    private double keskosaDiameeterM;
    private double palgiPikkus;
    private List<Float> puud = new ArrayList<>();

    public Puu(double keskosaDiameeterM, double palgiPikkus) {
        this.keskosaDiameeterM = keskosaDiameeterM;
        this.palgiPikkus = palgiPikkus;
    }
    public double arvutaTihumeeter(){
        return  ( Math.PI*Math.pow(keskosaDiameeterM/2,2)*palgiPikkus);
    }


    public String puuliik(){
        return "Puu";
    }

    @Override
    public String toString() {
        return puuliik() +
                ", puu mõõdud: " + keskosaDiameeterM + ", " +palgiPikkus;
    }
}
