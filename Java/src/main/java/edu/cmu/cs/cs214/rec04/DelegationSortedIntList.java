package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    private final SortedIntList list;
    private int totalAdded;

    public DelegationSortedIntList() {
        this.list = new SortedIntList();
        this.totalAdded = 0;
    }

    @Override
    public boolean add(int value) {
        totalAdded++;
        return list.add(value);
    }

    @Override
    public boolean addAll(IntegerList otherList) {
        totalAdded += otherList.size();
        return list.addAll(otherList);
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public boolean remove(int index) {
        return list.remove(index);
    }

    @Override
    public boolean removeAll(IntegerList otherList) {
        return list.removeAll(otherList);
    }

    @Override
    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}