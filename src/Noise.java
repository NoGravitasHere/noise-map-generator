public class Noise {

    public static double[][] generateRandomNoise(int width, int height) {
        double[][] noise = new double[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                noise[i][j] = Math.random()*2 - 1;
            }
        }
        return noise;
    }

    public static double[][] generateSimplexNoise(int width, int height){
        double[][] simplexnoise = new double[width][height];

        OpenSimplexNoise osn = new OpenSimplexNoise();

        double x = 0;
        double y = 0;
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                simplexnoise[j][i] = osn.eval(x, y);
                x += 0.01;
                y += 0.01;
            }
        }
        return simplexnoise;
     }

     public static double[][] generateSimplexNoiseC(int width, int height){
        double[][] simplexnoise = new double[width][height];
        double frequency = 5.0 / (double) width;
        OpenSimplexNoise osn = new OpenSimplexNoise();

        for(int x = 0; x < width; x++){
           for(int y = 0; y < height; y++){
              simplexnoise[x][y] = (double) osn.eval(x * frequency,y * frequency);
              simplexnoise[x][y] = (simplexnoise[x][y] + 1) / 2;   //generate values between 0 and 1
           }
        }

        return simplexnoise;
     }

}