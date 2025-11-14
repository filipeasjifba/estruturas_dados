package com.example.Atividade_GitHub;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import com.example.DEQueable;
import com.example.LinkedDeque;

public class CarDAOLinkedDEQue implements CarDAO {

    private DEQueable<Car> cars = new LinkedDeque<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        cars.enqueue(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        Car foundCar = null;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if(current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                foundCar=current;
            }
        }

        while(!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

        return foundCar;
    }

    @Override
    public Car[] getAllCars() {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            count++;
        }

        Car[] todosCarros = new Car[count];
        int index = 0;

        while(!temp.isEmpty()){
            Car current = temp.dequeue();
            cars.enqueue(current);
            todosCarros[index++] = current;
        }

        return todosCarros;
    }

    @Override
    public void updateCar(Car newCar) {
        if(cars.isEmpty()){
            throw new NoSuchElementException("Fila vazia");
        }
        LinkedDeque<Car> temp = new LinkedDeque<>();

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            if(current.getLicensePlate().equalsIgnoreCase(newCar.getLicensePlate())){
                temp.enqueue(newCar);
            } else {
                temp.enqueue(current);
            }
        }

        while(!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

    }

    @Override
    public Car deleteCar(String plateLicense) {
        if(cars.isEmpty()){
            throw new NoSuchElementException("Fila vazia");
        }
        LinkedDeque<Car> temp = new LinkedDeque<>();
        Car carroDeletado = null;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            if(!current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                temp.enqueue(current);
            } else {
                carroDeletado = current;
            }
        }

        while (!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

        return carroDeletado;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        Car carroPlaca = null;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if(current.getLicensePlate().equalsIgnoreCase(licensePlate)){
                carroPlaca=current;
            }
        }

        while(!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

        return carroPlaca;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if (current.getMark().equalsIgnoreCase(mark)){
            count ++;
            }
        }

        Car[] carrosMarca = new Car[count];
        int index = 0;

        while(!temp.isEmpty()){
            Car current = temp.dequeue();
            cars.enqueue(current);
            if (current.getMark().equalsIgnoreCase(mark)){
                carrosMarca[index++] = current;
            }
        }

        return carrosMarca;
    }

    @Override
    public Car[] getCarsByModel(String model) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if (current.getModel().equalsIgnoreCase(model)){
                count ++;
            }
        }

        Car[] carrosModelo = new Car[count];
        int index =0;

        while(!temp.isEmpty()){
            Car current = temp.dequeue();
            cars.enqueue(current);
            if (current.getModel().equalsIgnoreCase(model)){
                carrosModelo[index++] = current;
            }
        }

        return carrosModelo;
    }

    @Override
    public Car[] getCarsByColor(String color) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if (current.getColor().equalsIgnoreCase(color)){
                count ++;
            }
        }

        Car[] carrosCor = new Car[count];
        int index = 0;

        while(!temp.isEmpty()){
            Car current = temp.dequeue();
            cars.enqueue(current);
            if (current.getColor().equalsIgnoreCase(color)){
                carrosCor[index++] = current;
            }
        }

        return carrosCor;
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if (current.getOwnerName().equalsIgnoreCase(owner)){
                count ++;
            }
        }

        Car[] carrosDono = new Car[count];
        int index =0;

        while(!temp.isEmpty()){
            Car current = temp.dequeue();
            cars.enqueue(current);
            if (current.getOwnerName().equalsIgnoreCase(owner)){
                carrosDono[index++] = current;
            }
        }

        return carrosDono;
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if ((current.getArrived().isEqual(initialMoment) || current.getArrived().isAfter(initialMoment)) &&
            (current.getArrived().isEqual(finalMoment) || current.getArrived().isBefore(finalMoment)) ){
                count ++;
            } 
        }

        Car[] carrosPorIntervalo = new Car[count];
        int index =0;

        while(!temp.isEmpty()){
            Car current = temp.dequeue();
            cars.enqueue(current);
            if ((current.getArrived().isEqual(initialMoment) || current.getArrived().isAfter(initialMoment)) &&
            (current.getArrived().isEqual(finalMoment) || current.getArrived().isBefore(finalMoment)) ){
                carrosPorIntervalo[index++] = current;
            }
        }

        return carrosPorIntervalo;
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        if(cars.isEmpty()){
            throw new NoSuchElementException("fila vazia");
        }
        LinkedDeque<Car> temp = new LinkedDeque<>();
        Car carroRecente = cars.front();

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if(current.getArrived().isAfter(carroRecente.getArrived())){
                carroRecente = current;
            }
        }

        while (!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

        return carroRecente;
    }

    @Override
    public Car getCarByOldestArrival() {
        if(cars.isEmpty()){
            throw new NoSuchElementException("fila vazia");
        }
        LinkedDeque<Car> temp = new LinkedDeque<>();
        Car carroAntigo = cars.front();

        while(cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if(current.getArrived().isBefore(carroAntigo.getArrived())){
                carroAntigo = current;
            }
        }

        while(!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

        return carroAntigo;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
       LinkedDeque<Car> temp = new LinkedDeque<>();
       StringBuilder sb = new StringBuilder();

       while(!cars.isEmpty()){
        Car current = cars.dequeue();
        temp.enqueue(current);
        sb.append(current.toString()).append("\n");
       }

       while (!temp.isEmpty()){
        cars.enqueue(temp.dequeue());
       }

       return sb.toString();
    }

    @Override
    public int getTotalCars() {
        return cars.amount();
    }

    @Override
    public String getMostPopularMark() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String getMostPopularModel() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public String getMostPopularColor() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    // Operações de gerenciamento
    @Override
    public boolean isCarInPlaced(String plateLicense) {
        if(cars.isEmpty()){
            throw new NoSuchElementException("fila vazia");
        }
        LinkedDeque<Car> temp = new LinkedDeque<>();
        boolean carroAchado = false;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if(current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                carroAchado=true;
            }
        }

        while (!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

        return carroAchado;
    }

    @Override
    public void clearAllCars() {
        while(!cars.isEmpty()){
            cars.dequeue();
        }
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        LinkedDeque<Car> temp = new LinkedDeque<>();

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            if(current.getArrived().isAfter(date)){
                temp.enqueue(current);
            }
        }

        while(!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getAvailableSpaces() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isParkingEmpty() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getMaxCapacity() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getOccupancyRate() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isParkingFull() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void removeCarsByOwner(String owner) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public long getAverageArrivalTime() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    public DEQueable<Car> getCars() {
        return cars;
    }

    public void setCars(DEQueable<Car> cars) {
        this.cars = cars;
    }
}