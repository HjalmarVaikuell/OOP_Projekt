public class Haab extends Puu{
    private String puuliik;

    public Haab(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus);
        this.puuliik = puuliik;
    }

    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*92.15)*100)/100.0;
    }

    @Override //meetodi ülekatmine
    public String puuliik() {
        return puuliik;
    }

}
