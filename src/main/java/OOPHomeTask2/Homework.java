package OOPHomeTask2;

import java.util.Arrays;
import java.util.List;

public class Homework {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {
        Render render = new Render();

        Building building = new Building(100);
        building.setCurrentHealthPoint(100);
        Hero hero = new Hero(100, 100);
        hero.setCurrentHealthPoint(100);
        hero.setCurrentManaPoint(100);
        Neutral neutral = new Neutral(100);
        neutral.setCurrentHealthPoint(100);

        System.out.println("building information: ");
        render.showIndicator(building);
        building.getDamaged(100);
        render.showIndicator(building);
        System.out.println("______________________________________________________________________________");
        System.out.println("hero information: ");
        render.showIndicator(hero);
        hero.getDamaged(30);
        hero.useMana(40);
        render.showIndicator(hero);
        hero.getCure(50);
        render.showIndicator(hero);
        System.out.println("______________________________________________________________________________");
        System.out.println("neutral information: ");
        render.showIndicator(neutral);
        neutral.getDamaged(100);
        neutral.getCure(100);
        render.showIndicator(neutral);

    }

    interface Health {
        void getDamaged(int damage);

        void getCure(int cure);

        int[] returnHealth();


    }

    interface ManaPower {
        void useMana(int outMana);

        void refileMana(int inMana);

        int[] returnMana();

    }

    static class Render {

        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
         * * В качестве упрощения, пусть вывод на дисплей = запись информации в консоль.
         */
        public void showIndicator(Object object) {
            if (Health.class.isInstance(object)) {
                int[] health = ((Health) object).returnHealth();
                System.out.println(ANSI_GREEN + "Current health: " + health[0] + " Maximum possible: " + health[1] + ANSI_RESET);

            }
            if (ManaPower.class.isInstance(object)) {
                int[] mana = ((ManaPower) object).returnMana();
                System.out.println(ANSI_YELLOW + "Current mana: " + mana[0] + " Maximum possible: " + mana[1] + ANSI_RESET);
            }
            // Не должно быть упоминания конкретных классов!!!
        }

    }


    static class Building implements Health {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        public Building(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }


        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public void getDamaged(int damage) {
            this.currentHealthPoint -= damage;
            if (this.currentHealthPoint == 0) {
                System.out.println(ANSI_RED + "The building has been destroyed" + ANSI_RESET);
            }

        }

        @Override
        public void getCure(int cure) {
            if (this.currentHealthPoint != 0) {
                if (this.currentHealthPoint + cure <= this.maxHealthPoint) {
                    this.currentHealthPoint += cure;
                } else {
                    this.currentHealthPoint = this.maxHealthPoint;
                }

            } else {
                System.out.println("Totally destroyed building can't be repaired");
            }
        }

        @Override
        public int[] returnHealth() {
            int[] health = new int[2];
            health[0] = this.currentHealthPoint;
            health[1] = this.maxHealthPoint;
            return health;

        }


    }

    static class Hero implements Health, ManaPower {

        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        private int maxManaPoint; // максимально количество магический энергии
        private int currentManaPoint; // текущее количество магический энергии

        public Hero(int maxHealthPoint, int maxManaPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.maxManaPoint = maxManaPoint;

            this.currentHealthPoint = maxHealthPoint;
            this.currentManaPoint = maxManaPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        public void setCurrentManaPoint(int currentManaPoint) {
            this.currentManaPoint = currentManaPoint;
        }

        @Override
        public void getDamaged(int damage) {
            this.currentHealthPoint -= damage;
            if (this.currentHealthPoint == 0) {
                System.out.println(ANSI_RED + "The hero is dead" + ANSI_RESET);
            }
        }


        @Override
        public void getCure(int cure) {
            if (this.currentHealthPoint != 0) {
                if (this.currentHealthPoint + cure <= this.maxHealthPoint) {
                    this.currentHealthPoint += cure;
                } else {
                    this.currentHealthPoint = this.maxHealthPoint;
                }

            } else {
                System.out.println("Dead hero can't be cured");
            }

        }


        @Override
        public int[] returnHealth() {
            int[] health = new int[2];
            health[0] = this.currentHealthPoint;
            health[1] = this.maxHealthPoint;
            return health;

        }

        @Override
        public void useMana(int outMana) {
            this.currentManaPoint -= outMana;
            if (this.currentManaPoint == 0) {
                System.out.println(ANSI_RED + "The hero lost his power" + ANSI_RESET);
            }
        }

        @Override
        public void refileMana(int inMana) {

            if (this.currentManaPoint + inMana <= this.currentManaPoint) {
                this.currentManaPoint += inMana;
            } else {
                this.currentManaPoint = this.maxManaPoint;
            }

        }

        @Override
        public int[] returnMana() {
            int[] mana = new int[2];
            mana[0] = this.currentManaPoint;
            mana[1] = this.maxManaPoint;
            return mana;
        }


    }

    static class Neutral implements Health {


        private int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья

        public Neutral(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }

        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public void getDamaged(int damage) {
            this.currentHealthPoint -= damage;
            if (this.currentHealthPoint == 0) {
                System.out.println(ANSI_RED + "This innocent has been killed" + ANSI_RESET);
            }
        }


        @Override
        public void getCure(int cure) {
            if (this.currentHealthPoint != 0) {
                if (this.currentHealthPoint + cure <= this.maxHealthPoint) {
                    this.currentHealthPoint += cure;
                } else {
                    this.currentHealthPoint = this.maxHealthPoint;
                }

            } else {
                System.out.println("Dead person can't be cured");
            }
        }

        @Override
        public int[] returnHealth() {
            int[] health = new int[2];
            health[0] = this.currentHealthPoint;
            health[1] = this.maxHealthPoint;
            return health;

        }


    }

}
