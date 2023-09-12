package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.repository.RectangleRepository;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        int id = rectangle.getId();
        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();
        double square = sideA * sideB;
        double perimeter = 2 * (sideA + sideB);
        RectangleValues old = RectangleWarehouse.getInstance().get(id);

        RectangleWarehouse.getInstance().remove(id, old);
        RectangleValues newValues = new RectangleValues(square, perimeter);
        RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
        warehouse.get(id).setSquare(square);
        warehouse.get(id).setPerimeter(perimeter);
        warehouse.put(id, newValues);
    }
}