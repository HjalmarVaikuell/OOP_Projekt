public class KuusePeenpalk extends Kuusk{
    public KuusePeenpalk(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, puuliik);
    }

    @Override //meetodi ülekatmine
    public double arvutaHind() {
        return Math.round((super.arvutaTihumeeter()*46.3)*100)/100.0;
    }
}
