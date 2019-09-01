import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> temp2=new ArrayList<Integer>();
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        find(nestedList);
        index=0;
    }

    public void find(List<NestedInteger> temp){
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).isInteger()){
                temp2.add(temp.get(i).getInteger());
            }else{
                find(temp.get(i).getList());
            }
        }
    }

    @Override
    public Integer next() {
        return temp2.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index>=temp2.size()?false:true;
    }

}
