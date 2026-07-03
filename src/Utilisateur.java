public class Utilisateur {
    protected String identifiant;
    protected String nomComplet;
    protected String  adressEmail;
    protected String motDePasse;
    protected String statut;
    protected long numeros;
    protected String comparaison = "";
    protected String motDePasseNonChiffre="";

    public Utilisateur(String identifiant,String nomComplet, String adressEmail , String motDePasse, String statut, long numeros){
        //Cette instructions permet de verifier que l'identifiant ne dépasse pas cinq caractere et aussi que l'identfiant ne contient pas d'espace
        if (identifiant.length()==5 && identifiant.contains("")){this.identifiant = identifiant;}else{
            this.identifiant = null;
            System.out.println("Erreur l'identifiant ne doit pas depasser cinq (5) carateres et il l'identifiant ne doit pas contenir d'espace !");
        }
        this.nomComplet = nomComplet;
        this.adressEmail = adressEmail;
        //Cette instructions permet de verifier que le mot de passe ne dépasse pas huit caractere et aussi que l'identfiant ne contient pas d'espace
        //Cette instruction nous permettra de chiffrer le mot de passe
        for(int i = 0;i<motDePasse.length();i++){comparaison = comparaison + String.valueOf(((int)motDePasse.charAt(i)+3));}
        for(int i = 0;i<motDePasse.length();i++){motDePasseNonChiffre = motDePasseNonChiffre + String.valueOf(((char)((int)motDePasse.charAt(i) )));};
        this.motDePasse = comparaison;
        this.statut = statut.toUpperCase();
        this.numeros = numeros;
    }

    public void setStatut(String statut){
        this.statut = statut.toUpperCase();
    }


}
