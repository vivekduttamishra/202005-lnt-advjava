package in.conceptarchitect.practices;

import java.util.Collection;

public interface Repository<Id,Entity> {
	
	
	
	Id add(Entity entity);
	
	Collection<Entity> getAll();
	
	Entity getById(Id id);
	
	void update(Entity entity);
	
	void delete(Id id);
	
	void save();

	
}
