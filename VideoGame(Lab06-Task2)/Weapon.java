public class Weapon implements Damageable,Repairable {
    private String name;
    private int durability;

    public Weapon(String name,int durability){
        this.name=name;
        this.durability=durability;
    }

    public void takeDamage(int amount){
        durability=durability-amount;
        System.out.println("Weapon "+name+" durability "+" reduced to "+durability);
    }

    public boolean isDestroyed(){
        if (durability<=0){
            return true;
        }
        else {
            return false;
        }
    }
    public void repair(int amount){
        durability=durability+amount;
        System.out.println("Weapon "+name+" repaired.");
        System.out.println("Durability "+durability);
    }


}
