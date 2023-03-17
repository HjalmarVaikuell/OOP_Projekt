public class Puu {
    private double keskosaDiameeterM;
    private double palgiPikkus;

    public Puu(double keskosaDiameeterM, double palgiPikkus) {
        this.keskosaDiameeterM = keskosaDiameeterM;
        this.palgiPikkus = palgiPikkus;
    }
    public float arvutaTihumeeter(){
        return (float) ((float) Math.PI*Math.pow(keskosaDiameeterM/2,2)*palgiPikkus);
    }
    public String puuliik(){
        return "Puu";
    }

    @Override
    public String toString() {
        return puuliik() +
                ", puu mõõdud: " + keskosaDiameeterM + ", " +palgiPikkus;
    }
}
