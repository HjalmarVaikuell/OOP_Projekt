public class HaavaPeenpalk extends Haab{
    public HaavaPeenpalk(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, puuliik);
    }
    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*74.04)*100)/100.0;
    }
}
