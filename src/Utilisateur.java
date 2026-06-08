public class Utilisateur {
    String nomComplet;
    String adressEmail;
    String motDePasse;
    String statut;
    long numeros;

    public Utilisateur(String nomComplet, String adressEmail , String motDePasse, String statut, long numeros){
        this.nomComplet = nomComplet;
        this.adressEmail = adressEmail;
        this.motDePasse = motDePasse;
        this.statut = statut.toUpperCase();
        this.numeros = numeros;
    }
}
