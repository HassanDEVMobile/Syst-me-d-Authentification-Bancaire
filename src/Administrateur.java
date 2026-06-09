public class Administrateur extends Employe{
    protected int niveau;
    protected String cleSpecial;
    public Administrateur(String identifiant,String nomComplet, String adressEmail ,String motDePasse,String statut, long numeros,int niveau , String cleSpecial,int matricule,String departement, double salaire){
        super(identifiant,nomComplet, adressEmail , motDePasse, statut,  numeros,matricule,departement,salaire);
        this.niveau = niveau;
        if(cleSpecial.length()==5 && cleSpecial.contains("")){ this.cleSpecial = cleSpecial;}else{
            System.out.println("Erreur la clé spéciale ne doit pas depasser cinq (5) carateres et la clé spéciale ne doit pas contenir d'espace !");
        }

    }


}
