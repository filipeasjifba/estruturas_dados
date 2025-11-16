package com.example.Atividade_GitHub;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import com.example.LinkedList;

public class CarDAOLinkedList implements CarDAO {

    private LinkedList<Car> cars = new LinkedList<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        cars.append(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        for(int i = 0; i < cars.size(); i++){
            Car current = cars.select(i);
            if (current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                return current;
            }
        }
        return null;
    }

    @Override
    public Car[] getAllCars() {
       return cars.selectAll();
    }

    @Override
    public void updateCar(Car newCar) {
        for (int i = 0; i< cars.size(); i++){
            Car current = cars.select(i);
            if (newCar.getLicensePlate().equalsIgnoreCase(current.getLicensePlate())){
                cars.update(i, newCar);
                return;
            }
        }

    }

    @Override
    public Car deleteCar(String plateLicense) {
        for(int i = 0; i < cars.size(); i++){
            Car current = cars.select(i);
            if(current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                cars.delete(i);
                return current;
            }
        }
        return null;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        for(int i = 0; i <cars.size(); i++){
            Car current = cars.select(i);
            if(current.getLicensePlate().equalsIgnoreCase(licensePlate)){
                return current;
            }
        }
        return null;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        int count = 0;
        for(int i = 0; i<cars.size(); i++){
            Car current = cars.select(i);
            if(current.getMark().equalsIgnoreCase(mark)){
                count++;
            }
        }
        Car[] carrosMarca = new Car[count];
        int index = 0;

        for (int i= 0; i <cars.size(); i++){
            Car current  = cars.select(i);
            if(current.getMark().equalsIgnoreCase(mark)){
                carrosMarca[index++]=current;
            }
        }

        return carrosMarca;
    }

    @Override
    public Car[] getCarsByModel(String model) {
        int count = 0;
        for(int i = 0; i<cars.size(); i++){
            Car current = cars.select(i);
            if(current.getModel().equalsIgnoreCase(model)){
                count++;
            }
        }
        Car[] carrosModelo = new Car[count];
        int index = 0;

        for (int i= 0; i <cars.size(); i++){
            Car current  = cars.select(i);
            if(current.getModel().equalsIgnoreCase(model)){
                carrosModelo[index++]=current;
            }
        }

        return carrosModelo;
    }

    @Override
    public Car[] getCarsByColor(String color) {
        int count = 0;
        for(int i = 0; i<cars.size(); i++){
            Car current = cars.select(i);
            if(current.getColor().equalsIgnoreCase(color)){
                count++;
            }
        }
        Car[] carrosCor = new Car[count];
        int index = 0;

        for (int i= 0; i <cars.size(); i++){
            Car current  = cars.select(i);
            if(current.getColor().equalsIgnoreCase(color)){
                carrosCor[index++]=current;
            }
        }

        return carrosCor;
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        int count = 0;
        for(int i =0; i <cars.size();i++){
            Car current=cars.select(i);
            if(current.getOwnerName().equalsIgnoreCase(owner)){
                count ++;
            }
        }

        Car[] carrosDono = new Car[count];
        int index = 0;

        for(int i =0; i< cars.size();i++){
            Car current = cars.select(i);
            if(current.getOwnerName().equalsIgnoreCase(owner)){
                carrosDono[index] = current;
            }
        }

        return carrosDono;
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        int count = 0;
        for (int i=0; i < cars.size(); i ++){
            Car current = cars.select(i);
            if(!current.getArrived().isBefore(initialMoment) && !current.getArrived().isAfter(finalMoment)){
                count++;
            }
        }

        Car[] carrosIntervalo = new Car[count];
        int index =0;

        for (int i=0; i < cars.size(); i ++){
            Car current = cars.select(i);
            if(!current.getArrived().isBefore(initialMoment) && !current.getArrived().isAfter(finalMoment)){
                carrosIntervalo[index++] = current;
            }
        }

        return carrosIntervalo;
    }

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
        if(cars.isEmpty()){
            throw new NoSuchElementException ("Lista vazia");
        }

        Car carroRecente = cars.select(0);
        
        for(int i=1; i<cars.size();i++){
            Car current = cars.select(i);
            if(current.getArrived().isAfter(carroRecente.getArrived())){
                carroRecente = current;
            }
        }

