public class Haab extends Puu{
    private String puuliik;
    private int kogus;

    public Haab(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus);
        this.kogus = kogus;
        this.puuliik = puuliik;
    }
    public void arvutaHind(){
        System.out.println("Haava eest saadav raha on " + Math.round((super.arvutaTihumeeter()*92.15*kogus)*100)/100.0);
    }

    public int getKogus() {
        return kogus;
    }

    @Override //meetodi ülekatmine
    public String puuliik() {
        return puuliik;
    }

}
