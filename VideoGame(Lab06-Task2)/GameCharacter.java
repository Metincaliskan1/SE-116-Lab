public class GameCharacter implements Damageable,Upgradeable{
    private String name;
    private int health;
    private int level;

    public GameCharacter(String name,int health,int level){
        this.name=name;
        this.health=health;
        this.level=level;
    }

    public void takeDamage(int amount){
        health=health-amount;
        System.out.println("Character "+this.name +"took "+ amount +" damage."+"Remaining health: "+health);
    }

    public boolean isDestroyed(){
        if (health<=0){
            return true;
        }
        else {
            return false;
        }
    }

    public void upgrade(){
        level+=1;
        health+=20;
        System.out.println("Character "+name +"leveled up to "+level);
        System.out.println("Health: "+health);
    }






}
