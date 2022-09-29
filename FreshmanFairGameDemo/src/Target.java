public class Target extends Entity{
    public Target(){
        super( 0, 0, null);
        setHealth(10); //set health to be able to be killed in one hit with basic attack.
        setDamage(0); //target does not attack.
    }
}
