public class HaavaPeenpalk extends Haab{
    public HaavaPeenpalk(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, kogus, puuliik);
    }
    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*74.04*getKogus())*100)/100.0;
    }
}
