package com.Project.cabbooking.admin;

import com.Project.cabbooking.booking.Booking;
import com.Project.cabbooking.car.Car;
import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.user.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("user")
    public CustomerAccount registerUser(@RequestBody CustomerAccount account) throws AdminExceptions {
        return this.adminService.registerUser(account);

    }

    @PostMapping("driver")
    public DriverAccount registerDriver(@RequestBody DriverAccount account) throws AdminExceptions {
        return this.adminService.registerDriver(account);
    }

    @PostMapping("cab")
    public Car registerCar(@RequestBody Car account) throws AdminExceptions {
        return this.adminService.registerCar(account);
    }

    @GetMapping("/Booking/customertrips")
    public List<Booking> getTripsCustomerwise() throws AdminExceptions {
        return adminService.getTripsCustomerwise();
    }

    @GetMapping("/Booking/{customerId}")
    public List<Booking>  getAllTripsById(@PathVariable("customerId") Integer customerId) throws AdminExceptions {
        return adminService.getAllTrips(customerId);
    }

    @GetMapping("/Booking/driverwise")
    public List<Booking> getTripsDriverwise() throws AdminExceptions {
        return adminService.getTripsDriverwise();
    }









}
