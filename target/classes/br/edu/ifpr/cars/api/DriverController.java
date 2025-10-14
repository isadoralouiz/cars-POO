// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package br.edu.ifpr.cars.api;

import br.edu.ifpr.cars.domain.Driver;
import br.edu.ifpr.cars.domain.DriverRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(
   produces = {"application/json"}
)
public class DriverController {
   @Autowired
   DriverRepository driverRepository;

   public DriverController() {
   }

   @GetMapping({"/drivers"})
   public List<Driver> listDrivers() {
      return this.driverRepository.findAll();
   }
}
