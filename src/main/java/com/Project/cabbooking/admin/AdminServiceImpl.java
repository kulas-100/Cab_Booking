package com.Project.cabbooking.admin;
import com.Project.cabbooking.booking.Booking;
import com.Project.cabbooking.booking.BookingRepository;
import com.Project.cabbooking.car.Car;
import com.Project.cabbooking.car.CarRepository;
import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.driver.DriverRepository;
import com.Project.cabbooking.user.CustomerAccount;
import com.Project.cabbooking.user.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements com.Project.cabbooking.admin.AdminService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public CustomerAccount registerUser(CustomerAccount account) throws AdminExceptions {
        if (customerRepository.findByCdsId(account.getCdsId()))
        {
            throw new AdminExceptions("User Email already exists");
        }
        return this.customerRepository.save(account);
    }

//    @Override
//    public Optional<CustomerAccount> existsByEmail(String email) {
//        return Optional.empty();
//    }

//    @Override
//    public Optional<CustomerAccount> existsById(String Id) {
//        return this.customerRepository.existsByEmail(Id);
//    }

    @Override
    public DriverAccount registerDriver(DriverAccount account)throws AdminExceptions {
        if (driverRepository.findById(account.getId()).isPresent())
        {
            throw new AdminExceptions("Driver ID already exists");
        }
        return  this.driverRepository.save(account);

    }




    @Override
    public Car registerCar(Car account) throws AdminExceptions{
        if(carRepository.existsById(account.getId()))
        {
            throw new AdminExceptions("Car is already Registered");
        }
       return  this.carRepository.save(account);
    }

    @Override
    public List<Booking> getAllTrips(Integer customerid) throws AdminExceptions {
        Optional<CustomerAccount> opt = customerRepository.findById(customerid);
        if (opt.isPresent()) {
            List<Booking> trips = bookingRepository.findAll();
            return trips;
        }
        throw new AdminExceptions("Invalid Id");
    }

    @Override
    public List<Booking> getTripsDriverwise() throws AdminExceptions {
        return null;
    }

    @Override
    public List<Booking> getTripsCustomerwise() throws AdminExceptions {
        return null;
    }

//    @Override
//    public List<Booking> getTripsDriverwise() throws AdminExceptions {
//        List<Booking> list = BookingRepository.findByDriverAscs();
//        if (list.size()> 0) {
//            List<Booking> trips = bookingRepository.findAll();
//            return trips;
//        }
//        throw new AdminExceptions("Invalid Id");
//        }
//
//
//    @Override
//    public List<Booking> getTripsCustomerwise() throws AdminExceptions {
//        List <Booking> list = BookingRepository.FindByCustomeridAscs();
//        if(list.size()> 0)
//            return list;
//        else
//            throw new AdminExceptions("No trips made by the Customer");
//
//    }
}
