


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int reponse = 0;
        String comparaison = "";
        String motDePasseChiffer = "";
        String motPasse="";
        int cptr = 0;
        String cleSpecial;
        Scanner scanner = new Scanner(System.in);
        String menu = """
              ====================================================================
                          BIENVENU DANS NOTRE APPLICATION
              ====================================================================
              1-Client
              2-Employer
              3-Administrateur
              4-Creer un compte
              0-Quitter L'application
              Veuillez choisir une option :
              """;





        //String[] Identifiant = new String[]{utilisateur1.identifiant};


       //Interface d'authentification
        do{
            System.out.println(menu);
            reponse = scanner.nextInt();
            if(reponse == 1) {
                Client[] client = {
                        new Client("Hassa","Hassan","diabagate@gmail.com","hassanaz","active",1233,445655,1000000),
                       // new Utilisateur(identifiant,nomComplet,email, motDePasseChiffer,"active",numeros)
                };
                scanner.nextLine();
                System.out.println("Veuillez saisir votre identifiant(Nom d'utilisateur) :");
                String id = scanner.nextLine();
                  for (int i = 0; i < client.length; i++) {
                      //Conditions permettant de verifier l'existence du compte
                      if (id.equals(client[i].identifiant)) {
                          //Cette condtion permet de verifier si le compte de l'utilisateur est active ou bloquer
                           if (client[i].statut.equals("ACTIVE")){
                               //Cette boucle permet de compter le nombre de tentative du mot de passe avan de le bloquer
                               for (int j=0;j<3;j++){
                                   System.out.println("Veuillez saisir votre mot de passe : ");
                                    motPasse = scanner.nextLine();
                                    //Cette boucle permet de chiffrer le mot de passe avant de faire la comparaison
                                   for(int x = 0;x<motPasse.length();x++){comparaison = comparaison + String.valueOf(((int)motPasse.charAt(x)+3));}
                                   System.out.println(comparaison);
                                   //Cette conditions permet de verifier si le mot de passe est correct
                                   if(comparaison.equals(client[i].motDePasse)){
                                       System.out.println("Vous avez réussir a vous connecter a votre compte Monsieur/Madame"+" "+client[i].nomComplet);
                                       break;
                                   }
                                   else if(!comparaison.equals(client[i].motDePasse)){
                                       System.out.println("Echec le mot de passe est incorrect");
                                       cptr++;
                                       if (cptr ==3){
                                           System.out.println("Votre compte a été bloquer suite a plusieurs tentatives d'echec de votre mot de passe");
                                           client[i].statut = "BLOQUE";
                                       }
                                   }
                              }

                           }
                           else{System.out.println("Vous ne pouvez pas acceder a votre compte car il a ete est bloquer !");}

                      } else if (i == client.length - 1) {System.out.println("Compte Introuvable !");}
                  }

            }
            else if(reponse == 2){
                Employe[] employe = {
                        new Employe("Hassa","Hassan","diabagate@gmail.com","hassanaz","bloque",1233,445655,"Informatique et Recherche Scientifique",3000000),
                        // new Utilisateur(identifiant,nomComplet,email, motDePasseChiffer,"active",numeros)
                };
                scanner.nextLine();
                System.out.println("Veuillez saisir votre identifiant(Nom d'utilisateur) :");
                String id = scanner.nextLine();
                for (int i = 0; i < employe.length; i++) {
                    if (id.equals(employe[i].identifiant)) {
                        if (employe[i].statut.equals("ACTIVE")){
                            for (int j=0;j<5;j++){
                                System.out.println("Veuillez saisir votre mot de passe : ");
                                 motPasse = scanner.nextLine();
                                for(int x = 0;x<motPasse.length();x++){comparaison = comparaison + String.valueOf(((int)motPasse.charAt(x)+3));}
                                if(comparaison.equals(employe[i].motDePasse)){
                                    System.out.println("Vous avez réussir a vous connecter a votre compte Monsieur/Madame"+" "+employe[i].nomComplet);
                                    break;
                                }
                                else if(!comparaison.equals(employe[i].motDePasse)){
                                    System.out.println("Echec le mot de passe est incorrect");
                                    cptr++;
                                    if (cptr ==5){
                                        System.out.println("Votre compte a été bloquer suite a plusieurs tentatives d'echec de votre mot de passe");
                                        employe[i].statut = "BLOQUE";
                                    }
                                }
                            }

                        }
                        else{System.out.println("Vous ne pouvez pas acceder a votre compte car il a ete est bloquer !");}

                    } else if (i == employe.length - 1) {System.out.println("Compte Introuvable !");}
                }
            }
            else if(reponse == 3){
                Administrateur[] administrateur = {
                        new Administrateur("Hassa","Hassan","diabagate@gmail.com","hassanaz","bloque",1233,3,"KGB45",300,"Informatique et Recherche Scientifique",3000000),
                        // new Utilisateur(identifiant,nomComplet,email, motDePasseChiffer,"active",numeros)
                };
                scanner.nextLine();
                System.out.println("Veuillez saisir votre identifiant(Nom d'utilisateur) :");
                String id = scanner.nextLine();
                for (int i = 0; i < administrateur.length; i++) {
                    if (id.equals(administrateur[i].identifiant)) {
                            do{
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
                                        if( administrateur[i].cleSpecial.equals(cleSpecial)){
                                            System.out.println("Vous avez réussir a vous connecter a votre compte Monsieur/Madame" + " " + administrateur[i].nomComplet);
                                            break;
                                        }
                                        break;
                                    }while(administrateur[i].cleSpecial.equals(cleSpecial));

                                } else if (!comparaison.equals(administrateur[i].motDePasse)) {
                                    System.out.println("Echec le mot de passe est incorrect");
                                }
                            }while(!comparaison.equals(administrateur[i].motDePasse));

                    } else if (i == administrateur.length - 1) {
                        System.out.println("Compte Introuvable !");
                    }
                }
            }
            else if(reponse==4){
                //formulaire pour créér un compte
                System.out.println("Veuillez saisir votre identifiant :");
                String identifiant = scanner.nextLine();
                System.out.println("Veuillez saisir votre nom complet :");
                String nomComplet = scanner.nextLine();
                System.out.println("Veuillez saisir  votre email (exemple : votrenom@gmail.com) : ");
                String email = scanner.nextLine();
                do{
                    System.out.println("Veuillez saisir votre mot de passe (8 caractere obligatoire) :");
                    motPasse = scanner.nextLine();
                    if(motPasse.length() == 8 && motPasse.contains("")){
                        for(int i = 0;i<motPasse.length();i++){
                            //Cette instruction permet de chiffrer le mot de passe
                            motDePasseChiffer = motDePasseChiffer + String.valueOf(((int)motPasse.charAt(i)+3));}
                    }
                    else{
                        System.out.println("Erreur le mot de passe ne doit pas depasser huit (8) carateres et ne doit pas contenir d'espace !");
                    }
                }while(!(motPasse.length() == 8 && motPasse.contains("")));
                System.out.println("Veuillez saisir votre numéros de telephone : ");
                long numeros = scanner.nextLong();
                Utilisateur[] utilisateur = {
                        new Utilisateur("Hassa","Hassan","diabagate@gmail.com","hassanaz","bloque",1233),
                        new Utilisateur(identifiant,nomComplet,email, motDePasseChiffer,"active",numeros)
                };
            }

        }while(reponse != 0);

    }

    /**
     * Le programme démarre et affiche un menu. L'utilisateur choisit son type de compte (client, employé ou administrateur), puis saisit ses identifiants.
     *     Le système doit :
     *
     *     Vérifier que le compte existe
     *     Vérifier que le compte n'est pas bloqué
     *     Vérifier le mot de passe (en le chiffrant à la volée avant comparaison)
     *     Pour un administrateur uniquement, demander en plus la clé secrète
     *     Incrémenter le compteur d'échecs à chaque erreur
     *     Bloquer le compte si le nombre maximum de tentatives est atteint
     *     Afficher un message de bienvenue personnalisé selon le type d'utilisateur en cas de succès
     */


}