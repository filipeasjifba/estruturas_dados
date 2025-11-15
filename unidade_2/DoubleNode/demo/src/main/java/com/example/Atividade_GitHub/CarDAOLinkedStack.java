//Filipe Alves Sousa Julio
package com.example.Atividade_GitHub;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import com.example.LinkedStack;
import com.example.Stackable;

public class CarDAOLinkedStack implements CarDAO {

    private final Stackable<Car> cars = new LinkedStack<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        if(cars.isFull()){
            throw new IllegalStateException("Estacionamento cheio");
        }
        cars.push(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        if(cars.isEmpty()){
            throw new NoSuchElementException("Nenhum carro na pilha");
        }

        Stackable<Car> temp = new LinkedStack<>(20);
        Car foundCar = null;

        while (!cars.isEmpty()){
            Car current = cars.pop();
            temp.push(current);
            if (current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                foundCar = current;
                break;
            }
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }

        return foundCar;
    }

    @Override
    public Car[] getAllCars() {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        Car[] carros = new Car[cars.size()];
        int index = 0;

        while(!cars.isEmpty()){
            Car c = cars.pop();
            carros[index++] = c;
            temp.push(c);
        }
        
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return carros;
    }

    @Override
    public void updateCar(Car newCar) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        boolean updated = false;

