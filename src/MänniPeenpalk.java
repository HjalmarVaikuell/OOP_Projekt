public class MänniPeenpalk extends Mänd {

    public MänniPeenpalk(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, puuliik);
    }

    @Override //meetodi ülekatmine
    public double arvutaHind() {
        return Math.round((super.arvutaTihumeeter()*40.35)*100)/100.0;
    }
}
