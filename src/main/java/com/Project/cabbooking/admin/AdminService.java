package com.Project.cabbooking.admin;

import com.Project.cabbooking.booking.Booking;
import com.Project.cabbooking.car.Car;
import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.user.CustomerAccount;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    CustomerAccount registerUser(CustomerAccount account) throws AdminExceptions ;

//    Optional<CustomerAccount> existsByEmail(String email);

//    Optional<CustomerAccount> existsById(String Id);


    DriverAccount registerDriver(DriverAccount account)throws AdminExceptions;

    Car registerCar(Car account) throws AdminExceptions;

    public List<Booking> getAllTrips(Integer customerid) throws AdminExceptions;

    public List<Booking> getTripsDriverwise() throws AdminExceptions;

    public List<Booking> getTripsCustomerwise() throws AdminExceptions;


}
