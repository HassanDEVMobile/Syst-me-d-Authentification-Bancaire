import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Utilisateur utilisateur = new Utilisateur("hasea","Hassan","diabagate@gmail.com","hassanaz","actif",1233);
      //Client client = new Client("Diabagate","Diabagatehassanilias@gmail.com","moussa10@","actif",05225,18019384,1000000);
      //Variable du programme principale

        String[] Identifiant = {"Hassan","Roméo","jolie","ZERO","Vilain"};

        int reponse = 0;
        Scanner scanner = new Scanner(System.in);
        String menu = """
              ====================================================================
                          BIENVENU DANS NOTRE APPLICATION
              ====================================================================
              1-Client
              2-Employer
              3-Administrateur
              0-Quitter L'application
              Veuillez choisir une option :
              """;
       //Interface d'authentification
        do{
            System.out.println(menu);
            reponse = scanner.nextInt();
            if(reponse == 1 || reponse == 2) {
                scanner.nextLine();
                System.out.println("Veuillez saisir votre identifiant(Nom d'utilisateur) :");
                String id = scanner.nextLine();
                for (int i = 0; i < Identifiant.length; i++) {
                    if (id.equals(Identifiant[i])) {
                        //System.out.p rintln("Compte Trouver !");
                        //if(){}
                        System.out.println("Veuillez saisir votre mot de passe :");
                        String motDePase = scanner.nextLine();
                        break;
                    }
                    else if(i== Identifiant.length-1){
                        System.out.println("Compte Introuvable !");
                    }
                }
            }

        }while(reponse != 0);

    }
}