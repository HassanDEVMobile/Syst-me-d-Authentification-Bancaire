public class Utilisateur {
    protected String identifiant;
    protected String nomComplet;
    protected String  adressEmail;
    protected String motDePasse;
    protected String statut;
    protected long numeros;
    protected int motDePasseChiffer;

    public Utilisateur(String identifiant,String nomComplet, String adressEmail , String motDePasse, String statut, long numeros){
        //Cette instructions permet de verifier que l'identifiant ne dépasse pas cinq caractere et aussi que l'identfiant ne contient pas d'espace
        if (identifiant.length()==5 && identifiant.contains("")){this.identifiant = identifiant;}else{
            this.identifiant = null;
            System.out.println("Erreur l'identifiant ne doit pas depasser cinq (5) carateres et il l'identifiant ne doit pas contenir d'espace !");
        }
        this.nomComplet = nomComplet;
        this.adressEmail = adressEmail;
        //Cette instructions permet de verifier que le mot de passe ne dépasse pas huit caractere et aussi que l'identfiant ne contient pas d'espace
        if (motDePasse.length() == 8 && motDePasse.contains("")){this.motDePasse = motDePasse;}else{
            this.motDePasse = null;
            System.out.println("Erreur le mot de passe ne doit pas depasser huit (8) carateres et ne doit pas contenir d'espace !");
        }
        this.statut = statut.toUpperCase();
        this.numeros = numeros;
        //ses instructions nous permettrons de chiffrer le mot de passe
         for(int i = 0;i<motDePasse.length();i++){
              motDePasseChiffer = ((int)motDePasse.charAt(i)+3)+motDePasseChiffer;
         }
         for (int i = 0;i<motDePasse.length();i++){

         }
        System.out.println(motDePasseChiffer);
    }
}