        return carroRecente;
    }

    @Override
    public Car getCarByOldestArrival() {
        if (cars.isEmpty()){
            throw new NoSuchElementException("Lista vazia");
        }

        Car carroDuradouro = cars.select(0);

        for(int i=1; i <cars.size(); i++){
            Car current = cars.select(i);
            if(current.getArrived().isBefore(carroDuradouro.getArrived())){
                carroDuradouro = current;
            }
        }

        return carroDuradouro;
    }

    // Operações de relatório e estatísticas
    @Override
    public String printCars() {
        return cars.print();
    }

    @Override
    public int getTotalCars() {
        return cars.size();
    }

    @Override
    public String getMostPopularMark() {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }

        String[] marks = new String[cars.size()];
        int[] counts = new int[cars.size()];
        int distinct = 0;

        for (int i = 0; i < cars.size(); i++) {
            String mark = cars.select(i).getMark();
            boolean found = false;

            for (int j = 0; j < distinct; j++) {
                if (marks[j].equalsIgnoreCase(mark)) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                marks[distinct] = mark;
                counts[distinct] = 1;
                distinct++;
            }
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
            throw new NoSuchElementException("Lista vazia");
        }

        String[] models = new String[cars.size()];
        int[] counts = new int[cars.size()];
        int distinct = 0;

        for (int i = 0; i < cars.size(); i++) {
            String model = cars.select(i).getModel();
            boolean found = false;

            for (int j = 0; j < distinct; j++) {
                if (models[j].equalsIgnoreCase(model)) {
                    counts[j]++;
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
            throw new NoSuchElementException("Lista vazia");
        }

        String[] colors = new String[cars.size()];
        int[] counts = new int[cars.size()];
        int distinct = 0;

        for (int i = 0; i < cars.size(); i++) {
            String color = cars.select(i).getColor();
            boolean found = false;

            for (int j = 0; j < distinct; j++) {
                if (colors[j].equalsIgnoreCase(color)) {
                    counts[j]++;
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
        for(int i =0; i<cars.size(); i++){
            Car current = cars.select(i);
            if(current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clearAllCars() {
        cars.clear();
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        for(int i=cars.size()-1; i>=0 ;i--){
            Car current = cars.select(i);
            if(current.getArrived().isBefore(date)){
                cars.delete(i);
            }
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        int count = 0;
        for(int i=0; i<cars.size(); i++){
            Car current = cars.select(i);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if(duration>=minHours && duration<=maxHours){
                count++;
            }
        }

        Car[] carroDuracao = new Car[count];
        int index =0;

        for(int i=0; i<cars.size(); i++){
            Car current = cars.select(i);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if(duration>=minHours && duration<=maxHours){
                carroDuracao[index++] = current;
            }
        }

        return carroDuracao;
    }

    @Override
    public int getAvailableSpaces() {
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
        return (cars.size()*100)/cars.getMaxCapacity();
    }

    @Override
    public boolean isParkingFull() {
        return cars.isFull();
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        for (int i=0; i<cars.size(); i++){
            Car current = cars.select(i);
            if(current.getLicensePlate().equalsIgnoreCase(plateLicense)){
                long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
                return duration;
            }
        }
        throw new NoSuchElementException("Lista vazia");
    }

    @Override
    public void removeCarsByOwner(String owner) {
        for(int i=cars.size(); i>=0; i--){
            Car current= cars.select(i);
            if(current.getOwnerName().equalsIgnoreCase(owner)){
                cars.delete(i);
            }
        }
    }

    @Override
    public long getAverageArrivalTime() {
        if(cars.isEmpty()){
            return 0;
        }

        long somaHoras = 0;
        for(int i=0; i<cars.size(); i++){
            Car current = cars.select(i);
            somaHoras += current.getArrived().getHour();
        }

        return somaHoras/cars.size();
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        int count=0;
        for(int i=cars.size()-1; i >= 0 ;i--){
            Car current = cars.select(i);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if(duration>thresholdHours){
                count++;
            }
        }

        Car[] carroAnterior = new Car[count];
        int index = 0;

        for(int i=cars.size()-1; i >= 0 ;i--){
            Car current = cars.select(i);
            long duration = Duration.between(current.getArrived(), LocalDateTime.now()).toHours();
            if(duration>thresholdHours){
                carroAnterior[index++] = current;
            }
        }

        return carroAnterior;
    }
}