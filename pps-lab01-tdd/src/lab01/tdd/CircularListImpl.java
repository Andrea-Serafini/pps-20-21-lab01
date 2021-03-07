package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private List<Integer> list;
    Integer position;

    public CircularListImpl() {
        list = new ArrayList<>();
        position = null;
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(list.isEmpty()){
            return Optional.empty();
        } else {
            if(position == null){
                position = 0;
            } else {
                position++;
                if (position == list.size()){
                    position = 0;
                }
            }

            return Optional.of(list.get(position));
        }
    }

    @Override
    public Optional<Integer> previous() {
        if(list.isEmpty()){
            return Optional.empty();
        } else {
            if(position == null){
                position = list.size() - 1;
            } else {
                position--;
                if (position == -1){
                    position = list.size() - 1;
                }
            }

            return Optional.of(list.get(position));
        }
    }

    @Override
    public void reset() {
        this.position = null;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {

        for (int i = 0; i < list.size(); i++){
            if(strategy.apply(next().get())){
                return Optional.of(list.get(position));
            };
        }
        return Optional.empty();

    }
}
