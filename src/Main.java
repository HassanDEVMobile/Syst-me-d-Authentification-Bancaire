
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declaration des variables
        int reponse = 0;
        String comparaison = "";
        String motPasse="";
        int cptr = 0;
        String cleSpecial;
        Client[] client = {
                new Client("Hassa", "Diabagate Hassan Ilias", "diabagate@gmail.com", "hassanaz", "active", 1233, 445655, 1000000),
                new Client("abdle", "Diabagate Abdoul Aziz Yacouba", "AbdoulAziz@gmail.com", "hassanaz", "active", 1233, 445655, 1000000),
                new Client("bigas", "Assa Ylane", "Assa@gmail.com", "hassanaz", "bloque", 1233, 445655, 1000000),
        };
        Employe[] employe ={
                new Employe("Zd123", "Kone", "Kone@gmail.com", "moussa10", "active", 1333, 449655,"INFORMATIQUE",10000),
                new Employe("Zd156", "Cristiano Ronaldo", "Ronaldo@gmail.com", "ronaldo7", "active", 1333, 449655,"Santer",10000),
        };
        Administrateur[] administrateur = {
                new Administrateur("Hassa", "Diabagate Hassan Ilias", "diabagate@gmail.com", "hassanaz", "active", 1233, 3, "KGB45", 300, "Informatique et Recherche Scientifique", 3000000),
        };
        Scanner scanner = new Scanner(System.in);
        String menuPrincipale = """
              ====================================================================
                          BIENVENU DANS NOTRE APPLICATION
              ====================================================================
              1-Client
              2-Employer
              3-Administrateur
              0-Quitter L'application
              Veuillez choisir une option :
              """;
        String menuClient = """
                1-Consulter Solde
                2-Consulter ses informations personnels
                """;
        String menuEmploye = """
                1-Consulter Son Departement
                2-Consulter Son Matricule
                """;
        String memuAdministrateur = """
                1-Consulter La Liste des Utilisateurs Enregistrer
                2-Reinitialisé le compteur de tentative d'un compte bloquer
                """;

       //Interface d'authentification
        do {

            System.out.println(menuPrincipale);
            reponse = scanner.nextInt();
            if (reponse == 1) {
                scanner.nextLine();
                System.out.println("Veuillez saisir votre identifiant(Nom d'utilisateur) :");
                String id = scanner.nextLine();
                for (int i = 0; i < client.length; i++) {
                    //Conditions permettant de verifier l'existence du compte
                    if (id.equals(client[i].identifiant)) {
                        //Cette condtion permet de verifier si le compte de l'utilisateur est active ou bloquer
                        if (client[i].statut.equals("ACTIVE")) {
                            //Cette boucle permet de compter le nombre de tentative du mot de passe avan de le bloquer
                            for (int j = 0; j < 3; j++) {
                                System.out.println("Veuillez saisir votre mot de passe : ");
                                motPasse = scanner.nextLine();
                                //Cette boucle permet de chiffrer le mot de passe avant de faire la comparaison
                                for (int x = 0; x < motPasse.length(); x++) {
                                    comparaison = comparaison + String.valueOf(((int) motPasse.charAt(x) + 3));
                                }
                                //Cette conditions permet de verifier si le mot de passe est correct
                                if (comparaison.equals(client[i].motDePasse)) {
                                    System.out.println("Vous avez réussir a vous connecter a votre compte Monsieur/Madame" + " " + client[i].nomComplet);
                                    System.out.println(menuClient);
                                    int choix = scanner.nextInt();
                                    if (choix == 1){
                                            System.out.println("""
                                                ===============================================
                                                          INFORMATION PERSONNELS
                                                ===============================================
                                                """);
                                            System.out.println(client[i].toString());
                                    } else if (choix == 2) {
                                            System.out.println("""
                                                ===============================================
                                                                   SOLDE
                                                ===============================================
                                                """);
                                            client[i].voirSolde();
                                    }
                                    comparaison = "";
                                    break;
                                } else if (!comparaison.equals(client[i].motDePasse)) {
                                    System.out.println("Echec le mot de passe est incorrect");
                                    comparaison = "";
                                    cptr++;
                                    if (cptr == 3) {
                                        System.out.println("Votre compte a été bloquer suite a plusieurs tentatives d'echec de votre mot de passe");
                                        client[i].setStatut("bloque");
                                    }
                                }
                            }

                        } else {
                            System.out.println("Vous ne pouvez pas acceder a votre compte car il a ete est bloquer !");
                        }

                    } else if (i == client.length - 1) {
                        System.out.println("Compte Introuvable !");
                    }
                }

            } else if (reponse == 2) {
                scanner.nextLine();
                System.out.println("Veuillez saisir votre identifiant(Nom d'utilisateur) :");
                String id = scanner.nextLine();
                for (int i = 0; i < employe.length; i++) {
                    if (id.equals(employe[i].identifiant)) {
                        if (employe[i].statut.equals("ACTIVE")) {
                            for (int j = 0; j < 5; j++) {
                                System.out.println("Veuillez saisir votre mot de passe : ");
                                motPasse = scanner.nextLine();
                                for (int x = 0; x < motPasse.length(); x++) {
                                    comparaison = comparaison + String.valueOf(((int) motPasse.charAt(x) + 3));
                                }
                                if (comparaison.equals(employe[i].motDePasse)) {
                                    System.out.println("Vous avez réussir a vous connecter a votre compte Monsieur/Madame" + " " + employe[i].nomComplet);
                                    System.out.println(menuEmploye);
                                    int choix = scanner.nextInt();

                                        if(choix == 1){
                                            System.out.println("""
                                                ===============================================
                                                                DEPARTEMENT
                                                ===============================================
                                                """);
                                            employe[i].voirDepartement();
                                        }
                                        else if(choix == 2){
                                            System.out.println("""
                                                ===============================================
                                                                 MATRICULE
                                                ===============================================
                                                """);
                                            employe[i].voirMatricule();}
                                        comparaison = "";
                                        break;
                                } else if (!comparaison.equals(employe[i].motDePasse)) {
                                    System.out.println("Echec le mot de passe est incorrect");
                                    comparaison = "";
                                    cptr++;
                                    if (cptr == 5) {
                                        System.out.println("Votre compte a été bloquer suite a plusieurs tentatives d'echec de votre mot de passe");
                                        employe[i].setStatut("bloque");
                                    }
                                }
                            }

                        } else {
                            System.out.println("Vous ne pouvez pas acceder a votre compte car il a ete est bloquer !");
                        }

                    } else if (i == employe.length - 1) {
                        System.out.println("Compte Introuvable !");
                    }
                }
            } else if (reponse == 3) {
                scanner.nextLine();
                System.out.println("Veuillez saisir votre identifiant(Nom d'utilisateur) :");
                String id = scanner.nextLine();
                for (int i = 0; i < administrateur.length; i++) {
                    if (id.equals(administrateur[i].identifiant)) {
                        do {
                            System.out.println("Veuillez saisir votre mot de passe : ");
                            motPasse = scanner.nextLine();
                            for (int x = 0; x < motPasse.length(); x++) {
                                comparaison = comparaison + String.valueOf(((int) motPasse.charAt(x) + 3));
                            }
                            if (comparaison.equals(administrateur[i].motDePasse)) {
                                do{
                                    System.out.println("Veuillez saisir votre clé secrete : ");
                                    cleSpecial = scanner.nextLine();
                                    //Condition permettant de verifier la cle speciale de l'admin
                                    if (administrateur[i].cleSpecial.equals(cleSpecial)) {
                                        System.out.println("Vous avez réussir a vous connecter a votre compte Monsieur/Madame" + " " + administrateur[i].nomComplet);
                                        System.out.println(memuAdministrateur);
                                        int choix = scanner.nextInt();
                                            if(choix==1){
                                                System.out.println("""
                                                    ==============================================
                                                         LISTE DES UTILISATEURS ENREGISTRER 
                                                    ==============================================
                                                    """);
                                                for(int j=0;j<client.length;j++){
                                                    System.out.println((j+1)+"-"+client[j].nomComplet);
                                                }
                                            }
                                            else if(choix==2){
                                                for(int j=0;j<client.length;j++){
                                                    System.out.println((j+1)+"-"+client[j].nomComplet);
                                                }
                                                System.out.println("Veuillez faire un choix : ");
                                                int select = scanner.nextInt();
                                                client[select].setStatut("active");
                                                System.out.println("Opération effectuer avec succes");
                                            }
                                        comparaison = "";
                                        break;
                                    }
                                    break;
                                } while (administrateur[i].cleSpecial.equals(cleSpecial));

                            } else if (!comparaison.equals(administrateur[i].motDePasse)) {
                                comparaison = "";
                                System.out.println("Echec le mot de passe est incorrect");
                            }
                        } while (comparaison.equals(administrateur[i].motDePasse));

                    } else if (i == administrateur.length - 1) {
                        System.out.println("Compte Introuvable !");
                    }
                }
            }
        }while (reponse != 0);

    }
}