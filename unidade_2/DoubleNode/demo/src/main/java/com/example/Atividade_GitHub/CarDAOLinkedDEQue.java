package com.example.Atividade_GitHub;

import java.time.Duration;
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
        return cars.getAmount();
    }

    @Override
    public String getMostPopularMark() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }

        LinkedDeque<Car> temp = new LinkedDeque<>();
        String[] marks = new String[50];
        int[] counts = new int[50];
        int distinct = 0;

        while (!cars.isEmpty()) {
            Car current = cars.dequeue();
            temp.enqueue(current);

            String currentMark = current.getMark();
            boolean found = false;

            for (int i = 0; i < distinct; i++) {
                if (marks[i].equalsIgnoreCase(currentMark)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                marks[distinct] = currentMark;
                counts[distinct] = 1;
                distinct++;
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        int maxIndex = 0;
        for (int i = 1; i < distinct; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }

        return marks[maxIndex];
    }

    @Override
    public String getMostPopularModel() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }

        LinkedDeque<Car> temp = new LinkedDeque<>();
        String[] models = new String[50];
        int[] counts = new int[50];
        int distinct = 0;

        while (!cars.isEmpty()) {
            Car current = cars.dequeue();
            temp.enqueue(current);

            String model = current.getModel();
            boolean found = false;

            for (int i = 0; i < distinct; i++) {
                if (models[i].equalsIgnoreCase(model)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                models[distinct] = model;
                counts[distinct] = 1;
                distinct++;
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        int maxIndex = 0;
        for (int i = 1; i < distinct; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }

        return models[maxIndex];
    }


    @Override
    public String getMostPopularColor() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }

        LinkedDeque<Car> temp = new LinkedDeque<>();
        String[] colors = new String[50];
        int[] counts = new int[50];
        int distinct = 0;

        while (!cars.isEmpty()) {
            Car current = cars.dequeue();
            temp.enqueue(current);
            String color = current.getColor();
            boolean found = false;

            for (int i = 0; i < distinct; i++) {
                if (colors[i].equalsIgnoreCase(color)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                colors[distinct] = color;
                counts[distinct] = 1;
                distinct++;
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        int maxIndex = 0;
        for (int i = 1; i < distinct; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }

        return colors[maxIndex];
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
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if(duration>= minHours && duration<=maxHours){
                count++;
            }
        }

        Car[] carrosIntervalo = new Car[count];
        int index =0 ;

        while(!temp.isEmpty()){
            Car current = temp.dequeue();
            cars.enqueue(current);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if(duration>=minHours && duration<=maxHours){
                carrosIntervalo[index++] = current;
            }
        }

        return carrosIntervalo;
    }

    @Override
    public int getAvailableSpaces() {
        return cars.getLength() - cars.getAmount();
    }

    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }

    @Override
    public int getMaxCapacity() {
        return cars.getLength();
    }

    @Override
    public int getOccupancyRate() {
        if (cars.isEmpty()){
            return 0;
        }
        return (cars.getAmount() * 100) / cars.getLength();
    }

    @Override
    public boolean isParkingFull() {
        return cars.isFull();
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        Car foundCar = null;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            if (current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                foundCar = current;
            }
        }

        while(!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

        if(foundCar == null){
            throw new NoSuchElementException("Carro com placa " + plateLicense + " não encontrado");
        }

        return Duration.between(foundCar.getArrived(), LocalDateTime.now()).toHours();
    }

    @Override
    public void removeCarsByOwner(String owner) {
        LinkedDeque<Car> temp = new LinkedDeque<>();

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            if (!current.getOwnerName().equalsIgnoreCase(owner)){
                temp.enqueue(current);
            }
        }

        while (!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }
    }

    @Override
    public long getAverageArrivalTime() {
        if (cars.isEmpty()){
            throw new NoSuchElementException("Fila de carros vazia");
        }
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int soma = 0;
        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            soma += current.getArrived().getHour();
        }

        while(!temp.isEmpty()){
            cars.enqueue(temp.dequeue());
        }

        return soma/cars.getAmount();
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        LinkedDeque<Car> temp = new LinkedDeque<>();
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.dequeue();
            temp.enqueue(current);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if( duration > thresholdHours){
                count ++;
            }
        }

        Car[] carros = new Car[count];
        int index = 0;

        while(!temp.isEmpty()){
            Car current = temp.dequeue();
            cars.enqueue(current);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if( duration > thresholdHours){
                carros[index++] = current;
            }
        }

        return carros;
    }

    public DEQueable<Car> getCars() {
        return cars;
    }

    public void setCars(DEQueable<Car> cars) {
        this.cars = cars;
    }
}