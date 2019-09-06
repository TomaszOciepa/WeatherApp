package data.dao;

import data.model.Station;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Stateless
public class StationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public long save(Station station) {
        entityManager.persist(station);
        return station.getStationId();
    }

    public Station update(Station station) {
        return entityManager.merge(station);
    }

    public void delete(long id) {
        final Station city = entityManager.find(Station.class, id);
        if (city != null) {
            entityManager.remove(city);
        }
    }

    public Station findById(long id) {
        return entityManager.find(Station.class, id);
    }

    public List<Station> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Station s");

        return (List<Station>) query.getResultList();
    }

    public List<Station> getSelectedCity(String city) {
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationName = :city");
        query.setParameter("city", city);

        return (List<Station>) query.getResultList();
    }

    public List<String> getCitiesName() {
        final Query query = entityManager.createQuery("SELECT s.stationName FROM Station s");
        return (List<String>) query.getResultList();
    }

    public List<Double> getSumTempForPoland() {
        final Query query = entityManager.createQuery("SELECT SUM(s.stationTemperature) FROM Station s");
        return query.getResultList();
    }

    public List<Long> getCountTempForPoland() {
        final Query query = entityManager.createQuery("SELECT COUNT(s.stationTemperature) FROM Station s");
        return (List<Long>) query.getResultList();
    }

    public List<Station> lastUpdate() {
        final Query query = entityManager.createQuery("SELECT s FROM Station s ORDER BY s.stationDateTime DESC");
        return (List<Station>) query.getResultList();
    }

    public List<Double> getSumTempForCity(String city) {
        final Query query = entityManager.createQuery("SELECT SUM (s.stationTemperature) FROM Station s WHERE s.stationName = :city");
        query.setParameter("city", city);
        return (List<Double>) query.getResultList();
    }

    public List<Long> getCountTempForCity(String city) {
        final Query query = entityManager.createQuery("SELECT COUNT(s.stationTemperature) FROM Station s WHERE s.stationName = :city");
        query.setParameter("city", city);
        return (List<Long>) query.getResultList();
    }

    public List<Double> getSumTempYearForCity(int year, String city) {
        final Query query = entityManager.createQuery("select SUM(s.stationTemperature) FROM Station s WHERE s.stationDateTime LIKE CONCAT(:year, '%') AND s.stationName = :city");
        query.setParameter("year", year);
        query.setParameter("city", city);
        return (List<Double>) query.getResultList();
    }

    public List<Long> getCountTempYearForCity(int year, String city) {
        final Query query = entityManager.createQuery("select COUNT(s.stationTemperature) FROM Station s WHERE s.stationDateTime LIKE CONCAT(:year, '%') AND s.stationName = :city");
        query.setParameter("year", year);
        query.setParameter("city", city);
        return (List<Long>) query.getResultList();
    }

    public List<Double> getSumTempMonthForCity(int month, String city) {
        final Query query = entityManager.createQuery("SELECT SUM(s.stationTemperature) FROM Station s WHERE s.stationDateTime LIKE CONCAT('%-%', :month, '-%') AND s.stationName = :city");
        query.setParameter("month", month);
        query.setParameter("city", city);
        return (List<Double>) query.getResultList();
    }

    public List<Long> getCountTempMonthForCity(int month, String city) {
        final Query query = entityManager.createQuery("SELECT COUNT(s.stationTemperature) FROM Station s WHERE  s.stationDateTime LIKE CONCAT('%-%', :month, '-%') AND s.stationName = :city");
        query.setParameter("month", month);
        query.setParameter("city", city);
        return (List<Long>) query.getResultList();
    }

    public List<Double> getSumTempDayForCity(LocalDate date, String city) {
        final Query query = entityManager.createQuery("SELECT SUM(s.stationTemperature) FROM Station s WHERE  s.stationDateTime LIKE CONCAT(:date, '%') AND s.stationName = :city");
        query.setParameter("date", date);
        query.setParameter("city", city);
        return (List<Double>) query.getResultList();
    }

    public List<Long> getCountTempDayForCity(LocalDate date, String city) {
        final Query query = entityManager.createQuery("SELECT COUNT (s.stationTemperature) FROM Station s WHERE  s.stationDateTime LIKE CONCAT(:date, '%') AND s.stationName = :city");
        query.setParameter("date", date);
        query.setParameter("city", city);
        return (List<Long>) query.getResultList();
    }

    public List<Station> getMaxTempForCity(String city){
        final  Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationName = :city ORDER BY s.stationTemperature DESC");
        query.setParameter("city", city);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinTempForCity(String city){
        final  Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationName = :city ORDER BY s.stationTemperature ASC");
        query.setParameter("city", city);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxTempForPolandAllMeasurement(){
        final Query query = entityManager.createQuery("SELECT s FROM Station s ORDER BY s.stationTemperature DESC ");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinTempForPolandAllMeasurement(){
        final Query query = entityManager.createQuery("SELECT s FROM Station s ORDER BY s.stationTemperature ASC ");
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxTempForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationTemperature DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinTempForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationTemperature ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxWindForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationWindSpeed DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinWindForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationWindSpeed ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxRainFallForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationTotalRainfall DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinRainFallForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationTotalRainfall ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxHumidityForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationHumidity DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinHumidityForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationHumidity ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMaxPressureForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationPressure DESC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Station> getMinPressureForPolandLastMeasurement(LocalDateTime lastUpdate){
        final Query query = entityManager.createQuery("SELECT s FROM Station s WHERE s.stationDateTime = :lastUpdate ORDER BY s.stationPressure ASC");
        query.setParameter("lastUpdate", lastUpdate);
        query.setMaxResults(1);
        return (List<Station>) query.getResultList();
    }

    public List<Double> getSumPreassureForPoland(){
        final Query query = entityManager.createQuery("SELECT SUM(s.stationPressure) FROM Station s");
        return (List<Double>) query.getResultList();
    }

    public List<Long> getCountPreassureForPoland(){
        final  Query query = entityManager.createQuery("SELECT COUNT(s.stationPressure) FROM Station s");
        return (List<Long>) query.getResultList();
    }

    public List<Long> getSumWindSpeedForPoland(){
        final  Query query = entityManager.createQuery("SELECT SUM(s.stationWindSpeed) FROM Station s");
        return (List<Long>) query.getResultList();
    }

    public List<Long> getCountWindSpeedForPoland(){
        final Query query = entityManager.createQuery("SELECT COUNT(s.stationWindSpeed) FROM Station s");
        return (List<Long>) query.getResultList();
    }

    public List<Double> getSumHumidityForPoland(){
        final Query query = entityManager.createQuery("SELECT SUM(s.stationHumidity) FROM Station s");
        return (List<Double>) query.getResultList();
    }

    public List<Long> getCountHumidityForPoland(){
        final Query query = entityManager.createQuery("SELECT COUNT(s.stationHumidity) FROM Station s");
        return (List<Long>) query.getResultList();
    }
}
