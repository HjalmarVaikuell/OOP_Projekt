public class MänniPaberipuu extends Mänd{
    public MänniPaberipuu(double keskosaDiameeterM, double palgiPikkus, String puuliik) {
        super(keskosaDiameeterM, palgiPikkus, puuliik);
    }
    public double arvutaHind(){
        return Math.round((super.arvutaTihumeeter()*40.23)*100)/100.0;
    }

}
