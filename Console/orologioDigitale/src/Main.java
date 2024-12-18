public class Main {
    public static void main(String[] args) {

        orologioDigitale orologioDigitale = new orologioDigitale(9,27);
        orologioDigitale.setSveglia(6,30);
        System.out.println(orologioDigitale);

        System.out.println("_______________________________ \n");

        orologioDigitale.impostaSveglia();
        orologioDigitale.setMinuti();
        orologioDigitale.setOre();
        System.out.println(orologioDigitale);

        System.out.println("_______________________________ \n");

        //setSveglia è un metodo utilizzato puramente per scopo di testing
        orologioDigitale.impostaSveglia();
        orologioDigitale.setSveglia(23,61);
        System.out.println(orologioDigitale);
    }
}