public class HaavaPaberipuu extends Haab{
    public HaavaPaberipuu(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, puuliik);
    }
    public double arvutaHind(){

        return Math.round((super.arvutaTihumeeter()*65.67)*100)/100.0;
    }
}
