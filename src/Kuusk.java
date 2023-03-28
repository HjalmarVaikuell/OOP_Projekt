public class Kuusk extends Puu {
    private String puuliik;

    public Kuusk(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus);
        this.puuliik = puuliik;
    }

    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*74.04)*100)/100.0;
    }


    @Override //meetodi ülekatmine
    public String puuliik() {
        return puuliik;
    }
}
