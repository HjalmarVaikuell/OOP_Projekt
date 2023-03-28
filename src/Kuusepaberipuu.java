public class Kuusepaberipuu extends Kuusk{

    public Kuusepaberipuu(double keskosaDiameetercm, double palgiPikkus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, puuliik);
    }

    @Override
    public double arvutaHind() {
        return Math.round((super.arvutaTihumeeter()*42.04)*100)/100.0;
    }
}
