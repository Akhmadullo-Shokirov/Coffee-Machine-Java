public class Latte extends Coffee {
        private int milk;

        public Latte() {
                super(350, 20, 7);
                this.milk = 75;
        }

        public int getMilk() {
                return milk;
        }
}
