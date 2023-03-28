public class MänniPaberipuu extends Mänd{
    public MänniPaberipuu(double keskosaDiameeterM, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameeterM, palgiPikkus, kogus, puuliik);
    }
    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*40.23*getKogus())*100)/100.0;
    }

}
