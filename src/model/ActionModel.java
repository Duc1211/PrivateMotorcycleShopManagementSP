package model;

import entity.Vehicle;
import format.event.TableActionEvent;

public class ActionModel {

    private Vehicle vehicle;
    private TableActionEvent event;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public TableActionEvent getEvent() {
        return event;
    }

    public void setEvent(TableActionEvent event) {
        this.event = event;
    }
    public ActionModel() {
    }

    public ActionModel(Vehicle vehicle, TableActionEvent event) {
        this.vehicle = vehicle;
        this.event = event;
    }

}
