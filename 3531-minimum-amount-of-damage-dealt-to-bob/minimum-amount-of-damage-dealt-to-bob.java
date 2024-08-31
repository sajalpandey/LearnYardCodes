class Solution {
    class Enemy {
        int damage;
        int health;

        Enemy(int damage, int health) {
            this.damage = damage;
            this.health = health;
        }
    }
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        long totalDamage = 0;
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            enemies.add(new Enemy(damage[i], health[i]));
        }
        enemies.sort((e1, e2) -> {
            int t1 = (e1.health + power - 1) / power;
            int t2 = (e2.health + power - 1) / power;
            int ratioComparison = Integer.compare(e2.damage*t1 ,  e1.damage*t2);
            
            return (int)ratioComparison;
        });
        int currentTime = 0;
        for (Enemy enemy : enemies) {
            int timeToKill = (enemy.health + power - 1) / power;
            long damageDealt = (long) (currentTime + timeToKill) * enemy.damage;
            totalDamage += damageDealt;
            currentTime += timeToKill;
        }
        return totalDamage;
    }
}