        while(!cars.isEmpty()){
            Car current = cars.pop();
            if(current.getLicensePlate().equalsIgnoreCase(newCar.getLicensePlate())){
                temp.push(newCar);
                updated=true;
            } else{
                temp.push(current);
            }
        }

        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }

        if(!updated){
            throw new NoSuchElementException("Carro com placa" + newCar.getLicensePlate() + " não encontrado");
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        if(cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros está vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        Car deletedCar = null;

        while(!cars.isEmpty()){
            Car current = cars.pop();
            if(current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                deletedCar = current;
            } else{
                temp.push(current);
            }
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }

        return deletedCar;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        Car foundCar = null;

        while (!cars.isEmpty()){
            Car current = cars.pop();
            if (current.getLicensePlate().equalsIgnoreCase(licensePlate)){
                foundCar = current;
            }
            temp.push(current);
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }

        return foundCar;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        int count = 0;
        
        while (!cars.isEmpty()){
            Car current = cars.pop();
            if(current.getMark().equalsIgnoreCase(mark)){
                count++;
            }
            temp.push(current);
        }
        
        Car[] carros = new Car[count];
        int index = 0;
        
        while (!temp.isEmpty()){
            Car current = temp.pop();
            if(current.getMark().equalsIgnoreCase(mark)){
                carros[index++] = current;
            }
            cars.push(current);
        }

        return carros;
    }

    @Override
    public Car[] getCarsByModel(String model) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        int count = 0;

        while (!cars.isEmpty()){
            Car c = cars.pop();
            if(c.getModel().equalsIgnoreCase(model)){
                count++;
            }
            temp.push(c);
        }

        Car[] carrosPorModelo = new Car[count];
        int index = 0;

        while(!temp.isEmpty()){
            Car c = temp.pop();
            if(c.getModel().equalsIgnoreCase(model)){
                carrosPorModelo[index++] = c;
            }
            cars.push(c);
        }

        return carrosPorModelo;
    }

    @Override
    public Car[] getCarsByColor(String color) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        int count = 0;

        while (!cars.isEmpty()){
            Car c = cars.pop();
            if(c.getColor().equalsIgnoreCase(color)){
                count++;
            }
            temp.push(c);
        }

        Car[] carrosPorCor = new Car[count];
        int index = 0;

        while(!temp.isEmpty()){
            Car c = temp.pop();
            if(c.getColor().equalsIgnoreCase(color)){
                carrosPorCor[index++] = c;
            }
            cars.push(c);
        }

        return carrosPorCor;
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        int count = 0;

        while (!cars.isEmpty()){
            Car c = cars.pop();
            if(c.getOwnerName().equalsIgnoreCase(owner)){
                count++;
            }
            temp.push(c);
        }

        Car[] carrosPorDono = new Car[count];
        int index = 0;

        while(!temp.isEmpty()){
            Car c = temp.pop();
            if(c.getOwnerName().equalsIgnoreCase(owner)){
                carrosPorDono[index++] = c;
            }
            cars.push(c);
        }

        return carrosPorDono;
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        int count = 0;

        while(!cars.isEmpty()){
            Car current = cars.pop();
            if (current.getArrived() != null &&
            (current.getArrived().isEqual(initialMoment) || current.getArrived().isAfter(initialMoment)) &&
            (current.getArrived().isEqual(finalMoment)) || current.getArrived().isBefore(finalMoment)){
                count++;
            }
            temp.push(current);
        }

        Car[] carrosPorChegada = new Car[count];
        int index = 0;

        while (!temp.isEmpty()){
            Car current = temp.pop();
            if (current.getArrived() != null &&
            (current.getArrived().isEqual(initialMoment) || current.getArrived().isAfter(initialMoment)) &&
            (current.getArrived().isEqual(finalMoment)) || current.getArrived().isBefore(finalMoment)){
                carrosPorChegada[index++] = current;
            }
            cars.push(current);
        }

        return carrosPorChegada;
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }

        LinkedStack<Car> temp = new LinkedStack<>(20);
        Car carroChegouCedo = cars.peek();
        
        while(!cars.isEmpty()){
            Car current = cars.pop();
            if(current.getArrived().isAfter(carroChegouCedo.getArrived())){
                carroChegouCedo = current;
            }
            temp.push(current);
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }

        return carroChegouCedo;
    }

    @Override
    public Car getCarByOldestArrival() {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }

        LinkedStack<Car> temp = new LinkedStack<>(20);
        Car carroChegouTarde = cars.peek();
        
        while(!cars.isEmpty()){
            Car current = cars.pop();
            if(current.getArrived().isBefore(carroChegouTarde.getArrived())){
                carroChegouTarde = current;
            }
            temp.push(current);
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }

        return carroChegouTarde;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        if (cars.isEmpty()){
            throw new NoSuchElementException("pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        StringBuilder sb = new StringBuilder();

        while (!cars.isEmpty()){
            Car current = cars.pop();
            sb.append(current.toString()).append("\n");
            temp.push(current);
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }

        return sb.toString();
    }

    @Override
    public int getTotalCars() {
        return cars.size();
    }

    @Override
    public String getMostPopularMark() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("pilha de carros vazia");
        }

        LinkedStack<Car> temp = new LinkedStack<>(20);
        String[] marks = new String[20];
        int[] counts = new int[20];
        int distinct = 0;

        while (!cars.isEmpty()) {
            Car current = cars.pop();
            String mark = current.getMark();
            boolean found = false;

            for (int i = 0; i < distinct; i++) {
                if (marks[i].equalsIgnoreCase(mark)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                marks[distinct] = mark;
                counts[distinct] = 1;
                distinct++;
            }

            temp.push(current);
        }

        while (!temp.isEmpty()) {
            cars.push(temp.pop());
        }

        String mostPopular = marks[0];
        int maxCount = counts[0];
        for (int i = 1; i < distinct; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                mostPopular = marks[i];
            }
        }

        return mostPopular + " (" + maxCount + " carros)";
    }


    @Override
    public String getMostPopularModel() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("pilha vazia");
        }

        LinkedStack<Car> temp = new LinkedStack<>(20);
        String[] models = new String[20];
        int[] counts = new int[20];
        int unique = 0;

        while (!cars.isEmpty()) {
            Car current = cars.pop();
            temp.push(current);

            String model = current.getModel();
            boolean found = false;

            for (int i = 0; i < unique; i++) {
                if (models[i].equalsIgnoreCase(model)) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                models[unique] = model;
                counts[unique] = 1;
                unique++;
            }
        }

        while (!temp.isEmpty()) {
            cars.push(temp.pop());
        }

        String mostPopular = models[0];
        int maxCount = counts[0];
        for (int i = 1; i < unique; i++) {
            if (counts[i] > maxCount) {
                mostPopular = models[i];
                maxCount = counts[i];
            }
        }

        return mostPopular + " (" + maxCount + " carros)";
    }


    @Override
    public String getMostPopularColor() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("pilha vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        String[] colors = new String[20];
        int[] counts = new int[20];
        int unique = 0;
        
        while (!cars.isEmpty()) {
            Car current = cars.pop();
            temp.push(current);
            String color = current.getColor();
            boolean found = false;

            for(int i=0; i<unique;i++){
                if(colors[i].equalsIgnoreCase(color)){
                    counts[i]++;
                    found=true;
                    break;
                }
            }
            if(!found){
                colors[unique] = color;
                counts[unique] = 1;
                unique++;
            }
        }

        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }

        String mostPopular = colors[0];
        int maxCount = counts[0];
        for(int i = 1; i < unique; i++) {
            if(counts[i] > maxCount){
                mostPopular = colors[i];
                maxCount = counts[i];
            }
        }

        return mostPopular + "("+ maxCount +")";
    }

    // Operações de gerenciamento
    @Override
    public boolean isCarInPlaced(String plateLicense) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("A pilha de carros está vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        boolean found = false;

        while (!cars.isEmpty()){
            Car current = cars.pop();
            temp.push(current);
            if(current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                found = true;
                break;
            }
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }

        return found;
    }

    @Override
    public void clearAllCars() {
        while (!cars.isEmpty()){
            cars.pop();
        }
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("A pilha de carros está vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);

        while (!cars.isEmpty()){
            Car current = cars.pop();
            if(current.getArrived().isAfter(date)){
                temp.push(current);
            }
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        if (cars.isEmpty()){
            throw new NoSuchElementException("A pilha de carros está vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        int count = 0;
        
        while(!cars.isEmpty()){
            Car current = cars.pop();
            temp.push(current);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if (duration>= minHours && duration<=maxHours){
                count++;
            }
        }

        Car[] carrosPorDuracao = new Car[count];
        int index = 0;

        while (!temp.isEmpty()){
            Car current = temp.pop();
            cars.push(current);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if (duration>= minHours && duration<=maxHours){
                carrosPorDuracao[index++] = current;
            }
        }

        return carrosPorDuracao;
    }

    @Override
    public int getAvailableSpaces() {
        if (cars.isFull()){
            return 0;
        }
        return cars.getMaxCapacity() - cars.size();
    }

    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }

    @Override
    public int getMaxCapacity() {
        return cars.getMaxCapacity();
    }

    @Override
    public int getOccupancyRate() {
        if(cars.isEmpty()){
            return 0;
        }
        int rate = (int) ((double) cars.size() / cars.getMaxCapacity() *100);
        return rate;
    }

    @Override
    public boolean isParkingFull() {
        return cars.isFull();
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Pilha de carros vazia");
        }

        LinkedStack<Car> temp = new LinkedStack<>(20);
        Long duration = null;

        while (!cars.isEmpty()) {
            Car current = cars.pop();
            temp.push(current);
            if (current.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
                break;
            }
        }

        while (!temp.isEmpty()) {
            cars.push(temp.pop());
        }

        if (duration == null) {
            throw new NoSuchElementException("Carro não encontrado");
        }

        return duration;
    }


    @Override
    public void removeCarsByOwner(String owner) {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);

        while (!cars.isEmpty()){
            Car current = cars.pop();
            if(!current.getOwnerName().equalsIgnoreCase(owner)){
                temp.push(current);
            }
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }
    }

    @Override
    public long getAverageArrivalTime() {
        if (cars.isEmpty()){
            throw new NoSuchElementException("A pilha de carros está vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        long somaHoras = 0;

        while(!cars.isEmpty()){
            Car current = cars.pop();   
            temp.push(current);
            somaHoras += current.getArrived().getHour();
        }

        while (!temp.isEmpty()){
            cars.push(temp.pop());
        }

        return (somaHoras)/(cars.size());
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Pilha de carros vazia");
        }
        LinkedStack<Car> temp = new LinkedStack<>(20);
        int count =  0;

        while (!cars.isEmpty()){
            Car current = cars.pop();
            temp.push(current);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if(duration>thresholdHours){
                count++;
            }
        }

        Car[] carrosTempoExpirado = new Car[count];
        int index =0;

        while (!temp.isEmpty()){
            Car current = cars.pop();
            cars.push(current);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if(duration>thresholdHours){
                carrosTempoExpirado[index++] = current;
            }
        }

        return carrosTempoExpirado;
    }
}
