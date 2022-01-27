public class Rocket implements SpaceShip {

    int cost;
    int weight;
    int cargo;
    int maxWeight;
    int maxCargo = this.maxWeight - this.weight;
    double chanceOfLaunchExplosion;
    double chanceOfLandingExplosion;


    public boolean launch() {
        return true;
    }
    public boolean land() {
        return true;
    }
    public boolean canCarry(Item item) {
        if (item.weight > (this.maxWeight - this.weight - this.cargo)) {
            return false;
        } else {
            return true;
        }
    }

    // dodać listę itemów jakie wziął ze sobą
    public void carry(Item item) {
        //if (canCarry(item)) {
            this.cargo += item.weight;
        //}
    }
}
