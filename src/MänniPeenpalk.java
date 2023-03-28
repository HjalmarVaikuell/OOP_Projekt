public class MänniPeenpalk extends Mänd {

    public MänniPeenpalk(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, kogus, puuliik);
    }

    @Override //meetodi ülekatmine
    public double arvutaHind() {
        return Math.round((super.arvutaTihumeeter()*40.35*getKogus())*100)/100.0;
    }
}
