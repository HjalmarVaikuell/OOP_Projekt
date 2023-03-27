public class KasePaberipuu extends Kask{
    public KasePaberipuu(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, kogus, puuliik);
    }
    public void arvutaHind(){
        System.out.println("Kasepaberipuidu eest saadav raha on " + Math.round((super.arvutaTihumeeter()*42.04*getKogus()*100)/100.0));
    }

}
