/*
    // Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
    // Вилки лежат на столе между каждой парой ближайших философов.
    // Каждый философ может либо есть, либо размышлять.
    // Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
    // Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
    // Описать в виде кода такую ситуацию (Не обгадится на дедлоках). Каждый философ должен поесть три раза
 */
public class Philosopher implements Runnable {
    public Philosopher(String name, RoundTable table) {
        this.name = name;
        this.table = table;
        table.addPhilosopher(this);
        countMeals = 0;
        countThoughts = 0;
    }

    String name;
    boolean isLastActionIsEat = false;
    final RoundTable table;
    Fork leftHand;
    Fork rightHand;
    int countMeals;
    int countThoughts;


    private boolean tryToGetFork() {
        synchronized (table) {
            try {
                leftHand = table.getLeftFork(this);
                rightHand = table.getRightFork(this);
                return true;
            } catch (IllegalStateException e) {
                //System.out.printf("%s says: At least one of two forks is taken.\n", name);
                putForksBack();
                return false;
            }
        }
    }
    private void putForksBack() {
        if (leftHand != null) {
            table.putForkBack(leftHand);
            leftHand = null;
        }
        if (rightHand != null) {
            table.putForkBack(rightHand);
            rightHand = null;
        }
    }

    private void eat() {
        if (leftHand != null && rightHand != null) {
            try {
                countMeals++;
                System.out.printf(name + " eats for the %s time.\n", countMeals);
                Thread.sleep(500);
                System.out.println(name + " stopped eating.");
                isLastActionIsEat = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void think(int timeMillis) {
        try {
            System.out.println(name + " thinks.");
            Thread.sleep(timeMillis);
            System.out.println(name + " stopped thinking.");
            countThoughts++;
            isLastActionIsEat = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        while (countMeals < 3) {
            if (isLastActionIsEat) {
                think(3000);
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (tryToGetFork()) {
                    eat();
                    putForksBack();
                }
            }
        }
        System.out.printf("%s ate for %s times and thought %s times.\n", name, countMeals, countThoughts);
    }
}
