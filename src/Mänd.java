public class Mänd extends Puu {
    private String puuliik;

    public Mänd(double keskosaDiameeterM, double palgiPikkus, String puuliik) {
        super(keskosaDiameeterM, palgiPikkus);
        this.puuliik = puuliik;
    }
    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*67.27)*100)/100.0; //Käivitab klassis Puu oleva meetodi
    }

    @Override //meetodi ülekatmine
    public String puuliik() {
        return puuliik;
    }
    }
