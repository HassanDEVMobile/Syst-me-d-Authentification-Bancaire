public class Employe extends Utilisateur {
   protected int matricule;
   protected  String departement;
   protected  double salaire;
    public Employe(String identifiant,String nomComplet, String adressEmail ,String motDePasse,String statut, long numeros,int matricule,String departement , double salaire){
        super(identifiant,nomComplet, adressEmail , motDePasse, statut,  numeros);
        this.matricule = matricule;
        this.departement = departement;
        this.salaire = salaire;
    }
    public void voirDepartement(){System.out.println("Departement : "+this.departement);}
    public void voirMatricule(){System.out.println("Matricule : "+this.matricule);}

}
