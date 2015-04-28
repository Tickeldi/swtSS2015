package de.ostfalia.swt.aufgabe4;

import java.util.HashMap;
import java.util.Map;

public class EntityManager {
	private static EntityManager instance;
	private Map<
		Class<? extends Entity>, 
		Map<Integer, Entity>
	> idToEntity = new HashMap<>();
	
	private EntityManager(){
		
	}
	
	public static EntityManager getInstance() {
		if(instance == null) {
			instance = new EntityManager();
		}
		return instance;
	}
	
	public Integer saveOrUpdate(Entity entity) 
			throws IllegalArgumentException {

		if (entity == null) {
			throw new IllegalArgumentException();
		}
		
		Class<? extends Entity> classOfEntity = entity.getClass();
		
		if (idToEntity.get(classOfEntity) == null) {
			idToEntity.put(classOfEntity, new HashMap<Integer, Entity>());
		}
		
		if (entity.getId() == null) {
			Map<Integer, Entity> classSubMap = idToEntity.get(classOfEntity);
			int newId = 0;
			
			while(classSubMap.containsKey(newId)) newId++;
			
			entity.setID(newId);
		}
		
		idToEntity.get(classOfEntity).put(entity.getId(), entity);
		
		return entity.getId();
	}
	
	public Entity find(Class<? extends Entity> clazz, Integer id) 
			throws EntityNotFoundException {
		if(idToEntity.get(clazz) == null 
				|| idToEntity.get(clazz).get(id) == null) {
			throw new EntityNotFoundException();
		}
		return idToEntity.get(clazz).get(id);
	}
	
	public void remove(Entity o) {
		idToEntity.get(o.getClass()).remove(o.getId());
	}
}
