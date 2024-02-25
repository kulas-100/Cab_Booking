package com.Project.cabbooking.driver;

import com.Project.cabbooking.driver.DriverAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverAccount, Integer> {
}
