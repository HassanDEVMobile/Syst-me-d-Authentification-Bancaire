public class Administrateur extends Utilisateur{
    int niveau;
    String cleSpecial;
    public Administrateur(String nomComplet, String adressEmail ,String motDePasse,String statut, long numeros,int niveau , String cleSpecail){
        super(nomComplet, adressEmail , motDePasse, statut,  numeros);
        this.niveau = niveau;
        this.cleSpecial = cleSpecial;
    }


}
