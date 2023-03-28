public class Kask extends Puu {
    private String puuliik;

    public Kask(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus);
        this.puuliik = puuliik;
    }

    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*54.05)*100)/100.0;
    }

    @Override //meetodi ülekatmine
    public String puuliik() {
        return puuliik;
    }
}
