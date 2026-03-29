public class GameDemo {
    public static void main(String[] args) {
        GameCharacter thanos=new GameCharacter("Thanos",100,10);
        Weapon axe= new Weapon("Axe",70);
        Building hell=new Building("Hell",100,90);

        GameManager gameManager=new GameManager();
        gameManager.applyDamage(thanos,50);
        gameManager.repairObject(axe,20);

        System.out.println(thanos.isDestroyed());





    }
}
