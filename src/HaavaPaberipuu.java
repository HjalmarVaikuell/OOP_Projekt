public class HaavaPaberipuu extends Haab{
    public HaavaPaberipuu(double keskosaDiameetercm, double palgiPikkus, int kogus, String puuliik) {
        super(keskosaDiameetercm, palgiPikkus, kogus, puuliik);
    }
    public void arvutaHind(){
        System.out.println("Haavapaberipuidu eest saadav raha on " + Math.round((super.arvutaTihumeeter()*65.67*getKogus())*100)/100.0);
    }
}
