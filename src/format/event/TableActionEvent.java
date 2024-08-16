package format.event;

import entity.Vehicle;

public interface TableActionEvent {
        public void delete(Vehicle vehicle);

        public void update(Vehicle vehicle);
}
