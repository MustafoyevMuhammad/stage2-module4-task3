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
        RectangleRepository repository = RectangleRepository.getInstance();
        Rectangle rectangle = event.getSource();
        int id = rectangle.getId();
        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();
        double square = sideA * sideB;
        double perimeter = 2 * (sideA + sideB);
        RectangleValues values = new RectangleValues(square, perimeter);
        RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
        warehouse.remove(id,warehouse.get(id));
        warehouse.put(id, values);
        repository.add(rectangle);
    }
}