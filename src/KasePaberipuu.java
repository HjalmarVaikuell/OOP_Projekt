public class KasePaberipuu extends Kask{
    public KasePaberipuu(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, puuliik);
    }
    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*42.04*100)/100.0);
    }

}
