public class KuusePeenpalk extends Kuusk{
    public KuusePeenpalk(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, kogus, puuliik);
    }

    @Override //meetodi ülekatmine
    public void arvutaHind() {
        System.out.println("Kuusepeenpalgi eest saadav raha on " + Math.round((super.arvutaTihumeeter()*46.3*getKogus())*100)/100.0);
    }
}
