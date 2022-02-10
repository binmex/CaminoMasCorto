public class runCaminos {
    public static void main(String[] args){
        long matrizA[][] = {{0,1,0,0,4},{1,0,1,1,1},{0,1,0,1,0},{0,1,1,0,1},{1,1,0,1,0}};
        CaminoCorto ruta = new CaminoCorto();
        System.out.println(ruta.allgoritmoFloyd (matrizA));
    }
}
