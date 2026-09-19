public class Character {
    private int health;
    private final int maxHealth;

    // The maximum health is set once upon creation
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Characters usually spawn with full health
    }

    // Reduces health but clamps it at 0
    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
        }
    }

    // Increases health but caps it at maxHealth
    public void heal(int amount) {
        if (amount > 0) {
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    // Read-only access to current health (no setter provided)
    public int getHealth() {
        return this.health;
    }
    
    // Optional getter for maxHealth
    public int getMaxHealth() {
        return this.maxHealth;
    }

    // Main method to demonstrate the expected behavior
    public static void main(String[] args) {
        Character c = new Character(100);
        
        c.takeDamage(30);
        System.out.println("After taking 30 damage, health = " + c.getHealth()); // 70
        
        c.heal(50);
        System.out.println("After healing 50, health = " + c.getHealth()); // 100 (capped)
        
        c.takeDamage(150);
        System.out.println("After taking 150 damage, health = " + c.getHealth()); // 0 (floored)
    }
}