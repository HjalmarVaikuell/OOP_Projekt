public class MänniPeenpalk extends Mänd{
    private int tegelikKogus;
    public MänniPeenpalk(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik, int tegelikKogus) {
        super(keskosaDiameetercm, palgiPikkus, kogus, puuliik);
        this.tegelikKogus = tegelikKogus;
    }

    @Override //meetodi ülekatmine
    public void arvutaHind() {
        System.out.println("Männipeenpalgi eest saadav raha on " + Math.round((super.arvutaTihumeeter()*40.35*tegelikKogus)*100)/100.0);
    }
}
