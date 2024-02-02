package hkmu.comps380f;

import java.io.Serializable;

public class VisitCounter implements Serializable {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
