public class Building implements Damageable,Repairable,Upgradeable{
    private String type;
    private int health;
    private int level;

    public Building(String type,int health,int level){
        this.type=type;
        this.health=health;
        this.level=level;
    }

    public void takeDamage(int amount){
        health=health-amount;
        System.out.println(type +" building took "+amount+ " damage.Remaing health:"+health);
    }

    public boolean isDestroyed(){
        if (health<=0){
            return true;
        }
        else {
            return false;
        }
    }

    public void repair(int amount){
        health=health+amount;
        System.out.println(type+" building repaired.");
        System.out.println("Health "+health);
    }

    public void upgrade(){
        level+=1;
        health+=20;
        System.out.println(type+" building upgraded to level "+level);
    }




}
