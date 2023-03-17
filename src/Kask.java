public class Kask extends Puu {
    private String puuliik;
    private int kogus;

    public Kask(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus);
        this.kogus = kogus;
        this.puuliik = puuliik;
    }

    public void arvutaHind(){
        System.out.println("Kase eest saadav raha on " + Math.round((super.arvutaTihumeeter()*54.05*kogus)*100)/100.0);
    }

    @Override //meetodi ülekatmine
    public String puuliik() {
        return puuliik;
    }
}
