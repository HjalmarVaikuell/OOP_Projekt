public class Mänd extends Puu {
    private String puuliik;
    private int kogus;

    public Mänd(double keskosaDiameeterM, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameeterM, palgiPikkus);
        this.kogus = kogus;
        this.puuliik = puuliik;
    }
    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*kogus*67.27)*100)/100.0; //Käivitab klassis Puu oleva meetodi
    }

    public int getKogus() {
        return kogus;
    }

    @Override //meetodi ülekatmine
    public String puuliik() {
        return puuliik;
    }
}
