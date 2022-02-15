package dao;

import java.util.List;

public interface ValueListIterator {

    public int getSize();

    public List getCurrentElements();

    public List getPreviousElements();

    public List getNextElements();


}
