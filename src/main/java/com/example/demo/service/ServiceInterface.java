package com.example.demo.service;


import com.example.demo.models.Manufacture;
import com.example.demo.models.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceInterface {
    void addManufacture(Manufacture manufacture);
    void addWorker(Worker worker);
    List<Manufacture> getAllManufacture();
    List<Worker> getAllWorker();
    List<Manufacture> filterByName();
    List<Manufacture> filterByAddress();
    List<Manufacture> filterByManId();
    List<Worker> filterByFirstName();
    List<Worker> filterByLastName();
    List<Worker>filterByMiddleName();
    List<Worker> filterByWorId();
    List<Worker> filterByRelatedManId();
    Manufacture getManufactureById(Long id);
    Worker getWorkerById(Long id);
    void deleteManufactureById(Long id);
    void deleteAllManufactures();
    void deleteWorkerById(Long id);
    void deleteAllWorkers();
    Manufacture getBanByManufacture(Long id);
    Long getManufactureId(String name);
    Long getWorkerId(String firstName);
}
