public class Employe extends Utilisateur {
    int matricule;
    String departement;
    double salaire;
    public Employe(String nomComplet, String adressEmail ,String motDePasse,String statut, long numeros,int matricule,String departement , double salaire){
        super(nomComplet, adressEmail , motDePasse, statut,  numeros);
        this.matricule = matricule;
        this.departement = departement;
        this.salaire = salaire;
    }

}
