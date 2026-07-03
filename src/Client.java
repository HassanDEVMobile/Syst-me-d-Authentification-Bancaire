public class Client extends Utilisateur{
    private int numeroCompteBancaire;
    private double solde;
    public Client(String identifiant,String nomComplet, String adressEmail ,String motDePasse, String statut, long numeros,int numeroCompteBancaire,double solde){
        super(identifiant,nomComplet, adressEmail , motDePasse, statut,  numeros);
        this.numeroCompteBancaire = numeroCompteBancaire;
        this.solde =  solde;
    }
    public int getNumeroCompteBancaire(){
        return this.numeroCompteBancaire;
    }
    public double getsolde(){
        return this.solde;
    }
    public String toString(){
        return """
                Identifiant : %s , Nom Complet : %s , Adresse Email : %s , Mot De Passe : %s , Statut : %s , numeros : %s , Numeros De Compte Bancaire : %s
                """.formatted(identifiant,nomComplet,adressEmail,super.motDePasseNonChiffre,statut,numeros,numeroCompteBancaire);
    }
    public void voirSolde(){
        System.out.println("Votre solde est = "+getsolde()+" euros");
    }
}
