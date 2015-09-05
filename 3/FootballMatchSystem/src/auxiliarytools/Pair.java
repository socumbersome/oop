/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auxiliarytools;

/**
 *
 * @author ja
 */
public class Pair<X, Y>
{
    private final X x;
    private final Y y;

    public Pair(X a, Y b) {
        x = a;
        y = b;
    }

    public X getFirst() {
        return x;
    }
    public Y getSecond() {
        return y;
    }
}