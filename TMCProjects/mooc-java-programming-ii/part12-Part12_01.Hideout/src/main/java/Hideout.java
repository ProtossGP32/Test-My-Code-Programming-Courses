public class Hideout<T> {
    T hiddenObject;
    public Hideout() {
        this.hiddenObject = null;
    }

    public void putIntoHideout(T toHide) {
        this.hiddenObject = toHide;
    }

    public T takeFromHideout() {
        T taken = this.hiddenObject;
        this.hiddenObject = null;
        return taken;
    }

    public boolean isInHideout() {
        return this.hiddenObject != null;
    }
}
