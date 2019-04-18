package sex.game;

import sex.game.items.consumables.effective.effects.Effect;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final LevelCalculator calculator;
    private final Equipment equipment;
    private final List<Effect> effects;

    private int x, y;
    private int experience = 0;
    private int hp;

    public Player(LevelCalculator calculator, int x, int y, Equipment equipment) {
        this.calculator = calculator;
        this.equipment = equipment;
        this.x = x;
        this.y = y;
        this.hp = maxHealth();
        this.effects = new ArrayList<>();
    }

    public String getName() {
        return "Mateosz";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int experience() {
        return experience;
    }

    public int level() {
        return calculator.calculateLevel(experience);
    }

    public void gainExperience(int experience) {
        this.experience += experience;
    }

    public int maxHealth() {
        return 150;
    }

    public void healOrDamage(int health) {
        this.hp = Math.min(this.hp + health, maxHealth());
    }

    public void overheal(int health) {
        this.hp += health;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Stats baseStats() {
        return new Stats(level() / 2, level() / 3, level() / 4);
    }

    public void getEffect(Effect effect) {
        this.effects.add(effect);
    }

    public void tickDownEffects() {
        this.effects.forEach(Effect::tickDown);
    }
}