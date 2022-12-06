
public class PaymentTerminal {


    private double money;  // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals


    public PaymentTerminal() {
        // register initially has 1000 euros of money
        this.money = 1000.0;
    }

    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        // increase the amount of cash by the price of an affordable mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        double affordableMeal = 2.50;
        if (payment >= affordableMeal) {
            this.money += affordableMeal;
            ++this.affordableMeals;
            return payment - affordableMeal;
        } else {
            return payment;
        }
    }

    public boolean eatAffordably(PaymentCard card) {
        double affordableMeal = 2.50;
        if (card.balance() >= affordableMeal) {
            ++this.affordableMeals;
        }
        return card.takeMoney(affordableMeal);
    }

    public boolean eatHeartily(PaymentCard card) {
        double heartyMeal = 4.30;
        if (card.balance() >= heartyMeal) {
            ++this.heartyMeals;
        }
        return card.takeMoney(heartyMeal);
    }

    public double eatHeartily(double payment) {
        // a hearty meal costs 4.30 euros
        // increase the amount of cash by the price of a hearty mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        double heartyMeal = 4.30;
        if (payment >= heartyMeal) {
            this.money += heartyMeal;
            ++this.heartyMeals;
            return payment - heartyMeal;
        } else {
            return payment;
        }
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        // - card is the user PaymentCard
        // - sum is the cash amount that the user is willing to add to its card,
        // so sum must be added to the terminal available money
        if (sum > 0) {
            this.money += sum;
            card.addMoney(sum);
        }
    }

    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
