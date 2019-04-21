package sex.game;

public class LevelCalculator
{
    int calculateLevel(int experience)
    {
        if (experience < 0)
        {
            throw new IllegalArgumentException("Negative experience");
        }
        return getLevelByExperience(experience);
    }

    private int getLevelByExperience(int experience)
    {
        double level = Math.sqrt(experience) / 3.0;
        return (int) Math.floor(level);
    }
}
