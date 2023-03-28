public class KasePeenpalk extends Kask{
    public KasePeenpalk(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik, int tegelikKogus) {
        super(keskosaDiameetercm, palgiPikkus, puuliik);
    }

    @Override //meetodi ülekatmine
    public double arvutaHind() {
        return Math.round((super.arvutaTihumeeter()*40.35)*100)/100.0;
    }
}
