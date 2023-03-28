public class Kuusk extends Puu {
    private String puuliik;
    private int kogus;

    public Kuusk(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus);
        this.kogus = kogus;
        this.puuliik = puuliik;
    }
    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*74.04*kogus)*100)/100.0;
    }

    public int getKogus() {
        return kogus;
    }

    @Override //meetodi ülekatmine
    public String puuliik() {
        return puuliik;
    }
}
