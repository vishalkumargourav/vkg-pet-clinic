package vkg.springframework.vkgpetclinic.services.map;

import vkg.springframework.vkgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(null != object){
            if(object.getId() == null){
                object.setId(getNextID());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object Passed Cannot be NULL");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextID(){
        Long nextId = null;

        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException ex){
            nextId = 1L;
        }

        return nextId;
    }
}
