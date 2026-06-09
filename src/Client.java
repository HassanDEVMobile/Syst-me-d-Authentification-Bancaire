public class Client extends Utilisateur{
    int numeroCompteBancaire;
    double solde;
    public Client(String identifiant,String nomComplet, String adressEmail ,String motDePasse, String statut, long numeros,int numeroCompteBancaire,double solde){
        super(identifiant,nomComplet, adressEmail , motDePasse, statut,  numeros);
        this.numeroCompteBancaire = numeroCompteBancaire;
        this.solde =  solde;
    }
}
