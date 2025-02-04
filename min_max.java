public class min_max {
    public static void main(String[] args) {

        int[] data = {3, 5, 7, 2, 8, 10, 11, 1, 6, 4};


        // Calcul de la moyenne 
        double sum = 0; 
        
        for(int value : data ) {
            sum += value;
        }
        double moy = sum / data.length;

        System.out.println("La Moyenne de ce tableau est : " + moy);





    }
}
    

